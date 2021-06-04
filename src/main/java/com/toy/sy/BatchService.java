package com.toy.sy;

import lombok.RequiredArgsConstructor;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.PersistJobDataAfterExecution;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;



@Component
public class BatchService {

    private final QuartzService quartzService;

    public BatchService(QuartzService quartzService) {
        this.quartzService = quartzService;
    }

    @PostConstruct
    public void init() {
        try {
            quartzService.addSimpleJob(QuartzJob.class, "QuartzJob", "Quartz 잡",null , 10);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
