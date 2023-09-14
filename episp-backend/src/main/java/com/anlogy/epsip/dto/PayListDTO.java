package com.anlogy.epsip.dto;


import com.anlogy.epsip.pojo.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayListDTO {

    private List<Integer> productIdList = new ArrayList<>();
    private List<Integer> countList = new ArrayList<>();
    private Integer customerId;

}
