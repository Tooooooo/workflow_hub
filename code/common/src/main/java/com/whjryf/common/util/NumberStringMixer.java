package com.whjryf.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @since  2020/7/17
 * @version 0.1
 * @author 涂鼎 tuding27@gmail.com  QQ:200161
 */
public class NumberStringMixer {

    /**
     * 四种简单的混淆模式
     */
    private static final char[] MIX_METHOD = {'r','t','u','d'};

    /**
     * 乱序的36进制码表
     */
    private static char[] nchar = {
        '7','g','t','z','e','v','3','5','1','u',
        'o','a','c','6','w','2','m','p','8','i',
        'f','4','r','j','d','9','q','n','x','h',
        'y','s','0','b','k','l'};
    private static final int hdlism = nchar.length;

    /**
     * 将一个正长整型数值转换为乱序的36进制表示形式.
     * 注意：不支持mix负数.
     * @param m 待转换的数值
     * @param mc 尾数
     * @return 乱序的36进制
     */
    private static String m2n(long m, String mc){
        int rem = (int)(m % hdlism);
        if ( rem == m )
            return nchar[rem] + mc;
        long ans = ( m - rem ) / hdlism;
        return m2n( ans, nchar[rem] + mc );
    }


    /**
     * 从乱序36进制字符串还原到十进制整数.
     */
    private static int n2m(String digitStr) {
        if (digitStr.length() == 1) {
            return locateChar(digitStr.charAt(0));
        }
        return locateChar(digitStr.charAt(0))
                * pow(digitStr.length()-1)+n2m(digitStr.substring(1));
    }

    // 幂
    private static int pow(int a) {
        int r = 36;
        for (int i = 1; i < a; i++) {
            r *= 36;
        }
        return r;
    }


    private static int locateChar(char c) {
        for (int i = 0; i < nchar.length; i++) {
            if (nchar[i] == c) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 采用随机的混淆模式加密数字, 向不良观察者隐藏.
     * @param regularNumber 具有规律的组合模式的字符串
     * @return 混淆后的结果
     */
    public static String mix(long regularNumber) {
        if (0 > regularNumber) {
            throw new IllegalArgumentException("不支持mix负数");
        }
        return mix(m2n(regularNumber, ""));
    }


    /**
     * 采用随机的混淆模式加密字符串, 避免观察者找到字符串的规律.
     * @param source 具有规律的组合模式的字符串
     * @return 混淆后的结果
     */
    private static String mix( String source ){
        char method = MIX_METHOD[RandomUtils.randomInt( 0, MIX_METHOD.length )];
        switch (method) {
            case 'r':
                return mixR( source );
            case 't':
                return mixT( source );
            case 'u':
                return mixU( source );
            case 'd':
                return mixD( source );
            default:
                return "###";
        }
    }


    /**
     * 将混淆的字符串复原.
     * @param mixed 已混淆的字符串
     * @return 解除混淆后的字符串
     */
    public static long unmix( String mixed ){
        char method = mixed.charAt( mixed.length() - 1 );
        String result = "";
        switch (method) {
            case 'r':
                result = recoverR( mixed );
                break;
            case 't':
                result = recoverT( mixed );
                break;
            case 'u':
                result = recoverU( mixed );
                break;
            case 'd':
                result = recoverD( mixed );
        }
        if ("".equals(result)) {
            return -1;
        }
        return n2m(result);
    }


    /**
     * 反转
     * @param source
     * @return
     */
    private static String mixR( String source ){
        System.out.println( "mix by R" );
        if ( StringUtils.isBlank( source ) )
            return "";
        return StringUtils.reverse( source ) + 'r';
    }


    /**
     * 解除反转
     * @param mixed
     * @return
     */
    private static String recoverR( String mixed ){
        System.out.println( "recover by R" );
        if ( StringUtils.isBlank( mixed ) )
            return "";
        String mixedSource = mixed.substring( 0, mixed.length() - 1 );
        return StringUtils.reverse( mixedSource );
    }


    /**
     * 首位和末尾对调
     * @param source
     * @return
     */
    private static String mixT( String source ){
        System.out.println( "mix by T" );
        if ( StringUtils.isBlank( source ) )
            return "";
        char[] ss = source.toCharArray();
        char tmp = ss[0];
        ss[0] = ss[ss.length - 1];
        ss[ss.length - 1] = tmp;
        return new String(ss) + 't';
    }


    /**
     * 解除首位和末尾对调
     * @param mixed
     * @return
     */
    private static String recoverT( String mixed ){
        System.out.println( "recover by T" );
        if ( StringUtils.isBlank( mixed ) )
            return "";
        String mixedSource = mixed.substring( 0, mixed.length() - 1 );
        char[] ss = mixedSource.toCharArray();
        char tmp = ss[0];
        ss[0] = ss[ss.length - 1];
        ss[ss.length - 1] = tmp;
        return new String(ss);
    }


    /**
     * 按字母表和数字顺序提升1位. 'z' -> 'a' | '9'->'0'
     * @param source
     * @return
     */
    private static String mixU( String source ){
        System.out.println( "mix by U" );
        if ( StringUtils.isBlank( source ) )
            return "";
        char[] ss = source.toLowerCase().toCharArray();
        for ( int i = 0; i < ss.length; i++ ) {
            if ( ss[i] == 'z' ) {
                ss[i] = 'a';
                continue;
            }
            if ( ss[i] == '9' ) {
                ss[i] = '0';
                continue;
            }
            ss[i]++;
        }
        return new String(ss) + 'u';
    }


    /**
     * 解除按字母表和数字顺序提升1位. 'z' -> 'a' | '9'->'0'
     * @param mixed
     * @return
     */
    private static String recoverU( String mixed ){
        System.out.println( "recover by U" );
        if ( StringUtils.isBlank( mixed ) )
            return "";
        String mixedSource = mixed.substring( 0, mixed.length() - 1 );
        String recovered = mixD( mixedSource );
        return recovered.substring( 0, recovered.length() - 1 );
    }


    /**
     * 按字母表和数字顺序降低1位. 'a' -> 'z' | '0'->'9'
     * @param source
     * @return
     */
    private static String mixD( String source ){
        System.out.println( "mix by D" );
        if ( StringUtils.isBlank( source ) )
            return "";
        char[] ss = source.toLowerCase().toCharArray();
        for ( int i = 0; i < ss.length; i++ ) {
            if ( ss[i] == 'a' ) {
                ss[i] = 'z';
                continue;
            }
            if ( ss[i] == '0' ) {
                ss[i] = '9';
                continue;
            }
            ss[i]--;
        }
        return new String(ss) + 'd';
    }


    /**
     * 解除按字母表和数字顺序降低1位. 'a' -> 'z' | '0'->'9'
     * @param mixed
     * @return
     */
    private static String recoverD( String mixed ){
        System.out.println( "recover by D" );
        if ( StringUtils.isBlank( mixed ) )
            return "";
        String mixedSource = mixed.substring( 0, mixed.length() - 1 );
        String recovered = mixU( mixedSource );
        return recovered.substring( 0, recovered.length() - 1 );
    }


    public static void main(String[] args) {
        long num = 99;
        System.out.println("long:" + num);
        String mixed = mix(num);
        System.out.println(mixed);
        long unmixed = unmix(mixed);
        System.out.println(unmixed);
    }

}
