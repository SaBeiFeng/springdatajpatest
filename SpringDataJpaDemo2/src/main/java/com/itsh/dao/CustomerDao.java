package com.itsh.dao;

import com.itsh.pojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Project SpringDataJpaTest
 * @Package com.itsh.dao
 * @Interface UserDao
 * @Author TimSmith
 * @CreatTime 2020/7/20 0:23
 * @Description TODO
 */
public interface CustomerDao extends JpaRepository<Customer,Long> {
}
