package com.zc.ths.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionUtil {

    public static String SHA1Encrypt(String srcStr) {
        return encrypt("SHA-1", srcStr);
    }

    private static String encrypt(String algorithm, String srcStr) {
        try {
            StringBuilder sbd = new StringBuilder();
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            byte[] bytes = digest.digest(srcStr.getBytes("utf8"));
            for (byte bt : bytes) {
                String str = Integer.toHexString(bt & 0xFF);
//                System.out.println(bt + "--> " + str);
                if(str.length() == 1){
                    sbd.append("0");
                }
                sbd.append(str);
            }
            return sbd.toString();
        }catch (Exception e){
            throw new RuntimeException();
        }

    }

}
