package com.user.service;

import com.user.dto.UserDepartmentDto;
import com.user.model.User;

import java.util.List;

public interface UserService {

    public List<User> findAllUsers();

    public UserDepartmentDto findById(Long id);

    public User findByEmail(String email);

    public User saveUser(User user);
}
