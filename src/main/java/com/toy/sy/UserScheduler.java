package com.toy.sy;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;



public class UserScheduler implements Job {

    UserService userService = (UserService) QuartzBean.getBean("userService");

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("배치 도는중");





    }


}
