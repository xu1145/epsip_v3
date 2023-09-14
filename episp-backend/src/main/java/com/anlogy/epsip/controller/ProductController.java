package com.anlogy.epsip.controller;


import com.anlogy.epsip.common.RespBean;
import com.anlogy.epsip.dto.ProductCheckUpdateDTO;
import com.anlogy.epsip.dto.ProductNameDTO;
import com.anlogy.epsip.pojo.Product;
import com.anlogy.epsip.pojo.ProductInfo;
import com.anlogy.epsip.pojo.Warehouse;
import com.anlogy.epsip.service.IProductInfoService;
import com.anlogy.epsip.service.IProductService;
import com.anlogy.epsip.service.IWarehouseService;
import com.anlogy.epsip.dto.ProductCheckDTO;
import com.anlogy.epsip.vo.product.ProductCheckVO;
import com.anlogy.epsip.vo.product.ProductInfoVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;
    @Autowired
    private IProductInfoService productInfoService;
    @Autowired
    private IWarehouseService warehouseService;


    /**
     * 添加商品
     * @param product
     * @return
     */
    @PostMapping("/add")
    public RespBean add(@RequestBody Product product) {
        boolean save = productService.save(product);
        if (save) {
            return RespBean.successAdd();
        }
        return RespBean.errorAdd();
    }

    /**
     * 修改定价
     * @param product
     * @return
     */
    @PutMapping("/update")
    public RespBean updateById(@RequestBody Product product) {
        Integer id = product.getId();
        Product productNew = productService.getById(id);
        if (productNew == null) {
            return RespBean.error("该商品不存在");
        }
        Double retail = product.getRetail();
        Double wholeSaleprice = product.getWholeSaleprice();
        productNew.setRetail(retail);
        productNew.setWholeSaleprice(wholeSaleprice);
        boolean update = productService.updateById(productNew);
        if (update) {
            return RespBean.successUpdate();
        }
        return RespBean.errorUpdate();
    }


    /**
     * 进货
     * @param productInfo
     * @return
     */
    @PostMapping("/add/warehouse")
    public RespBean addProductInfo(@RequestBody ProductInfo productInfo) {
        Integer productId = productInfo.getProductId();
        Product product = productService.getById(productId);
        if (product == null) {
            return RespBean.error("该商品不存在");
        }
        Integer warehouseId = productInfo.getWarehouseId();
        Warehouse warehouse = warehouseService.getById(warehouseId);
        if (warehouse == null) {
            return RespBean.error("该仓库不存在");
        }

        LambdaQueryWrapper<ProductInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ProductInfo::getProductId, productId)
                .eq(ProductInfo::getWarehouseId, warehouseId);

        ProductInfo productInfNew = productInfoService.getOne(wrapper);
        boolean save = false;
        if (productInfNew == null) {
            save = productInfoService.save(productInfo);
        } else {
            productInfNew.setNumber(productInfo.getNumber() + productInfNew.getNumber());
            save = productInfoService.updateById(productInfNew);
        }
        if (save) {
            return RespBean.successAdd();
        }
        return RespBean.errorAdd();
    }


    /**
     * 分仓查询
     * @param warehouseId
     * @return
     */
    @GetMapping("/list/{warehouseId}")
    public RespBean listByWarehouseId(@PathVariable Integer warehouseId) {

        Warehouse warehouse = warehouseService.getById(warehouseId);
        if (warehouse == null) {
            return RespBean.error("该仓库不存在");
        }

        LambdaQueryWrapper<ProductInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ProductInfo::getWarehouseId, warehouseId);
        List<ProductInfo> productInfoList = productInfoService.list(wrapper);
        List<ProductInfoVO> list = new ArrayList<>();

        for (ProductInfo productInfo : productInfoList) {
            Integer productId = productInfo.getProductId();
            Product product = productService.getById(productId);
            ProductInfoVO productInfoVO = new ProductInfoVO();
            productInfoVO.setId(product.getId());
            productInfoVO.setName(product.getName());
            productInfoVO.setNumber(productInfo.getNumber());
            list.add(productInfoVO);
        }
        return RespBean.successGet(list);
    }


    /**
     * 库存盘点
     * @param productCheckDTO
     * @return
     */
    @PostMapping("/check")
    public RespBean check(@RequestBody ProductCheckDTO productCheckDTO) {

        Integer productId = productCheckDTO.getProductId();
        if (productId == null) {
            return RespBean.error("请填写商品id");
        }
        Product product = productService.getById(productId);
        if (product == null) {
            return RespBean.error("该商品不存在");
        }
        Integer warehouseId = productCheckDTO.getWarehouseId();
        if (warehouseId == null) {
            return RespBean.error("请填写仓库id");
        }
        Warehouse warehouse = warehouseService.getById(warehouseId);
        if (warehouse == null) {
            return RespBean.error("该仓库不存在");
        }

        LambdaQueryWrapper<ProductInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ProductInfo::getProductId, productId)
                .eq(ProductInfo::getWarehouseId, warehouseId);
        ProductInfo productInfo = productInfoService.getOne(wrapper);
        if (productInfo == null) {
            return RespBean.error("该仓库没有此商品");
        }
        ProductCheckVO productCheckVO = new ProductCheckVO();
        productCheckVO.setProductId(productId);
        productCheckVO.setWarehouseId(warehouseId);
        productCheckVO.setName(product.getName());
        productCheckVO.setIntroduction(product.getIntroduction());
        productCheckVO.setNumber(productInfo.getNumber());
        ArrayList<ProductCheckVO> list = new ArrayList<>();
        list.add(productCheckVO);
        return RespBean.successGet(list);
    }


    /**
     * 修改盘点后的库存
     * @param productCheckUpdateDTO
     * @return
     */
    @PutMapping("/check/update")
    public RespBean checkUpdate(@RequestBody ProductCheckUpdateDTO productCheckUpdateDTO) {
        Integer productId = productCheckUpdateDTO.getProductId();
        if (productId == null) {
            return RespBean.error("请先盘点商品库存，未有商品id");
        }
        Integer warehouseId = productCheckUpdateDTO.getWarehouseId();
        if (warehouseId == null) {
            return RespBean.error("请先盘点商品库存，未有仓库id");
        }
        Integer number = productCheckUpdateDTO.getNumber();
        if (number == null || number < 0) {
            return RespBean.error("库存数量填写错误");
        }

        LambdaQueryWrapper<ProductInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ProductInfo::getProductId, productId)
                .eq(ProductInfo::getWarehouseId, warehouseId);
        ProductInfo productInfo = productInfoService.getOne(wrapper);
        productInfo.setNumber(number);
        boolean update = productInfoService.updateById(productInfo);
        if (update) {
            return RespBean.successUpdate();
        }
        return RespBean.errorUpdate();
    }


    /**
     * 根据名称模糊查询商品
     * @param productNameDTO
     * @return
     */
    @PostMapping("/list/name")
    public List<Product> listByName(@RequestBody ProductNameDTO productNameDTO) {
        String name = productNameDTO.getName();
        LambdaQueryWrapper<Product> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Product::getName, name);
        List<Product> productList = productService.list(wrapper);
        return productList;
    }

    /**
     * 查询商品列表
     * @return
     */
    @GetMapping("/list")
    public List<Product> list() {
        return productService.list();
    }

}
