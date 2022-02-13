package com.example.springmongoboilerplate.respository;

import com.example.springmongoboilerplate.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>, UserRepositoryCustom {


}
