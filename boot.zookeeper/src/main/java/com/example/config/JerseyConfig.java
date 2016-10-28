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
package com.example.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.example.resource.MyResource;

/**
 * @Type JerseyConfig.java
 * @Desc 
 * @author alex
 * @date 2016年10月27日 下午2:35:18
 * @version 
 */
@Component
public class JerseyConfig extends ResourceConfig {
    
    public JerseyConfig(){
        register(MyResource.class);
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