package com.jiashu.web.repository;


import com.jiashu.web.entity.AccountPlugin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created on 2018/4/3 20:04.
 *
 * @author Stanley Huang
 */
public interface AccountPluginRepository extends JpaRepository<AccountPlugin, Long> {

    @Query(value = "select * from account_plugin where userId = ?", nativeQuery = true)
    AccountPlugin findByUserId(long userId);

    @Query(value = "select * from account_plugin where port = ?", nativeQuery = true)
    AccountPlugin findByPort(int port);

    @Query(value = "SELECT max(account_plugin.port) from account_plugin", nativeQuery = true)
    int findMaxPort(int start, int end);

}
