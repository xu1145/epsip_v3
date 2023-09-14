package com.anlogy.epsip.vo.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerQueryVO {

    private Integer id;
    private String name;
    private Integer count;

}
