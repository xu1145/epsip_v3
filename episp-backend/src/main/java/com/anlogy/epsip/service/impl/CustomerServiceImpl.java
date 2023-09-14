package com.anlogy.epsip.service.impl;


import com.anlogy.epsip.mapper.CustomerMapper;
import com.anlogy.epsip.pojo.Customer;
import com.anlogy.epsip.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {
}
