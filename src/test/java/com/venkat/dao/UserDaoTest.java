package com.venkat.dao;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.venkat.dao.UserDao;
import com.venkat.model.User;

public class UserDaoTest {

    private EmbeddedDatabase db;
    private static final Logger log = Logger.getLogger(UserDaoTest.class.getName());
    UserDao userDao;
    
    @Before
    public void setUp() {
        //db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
    	db = new EmbeddedDatabaseBuilder()
    		.setType(EmbeddedDatabaseType.HSQL)
    		.addScript("db/sql/create-db.sql")
    		.addScript("db/sql/insert-db.sql")
    		.build();
    	
    }

    @Test
    public void testFindByname() {
    	NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
    	UserDao userDao = new UserDao();
    	userDao.setNamedParameterJdbcTemplate(template);
    	log.info("entering test case");
    	User user = userDao.findAll().get(0);
    	log.info(userDao.findAll().toString());
    	Assert.assertNotNull(user);
    	//Assert.assertEquals(1, user.getId().intValue());
    	//Assert.assertEquals("mkyong", user.getName());
    	//Assert.assertEquals("mkyong@gmail.com", user.getEmail());

    }

    @After
    public void tearDown() {
        db.shutdown();
    }

}