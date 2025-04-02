package com.delfalas.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.delfalas.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
