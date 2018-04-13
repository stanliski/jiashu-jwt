package com.jiashu.web.repository;

import com.jiashu.web.entity.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created on 2018/4/9 10:24.
 *
 * @author Stanley Huang
 */
public interface ServerRepository extends JpaRepository<Server, Long> {

    @Query(value = "select * from server where id = ?", nativeQuery = true)
    List<Server> findById(int id);

}
