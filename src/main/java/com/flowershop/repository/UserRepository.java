package com.flowershop.repository;

import com.flowershop.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findByMobile(String mobile);
}
