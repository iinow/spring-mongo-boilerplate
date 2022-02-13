package com.example.springmongoboilerplate.service.impl;

import com.example.springmongoboilerplate.common.ResponseType;
import com.example.springmongoboilerplate.dto.CreateUser;
import com.example.springmongoboilerplate.dto.UpdateUser;
import com.example.springmongoboilerplate.exception.CommonException;
import com.example.springmongoboilerplate.model.User;
import com.example.springmongoboilerplate.respository.UserRepository;
import com.example.springmongoboilerplate.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  private final RedisTemplate<String, Object> redisTemplateJson;

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public void saveUser(CreateUser createUser) {
    userRepository.save(new User(createUser));
  }

  @Override
  public void deleteUser(String id) {
    userRepository.deleteById(id);
  }

  @Override
  public void updateUser(UpdateUser updateUser) {
    this.findById(updateUser.getId());
    this.userRepository.save(new User(updateUser));
  }

  @Override
  public User findById(String id) {
    var savedUser = redisTemplateJson.boundHashOps("USER").get(String.format("ID:%s", id));
    if (savedUser == null) {
      var user = this.userRepository.findById(id)
          .orElseThrow(() -> new CommonException(ResponseType.USER_NOT_FOUND, id));
      redisTemplateJson.boundHashOps("USER").put(String.format("ID:%s", id), user);
      savedUser = user;
    }

    return (User) savedUser;
  }

  @Override
  public User hello(String id) {
    return this.userRepository.findHello();
  }
}
