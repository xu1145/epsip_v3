package com.anlogy.epsip.mapper;

import com.anlogy.epsip.dto.CustomerQueryDTO;
import com.anlogy.epsip.pojo.Order;
import com.anlogy.epsip.vo.order.CustomerQueryVO;
import com.anlogy.epsip.vo.order.ProductQueryVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

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
