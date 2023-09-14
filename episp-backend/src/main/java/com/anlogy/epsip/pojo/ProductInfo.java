package com.anlogy.epsip.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_product_info")
public class ProductInfo implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer productId;
    private Integer warehouseId;
    private Integer number;

}
