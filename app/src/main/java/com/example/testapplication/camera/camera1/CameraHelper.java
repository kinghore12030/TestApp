package com.example.testapplication.camera.camera1;

import android.app.Activity;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.List;

import androidx.annotation.NonNull;

/**
 *  camera2支持到5.0 camera 可以支持5.0以下
 *
 * 1 利用open(int)获取Camera实例
 * 2 利用getParameters()获取默认设置，如果需要利用setParameters(Camera.Parameters)进行参数设置
 * 3 利用setDisplayOrientation(int)函数设置正确的预览方向
 * 4 想要预览，需要配合SurfaceView，利用setPreviewDisplay(SurfaceHolder)设置SurfaceView的SurfaceHolder用于预览。
 * 5 调用startPreview()开始预览，拍照之前必须已经开始预览
 * 6 takePicture 拍摄照片
 * 7 调用takePickture后预览会停止，想要继续预览需要调用startPreview()函数
 * 8 调用stopPreview()停止预览
 * 9 调用release()释放资源，为了节省资源在Activity.onPause时调用停止预览，在onResume时开始预览。
 *
 * Created wangjinhao on 11/23/20.
 */
public class CameraHelper implements Camera.PreviewCallback, SurfaceHolder.Callback {


    private Camera mCamera;
    private Camera.Parameters mParameters;
    private SurfaceView mSurfaceView;
    private SurfaceHolder mSurfaceHolder;
    private Activity mActivity;
    private int mDisplayOrientation = 0;
    private int picWidth = 2016;
    private int picHeight = 3840;

    public CameraHelper(Activity activity, SurfaceView surfaceView) {
        mSurfaceView = surfaceView;
        mActivity = activity;
        init();
    }

    private void init() {
        mSurfaceHolder = mSurfaceView.getHolder();
        mSurfaceHolder.addCallback(this);
    }

    @Override
    public void onPreviewFrame(byte[] data, Camera camera) {

    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        if (mCamera == null) {
            openCamera();
        }
        startPreview();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        releaseCamera(); //释放相机资源
    }



    public void openCamera(){
        boolean supportCameraFacing = supportCameraFacing(Camera.CameraInfo.CAMERA_FACING_BACK);   //判断手机是否支持前置/后置摄像头
        if (supportCameraFacing) {
            try {
                mCamera = Camera.open(Camera.CameraInfo.CAMERA_FACING_BACK);
                initParameters(mCamera);        //初始化相机配置信息
                mCamera.setPreviewCallback(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //判断是否支持某个相机
    private boolean supportCameraFacing(int cameraFacing) {
        Camera.CameraInfo info = new Camera.CameraInfo();
        for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
            Camera.getCameraInfo(i, info);
            if (info.facing == cameraFacing) {
                return true;
            }
        }
        return false;
    }

    //配置相机参数
    private void initParameters(Camera camera) {
        try {
            mParameters = camera.getParameters();
            mParameters.setPreviewFormat(ImageFormat.NV21);   //设置预览图片的格式

            //获取与指定宽高相等或最接近的尺寸
            //设置预览尺寸
            Camera.Size bestPreviewSize = getBestSize(mSurfaceView.getWidth(), mSurfaceView.getHeight(), mParameters.getSupportedPreviewSizes());
            mParameters.setPreviewSize(bestPreviewSize.width, bestPreviewSize.height);
            //设置保存图片尺寸
            Camera.Size bestPicSize = getBestSize(picWidth, picHeight, mParameters.getSupportedPreviewSizes());
            mParameters.setPictureSize(bestPicSize.width, bestPicSize.height);
            //对焦模式
            if (isSupportFocus(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE)) {
                mParameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
            } else {
                mParameters.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
            }
            camera.setParameters(mParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isSupportFocus(String mode) {
        List<String> mSupportedFocusModes = mParameters.getSupportedFocusModes();
        if (mSupportedFocusModes != null && mSupportedFocusModes.contains(mode)) {
            return true;
        }
        return false;
    }

    //获取与指定宽高相等或最接近的尺寸
    private Camera.Size getBestSize(int targetWidth, int targetHeight, List<Camera.Size> sizeList) {
        Camera.Size bestSize = null;
        double targetRatio = ((double) targetHeight / targetWidth); //目标大小的宽高比
        double minDiff = targetRatio;
        for (Camera.Size size : sizeList) {
            if (size.width == targetHeight && size.height == targetWidth) {
                bestSize = size;
                break;
            }
            double supportedRatio = ((double) size.width / size.height);
            if (Math.abs(supportedRatio - targetRatio) < minDiff) {
                minDiff = Math.abs(supportedRatio - targetRatio);
                bestSize = size;
            }
        }
        return bestSize;
    }

    //开始预览
    public void startPreview() {
        try {
            mCamera.setPreviewDisplay(mSurfaceHolder);       //设置相机预览对象
            setCameraDisplayOrientation(mActivity);    //设置预览时相机旋转的角度
            mCamera.startPreview();
        } catch (Exception e) {

        }
    }

    //设置预览旋转的角度
    private void setCameraDisplayOrientation(Activity activity) {
        Camera.CameraInfo info = new Camera.CameraInfo();
        Camera.getCameraInfo(Camera.CameraInfo.CAMERA_FACING_BACK, info);
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        int screenDegree = 0;
        switch (rotation) {
            case Surface.ROTATION_0:
                screenDegree = 0;
                break;
            case Surface.ROTATION_90:
                screenDegree = 90;
                break;
            case Surface.ROTATION_180:
                screenDegree = 180;
                break;
            case Surface.ROTATION_270:
                screenDegree = 270;
                break;
        }
        if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
            mDisplayOrientation = (info.orientation + screenDegree) % 360;
            mDisplayOrientation = (360 - mDisplayOrientation) % 360;         // compensate the mirror
        } else {
            mDisplayOrientation = (info.orientation - screenDegree + 360) % 360;
        }
        mCamera.setDisplayOrientation(mDisplayOrientation);
    }

    //释放相机
    private void releaseCamera() {
        if (mCamera != null) {
            mCamera.stopPreview();
            mCamera.setPreviewCallback(null);
            mCamera.release();
            mCamera = null;
        }
    }
}
