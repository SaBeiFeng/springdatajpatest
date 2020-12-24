package com.minsheng.Tests;

import com.minsheng.pojo.Customer;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

/**
 * @Project SpringDataJpaTest
 * @Package com.minsheng.Tests
 * @Author SongHe
 * @Date 2020/2/5 23:08
 * @Version 1.0
 * @Description TODO
 */
public class JPQLTest {
    /**
     *@Description 查询全部
     *@Params []
     *@Return void
     *@Author SongHe
     *@CreatTime 2020/2/5 18:27
     *@Updater&Else
     */
    @Test
    public void fun() {

        EntityManagerFactory myJpa = Persistence.createEntityManagerFactory("myJpa");
        EntityManager entityManager = myJpa.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        //基本的事务操作
        tx.begin();

        String hql = "from Customer";
        Query query = entityManager.createQuery(hql);
        List<Customer> resultList = query.getResultList();
        for (Customer customer : resultList) {
            System.out.println(customer);
        }
        tx.commit();

    }

    /**
     *@Description 模糊查询
     *@Params []
     *@Return void
     *@Author SongHe
     *@CreatTime 2020/2/5 18:27
     *@Updater&Else
     */
    @Test
    public void fun1() {

        EntityManagerFactory myJpa = Persistence.createEntityManagerFactory("myJpa");
        EntityManager entityManager = myJpa.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        //基本的事务操作
        tx.begin();

        String hql = "from Customer where custName like ?" ;
        Query query = entityManager.createQuery(hql);
        query.setParameter(1,"%有福%");
        List<Customer> resultList = query.getResultList();
        for (Customer customer : resultList) {
            System.out.println(customer);
        }
        tx.commit();

    }
    /**
     *@Description 模糊查询-命名占位符
     *@Params []
     *@Return void
     *@Author SongHe
     *@CreatTime 2020/2/5 18:27
     *@Updater&Else
     */
    @Test
    public void fun2() {

        EntityManagerFactory myJpa = Persistence.createEntityManagerFactory("myJpa");
        EntityManager entityManager = myJpa.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        //基本的事务操作
        tx.begin();

        String hql = "from Customer where custName like :custName" ;
        Query query = entityManager.createQuery(hql);
        query.setParameter("custName","%有福%");
        List<Customer> resultList = query.getResultList();
        for (Customer customer : resultList) {
            System.out.println(customer);
        }
        tx.commit();

    }

    /**
     *@Description 分页查询
     *@Params []
     *@Return void
     *@Author SongHe
     *@CreatTime 2020/2/5 18:27
     *@Updater&Else
     */
    @Test
    public void fun3() {

        EntityManagerFactory myJpa = Persistence.createEntityManagerFactory("myJpa");
        EntityManager entityManager = myJpa.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        //基本的事务操作
        tx.begin();

        String hql = "from Customer" ;
        Query query = entityManager.createQuery(hql);
        query.setFirstResult(0);
        query.setMaxResults(1);
        List<Customer> resultList = query.getResultList();
        for (Customer customer : resultList) {
            System.out.println(customer);
        }
        tx.commit();

    }
    /**
     *@Description 排序查询
     *@Params []
     *@Return void
     *@Author SongHe
     *@CreatTime 2020/2/5 18:27
     *@Updater&Else
     */
    @Test
    public void fun4() {

        EntityManagerFactory myJpa = Persistence.createEntityManagerFactory("myJpa");
        EntityManager entityManager = myJpa.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        //基本的事务操作
        tx.begin();

        String hql = "from Customer where custName like :custName order by custId DESC " ;
        Query query = entityManager.createQuery(hql);
        query.setParameter("custName","%有福%");
        List<Customer> resultList = query.getResultList();
        for (Customer customer : resultList) {
            System.out.println(customer);
        }
        tx.commit();

    }
    /**
     *@Description 聚合函数查询
     *@Params []
     *@Return void
     *@Author SongHe
     *@CreatTime 2020/2/5 18:27
     *@Updater&Else
     */
    @Test
    public void fun5() {

        EntityManagerFactory myJpa = Persistence.createEntityManagerFactory("myJpa");
        EntityManager entityManager = myJpa.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        //基本的事务操作
        tx.begin();

//        String hql = "select count(c.custId) from Customer c " ;
//        String hql = "select sum(c.custId) from Customer c " ;
        String hql = "select avg(c.custId) from Customer c " ;
        Query query = entityManager.createQuery(hql);
        Number number = (Number) query.getSingleResult();
        System.out.println(number);
        tx.commit();

    }
}
