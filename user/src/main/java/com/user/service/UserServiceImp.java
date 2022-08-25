package com.user.service;

import com.user.config.CustomNotFoundException;
import com.user.dto.DepartmentDto;
import com.user.dto.UserDepartmentDto;
import com.user.model.User;
import com.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public List<User> findAllUsers() {
        return StreamSupport.stream(
                userRepository.findAll()
                        .spliterator(),
                false
        )
                .collect(Collectors.toList());
    }

    @Override
    public UserDepartmentDto findById(Long id) {
        return userRepository.findById(id)
                .map(obj->{
                    UserDepartmentDto userDepartmentDto= new UserDepartmentDto();
                    DepartmentDto departmentDto=restTemplate.getForObject(
                            "http://DEPARTMENT-SERVICE/departments/id/"+obj.getDepartmentId(),
                            DepartmentDto.class
                    );
                    userDepartmentDto.setUser(obj);
                    userDepartmentDto.setDepartmentDto(departmentDto);
                    return userDepartmentDto;
                })
                .orElseThrow(()->new CustomNotFoundException("Not Found!!"));
    }


    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(()->new CustomNotFoundException("Not Found Exception"));
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
