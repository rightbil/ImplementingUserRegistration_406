package com.springboot.security.repository;

import com.springboot.security.model.Role;
import com.springboot.security.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);

}
