package com.example01.Test01.repo;

import com.example01.Test01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

public interface userRepo extends JpaRepository<User,Integer> {
@Query (value = "SELECT * FROM user WHERE id= ?1", nativeQuery = true)
    User getUserByUserID(String userId);

//@Modifying-update
    @Query (value = "SELECT * FROM user WHERE id= ?1 AND address= ?2", nativeQuery = true)
User getUserByIdAndAddress(String userId,String Addresss);
}
