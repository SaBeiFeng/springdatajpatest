package test;

import com.itsh.dao.CustomerDao;
import com.itsh.pojo.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @Project SpringDataJpaTest
 * @Package test
 * @Class SpringDataTest
 * @Author TimSmith
 * @CreatTime 2020/7/20 0:28
 * @Description TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDataTest {
    @Autowired
    private CustomerDao customerDao;
    //保存
    @Test
    public void fun1() {
        Customer c = new Customer();
        c.setCustLevel("1");
        c.setCustName("家里蹲书店2店");
        c.setCustPhone("15662137446");
        customerDao.save(c);
    }
    //删除
    @Test
    public void fun2() {
        customerDao.delete(1L);
    }

    //根据id查询
    @Test
    public void fun3() {
        Customer one = customerDao.findOne(2L);
        System.out.println(one);
    }
    //根据对象删除
    @Test
    public void fun4() {
        Customer one = customerDao.findOne(2L);
        customerDao.delete(one);
    }
    //修改
    @Test
    public void fun5() {
        Customer one = customerDao.findOne(3L);
        one.setCustName("家里蹲书店分店");
        customerDao.save(one);
    }

    //查询所有
    @Test
    public void fun6(){
        List<Customer> all = customerDao.findAll();
        System.out.println(all);
    }
    //查询记录数
    @Test
    public void fun7(){
        long count = customerDao.count();
        System.out.println(count);
    }

    //分页查询
    @Test
    public void fun8(){
        Page<Customer> all = customerDao.findAll(new PageRequest(1, 2));
        System.out.println(all.getTotalElements());
        System.out.println(all.getTotalPages());
        System.out.println(all.getContent());
        System.out.println(all.getNumber());
    }
    @Test
    public void fun9(){
        Long[] ints = {3L, 4L, 5L};
        List<Customer> all = customerDao.findAll(Arrays.asList(ints));
        for (Customer customer : all) {
            System.out.println(customer);
        }
    }
}
