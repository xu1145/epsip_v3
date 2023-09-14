package com.anlogy.epsip.controller;


import com.anlogy.epsip.common.RespBean;
import com.anlogy.epsip.pojo.Customer;
import com.anlogy.epsip.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;


    /**
     * 查询所有客户
     * @return
     */
    @GetMapping("/list")
    public List<Customer> list() {
        return customerService.list();
    }

    /**
     * 根据id删除客户
     * @param id
     * @return
     */
    @DeleteMapping("/del/{id}")
    public RespBean deleteById(@PathVariable Integer id) {
        boolean del = customerService.removeById(id);
        if (del) {
            return RespBean.successDel();
        }
        return RespBean.errorDel();
    }

    /**
     * 添加客户信息
     * @param customer
     * @return
     */
    @PostMapping("/add")
    public RespBean add(@RequestBody Customer customer) {
        boolean save = customerService.save(customer);
        if (save) {
            return RespBean.successAdd();
        }
        return RespBean.errorAdd();
    }
}
