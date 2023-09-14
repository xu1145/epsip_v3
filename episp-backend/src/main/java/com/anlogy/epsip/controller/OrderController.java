package com.anlogy.epsip.controller;


import com.anlogy.epsip.common.RespBean;
import com.anlogy.epsip.dto.OrderAllowDTO;
import com.anlogy.epsip.dto.OrderCancelDTO;
import com.anlogy.epsip.dto.PayListDTO;
import com.anlogy.epsip.pojo.Customer;
import com.anlogy.epsip.pojo.Order;
import com.anlogy.epsip.pojo.OrderInfo;
import com.anlogy.epsip.pojo.Product;
import com.anlogy.epsip.service.ICustomerService;
import com.anlogy.epsip.service.IOrderInfoService;
import com.anlogy.epsip.service.IOrderService;
import com.anlogy.epsip.service.IProductService;
import com.anlogy.epsip.vo.product.PayVO;
import com.anlogy.epsip.vo.order.CustomerQueryVO;
import com.anlogy.epsip.vo.order.ProductQueryVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private IOrderInfoService orderInfoService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IProductService productService;


    /**
     * 订单显示
     * @return
     */
    @GetMapping("/list")
    public List<Order> list() {
        return orderService.list();
    }


    /**
     * 根据id退货
     * @param orderCancelDTO
     * @return
     */
    @PutMapping("/cancel")
    public RespBean cancel(@RequestBody OrderCancelDTO orderCancelDTO) {
        Integer id = orderCancelDTO.getId();
        if (id == null) {
            return RespBean.error("请输入订单号");
        }
        Order order = orderService.getById(id);
        if (order == null) {
            return RespBean.error("没有该订单");
        }
        Integer status = order.getStatus();
        if (status == 3) {
            return RespBean.error("该订单已经退货");
        }
        order.setStatus(3);
        boolean update = orderService.updateById(order);
        if (update) {
            return RespBean.success("退货成功");
        }
        return RespBean.error("退货失败");
    }


    /**
     * 查询所有未配货的订单
     * @return
     */
    @GetMapping("/list/no/allow")
    public List<Order> listAllow() {
        LambdaQueryWrapper<Order> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Order::getStatus, 1);
        List<Order> list = orderService.list(wrapper);
        return list;
    }


    /**
     * 订单配货
     * @param orderAllowDTO
     * @return
     */
    @PutMapping("/allow")
    public RespBean allow(@RequestBody OrderAllowDTO orderAllowDTO) {
        Integer id = orderAllowDTO.getId();
        Order order = orderService.getById(id);
        order.setStatus(2);
        boolean update = orderService.updateById(order);
        if (update) {
            return RespBean.successUpdate();
        }
        return RespBean.errorUpdate();
    }

    /**
     * 根据id查询订单
     * @return
     */
    @GetMapping("/list/{id}")
    public RespBean listById(@PathVariable Integer id) {
        if (id == null || id < 0) {
            return RespBean.successGet(orderService.list());
        }
        Order order = orderService.getById(id);
        if (order == null) {
            return RespBean.error("该订单不存在");
        }
        ArrayList<Order> list = new ArrayList<>();
        list.add(order);
        return RespBean.successGet(list);
    }

    /**
     * 客户销售状况统计
     * @param id
     * @return
     */
    @GetMapping("/stat/cust/{id}")
    public RespBean statisticsByCustomerId(@PathVariable Integer id){
        if (id == null || id < 0) {
            return RespBean.error("请输入客户id");
        }
        Customer customer = customerService.getById(id);
        if (customer == null) {
            return RespBean.error("该客户不存在");
        }
        List<CustomerQueryVO> list = orderService.statCustomer(id);
        return RespBean.successGet(list);
    }

    /**
     * 货品销售状况统计
     * @param id
     * @return
     */
    @GetMapping("/stat/prod/{id}")
    public RespBean statisticsByProductId(@PathVariable Integer id){
        if (id == null || id < 0) {
            return RespBean.error("请输入货品id");
        }
        Product product = productService.getById(id);
        if (product == null) {
            return RespBean.error("该货品不存在");
        }
        List<ProductQueryVO> list = orderService.statProduct(id);
        return RespBean.successGet(list);
    }


    /**
     * 零售收银
     * @param payListDTO
     * @return
     */
    @PostMapping("/pay")
    @Transactional
    public RespBean pay(@RequestBody PayListDTO payListDTO) {

        List<Integer> productList = payListDTO.getProductIdList();
        if (productList == null || productList.size() == 0) {
            return RespBean.error("请选择商品");
        }
        Double price = 0d;
        List<Integer> countList = payListDTO.getCountList();

        for (int i = 0; i < productList.size(); i++) {
            Integer id = productList.get(i);
            Product product = productService.getById(id);
            Integer count = countList.get(i);

            Order order = new Order();
            order.setCreateTime(LocalDateTime.now());
            order.setStatus(2);
            order.setCustomerId(payListDTO.getCustomerId());
            boolean save = orderService.save(order);
            if (!save) {
                return RespBean.errorAdd("支付失败");
            }
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setOrderId(order.getId());
            orderInfo.setProductId(product.getId());
            orderInfo.setCount(count);
            boolean save2 = orderInfoService.save(orderInfo);
            if (!save2) {
                return RespBean.errorAdd("支付失败");
            }
            price += product.getRetail() * count;
        }
        PayVO payVO = new PayVO();
        payVO.setPrice(price);
        return RespBean.success("支付成功", payVO);
    }



}
