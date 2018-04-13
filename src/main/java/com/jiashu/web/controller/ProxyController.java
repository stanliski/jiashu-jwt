package com.jiashu.web.controller;

import com.jiashu.web.auth.TokenValidator;
import com.jiashu.web.entity.AccountPlugin;
import com.jiashu.web.entity.ErrorInfo;
import com.jiashu.web.entity.Server;
import com.jiashu.web.entity.dto.Proxy;
import com.jiashu.web.entity.dto.ProxyServers;
import com.jiashu.web.entity.dto.Response;
import com.jiashu.web.service.AccountPluginService;
import com.jiashu.web.service.ServerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018/4/3 20:04.
 *
 * @author Stanley Huang
 */
@RestController
@Validated
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProxyController {

    private static final Logger logger = LoggerFactory.getLogger(ProxyController.class);

    @Autowired
    private AccountPluginService accountPluginService;

    @Autowired
    private ServerService serverService;

    @Autowired
    private TokenValidator tokenValidator;

    @ApiOperation("获取代理服务器列表")
    @ApiResponses(@ApiResponse(code = 200, message = "Token and login user info"))
    @GetMapping("/server")
    public ResponseEntity<Response<ProxyServers>> getServerList(@RequestHeader("Authorization")
                                                                @Length(max = 2000) String token) {
        long userId = tokenValidator.getUserIdWithoutValidated(token);
        AccountPlugin accountPlugin = accountPluginService.loadAccountPluginByUserId(userId);
        String serverIds = accountPlugin.getServer();
        if (serverIds == null) {
            Response<ProxyServers> notFoundResponse = new Response<>(ErrorInfo.NOT_FOUND, "No proxy server exist ", "没有可用代理服务器");
            return new ResponseEntity<>(notFoundResponse, notFoundResponse.getStatusCode());
        }
        List<Server> servers = serverService.loadServerById(getServerIds(serverIds));
        List<Proxy> proxys = new ArrayList<>(servers.size());
        for (int i = 0; i < servers.size(); i++) {
            Server server = servers.get(i);
            Proxy proxy = new Proxy(server.getName(), server.getHost(),
                    accountPlugin.getPort(), accountPlugin.getPassword(),
                    server.getMethod(), server.getComment());
            proxys.add(proxy);
        }
        Response<ProxyServers> response = new Response<>(new ProxyServers(proxys));
        return new ResponseEntity<>(response, response.getStatusCode());
    }

    private List<Long> getServerIds(String serverList) {
        String newStr = serverList.substring(1, serverList.length() - 1);
        String[] ids = newStr.split(",");
        List<Long> idList = new ArrayList<>(ids.length);
        for (int i = 0; i < ids.length; i++) {
            idList.add(Long.valueOf(ids[i]));
        }
        return idList;
    }

}
