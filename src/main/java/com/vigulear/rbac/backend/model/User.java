package com.vigulear.rbac.backend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/** Created by kosta on 3/31/2023 */
@Entity
@Table(name = "users")
public class User {

  @Column(name = "name")
  private String name;

  @Id
  @Column(name = "email")
  private String email;

  @Column(name = "salary")
  private int salary;

  @Column(name = "active")
  private boolean active;

  @ManyToMany(
      fetch = FetchType.LAZY,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinTable(
      name = "users_roles",
      joinColumns = @JoinColumn(name = "user_email"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private List<Role> roles = new ArrayList<>();

  public User() {}

  public boolean getActive() {
    return active;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }


  public int getSalary() {
    return salary;
  }


  public List<Role> getRoles() {
    return roles;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User user)) return false;

    if (getSalary() != user.getSalary()) return false;
    if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null)
      return false;
    if (getEmail() != null ? !getEmail().equals(user.getEmail()) : user.getEmail() != null)
      return false;
    if (getActive() != user.getActive()) return false;
    return getRoles() != null ? getRoles().equals(user.getRoles()) : user.getRoles() == null;
  }

  @Override
  public int hashCode() {
    int result = getName() != null ? getName().hashCode() : 0;
    result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
    result = 31 * result + getSalary();
    result = 31 * result + (getRoles() != null ? getRoles().hashCode() : 0);
    return result;
  }
}
