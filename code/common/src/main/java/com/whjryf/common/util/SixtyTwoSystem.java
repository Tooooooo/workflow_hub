package com.whjryf.common.util;

import java.util.Arrays;

/**
 * 62 进制类.
 *
 * @author 涂鼎 [eMail: tuding27@gmail.com]
 * @version 0.1 [2019/2/21]
 */
public final class SixtyTwoSystem {

    // 基底
    private static final char[] ism = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};


    /**
     * 从十进制到六十二进制字符串.
     *
     * @param decimal 要转换的十进制数
     * @param tail    始终传 ""(空字符串)
     * @return 六十二进制字符串
     */
    public static String fromDecimal(int decimal, String tail) {
        int rem = decimal % 62;
        if (rem == decimal)
            return ism[rem] + tail;
        int ans = (decimal - rem) / 62;
        return fromDecimal(ans, ism[rem] + tail);
    }


    /**
     * 从六十二进制字符串还原到十进制整数.
     *
     * @param sixtyTwoDigit 由本类 {@link #fromDecimal(int, String)}转换的六十二进制字符串
     * @return 向 sixtyTwoDigit 转换得到的十进制整数
     */
    public static int toDecimal(String sixtyTwoDigit) {
        if (sixtyTwoDigit.length() == 1) {
            return Arrays.binarySearch(ism, sixtyTwoDigit.charAt(0));
        }
        int result = Arrays.binarySearch(ism, sixtyTwoDigit.charAt(0))
                * pow(sixtyTwoDigit.length() - 1) + toDecimal(sixtyTwoDigit.substring(1));
        return result;
    }


    // 62的幂
    private static int pow(int a) {
        int r = 62;
        for (int i = 1; i < a; i++) {
            r *= 62;
        }
        return r;
    }

}
