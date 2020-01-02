package com.swtl.wz.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *  定时任务操作类
 * @author  Gaofei
 * create by 2018-11-07
 *
 */
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);


    //@Scheduled(fixedRate = 60000) //上一次开始执行时间点之后5秒再执行
    //@Scheduled(fixedDelay = 5000) //上一次执行完毕时间点之后5秒再执行
    //@Scheduled(initialDelay=1000, fixedRate=5000) //第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
   // @Scheduled(cron="*/5 * * * * *")//通过cron表达式定义规则
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }






}
