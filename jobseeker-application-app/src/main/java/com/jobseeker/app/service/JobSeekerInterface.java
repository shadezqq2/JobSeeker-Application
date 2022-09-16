package com.jobseeker.app.service;

import com.jobseeker.domain.JobEntity;
import com.jobseeker.domain.UserEntity;

import java.util.List;

public interface JobSeekerInterface {

    boolean authenticateUser(UserEntity user);

    boolean registerUser(UserEntity user);

    List<JobEntity> getSearchResult(String search, String location);

    boolean registerJob(JobEntity job);
}
