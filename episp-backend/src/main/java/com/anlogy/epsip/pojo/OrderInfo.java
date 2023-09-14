package com.anlogy.epsip.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_order_info")
public class OrderInfo implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer orderId;
    private Integer productId;
    private Integer count;

}
