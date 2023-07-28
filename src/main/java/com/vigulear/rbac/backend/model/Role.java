package com.vigulear.rbac.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Created by kosta on 3/31/2023 */
@Entity
@Table(name = "roles")
public class Role {

  @Id
  @Column(name = "id")
  private String id;

  @Column(name = "description")
  private String description;

  @ManyToMany(
      mappedBy = "roles",
      fetch = FetchType.LAZY,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JsonIgnore
  private List<User> users = new ArrayList<>();

  public Role() {}

  public String getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public List<User> getUsers() {
    return users;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Role role)) return false;
    return Objects.equals(getId(), role.getId())
        && Objects.equals(getDescription(), role.getDescription())
        && Objects.equals(getUsers(), role.getUsers());
  }

  @Override
  public int hashCode() {
    int result = getId() != null ? getId().hashCode() : 0;
    result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
    result = 31 * result + (getUsers() != null ? getUsers().hashCode() : 0);
    return result;
  }
}
