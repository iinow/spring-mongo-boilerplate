package com.example.springmongoboilerplate.model;

import com.example.springmongoboilerplate.dto.CreateUser;
import com.example.springmongoboilerplate.dto.UpdateUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(User.COLLECTION_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {

  public static final String COLLECTION_NAME = "users";

  @Id
  private String id;

  private String name;

  private Integer age;

  public User(CreateUser createUser) {
    this.name = createUser.getName();
    this.age = createUser.getAge();
  }

  public User(UpdateUser updateUser) {
    this.id = id;
    this.name = updateUser.getName();
    this.age = updateUser.getAge();
  }
}
