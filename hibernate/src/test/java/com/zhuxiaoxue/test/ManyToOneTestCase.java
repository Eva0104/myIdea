package com.zhuxiaoxue.test;

import com.zhuxiaoxue.pojo.Dept;
import com.zhuxiaoxue.pojo.Employee;
import com.zhuxiaoxue.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class ManyToOneTestCase {

    @Test
    public void testSave(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Dept dept = new Dept();
        dept.setDeptname("Linux开发部");

        Employee employee = new Employee();
        employee.setEmpname("eric");
        employee.setDept(dept);

        Employee employee1 = new Employee();
        employee1.setEmpname("tom");
        employee1.setDept(dept);

        session.save(dept);
        session.save(employee);
        session.save(employee1);

        session.getTransaction().commit();
    }

    @Test
    public void testFindDept(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Dept dept = (Dept) session.get(Dept.class,18);

        Set<Employee> employeeSet = dept.getEmployeeSet();
        for(Employee employee : employeeSet){
            System.out.println(employee.getEmpname());
        }
        System.out.println(dept.getDeptname());
        session.getTransaction().commit();
    }

    @Test
    public void testFindEmployee(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Employee employee = (Employee) session.get(Employee.class,31);
        System.out.println(employee.getEmpname() +"-->"+ employee.getDept().getDeptname());

        session.getTransaction().commit();
    }

    @Test
    public void testFindAllEmployee(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Employee.class);

        List<Employee> employeeList = criteria.list();

        for(Employee employee : employeeList){
            System.out.println(employee.getEmpname() +"-->"+employee.getDept().getDeptname());
        }

        session.getTransaction().commit();
    }

    @Test
    public void testDel(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Dept dept = (Dept) session.get(Dept.class,16);

        session.delete(dept);
        session.getTransaction().commit();
    }
}
