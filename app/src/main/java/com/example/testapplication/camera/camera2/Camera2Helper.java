package com.example.testapplication.camera.camera2;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;

import com.example.testapplication.util.DialogUtil;

import java.util.Arrays;

import androidx.core.app.ActivityCompat;

/**
 *
 * https://www.jianshu.com/p/0ea5e201260f
 * Created wangjinhao on 2021/7/15.
 */
public class Camera2Helper implements TextureView.SurfaceTextureListener {

    private Activity mActivity;
    private TextureView mTextureView;
    private CameraCaptureSession mCameraCaptureSession;
    private CameraDevice mCameraDevice;
    private Surface mPreviewSurface;
    private int mCameraFacing = CameraCharacteristics.LENS_FACING_BACK;       //默认使用后置摄像头
    private String mCameraId = "0";
    private CameraCharacteristics mCameraCharacteristics;

    private static final String TAG = "Camera2Helper";


    public Camera2Helper(Activity activity, TextureView textureView) {
        mTextureView = textureView;
        mActivity = activity;
        init();
    }

    private void init() {
        mTextureView.setSurfaceTextureListener(this);
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int arg1, int arg2) {
        mPreviewSurface = new Surface(surfaceTexture);
        try {
            initCameraManager();
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture arg0) {
        return false;
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture arg0, int arg1, int arg2) {
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture arg0) {
    }

    private void initCameraManager() throws CameraAccessException {
        CameraManager manager = (CameraManager) mActivity.getSystemService(Context.CAMERA_SERVICE);
        String[] cameraIdList = manager.getCameraIdList();
        if (cameraIdList.length == 0) {
            DialogUtil.showToast("没有可用相机");
            return;
        }

        for (String cameraId : cameraIdList) {
            CameraCharacteristics cameraCharacteristics = manager.getCameraCharacteristics(cameraId);
            int facing = cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);

            if (facing == mCameraFacing) {
                mCameraId = cameraId;
                mCameraCharacteristics = cameraCharacteristics;
            }
            Log.d(TAG,"设备中的摄像头"+cameraId);
        }

        try {
            if (ActivityCompat.checkSelfPermission(mActivity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            manager.openCamera("0", new CameraDevice.StateCallback() {

                @Override
                public void onOpened(CameraDevice cameraDevice) {
                    mCameraDevice = cameraDevice;
                    try {
                        mCameraDevice.createCaptureSession(Arrays.asList(mPreviewSurface), new CameraCaptureSession.StateCallback() {

                            @Override
                            public void onConfigured(CameraCaptureSession arg0) {
                                mCameraCaptureSession = arg0;
                                try {
                                    CaptureRequest.Builder builder;
                                    builder = mCameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
                                    builder.addTarget(mPreviewSurface);
                                    mCameraCaptureSession.setRepeatingRequest(builder.build(), null, null);
                                } catch (CameraAccessException e1) {
                                    e1.printStackTrace();
                                }
                            }

                            @Override
                            public void onConfigureFailed(CameraCaptureSession arg0) {

                            }
                        }, null);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onError(CameraDevice arg0, int arg1) {
                }

                @Override
                public void onDisconnected(CameraDevice arg0) {

                }
            }, null);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
}
