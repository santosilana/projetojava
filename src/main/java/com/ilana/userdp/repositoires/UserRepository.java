package com.ilana.userdp.repositoires;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ilana.userdp.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
