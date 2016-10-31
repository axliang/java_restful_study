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

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Assert;
import org.junit.Test;

import com.example.domain.Book;

/**
 * @Type PutTest.java
 * @Desc 
 * @author alex
 * @date 2016年10月28日 下午4:34:52
 * @version 
 */
public class PutTest extends JerseyTest {
    
    private final static Logger LOGGER = Logger.getLogger(PutTest.class);
    public static AtomicLong  clientBookSequence = new AtomicLong();
    
    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(EBookResourceImpl.class);
    }
    
    @Test
    public void testNew(){
        final Book newBook = new Book(clientBookSequence.incrementAndGet(), "book-" + System.nanoTime());
        MediaType contentTypeMediaType = MediaType.APPLICATION_XML_TYPE;
        MediaType acceptMediaType = MediaType.TEXT_PLAIN_TYPE;
        final Entity<Book> bookEntity = Entity.entity(newBook, contentTypeMediaType);
        final String lastUpdate = target("book").request(acceptMediaType).put(bookEntity, String.class);
        Assert.assertNotNull(lastUpdate);
        LOGGER.debug(lastUpdate);
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