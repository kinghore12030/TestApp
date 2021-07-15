package com.example.testapplication.algorithmtest;

/**
 * Created wangjinhao on 4/20/21.
 * AAAABBBDDIIOODDDDE转换为A4B3D2I2O2D4E1
 */
class CharCountTest {

    public static void main(String[] args) {
        System.out.println(getResult("AAAABBBDDIIOODDDDER"));
    }

    public static String getResult(String a) {
        if (a == null || a.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        String lastWord = String.valueOf(a.charAt(0));
        for (int i = 0; i < a.length(); i++) {
            if (lastWord.equals(String.valueOf(a.charAt(i)))) {
                count++;
                if (i == a.length() - 1) {
                    sb.append(lastWord + count);
                    break;
                }
            } else {
                sb.append(lastWord + count);
                count = 1;
                if (i == a.length() - 1) {
                    sb.append(String.valueOf(a.charAt(i)) + count);
                    break;
                }
            }
            lastWord = String.valueOf(a.charAt(i));
        }
        return sb.toString();
    }
}
