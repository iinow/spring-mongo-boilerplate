package com.example.springmongoboilerplate.respository.impl;

import com.example.springmongoboilerplate.model.User;
import com.example.springmongoboilerplate.respository.UserRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * MongoTemplate 사용
 */
@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

  private final MongoTemplate mongoTemplate;

  @Override
  public User findHello() {
    return mongoTemplate.findOne(new Query(Criteria.where("age").is(12)), User.class, User.COLLECTION_NAME);
  }
}
