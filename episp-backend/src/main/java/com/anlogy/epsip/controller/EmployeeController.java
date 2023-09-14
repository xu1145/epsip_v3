package com.anlogy.epsip.controller;


import com.anlogy.epsip.common.RespBean;
import com.anlogy.epsip.pojo.Employee;
import com.anlogy.epsip.service.IEmployeeService;
import com.anlogy.epsip.vo.employee.UpdatePositionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;


    /**
     * 查询所有员工
     * @return
     */
    @GetMapping("/list")
    public List<Employee> list() {
        return employeeService.list();
    }

    /**
     * 根据id删除员工
     * @param id
     * @return
     */
    @DeleteMapping("/del/{id}")
    public RespBean deleteById(@PathVariable Integer id) {
        boolean del = employeeService.removeById(id);
        if (del) {
            return RespBean.successDel();
        }
        return RespBean.errorDel();
    }

    /**
     * 添加员工信息
     * @param employee
     * @return
     */
    @PostMapping("/add")
    public RespBean add(@RequestBody Employee employee) {
        boolean save = employeeService.save(employee);
        if (save) {
            return RespBean.successAdd();
        }
        return RespBean.errorAdd();
    }

    /**
     * 员工职位修改
     * @param updatePositionVO
     * @return
     */
    @PutMapping("/update/position")
    public RespBean updatePositionById(@RequestBody UpdatePositionVO updatePositionVO) {
        Integer id = updatePositionVO.getId();
        Employee employee = employeeService.getById(id);
        if (employee == null) {
            return RespBean.error("该员工不存在");
        }
        String position = updatePositionVO.getPosition();
        employee.setPosition(position);
        boolean update = employeeService.updateById(employee);
        if (update) {
            return RespBean.successUpdate();
        }
        return RespBean.errorUpdate();
    }






}
