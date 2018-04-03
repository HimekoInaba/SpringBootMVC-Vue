package com.syrym.bootvue.bootvue.repository;


import com.syrym.bootvue.bootvue.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface RolesRepository extends JpaRepository<Roles, Long> {
}