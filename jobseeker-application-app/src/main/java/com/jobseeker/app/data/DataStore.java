package com.jobseeker.app.data;

import com.jobseeker.domain.JobEntity;
import com.jobseeker.domain.UserEntity;

import java.util.List;

public interface DataStore {

    List<UserEntity> getUsers();

    List<JobEntity> getJobs();

    void registerUser(UserEntity user);

    List<JobEntity> getJobsByTitleAndLocationLike(String search, String location);

    JobEntity getJobById(Long id);

    void registerJob(JobEntity job);
}
