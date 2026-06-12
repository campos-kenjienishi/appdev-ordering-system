package com.pup.taguig.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopProductDTO {

    private Long productId;
    private String productName;
    private Integer totalSold;
}