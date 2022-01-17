package com.whjryf.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public final class RandomUtils {

  /**
   * 禁止实例化.
   */
  private RandomUtils() {
  }

  /**
   * 生成指定区间内, 指定数量的不重复的伪随机整数.<br>
   * 生成的伪随机整数 N 满足条件: minimum &lt;= N &lt; maximum
   *
   * @param minimum 随机数的最小值
   * @param maximum 随机数的最大值
   * @param amount 生成随机数的数量
   *
   * @return 伪随机数组成的整型数组, 元素个数取决于 amount 参数的值
   */
  public static int[] nonRepeatRandomsInt(int minimum, int maximum, int amount) {
    if (maximum <= minimum) {
      throw new IllegalArgumentException("参数配置有错误: maximum 必须大于 minimum ");
    }
    int range = maximum - minimum;
    if (amount > range) {
      throw new Error("误参数: 如果 amount 大于最大值和最小值之差，则必定会出现重复");
    }

    int[] rndRange = new int[range];
    for (int i = 0; i < rndRange.length; i++) {
      rndRange[i] = i;
    }

    int[] result = new int[amount];
    int hitedIndex;
    int valueRegion;

    for (int i = 0; i < result.length; i++) {
      valueRegion = rndRange.length - i;
      hitedIndex = randomInt(0, valueRegion);
      result[i] = minimum + rndRange[hitedIndex];
      // 将本次产生的数排除到下次随机数的备选范围外
      rndRange[hitedIndex] = rndRange[valueRegion - 1];
    }
    return result;
  }


  /**
   * 生成指定区间内的伪随机整数.
   * 生成的随机数 N 满足条件: minimum &lt;= N &lt; maximum.
   *
   * @param minimum 随机数的最小值
   * @param maximum 随机数的最大值
   *
   * @return 指定区间的伪随机数
   */
  public static int randomInt(int minimum, int maximum) {
    if (maximum <= minimum) {
      throw new Error("参数配置有错误: maximum 必须大于 minimum ");
    }
    return (int) (minimum + (Math.random() * (maximum - minimum)));
  }


  /**
   * 从备选的对象数组中随机抽取不重复对象, 保存在长度为 size 的数组中返回. 其中 stuff.length &gt; size &gt; 2
   *
   * @param stuff 备选对象的数组, 不能有重复
   * @param size 指定返回的随机不重复对象数组的大小
   * @return 保存不重复随机对象的数组
   * @throws IllegalArgumentException 当  size &lt;= 2 || stuff.length &lt;= size 时抛出
   */
  public static Object[] randomPick(Object[] stuff, int size, boolean noRepeat) {
    if (noRepeat && (size <= 2 || stuff.length <= size)) {
      throw new IllegalArgumentException("stuff的长度必须大于要产生的随机数组的长度[该长度要大于2]");
    }
    Object[] result = new Object[size];
    for (int i = 0; i < size; i++) {
      if (noRepeat) {
        int idx = randomInt(0, stuff.length - 1 - i);
        result[i] = stuff[idx];
        stuff[idx] = stuff[stuff.length - 1 - i];
      } else {
        result[i] = stuff[randomInt(0, stuff.length)];
      }
    }
    return result;
  }


  /**
   * 获取随机日期.
   *
   * @param beginDate 起始日期，格式为：yyyy-MM-dd
   * @param endDate 结束日期，格式为：yyyy-MM-dd
   *
   * @return 获取指定范围内的某个随机日期
   */
  public static Date randomDate(String beginDate, String endDate) {
    try {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      Date start = format.parse(beginDate);// 构造开始日期
      Date end = format.parse(endDate);// 构造结束日期
      // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
      if (start.getTime() >= end.getTime()) {
        return null;
      }
      long date = randomLong(start.getTime(), end.getTime());
      return new Date(date);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }


  /**
   * 获得随机密码.
   *
   * @param len 生成密码长度
   * @return 随机密码
   */
  public static String randomPassWord(int len) {
    int i;  //生成的随机数
    int count = 0; //生成的密码的长度
    // 密码字典
    char[] str = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
        'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
        's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };
    StringBuilder sb = new StringBuilder();
    while (count < len) {
      //生成 0 ~ 密码字典-1之间的随机数
      sb.append(str[RandomUtils.randomInt(0, str.length)]);
      count++;
    }
    return sb.toString();
  }


  private static long randomLong(long minimum, long maximum) {
    if (maximum <= minimum) {
      throw new Error("参数配置有错误: maximum 必须大于 minimum ");
    }
    return (long) (minimum + (Math.random() * (maximum - minimum)));
  }


}
