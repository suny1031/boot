package com.toy.sy;

import lombok.RequiredArgsConstructor;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class BatchService {
    private final QuartzService quartzService;

    @PostConstruct
    public void init() {
        try {
            quartzService.addSimpleJob(QuartzJob.class, "QuartzJob", "Quartz 5",null , 5);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
