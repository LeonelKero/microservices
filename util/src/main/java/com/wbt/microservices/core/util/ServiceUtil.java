package com.wbt.microservices.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Component
public class ServiceUtil {
    @Autowired
    private Environment environment;

    private String hostname;
    private String port;

    public String getServiceAddress() {
        return "%S:%S".formatted(this.getHostname(), this.getPort());
    }

    private String getHostname() {
        try {
            if (hostname == null)
                hostname = InetAddress.getLocalHost().getHostName();
            return hostname;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Unable to get hostname";
    }

    private String getPort() {
        if (port == null)
            port = environment.getProperty("local.server.port");
        return port;
    }
}
