package com.example.springmongoboilerplate.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CreateUser {

  @NotEmpty
  private String name;

  @Min(1)
  @Max(1000)
  private int age;
}
