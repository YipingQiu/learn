package cn.qiuyiping.speed;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2016/11/25.
 */
public class SpeedTest {

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        for(int i = 0; i < 100000000; i++){
            if(i % 10000 == 0){
                System.out.println(i/10000);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, 6, 1, 7, 59, 59);
        System.out.println(calendar.getTime());
    }

}
