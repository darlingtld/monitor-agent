package com.emc.utils;

public class Bytes {
    public static String substring(String src, int startIdx, int endIdx) {
        byte[] b = src.getBytes();
        String tgt = "";
        for (int i = startIdx; i <= endIdx; i++) {
            tgt += (char) b[i];
        }
        return tgt;
    }
}
