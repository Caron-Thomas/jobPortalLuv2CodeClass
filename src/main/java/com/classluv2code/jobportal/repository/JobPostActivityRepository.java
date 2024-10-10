package com.classluv2code.jobportal.repository;


import com.classluv2code.jobportal.entity.IRecruiterJobs;
import com.classluv2code.jobportal.entity.JobPostActivity;
import com.classluv2code.jobportal.entity.RecruiterJobsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobPostActivityRepository extends JpaRepository<JobPostActivity,Integer> {

    @Query(value = "SELECT COUNT(s.user_id) as totalCandidates, j.job_post_id, j.job_title, l.id as locationId, l.city," +
            " l.state, l.country, c.id as companyId, c.name FROM job_post_activity j " +
            " inner join job_location l on j.job_location_id = l.id " +
            " inner join job_company c on j.job_company_id = c.id " +
            " left join job_seeker_apply s on s.job = j.job_post_id " +
            " where j.posted_by_id = :recruiter " +
            " group by j.job_post_id" , nativeQuery = true )
    List<IRecruiterJobs> getRecruiterJobs(@Param("recruiter") int recruiter);
}
