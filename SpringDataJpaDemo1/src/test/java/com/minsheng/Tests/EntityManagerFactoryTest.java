package com.minsheng.Tests;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @Project SpringDataJpaTest
 * @Package com.minsheng.Tests
 * @Author SongHe
 * @Date 2020/2/5 14:58
 * @Version 1.0
 * @Description EntityManagerFactory工厂类,用于创建EntityManager.该对象线程安全但是消耗资源较大,使用时应使用单例模式创建
 */
public class EntityManagerFactoryTest {
    @Test
    public void fun() {
        String s = "myJpa";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(s);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
    }
}
