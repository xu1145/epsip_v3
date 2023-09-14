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
@TableName("tb_warehouse")
public class Warehouse implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String type;
    private String address;
    private String phone;

}
