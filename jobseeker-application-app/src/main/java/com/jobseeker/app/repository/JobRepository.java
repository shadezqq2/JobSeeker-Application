package com.jobseeker.app.repository;

import com.jobseeker.domain.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Long> {

    @Query(value = "SELECT * FROM JOB WHERE lower(TITLE) LIKE %:search% AND  lower(LOCATION) LIKE %:location%", nativeQuery = true)
    List<JobEntity> getJobsByTitleAndLocationLike(@Param("search") String search, @Param("location") String location);

    @Query(value = "SELECT * FROM JOB WHERE JOB_ID = ?", nativeQuery = true)
    JobEntity getJobById(Long id);
}
