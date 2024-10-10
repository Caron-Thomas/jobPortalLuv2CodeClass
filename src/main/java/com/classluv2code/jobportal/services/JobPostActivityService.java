package com.classluv2code.jobportal.services;

import com.classluv2code.jobportal.entity.*;
import com.classluv2code.jobportal.repository.JobPostActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobPostActivityService {

    private final JobPostActivityRepository jobPostActivityRepository;

    @Autowired
    public JobPostActivityService(JobPostActivityRepository jobPostActivityRepository) {
        this.jobPostActivityRepository = jobPostActivityRepository;
    }

    public JobPostActivity addNew(JobPostActivity jobPostActivity) {
        return jobPostActivityRepository.save(jobPostActivity);
    }

    public List<RecruiterJobsDto> getRecruiterJobs(int recruiter) {

        List<IRecruiterJobs> recruiterJobs = jobPostActivityRepository.getRecruiterJobs(recruiter);

        List<RecruiterJobsDto> recruiterJobsDtos = new ArrayList<>();

        for(IRecruiterJobs rec: recruiterJobs) {
            JobLocation jobLocation = new JobLocation(rec.getLocationId(), rec.getCity(),rec.getState(),rec.getCountry());
            JobCompany jobCompany = new JobCompany(rec.getCompanyId(), rec.getName(), "");
            recruiterJobsDtos.add(new RecruiterJobsDto(rec.getTotalCandidates(), rec.getJob_post_id()
                    ,rec.getJob_title(), jobLocation, jobCompany));
        }
        return recruiterJobsDtos;
    }
}
