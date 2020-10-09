package com.code.himanshu.spring.scheduler;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleJob implements Job {

    @Autowired
    private SampleJobService sampleJobService = new SampleJobService();

    public void execute(JobExecutionContext context) throws JobExecutionException {
        sampleJobService.executeRestartService();
    }
}
