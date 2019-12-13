package com.kakaopay.shortening.common.utils;

/**
 * Base62 관련 클래스
 * Created by MHLab on 2019/12/11..
 */

public class Base62Helper {

    //Base62 Character set
    private static final char[] BASE62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();


    /**
     * 전달된 long 값을 인코딩하여 문자열 반환
     * @param value 인코딩할 long 값
     * @return 인코딩 된 문자열 반환
     */
    public static String encode(long value) {
        final StringBuilder sb = new StringBuilder();
        do {
            int i = (int)(value % 62);
            sb.append(BASE62[i]);
            value /= 62;
        } while (value > 0);
        return sb.toString();
    }

    /**
     * 전달된 인코딩 값을 long 형으로 반환
     * @param encodingValue 인코딩된 문자열
     * @return long 형 반환
     */
    public static long decode(String encodingValue) {
        long result=0;
        long power=1;
        for (int i = 0; i < encodingValue.length(); i++) {
            int digit = new String(BASE62).indexOf(encodingValue.charAt(i));
            result += digit * power;
            power *= 62;
        }
        return result;
    }

}
