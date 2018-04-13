package com.jiashu.web.service.impl;

import com.jiashu.web.entity.AccountPlugin;
import com.jiashu.web.repository.AccountPluginRepository;
import com.jiashu.web.service.AccountPluginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 2018/4/9 10:49.
 *
 * @author Stanley Huang
 */
@Service
public class AccountPluginServiceImpl implements AccountPluginService {

    @Autowired
    private AccountPluginRepository accountPluginRepository;

    @Override
    public AccountPlugin loadAccountPluginByUserId(long userId) {
        return accountPluginRepository.findByUserId(userId);
    }

    @Override
    public boolean checkIfPortExists(int port) {
        AccountPlugin accountPlugin = accountPluginRepository.findByPort(port);
        if (accountPlugin == null) {
            return false;
        }
        return true;
    }

    @Override
    public int getMaxPort(int portStart, int portEnd) {
        return accountPluginRepository.findMaxPort(portStart, portEnd);
    }

}
