package com.leileichen.sell.utils;

import java.util.Random;

public class KeyUtil {
    /**
     * 生成主键
     * @return
     */
    public static synchronized String genUniqueKey() {

        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;

        // 由现在的时间加上随机数来共同生成
        return System.currentTimeMillis() + String.valueOf(number);
    }

}
