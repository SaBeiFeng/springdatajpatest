package com.minsheng.Tests;

import com.minsheng.pojo.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @Project SpringDataJpaTest
 * @Package com.minsheng.Tests
 * @Author SongHe
 * @Date 2020/2/5 14:58
 * @Version 1.0
 * @Description EntityManager对象,JPA核心对象,一切CRUD全使用这个对象,线程不安全,所以每次使用都要为线程创建一个单独的EntityManager对象
 */
public class EntityManagerTest {
    /**
     *@Description 事务操作  JPA的更新类操作基本上都是先查询后操作
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
        tx.commit();
        tx.rollback();

    }


    /**
     *@Description find方法属于立即加载,不论是否使用结果都会执行查询的操作
     *@Params []
     *@Return void
     *@Author SongHe
     *@CreatTime 2020/2/5 18:27
     *@Updater&Else
     */
    @Test
    @SuppressWarnings(value = "uncheck")
    public void fun1() {
        EntityManagerFactory myJpa = Persistence.createEntityManagerFactory("myJpa");
        EntityManager entityManager = myJpa.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        //基本的事务操作
        tx.begin();
        //-------------------演示查询-------------------
        //根据主键id进行查询
        Customer customer = entityManager.find(Customer.class, 2L);
        System.out.println(customer);
        tx.commit();
        //EntityManager对象和EntityManagerFactory对象使用完成后都需要进行关闭
        entityManager.close();
        myJpa.close();

    }

    /**
     *@Description getReference方法属于懒加载,不使用查询结果的时候是不进行查询的
     *@Params []
     *@Return void
     *@Author SongHe
     *@CreatTime 2020/2/5 22:01
     *@Updater&Else
     */
    @Test
    @SuppressWarnings(value = "uncheck")
    public void fun2() {
        EntityManagerFactory myJpa = Persistence.createEntityManagerFactory("myJpa");
        EntityManager entityManager = myJpa.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        //基本的事务操作
        tx.begin();
        //-------------------演示查询-------------------
        //根据主键id进行查询
        Customer customer = entityManager.getReference(Customer.class, 2L);
        System.out.println(customer);
        tx.commit();
        //EntityManager对象和EntityManagerFactory对象使用完成后都需要进行关闭
        entityManager.close();
        myJpa.close();

    }
    /**
     *@Description 修改 查出来的对象因为在em中进行管理,所以不需要使用merge,直接提交事务即可,但是新创建的对象由于不在em中,所以需要merge将其合并到em的管理对象中.
     *             但是创建的对象使用merge方法需要将所有字段设置完全,因为merge的合并方法其实就是对原有的对象进行了覆盖
     *@Params []
     *@Return void
     *@Author SongHe
     *@CreatTime 2020/2/5 22:01
     *@Updater&Else
     */
    @Test
    @SuppressWarnings(value = "uncheck")
    public void fun3() {
        EntityManagerFactory myJpa = Persistence.createEntityManagerFactory("myJpa");
        EntityManager entityManager = myJpa.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        //基本的事务操作
        tx.begin();
        //-------------------演示查询-------------------
        //根据主键id进行修改
//        Customer customer = entityManager.getReference(Customer.class, 2L);
        Customer customer = new Customer();
        customer.setCustId(2L);
        customer.setCustAddress("北京");
        entityManager.merge(customer);
        System.out.println(customer);
        Customer customer1 = entityManager.find(Customer.class, 2L);
        System.out.println(customer1);
        tx.commit();
        //EntityManager对象和EntityManagerFactory对象使用完成后都需要进行关闭
        entityManager.close();
        myJpa.close();

    }

    /**
     *@Description 删除操作
     *@Params []
     *@Return void
     *@Author SongHe
     *@CreatTime 2020/2/5 22:01
     *@Updater&Else
     */
    @Test
    @SuppressWarnings(value = "uncheck")
    public void fun4() {
        EntityManagerFactory myJpa = Persistence.createEntityManagerFactory("myJpa");
        EntityManager entityManager = myJpa.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        //基本的事务操作
        tx.begin();
        //-------------------演示查询-------------------
        //根据主键id进行查询
        Customer customer = entityManager.getReference(Customer.class, 2L);
        entityManager.remove(customer);
        System.out.println(customer);
        tx.commit();
        //EntityManager对象和EntityManagerFactory对象使用完成后都需要进行关闭
        entityManager.close();
        myJpa.close();
    }
}
