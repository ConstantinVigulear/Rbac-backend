package com.vigulear.rbac.backend.services;

import com.vigulear.rbac.backend.model.User;

import java.util.List;

/** Created by kosta on 3/31/2023 */
public interface UserService {
  List<User> getAllUsers();

  User getUserByEmail(String email);

  void saveUser(User user);

  void deleteUser(String email);

  void deleteUser(User user);
}
