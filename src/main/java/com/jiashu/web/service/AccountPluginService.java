package com.jiashu.web.service;


import com.jiashu.web.entity.AccountPlugin;


/**
 * Created on 2018/4/9 10:43.
 *
 * @author Stanley Huang
 */
public interface AccountPluginService {

    AccountPlugin loadAccountPluginByUserId(long userId);

    boolean checkIfPortExists(int port);

    int getMaxPort(int portStart, int portEnd);

}
