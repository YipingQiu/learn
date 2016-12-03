package cn.qiuyiping.time;

/**
 * Created by Jack_邱 on 2016/12/3.
 */
public class TimeAbout {

    public static void main(String args[]){
        java.util.Date utilDate = new java.util.Date();
        System.out.println(utilDate);
        java.sql.Date sqlDate = new java.sql.Date(0L);
        System.out.println(sqlDate);

        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(2016,11,3,14,42,50,999999999);
        System.out.println(sqlTimestamp);
        java.sql.Timestamp sqlTimestamp2 = new java.sql.Timestamp(2016,11,3,14,42,50,1);
        System.out.println(sqlTimestamp2);

    }

}
