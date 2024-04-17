package com.workshop.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.workshop.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
