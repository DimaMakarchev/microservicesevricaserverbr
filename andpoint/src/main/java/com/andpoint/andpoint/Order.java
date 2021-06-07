package com.andpoint.andpoint;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {

    private  int id;
    private  String type;
    private  String name;
    private  String status;

}
