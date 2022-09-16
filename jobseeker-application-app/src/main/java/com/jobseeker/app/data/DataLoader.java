package com.jobseeker.app.data;

import com.jobseeker.app.repository.JobRepository;
import com.jobseeker.app.repository.UserRepository;
import com.jobseeker.domain.JobEntity;
import com.jobseeker.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DataLoader {

    @Autowired
    private DataInitializer initializer;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        saveUsers(initializer.createUsers());
        saveJobs(initializer.createJobs());

    }

    private void saveUsers(List<UserEntity> users) {
        userRepository.saveAll(users);
    }

    private void saveJobs(List<JobEntity> jobs) {
        jobRepository.saveAll(jobs);
    }
}
