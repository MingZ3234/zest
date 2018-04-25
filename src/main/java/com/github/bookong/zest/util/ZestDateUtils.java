package com.github.bookong.zest.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.github.bookong.zest.core.testcase.TestCaseData;

/**
 * @author jiangxu
 */
public class ZestDateUtils {

    private static final ThreadLocal<Map<String, SimpleDateFormat>> DATE_FORMAT_CACHE = new ThreadLocal<Map<String, SimpleDateFormat>>();

    /**
     * 以格式(yyyy-MM-dd HH:mm:ss)解析时间
     * 
     * @param time
     * @return
     */
    public static Date parseNormalDate(String time) {
        try {
            return getDateFormat(DateFormatType.NORMAL_DATE).parse(time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 以格式(yyyy-MM-dd HH:mm:ss)格式化日期
     * 
     * @param date
     * @return
     */
    public static String formatDateNormal(Date date) {
        return getDateFormat(DateFormatType.NORMAL_DATE).format(date);
    }

    /**
     * 计算要录入到数据库中的日期值（经过 currDbTimeDiff 修正过）
     * 
     * @param date
     * @param testCaseData
     * @return
     */
    public static Date getDateInDB(Date date, TestCaseData testCaseData) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MILLISECOND, 0);

        if (testCaseData.isTransferTime()) {
            cal.setTimeInMillis(cal.getTimeInMillis() + testCaseData.getCurrDbTimeDiff());
        }

        return cal.getTime();
    }

    /**
     * 得到数据库中 Date 类型字段在通过 currDbTimeDiff 修正以后的字符串表示
     * 
     * @param date
     * @param testCaseData
     * @return
     */
    public static String getStringFromDBDate(Date date, TestCaseData testCaseData) {
        return ZestDateUtils.formatDateNormal(getDateInDB(date, testCaseData));
    }

    /**
     * @param formatType
     * @return
     */
    public static SimpleDateFormat getDateFormat(DateFormatType formatType) {
        Map<String, SimpleDateFormat> map = DATE_FORMAT_CACHE.get();
        if (map == null) {
            map = new HashMap<String, SimpleDateFormat>();
        }

        SimpleDateFormat dateFormat = map.get(formatType.getFormatType());
        if (dateFormat == null) {
            dateFormat = formatType.genDateFormat();
            map.put(formatType.getFormatType(), dateFormat);
        }

        return dateFormat;
    }

    /**
     * @author jiangxu
     */
    public static enum DateFormatType {
                                       /** yyyy-MM-dd HH:mm:ss */
                                       NORMAL_DATE("yyyy-MM-dd HH:mm:ss"),
                                       /** yyyy-MM-dd HH:mm:ss.SSS */
                                       FULL_DATE("yyyy-MM-dd HH:mm:ss.SSS"),
                                       /** yyyy-MM-dd */
                                       DAY_DATE("yyyy-MM-dd");

        private String formatType;

        private DateFormatType(String dateFormatType){
            this.formatType = dateFormatType;
        }

        public String getFormatType() {
            return formatType;
        }

        public SimpleDateFormat genDateFormat() {
            return new SimpleDateFormat(formatType);
        }
    }
}
