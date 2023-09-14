package com.anlogy.epsip.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCheckUpdateDTO {

    private Integer productId;
    private Integer warehouseId;
    private Integer number;

}
