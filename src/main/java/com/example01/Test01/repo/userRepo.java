package com.example01.Test01.repo;

import com.example01.Test01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<User,Integer> {

}
