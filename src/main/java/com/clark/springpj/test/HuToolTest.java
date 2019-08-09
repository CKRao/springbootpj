package com.clark.springpj.test;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.CharsetUtil;

import java.util.Date;

/**
 * @author ClarkRao
 * @date 2019/8/8 15:39
 * @description: HuTool 工具类测试
 */
public class HuToolTest {
    public HuToolTest(String str) {
        System.out.println("hhhh :" + str);
    }

    public static void main(String[] args) {
//        String test = "风格和发挥规范化发货";
//
//        test = Convert.toHex(test, CharsetUtil.CHARSET_UTF_8);
//
//        System.out.println(test);
//
//        String hex = "e68891e698afe4b880e4b8aae5b08fe5b08fe79a84e58fafe788b1e79a84e5ad97e7aca6e4b8b2";
//
//        System.out.println(Convert.hexToStr(test, CharsetUtil.CHARSET_UTF_8));

        dateTest();

    }

    public static void dateTest() {
        String date = "2019-09-08";
        DateTime time = DateUtil.parse(date);
        String format = DateUtil.format(time, "yyyy/MM/dd");
        System.out.println(format);

        format = DateUtil.formatDate(time);
        System.out.println(format);

        format = DateUtil.formatDateTime(time);
        System.out.println(format);

        format = DateUtil.formatTime(time);
        System.out.println(format);

        DateTime dateTime = DateUtil.date();

        System.out.println(DateUtil.year(dateTime));
        System.out.println(DateUtil.month(dateTime));
        System.out.println(DateUtil.monthEnum(dateTime));
        System.out.println(DateUtil.thisMonthEnum());

        String dateStr = "2017-03-01 22:33:23";
        Date d = DateUtil.parse(dateStr);
        DateTime beginOfDay = DateUtil.beginOfDay(d);
        DateTime endOfDay = DateUtil.endOfDay(d);
        System.out.println(DateUtil.formatDateTime(beginOfDay));
        System.out.println(DateUtil.formatDateTime(endOfDay));

        System.out.println(DateUtil.ageOfNow("1995-03-25"));
    }
}
