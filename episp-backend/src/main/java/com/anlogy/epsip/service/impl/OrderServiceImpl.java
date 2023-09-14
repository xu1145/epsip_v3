package com.anlogy.epsip.service.impl;

import com.anlogy.epsip.dto.CustomerQueryDTO;
import com.anlogy.epsip.mapper.OrderMapper;
import com.anlogy.epsip.pojo.Order;
import com.anlogy.epsip.service.IOrderService;
import com.anlogy.epsip.vo.order.CustomerQueryVO;
import com.anlogy.epsip.vo.order.ProductQueryVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 客户销售状况统计
     * @param id
     * @return
     */
    public List<CustomerQueryVO> statCustomer(Integer id) {
        return orderMapper.statCustomer(id);
    }

    /**
     * 货品销售状况统计
     * @param id
     * @return
     */
    public List<ProductQueryVO> statProduct(Integer id) {
        return orderMapper.statProduct(id);
    }
}
