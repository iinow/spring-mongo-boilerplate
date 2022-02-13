package com.example.springmongoboilerplate.api;

import com.example.springmongoboilerplate.common.ResponseType;
import com.example.springmongoboilerplate.dto.CreateUser;
import com.example.springmongoboilerplate.dto.Response;
import com.example.springmongoboilerplate.dto.UpdateUser;
import com.example.springmongoboilerplate.model.User;
import com.example.springmongoboilerplate.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@RestController
public class UserController {

  private final UserService userService;

  @Operation
  @GetMapping
  public ResponseEntity<Response<List<User>>> getUsers() {
    return ResponseEntity.ok(Response.of(userService.findAll()));
  }

  @Operation
  @GetMapping("/{id}")
  public ResponseEntity<Response<User>> getUser(@PathVariable("id") String id) {
    return ResponseEntity.ok(Response.of(userService.findById(id)));
  }

  @Operation
  @PostMapping
  public ResponseEntity<Response<Void>> postUser(@Valid @RequestBody CreateUser createUser) {
    userService.saveUser(createUser);
    return ResponseEntity.ok(Response.of(ResponseType.OK));
  }

  @Operation
  @DeleteMapping
  public ResponseEntity<Response<Void>> deleteUser(@RequestParam("id") String id) {
    userService.deleteUser(id);
    return ResponseEntity.ok(Response.of(ResponseType.OK));
  }

  @Operation
  @PutMapping
  public ResponseEntity<Response<Void>> putUser(@Valid @RequestBody UpdateUser updateUser) {
    userService.updateUser(updateUser);
    return ResponseEntity.ok(Response.of(ResponseType.OK));
  }
}
