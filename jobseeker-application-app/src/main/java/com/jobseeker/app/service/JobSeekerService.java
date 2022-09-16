package com.jobseeker.app.service;

import com.jobseeker.app.data.DataStore;
import com.jobseeker.domain.JobEntity;
import com.jobseeker.domain.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class JobSeekerService implements JobSeekerInterface {
    private final DataStore dataStore;
    private final Logger logger = LoggerFactory.getLogger(JobSeekerService.class);

    public JobSeekerService(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public boolean authenticateUser(UserEntity user) {
        UserEntity userEntity = null;
        try {
            List<UserEntity> users = dataStore.getUsers();
            userEntity = users.stream()
                    .filter(getUserForAuthFilter(user))
                    .findAny()
                    .orElseThrow(() -> new Exception("No User found with these details!"));
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        return userEntity != null;
    }

    private Predicate<UserEntity> getUserForAuthFilter(UserEntity user) {
        return userEntity -> userEntity.getEmail().equals(user.getEmail());
    }

    @Override
    public boolean registerUser(UserEntity user) {
        if (authenticateUser(user)) {
            return false;
        } else {
            dataStore.registerUser(user);
            return true;
        }
    }

    @Override
    public List<JobEntity> getSearchResult(String search, String location) {
        return dataStore.getJobsByTitleAndLocationLike(search, location);
    }

    @Override
    public boolean registerJob(JobEntity job) {
        dataStore.registerJob(job);
        return true;
    }


}
