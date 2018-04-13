package com.jiashu.web.service;

import com.jiashu.web.entity.Server;

import java.util.List;

/**
 * Created on 2018/4/9 10:43.
 *
 * @author Stanley Huang
 */
public interface ServerService {

    List<Server> loadServerById(List<Long> ids);

}