package com.anlogy.epsip.vo.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCheckVO {

    private String name;
    private String introduction;
    private Integer number;
    private Integer productId;
    private Integer warehouseId;

}
