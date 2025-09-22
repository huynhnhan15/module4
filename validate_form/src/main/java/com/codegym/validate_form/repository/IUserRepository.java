package com.codegym.validate_form.repository;

import com.codegym.validate_form.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Long> {
}