package com.minsheng.Tests;

import com.minsheng.pojo.Customer;
import org.junit.Test;
import sun.net.www.http.HttpClient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.print.DocFlavor;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Create by Idea2019
 *
 * @Project SpringDataJpaTest
 * @ClassName JpaTest
 * @Author Tim Smith
 * @Date 2019/10/20 23:37
 * @Version 1.0
 * @description: TODO
 */

public class JpaTest {
    @Test
    public void fun1(){
        //对象管理工厂?
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myJpa");
        //创建实例管理对象?
        EntityManager em = emf.createEntityManager();
        //创建事务对象
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Customer customer = new Customer();
        customer.setCustName("有福");
        customer.setCustPhone("15615621765");
//        customer.setCustId(1);主键自增长,所以设置了主键的话,就会报错
        customer.setCustAddress("北京");
        customer.setCustLevel("vip6");
        customer.setCustIndustry("桑拿");
        customer.setCustSource("线下");
        em.persist(customer);
        tx.commit();
        em.close();
        emf.close();
    }
    @Test
    public void fun2() throws IOException {
        /**
         *@Description 测试HttpClient
         *@Params []
         *@Return void
         *@Author SongHe
         *@CreatTime 2020/2/5 1:21
         *@Updater&Else
         */
        URL url = new URL("https://www.nowcoder.com/questionTerminal/566c5439ab04493c9c683a01430d697e");
        HttpClient aNew = HttpClient.New(url);
        String urlFile = aNew.getURLFile();
        System.out.println(urlFile);
    }
}
