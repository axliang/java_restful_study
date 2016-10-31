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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.example.domain.Book;

/**
 * @Type EBookResource.java
 * @Desc 
 * @author alex
 * @date 2016年10月28日 下午3:08:10
 * @version 
 */
public class EBookResourceImpl implements BookResource {
    private final static Logger LOGGER = Logger.getLogger(EBookResourceImpl.class);

    @Override
    public String getWeight() {
        // TODO Auto-generated method stub
        return "150M";
    }

    @Override
    public String newBook(Book book) {
        // TODO Auto-generated method stub
        SimpleDateFormat f = new SimpleDateFormat("d MMM yyyy HH:mm:ss");
        Date lastUpdate = Calendar.getInstance().getTime();
        //...
        LOGGER.debug(book.getBookId());
        return f.format(lastUpdate);
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