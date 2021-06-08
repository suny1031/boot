package com.toy.sy;

import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class QuartzService2 {

    private SchedulerFactory schedulerFactory;

    private  Scheduler scheduler;

    @PostConstruct
    public void start() throws SchedulerException {

        schedulerFactory = new StdSchedulerFactory();
        scheduler = schedulerFactory.getScheduler();
        scheduler.start();


        //jobDetail 생성( Job 지정하고 실행하기 위한 상세 정보 )
        JobDetail job = JobBuilder.newJob(UserJob.class).withIdentity("testJob").build();


        if (scheduler.checkExists(job.getKey())) {
            scheduler.deleteJob(job.getKey());
        }

        //trigger 생성
        Trigger trigger = TriggerBuilder.newTrigger().
                withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();

        scheduler.scheduleJob(job, trigger);

    }

}
