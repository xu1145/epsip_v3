package com.anlogy.epsip.controller;


import com.anlogy.epsip.common.RespBean;
import com.anlogy.epsip.pojo.Warehouse;
import com.anlogy.epsip.service.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private IWarehouseService warehouseService;

    /**
     * 查询所有仓库
     * @return
     */
    @GetMapping("/list")
    public List<Warehouse> list() {
        return warehouseService.list();
    }


    /**
     * 根据id删除仓库
     * @return
     */
    @DeleteMapping("/del/{id}")
    public RespBean deleteById(@PathVariable Integer id) {
        boolean del = warehouseService.removeById(id);
        if (del) {
            return RespBean.successDel();
        }
        return RespBean.errorDel();
    }



}
