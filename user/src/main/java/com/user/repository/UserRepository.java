package com.user.repository;

import com.user.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User,Long> {
    public Optional<User> findByEmail(String email);
}
