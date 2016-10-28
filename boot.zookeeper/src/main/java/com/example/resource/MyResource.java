/*
 * Project: boot.zookeeper
 * 
 * File Created at 2016年10月27日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.example.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;

/**
 * @Type MyResource.java
 * @Desc 
 * @author alex
 * @date 2016年10月27日 下午2:33:42
 * @version 
 */
@Component
@Path("/")
public class MyResource {
    
    @Autowired
    private DiscoveryClient discover;
    
    @Autowired
    private LoadBalancerClient loadBalancer;

    @Value("${spring.application.name:bootZookeeper}")
    private String appName;
    
    @Path("hi")
    @GET
    public String hi(){
        ServiceInstance serviceInstance = discover.getLocalServiceInstance();
        return serviceInstance.getHost() +":"+serviceInstance.getPort();
    }
    
    @Path("all")
    @GET
    @Produces("application/json")
    public List<ServiceInstance> getService(){
        return discover.getInstances(appName);
    }
    
    @Path("discovery")
    @GET
    @Produces("application/json")
    public ServiceInstance discovery(){
        return loadBalancer.choose(appName);
    }
    
}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016年10月27日 alex creat
 */