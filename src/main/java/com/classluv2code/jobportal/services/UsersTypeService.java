package com.classluv2code.jobportal.services;

import com.classluv2code.jobportal.entity.UsersType;
import com.classluv2code.jobportal.repository.UsersTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersTypeService {

    private final UsersTypeRepository usersTypeRepository;

    public UsersTypeService(UsersTypeRepository usersTypeRepository) {
        this.usersTypeRepository = usersTypeRepository;
    }

    public List<UsersType> getAll(){
     return usersTypeRepository.findAll();
    }
}
