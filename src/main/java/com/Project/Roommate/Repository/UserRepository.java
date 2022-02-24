package com.Project.Roommate.Repository;

import com.Project.Roommate.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUserid(String userid);
//    @Query(value = "SELECT * FROM user WHERE userid = ?",nativeQuery = true)
//    Optional<User> login(String userid);


    @Query(value = "SELECT * FROM user WHERE userid=? AND userpw=?",nativeQuery = true)
    User login(String userid,String userpw);
}
