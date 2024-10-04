package com.classluv2code.jobportal.services;

import com.classluv2code.jobportal.entity.JobSeekerProfile;
import com.classluv2code.jobportal.entity.RecruiterProfile;
import com.classluv2code.jobportal.entity.Users;
import com.classluv2code.jobportal.repository.JobSeekerProfileRepository;
import com.classluv2code.jobportal.repository.RecruiterProfileRepository;
import com.classluv2code.jobportal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository
            , RecruiterProfileRepository recruiterProfileRepository
            , JobSeekerProfileRepository jobSeekerProfileRepository) {
        this.usersRepository = usersRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
    }

    public Users addNewUser(Users user) {
        user.setActive(true);
        user.setRegistrationDate(new Date(System.currentTimeMillis()));
        Users savedUser = usersRepository.save(user);
        int userTypeId = user.getUserTypeId().getUserTypeId();
        if(userTypeId == 1) {
            recruiterProfileRepository.save(new RecruiterProfile(savedUser));
        } else {
            jobSeekerProfileRepository.save(new JobSeekerProfile(savedUser));
        }

        return savedUser;
    }

    public Optional<Users> getUserByEmail(String email){
        return usersRepository.findByEmail(email);
    }
}
