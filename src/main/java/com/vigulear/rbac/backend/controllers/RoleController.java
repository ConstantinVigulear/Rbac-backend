package com.vigulear.rbac.backend.controllers;

import com.vigulear.rbac.backend.exception_handlig.NoSuchDataException;
import com.vigulear.rbac.backend.model.Role;
import com.vigulear.rbac.backend.services.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Created by kosta on 3/31/2023 */
@RestController
@CrossOrigin
@RequestMapping("/rbac")
public class RoleController {

  private final RoleService roleService;

  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  @GetMapping({"/roles", "/roles/"})
  public List<Role> showAllRoles() {
    return roleService.getAllRoles();
  }

  @GetMapping({"/roles/{id}", "/roles/{id}/"})
  public Role showRoleById(@PathVariable String id) {
    Role role = roleService.getRoleById(id);

    if (role == null)
      throw new NoSuchDataException("There is no role with id = " + id + " in database");

    return role;
  }

  @PostMapping({"/roles", "/roles/"})
  public Role addNewRole(@RequestBody Role role) {
    roleService.saveRole(role);
    return role;
  }

  @PutMapping({"/roles", "/roles/"})
  public Role updateRole(@RequestBody Role role) {
    roleService.saveRole(role);
    return role;
  }

  @DeleteMapping({"/roles/{id}", "/roles/{id}/"})
  public String deleteRole(@PathVariable String id) {
    Role role = roleService.getRoleById(id);

    if (role == null)
      throw new NoSuchDataException("There is no such role with ID = " + id + " in database");

    roleService.deleteRole(id);
    return "Role with ID = " + id + " was deleted";
  }
}
