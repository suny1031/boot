package com.toy.sy;

import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.springframework.stereotype.Service;


import java.util.Map;

@RequiredArgsConstructor
@Service
public class QuartzService {
    private final Scheduler scheduler;

    public void addSimpleJob(Class job, String name, String desc, Map params, Integer seconds) throws SchedulerException {
        JobDetail jobDetail = buildJobDetail(job, name, desc, params);

        if (scheduler.checkExists(jobDetail.getKey())) {
            scheduler.deleteJob(jobDetail.getKey());
        }

        scheduler.scheduleJob(
                jobDetail,
                buildSimpleJobTrigger(seconds)
        );
    }

    public void addCronJob(Class job, String name, String desc, Map params, String expression) throws SchedulerException {
        JobDetail jobDetail = buildJobDetail(job, name, desc, params);

        if (scheduler.checkExists(jobDetail.getKey())) {
            scheduler.deleteJob(jobDetail.getKey());
        }

        scheduler.scheduleJob(
                jobDetail,
                buildCronJobTrigger(expression)
        );
    }

    private JobDetail buildJobDetail(Class job, String name, String desc, Map params) {
        JobDataMap jobDataMap = new JobDataMap();
        if(params != null) jobDataMap.putAll(params);
        return JobBuilder
                .newJob(job)
                .withIdentity(name)
                .withDescription(desc)
                .usingJobData(jobDataMap)
                .build();
    }

    /**
     * Cron Job Trigger
     */
    // *  *   *   *   *   *     *
    // 초  분  시   일   월  요일  년도(생략가능)
    private Trigger buildCronJobTrigger(String scheduleExp) {
        return TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule(scheduleExp))
                .build();
    }

    /**
     * Simple Job Trigger
     */
    private Trigger buildSimpleJobTrigger(Integer seconds) {
        return TriggerBuilder.newTrigger()
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .repeatForever()
                        .withIntervalInSeconds(seconds))
                .build();
    }

}