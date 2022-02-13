package com.example.springmongoboilerplate.service;

import com.example.springmongoboilerplate.dto.CreateUser;
import com.example.springmongoboilerplate.dto.UpdateUser;
import com.example.springmongoboilerplate.model.User;
import java.util.List;

public interface UserService {

  List<User> findAll();

  void saveUser(CreateUser user);

  void deleteUser(String id);

  void updateUser(UpdateUser updateUser);

  User findById(String id);

  User hello(String id);
}
