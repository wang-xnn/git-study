package com.wangxnn.dao;

import com.wangxnn.pojo.Department;
import com.wangxnn.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工DAO
@Repository
public class EmployeeDao {
    //模拟数据库中的数据

    private static Map<Integer, Employee> employees=null;
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees=new HashMap<>();
        employees.put(1001,new Employee(1001,"AA","AA252279128@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","BB252279128@qq.com",1,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"CC","CC252279128@qq.com",1,new Department(103,"运营部")));
        employees.put(1004,new Employee(1004,"DD","DD252279128@qq.com",0,new Department(104,"教研部")));
        employees.put(1005,new Employee(1005,"EE","EE252279128@qq.com",1,new Department(105,"后勤部")));
    }
    private static Integer initId=1006;
    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
    public Employee getEmployeeById(Integer id){return employees.get(id);}
    public Collection<Employee> getAll(){
        return employees.values();
    }
    public void removeEmployee(Integer id){
        employees.remove(id);
    }
    
}
