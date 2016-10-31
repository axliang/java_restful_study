/*
 * Project: restApi
 * 
 * File Created at 2016年10月28日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.example.annotation.method;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

/**
 * @Type GetTest.java
 * @Desc 
 * @author alex
 * @date 2016年10月28日 下午3:15:39
 * @version 
 */
public class GetTest  extends JerseyTest{

    @Override
    protected Application configure() {
        return new ResourceConfig(EBookResourceImpl.class);
    }

    @Test
    public void testGet() {
        final Response response = target("book").request().get();
        Assert.assertEquals("150M", response.readEntity(String.class));
    }
    

}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016年10月28日 alex creat
 */