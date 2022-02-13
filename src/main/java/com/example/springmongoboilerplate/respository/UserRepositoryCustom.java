package com.example.springmongoboilerplate.respository;

import com.example.springmongoboilerplate.model.User;

/**
 * MongoTemplate 전용 인터페이스
 */
public interface UserRepositoryCustom {

  User findHello();
}
