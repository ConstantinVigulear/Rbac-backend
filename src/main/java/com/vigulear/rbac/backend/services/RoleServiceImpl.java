package com.vigulear.rbac.backend.services;

import com.vigulear.rbac.backend.repository.RoleRepository;
import com.vigulear.rbac.backend.model.Role;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/** Created by kosta on 3/31/2023 */
@Service
public class RoleServiceImpl implements RoleService {

  private final RoleRepository roleRepository;

  public RoleServiceImpl(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
  public List<Role> getAllRoles() {
    List<Role> roles = new ArrayList<>();
    Iterable<Role> result = roleRepository.findAll();
    result.forEach(roles::add);
    return roles;
  }

  @Override
  public Role getRoleById(String id) {
    Optional<Role> result = roleRepository.findById(id);

    return result.orElse(null);
  }

  @Override
  public void saveRole(Role role) {
    roleRepository.save(role);
  }

  @Override
  public void deleteRole(String id) {
    roleRepository.deleteById(id);
  }
}
