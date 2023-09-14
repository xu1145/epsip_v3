package com.anlogy.epsip.service.impl;


import com.anlogy.epsip.mapper.EmployeeMapper;
import com.anlogy.epsip.pojo.Employee;
import com.anlogy.epsip.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {
}
