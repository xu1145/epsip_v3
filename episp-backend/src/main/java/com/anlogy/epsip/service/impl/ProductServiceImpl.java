package com.anlogy.epsip.service.impl;

import com.anlogy.epsip.mapper.ProductMapper;
import com.anlogy.epsip.pojo.Product;
import com.anlogy.epsip.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
}
