package com.jobseeker.app.service;

import com.jobseeker.domain.JobEntity;
import com.jobseeker.domain.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobSeekerFacade {
    private final JobSeekerService jobSeekerService;


    public JobSeekerFacade(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    public boolean authenticateUser(UserEntity user) {
        return jobSeekerService.authenticateUser(user);
    }

    public boolean registerUser(UserEntity user) {
        return jobSeekerService.registerUser(user);
    }

    public List<JobEntity> getSearchResult(String search, String location) {
        return jobSeekerService.getSearchResult(search, location);
    }

    public boolean registerJob(JobEntity job) {
        return jobSeekerService.registerJob(job);
    }

}
