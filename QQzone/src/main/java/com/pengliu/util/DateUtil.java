package com.pengliu.util;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.assertj.core.util.Maps;

/**
 * Created with IntelliJ IDEA
 * User: zhangqingyang
 * Date: 2017/5/15
 * Time: 11:24
 */
public class DateUtil {
    /*
     * 获取某年每月的最大天数
     */
    public static int getMonthDays(int dyear, String dmouth) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM");
        Calendar rightNow = Calendar.getInstance();
        try {
            rightNow.setTime(simpleDate.parse(dyear + "/" + dmouth));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return rightNow.getActualMaximum(Calendar.DAY_OF_MONTH);// 根据年月 获取月份天数
    }
    /*
     * 获取某月最大天数
     */
    public static int getMonthDays(Date dateTime) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dateTime);
        return rightNow.getActualMaximum(Calendar.DAY_OF_MONTH);// 根据年月 获取月份天数
    }

    /*
     * 获得当天开始的时间
     */
    public static Date getStartDateTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /*
     * 格式化日期字符串
     */
    public static String formatDate(Date date, String datePattern) {
        String ret = null;
        if (date != null) {
            try {
                DateFormat dateFormat = new SimpleDateFormat(datePattern,Locale.CHINA);
                ret = dateFormat.format(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    /*
     * 获取当前日期是星期几
     */
    public static int getWeekOfDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        w = w < 0 ? 0 : w;

        return w;
    }

    /*
     * 解析日期字符串，转换成日期
     */
    public static Date parseDate(String strDate, String datePattern) {
        Date retDate = null;
        if (strDate != null) {
            if (strDate.indexOf("T") != -1) {
                strDate = strDate.replace("T", " ");
            }
            SimpleDateFormat sf = new SimpleDateFormat(datePattern);
            try {
                retDate = sf.parse(strDate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retDate;
    }

    public static String getDatetime() {
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = tempDate.format(new java.util.Date());
        return datetime;
    }

    public static String getDatetime(String format) {
        SimpleDateFormat tempDate = new SimpleDateFormat(format);
        String datetime = tempDate.format(new java.util.Date());
        return datetime;
    }

    /**
     * 得到二个日期间的间隔天数
     */
    public static long getDaysInterval(Date starttime, Date endtime) {
        long day = 0;
        try {
            day = (endtime.getTime() - starttime.getTime()) / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return day;
    }

    //
    public static String getNDayLaterTime(Date date, String datePattern, int n) {

        Calendar c = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat(datePattern);
        c.setTime(date);
        c.add(Calendar.DATE, n);
        Date d2 = c.getTime();
        return df.format(d2);
    }

    // 将2014-04-14 00:00:00.0转化成整数
    public static int dateToInteger(String date) {
        String[] arr = date.trim().split("\\s+");
        String[] arr1 = arr[0].split("-");
        String s = "";
        s = arr1[0] + arr1[1] + arr1[2];
        return Integer.parseInt(s);
    }

    public static String getCurrentDate(String moddel) {
        SimpleDateFormat formatter = new SimpleDateFormat(moddel);
        return formatter.format(new Date());
    }

    /**
     * @throws ParseException
     * 
     **/
    public static long dateToTimestamp(String date) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dt = format.parse(date);
        return dt.getTime();
    }

    /**
     * @throws ParseException
     * 
     **/
    public static int dateToInt(String date) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = format.parse(date);
        return (int) (dt.getTime() / 1000);
    }

    public static String longToDate(Long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
        java.util.Date dt = new Date(time);
        return sdf.format(dt); // 得到精确到秒的表示：
    }

    public static String intTodate(int time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
        Long l = new Long((long) time * 1000);
        Date d = new Date(l);
        return sdf.format(d);
    }

    /***
     * 获得 days天后 的时间值，精确到 秒
     ***/
    public static int getNDayLaterTime(int days) throws ParseException {

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();

        c.add(Calendar.DAY_OF_MONTH, days);
        return DateUtil.dateToInt(f.format(c.getTime()));
    }

    /**
     *	<p>函数名称: getYesterMonth()</p>
     *	<p>公司: 卡萨维斯</p>
     *	<p>方法描述: 获取上个月时间</p>
     *	<p>方法调用例子：</p>
     *	<p>完成日期：2017年9月13日 下午6:21:00</p>
     *	@return
     *	@throws ParseException
     *	@author  彭柳
     *	@version 1.0
     */
    public static Date getYesterMonth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        return c.getTime();
    }

    /**
     * 获得 当天的 开始时间 精确到 毫秒 return long
     * 
     ****/
    public static Long getCurrDayBeginTime() {

        Calendar currentDate = new GregorianCalendar();

        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        return currentDate.getTime().getTime();
    }

    /**
     * 获得 n天前(后)的 开始(结束)时间 n>0,n天后； n<0,n天前 isDaysBegin：true:开始时间； false:结束的时间
     * 精确到 毫秒 return long
     * 
     ****/
    public static Date getStartOrEndTime(int days, boolean isStart) {

        Calendar c = new GregorianCalendar();

        c.add(Calendar.DAY_OF_MONTH, days);
        if (isStart) {
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
        } else {
            c.set(Calendar.HOUR_OF_DAY, 23);
            c.set(Calendar.MINUTE, 59);
            c.set(Calendar.SECOND, 59);
        }
        return c.getTime();
    }

    /***
     * 获得当天的 时间 yyyy-MM-dd
     ***/
    public static String getCurrentDayStr() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        return f.format(c.getTime());
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     ***/
    public static String longToDate(Long time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        // 前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
        java.util.Date dt = new Date(time);
        return sdf.format(dt); // 得到精确到秒的表示：
    }

    /**
     * 在当前时间上加上多少天，返回时间戳
     * 
     * @param day
     * @return
     */
    public static Long addDay(Integer day) {
        Calendar now = Calendar.getInstance();
        Date date = new Date();
        now.setTime(date);
        now.add(Calendar.DATE, day);
        return now.getTime().getTime();
    }

    /**
     * 在起始时间上加上多少天，返回时间Date
     * 
     * @param day
     * @return
     */
    public static Date addDay(Date beginDate, Integer day) {
        Calendar now = Calendar.getInstance();
        now.setTime(beginDate);
        now.add(Calendar.DATE, day);
        return now.getTime();
    }

    /**
     *	<p>函数名称: addminute()</p>
     *	<p>公司: 卡萨维斯</p>
     *	<p>方法描述: 在起始时间上加上分钟，返回时间Date</p>
     *	<p>方法调用例子：</p>
     *	<p>完成日期：2017年9月13日 下午6:13:04</p>
     *	@param beginDate
     *	@param minute
     *	@return
     *	@author  彭柳
     *	@version 1.0
     */
    public static Date addminute(Date beginDate, Integer minute) {
        Calendar now = Calendar.getInstance();
        now.setTime(beginDate);
        now.add(Calendar.MINUTE, minute);
        return now.getTime();
    }

    /**
     *	<p>函数名称: getCurrentMonthStart()</p>
     *	<p>公司: 卡萨维斯</p>
     *	<p>方法描述: 获取当前月开始时间</p>
     *	<p>方法调用例子：</p>
     *	<p>完成日期：2017年9月13日 下午6:13:14</p>
     *	@return
     *	@author  彭柳
     *	@version 1.0
     */
    public static Date getCurrentMonthStart() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            Calendar now = Calendar.getInstance();
            c.setTime(sdf.parse(now.get(Calendar.YEAR) + "-" + (now.get(Calendar.MONTH) + 1) + "-" + 1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }
    /**
     *	<p>函数名称: getCurrentMonthEnd()</p>
     *	<p>公司: 卡萨维斯</p>
     *	<p>方法描述: 获取当前月结束时间</p>
     *	<p>方法调用例子：</p>
     *	<p>完成日期：2017年9月13日 下午6:13:26</p>
     *	@return
     *	@author  彭柳
     *	@version 1.0
     */
    public static Date getCurrentMonthEnd() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            Calendar now = Calendar.getInstance();
            c.setTime(sdf.parse(now.get(Calendar.YEAR) + "-" + (now.get(Calendar.MONTH) + 1) + "-"+ c.getActualMaximum(Calendar.DAY_OF_MONTH)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }
    
    /**
     *	<p>函数名称: getMonthStart()</p>
     *	<p>公司: 卡萨维斯</p>
     *	<p>方法描述: 获取某月的开始时间</p>
     *	<p>方法调用例子：</p>
     *	<p>完成日期：2017年9月13日 下午6:13:39</p>
     *	@param date
     *	@return
     *	@author  彭柳
     *	@version 1.0
     */
    public static Date getMonthStart(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND,0);
        c.set(Calendar.DATE, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }
    /**
     *	<p>函数名称: getMonthEnd()</p>
     *	<p>公司: 卡萨维斯</p>
     *	<p>方法描述: 获取某月的结束时间</p>
     *	<p>方法调用例子：</p>
     *	<p>完成日期：2017年9月13日 下午6:13:49</p>
     *	@param date
     *	@return
     *	@author  彭柳
     *	@version 1.0
     */
    public static Date getMonthEnd(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }
    /**
     * 获取某周开始时间
     * @param date
     * @return
     * @date 2017年6月16日
     */
    public static Date getWeekStart(Date date){
    	Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND,0);
        //设置星期一
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return c.getTime();
    }
    /**
     * 获取某周结束时间
     * @param date
     * @return
     * @date 2017年6月16日
     */
    public static Date getWeekEnd(Date date){
    	Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND,999);
        c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        return addDay(c.getTime(), 1);
    }
    /**
     *	<p>函数名称: getDayStart()</p>
     *	<p>公司: 卡萨维斯</p>
     *	<p>方法描述: 获取某天开始时间</p>
     *	<p>方法调用例子：</p>
     *	<p>完成日期：2017年9月13日 下午6:14:04</p>
     *	@param date
     *	@return
     *	@author  彭柳
     *	@version 1.0
     */
    public static Date getDayStart(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND,0);
        return c.getTime();
    }
    /**
     *	<p>函数名称: getDayEnd()</p>
     *	<p>公司: 卡萨维斯</p>
     *	<p>方法描述: 获取某天的结束时间</p>
     *	<p>方法调用例子：</p>
     *	<p>完成日期：2017年9月13日 下午6:14:14</p>
     *	@param date
     *	@return
     *	@author  彭柳
     *	@version 1.0
     */
    public static Date getDayEnd(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND,999);
        return c.getTime();
    }

    /**
     *	<p>函数名称: dateToCronTrigger()</p>
     *	<p>公司: 卡萨维斯</p>
     *	<p>方法描述: 时间转换成Cron任务表达式时间格式</p>
     *	<p>方法调用例子：</p>
     *	<p>完成日期：2017年9月13日 下午6:14:24</p>
     *	@param dateTime
     *	@return
     *	@author  彭柳
     *	@version 1.0
     */
    public static String dateToCronTrigger(Date dateTime) {
        String ss = formatDate(dateTime, "ss");
        String mm = formatDate(dateTime, "mm");
        String HH = formatDate(dateTime, "HH");
        String dd = formatDate(dateTime, "dd");
        String MM = formatDate(dateTime, "MM");
        String yyyy = formatDate(dateTime, "yyyy");
        return ss + " " + mm + " " + HH + " " + dd + " " + MM + " ? " + yyyy;
    }

    /**
     *	<p>函数名称: cronTriggerToDate()</p>
     *	<p>公司: 卡萨维斯</p>
     *	<p>方法描述: 定时任务表达式转Date对象</p>
     *	<p>方法调用例子：</p>
     *	<p>完成日期：2017年9月13日 下午6:14:34</p>
     *	@param cronTrigger
     *	@return
     *	@author  彭柳
     *	@version 1.0
     */
    public static Date cronTriggerToDate(String cronTrigger) {
        Date jobDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("ss mm HH dd MM ? yyyy");
        try {
            jobDate = sdf.parse(cronTrigger);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jobDate;
    }
    
    /**
     *	<p>函数名称: cronTriggerGetResidualTime()</p>
     *	<p>公司: 卡萨维斯</p>
     *	<p>方法描述: 定时任务-当前时间=返回剩余时间（xx天xx时xx分xx秒）</p>
     *	<p>方法调用例子：</p>
     *	<p>完成日期：2017年9月13日 下午6:14:49</p>
     *	@param cronTrigger
     *	@return
     *	@author  彭柳
     *	@version 1.0
     */
    public static String cronTriggerGetResidualTime(String cronTrigger) {
        String resultStr = "";
        SimpleDateFormat sdf = new SimpleDateFormat("ss mm HH dd MM ? yyyy");
        try {
            Date jobDate = sdf.parse(cronTrigger);
            Date dateTime = new Date();
            long resTime = jobDate.getTime() - dateTime.getTime();

            long days = resTime / (1000 * 60 * 60 * 24);
            long hours = (resTime % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
            long minutes = (resTime % (1000 * 60 * 60)) / (1000 * 60);
            long seconds = (resTime % (1000 * 60)) / 1000;
            resultStr = days + " 天 " + hours + " 时 " + minutes + " 分 " + seconds + " 秒 ";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultStr;
    }

    public static String cronTriggerGetResidualTime(Date dateTime, String cronTrigger) {
        String resultStr = "";
        SimpleDateFormat sdf = new SimpleDateFormat("ss mm HH dd MM ? yyyy");
        try {
            Date jobDate = sdf.parse(cronTrigger);
            long resTime = jobDate.getTime() - dateTime.getTime();

            long days = resTime / (1000 * 60 * 60 * 24);
            long hours = (resTime % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
            long minutes = (resTime % (1000 * 60 * 60)) / (1000 * 60);
            long seconds = (resTime % (1000 * 60)) / 1000;
            resultStr = days + " 天 " + hours + " 时 " + minutes + " 分 " + seconds + " 秒 ";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultStr;
    }
    /**
     *	<p>函数名称: getResidualTime()</p>
     *	<p>公司: 卡萨维斯</p>
     *	<p>方法描述: 获取时间差</p>
     *	<p>方法调用例子：</p>
     *	<p>完成日期：2017年9月13日 下午6:15:38</p>
     *	@param startTime
     *	@param endTime
     *	@return
     *	@author  彭柳
     *	@version 1.0
     */
    public static Map<String,Long> getResidualTime(Date startTime, Date endTime) {
    	Map<String,Long> maps = Maps.newConcurrentHashMap();
        long resTime = endTime.getTime() - startTime.getTime();
        long days = resTime / (1000 * 60 * 60 * 24);
        maps.put("days",days);
        long hours = (resTime % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        maps.put("hours",hours);
        long minutes = (resTime % (1000 * 60 * 60)) / (1000 * 60);
        maps.put("minutes",minutes);
        long seconds = (resTime % (1000 * 60)) / 1000;
        maps.put("seconds",seconds);
        return maps;
    }

    /**
     *	<p>函数名称: getAgeByBirthday()</p>
     *	<p>公司: 卡萨维斯</p>
     *	<p>方法描述: 根据生日计算年龄</p>
     *	<p>方法调用例子：</p>
     *	<p>完成日期：2017年9月13日 下午6:16:06</p>
     *	@param birthday
     *	@return
     *	@author  彭柳
     *	@version 1.0
     */
    public static int getAgeByBirthday(Date birthday) {
        Calendar now = Calendar.getInstance(), birth = Calendar.getInstance();
        birth.setTime(birthday);
        return now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
    }
    
    //获取当前时间x天后（前）的各种long时间
    public static HashMap<String,Long> xDay(Integer xDay) {
        HashMap<String,Long> longs=new HashMap<String, Long>();
    	Calendar calendar = Calendar.getInstance();  
    	//将小时至0  
    	calendar.set(Calendar.HOUR_OF_DAY, 0);  
    	//将分钟至0  
    	calendar.set(Calendar.MINUTE, 0);  
    	//将秒至0  
    	calendar.set(Calendar.SECOND,0);  
    	//将毫秒至0  
    	calendar.set(Calendar.MILLISECOND, 0);     
    	calendar.add(Calendar.DAY_OF_MONTH, xDay); 
    	Date sdate = calendar.getTime(); 
    	longs.put("begin", sdate.getTime());
    	
    	longs.put("end", sdate.getTime()+24*3600*1000-1);
    	return longs;
    }
    
    
    public static String getStringByDate(Date date){

    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");   
    	  
    	String str = format.format(date); 
    	
    	return str;
    }
    /**
     * 获取时间对应的星期
     * @param date
     * @return 星期一-星期日为1-7
     * @date 2017年4月10日
     */
    public static int getWeekByDate(Date date){
    	Calendar calendar = Calendar.getInstance(Locale.CHINA);
    	calendar.setTime(date);
    	//星期日-星期六为1-7，所以-1转换
    	int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)-1;
    	return dayOfWeek == 0 ? 7 : dayOfWeek;
    }
    /**
     * 获取开始时间到结束时间间的日期列表
     * @param startDate
     * @param endDate
     * @return
     * @date 2017年4月21日
     */
    public static List<Date> listStartDate2EndDate(Date startDate,Date endDate){
    	/*
    	 * 日期列表
    	 * 检查开始时间和结束时间间隔天数
    	 * 如果等于0，同一天，保存开始时间
    	 * 如果大于0，开始时间小于结束时间且是不同天，保存开始时间到结束时间的日期
    	 * 如果小于0，开始时间大于结束时间且不是同一天，不保存
    	 */
    	List<Date> dateList = new ArrayList<Date>();
    	//间隔天数
    	long interval = getDaysInterval(startDate, endDate);
    	if(interval == 0){//同一天
    		dateList.add(startDate);
    	}else if(interval > 0){//开始时间小于结束数据且不是同一天
    		dateList.add(startDate);
    		//开始日期的日历
        	Calendar startTime = Calendar.getInstance(); 
        	startTime.setTime(startDate);
        	//结束日期的日历
        	Calendar endTime = Calendar.getInstance();
        	endTime.setTime(endDate);
        	while(endDate.after(startTime.getTime())){
        		startTime.add(Calendar.DATE, 1);
        		dateList.add(startTime.getTime());
        	}
    	}
    	return dateList;
    }

}
