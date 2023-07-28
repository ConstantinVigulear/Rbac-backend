package com.vigulear.rbac.backend.services;

import com.vigulear.rbac.backend.model.User;
import com.vigulear.rbac.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/** Created by kosta on 3/31/2023 */
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> getAllUsers() {
    List<User> users = new ArrayList<>();
    Iterable<User> result = userRepository.findAll();
    result.forEach(users::add);

    return users;
  }

  @Override
  public User getUserByEmail(String email) {
    Optional<User> result = userRepository.findById(email);

    return result.orElse(null);
  }

  @Override
  public void saveUser(User user) {
    userRepository.save(user);
  }

  @Override
  public void deleteUser(String email) {
    userRepository.deleteById(email);
  }

  @Override
  public void deleteUser(User user) {
    userRepository.delete(user);
  }
}
