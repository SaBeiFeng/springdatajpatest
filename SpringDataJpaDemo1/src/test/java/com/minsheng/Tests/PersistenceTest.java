package com.minsheng.Tests;

import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @Project SpringDataJpaTest
 * @Package com.minsheng.Tests
 * @Author SongHe
 * @Date 2020/2/5 14:53
 * @Version 1.0
 * @Description Persistence工具类,单纯就是读取配置文件,创建配置文件里面的配置单元描述的EntityManagerFactory对象
 */
public class PersistenceTest {
    @Test
    public void fun() {
        String s = "myJpa";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(s);
    }
}
