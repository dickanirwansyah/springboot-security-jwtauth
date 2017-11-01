package com.dickanirwansyah.jwt.springbootjwtauthentication.dao;

import com.dickanirwansyah.jwt.springbootjwtauthentication.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<Users, Long>{

    Users findOneCredentialsByusername(String username);
}
