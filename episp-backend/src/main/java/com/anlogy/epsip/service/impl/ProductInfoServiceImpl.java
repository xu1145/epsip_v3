package com.anlogy.epsip.service.impl;

import com.anlogy.epsip.mapper.ProductInfoMapper;
import com.anlogy.epsip.pojo.ProductInfo;
import com.anlogy.epsip.service.IProductInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements IProductInfoService {
}
