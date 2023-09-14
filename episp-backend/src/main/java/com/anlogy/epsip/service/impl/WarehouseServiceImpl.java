package com.anlogy.epsip.service.impl;

import com.anlogy.epsip.mapper.WarehouseMapper;
import com.anlogy.epsip.pojo.Warehouse;
import com.anlogy.epsip.service.IWarehouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class WarehouseServiceImpl extends ServiceImpl<WarehouseMapper, Warehouse> implements IWarehouseService {
}
