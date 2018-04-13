package com.jiashu.web.entity.dto;

import java.util.List;

public class ProxyServers {

    private List<Proxy> proxyServers;

    public ProxyServers(List<Proxy> proxyServers) {
        this.proxyServers = proxyServers;
    }

    public List<Proxy> getProxyServers() {
        return proxyServers;
    }

    public void setProxyServers(List<Proxy> proxyServers) {
        this.proxyServers = proxyServers;
    }
}
