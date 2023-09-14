package com.anlogy.epsip.service;

import com.anlogy.epsip.dto.CustomerQueryDTO;
import com.anlogy.epsip.pojo.Order;
import com.anlogy.epsip.vo.order.CustomerQueryVO;
import com.anlogy.epsip.vo.order.ProductQueryVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IOrderService extends IService<Order> {


    /**
     * 客户销售状况统计
     * @param id
     * @return
     */
    List<CustomerQueryVO> statCustomer(Integer id);

    /**
     * 货品销售状况统计
     * @param id
     * @return
     */
    List<ProductQueryVO> statProduct(Integer id);

}
