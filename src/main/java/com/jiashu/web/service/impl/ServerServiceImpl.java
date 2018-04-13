package com.jiashu.web.service.impl;

import com.jiashu.web.entity.Server;
import com.jiashu.web.repository.ServerRepository;
import com.jiashu.web.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2018/4/9 10:49.
 *
 * @author Stanley Huang
 */
@Service
public class ServerServiceImpl implements ServerService {

    @Autowired
    private ServerRepository serverRepository;

    @Override
    public List<Server> loadServerById(List<Long> ids) {
//        return serverRepository.findById(id);
        return serverRepository.findAllById(ids);
    }


}
