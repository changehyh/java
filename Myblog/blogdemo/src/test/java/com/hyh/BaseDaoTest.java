package com.hyh;

import com.hyh.util.BaseDao;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
public class BaseDaoTest {

    @Test
    public void testConnection() {
        Connection connection = BaseDao.getConnection();
        Assert.assertNotNull(connection);
    }
}
