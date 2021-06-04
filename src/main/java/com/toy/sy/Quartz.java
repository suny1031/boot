package com.toy.sy;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class Quartz {

    private SchedulerFactory schedulerFactory;
    private Scheduler scheduler;

    @PostConstruct
    public void start() throws SchedulerException {
        schedulerFactory = new StdSchedulerFactory();
        scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        // job 지정
        JobDetail job = JobBuilder.newJob(UserScheduler.class).withIdentity("testJob").build();

        // trigger 지정
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("* /1 * * * ?")).build();

        scheduler.scheduleJob(job, trigger);
    }


}
