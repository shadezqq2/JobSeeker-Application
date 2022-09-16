package com.jobseeker.app.data;


import com.jobseeker.domain.JobEntity;
import com.jobseeker.domain.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {

    public List<UserEntity> createUsers() {

        UserEntity user1 = new UserEntity();
        user1.setName("John Doe");
        user1.setEmail("johndoe@example.com");

        UserEntity user2 = new UserEntity();
        user2.setName("Jane Doe");
        user2.setEmail("janedoe@example.com");

        return List.of(user1, user2);
    }

    public List<JobEntity> createJobs() {

        JobEntity job1 = new JobEntity();
        job1.setTitle("Java Software Engineer");
        job1.setLocation("London");

        JobEntity job2 = new JobEntity();
        job2.setTitle("C++ Software Engineer");
        job2.setLocation("New York");
        return List.of(job1, job2);
    }
}
