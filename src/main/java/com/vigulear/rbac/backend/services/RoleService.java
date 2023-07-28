package com.vigulear.rbac.backend.services;

import com.vigulear.rbac.backend.model.Role;

import java.util.List;

/** Created by kosta on 3/31/2023 */
public interface RoleService {

  List<Role> getAllRoles();

  Role getRoleById(String id);

  void saveRole(Role role);

  void deleteRole(String id);
}
