package com.classluv2code.jobportal.repository;

import com.classluv2code.jobportal.entity.JobPostActivity;
import com.classluv2code.jobportal.entity.JobSeekerApply;
import com.classluv2code.jobportal.entity.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerApplyRepository extends JpaRepository<JobSeekerApply, Integer> {

    List<JobSeekerApply> findByUserId(JobSeekerProfile userId);

    List<JobSeekerApply> findByJob(JobPostActivity job);
}
