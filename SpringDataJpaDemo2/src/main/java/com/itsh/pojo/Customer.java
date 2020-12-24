package com.itsh.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * Create by Idea2019
 *
 * @Project SpringDataJpaTest
 * @ClassName Customer
 * @Author Tim Smith
 * @Date 2019/10/20 23:11
 * @Version 1.0
 * @description: TODO
 */
@Entity
@Table(name = "cst_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long custId;
    private String custName;
    private String custSource;
    private String custIndustry;
    private String custLevel;
    private String custAddress;
    private String custPhone;

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return custId == customer.custId &&
                Objects.equals(custName, customer.custName) &&
                Objects.equals(custSource, customer.custSource) &&
                Objects.equals(custIndustry, customer.custIndustry) &&
                Objects.equals(custLevel, customer.custLevel) &&
                Objects.equals(custAddress, customer.custAddress) &&
                Objects.equals(custPhone, customer.custPhone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(custId, custName, custSource, custIndustry, custLevel, custAddress, custPhone);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPhone='" + custPhone + '\'' +
                '}';
    }
}

