package com.anlogy.epsip.service.impl;

import com.anlogy.epsip.mapper.OrderInfoMapper;
import com.anlogy.epsip.pojo.OrderInfo;
import com.anlogy.epsip.service.IOrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {
}
