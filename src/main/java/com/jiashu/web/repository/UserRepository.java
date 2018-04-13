package com.jiashu.web.repository;

import com.jiashu.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created on 2018/4/9 10:24.
 *
 * @author Stanley Huang
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Query(value = "select * from user where email = ?", nativeQuery = true)
    User findByEmail(String email);

    @Query(value = "select * from user where id = ?", nativeQuery = true)
    User findById(long id);

}
