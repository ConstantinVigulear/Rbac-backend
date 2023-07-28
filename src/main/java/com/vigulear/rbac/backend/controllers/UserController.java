package com.vigulear.rbac.backend.controllers;

import com.vigulear.rbac.backend.exception_handlig.NoSuchDataException;
import com.vigulear.rbac.backend.model.User;
import com.vigulear.rbac.backend.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Created by kosta on 3/31/2023 */
@RestController
@CrossOrigin
@RequestMapping("/rbac")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping({"/users", "/users/"})
  public List<User> showAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping({"/users/{email}", "/users/{email}/"})
  public User showUserByEmail(@PathVariable String email) {
    User user = userService.getUserByEmail(email);

    if (user == null)
      throw new NoSuchDataException("There is no user with EMAIL = " + email + " in database");

    return user;
  }

  @PostMapping({"/users", "/users/"})
  public User addNewUser(@RequestBody User user) {
    userService.saveUser(user);
    return user;
  }

  @PutMapping({"/users", "/users/"})
  public User updateUser(@RequestBody User user) {
    userService.saveUser(user);
    return user;
  }

  @DeleteMapping({"/users/{email}", "/users/{email}/"})
  public User deleteUser(@PathVariable String email) {
    User user = userService.getUserByEmail(email);

    if (user == null)
      throw new NoSuchDataException("There is no user with EMAIL = " + email + " in database");

    userService.deleteUser(email);

    return user;
  }

  @DeleteMapping({"/users", "/users/"})
  public User deleteUser(@RequestBody User user) {

    if (user == null) throw new NoSuchDataException("There is no user in database");

    userService.deleteUser(user);

    return user;
  }
}
