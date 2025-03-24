package com.empresa.erp.repositories;

import com.empresa.erp.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    @Query("SELECT u FROM UserModel u WHERE LOWER(u.username) = LOWER(:username)")
    Optional<UserModel> findByUsername(@Param("username") String username);
}