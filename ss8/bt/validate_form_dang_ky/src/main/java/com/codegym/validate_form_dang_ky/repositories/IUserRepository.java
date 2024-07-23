package com.codegym.validate_form_dang_ky.repositories;

import com.codegym.validate_form_dang_ky.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
