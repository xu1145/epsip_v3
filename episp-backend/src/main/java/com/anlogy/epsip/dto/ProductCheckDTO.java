package com.anlogy.epsip.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCheckDTO {

    private Integer productId;
    private Integer warehouseId;

}
