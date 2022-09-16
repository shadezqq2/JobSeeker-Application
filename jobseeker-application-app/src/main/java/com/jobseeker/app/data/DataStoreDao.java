package com.jobseeker.app.data;

import com.jobseeker.app.repository.JobRepository;
import com.jobseeker.app.repository.UserRepository;
import com.jobseeker.domain.JobEntity;
import com.jobseeker.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataStoreDao implements DataStore {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<JobEntity> getJobs() {
        return jobRepository.findAll();
    }

    @Override
    public void registerUser(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public List<JobEntity> getJobsByTitleAndLocationLike(String search, String location) {
        return jobRepository.getJobsByTitleAndLocationLike(search, location);
    }

    @Override
    public JobEntity getJobById(Long id) {
        return jobRepository.getJobById(id);
    }

    @Override
    public void registerJob(JobEntity job) {
        jobRepository.save(job);
    }

}
