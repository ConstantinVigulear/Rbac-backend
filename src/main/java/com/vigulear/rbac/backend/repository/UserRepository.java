package com.vigulear.rbac.backend.repository;

import com.vigulear.rbac.backend.model.User;
import org.springframework.data.repository.CrudRepository;

/** Created by kosta on 3/31/2023 */
public interface UserRepository extends CrudRepository<User, String> {}
