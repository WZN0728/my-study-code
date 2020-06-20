package com.demo.nginx.nginx;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wuting
 * @date 2019/02/17
 */
public class NginxControllerDemo {

    @RequestMapping("/nginxRute")
    public String getIp(HttpServletRequest httpServletRequest) {
        String remoteAddr = httpServletRequest.getRemoteAddr();
        //真实IP
        String ngip = httpServletRequest.getHeader("X-Real_IP");
        String param = httpServletRequest.getHeader("interface_version");
        return remoteAddr + "->" + ngip + "->" + param;
    }

}
