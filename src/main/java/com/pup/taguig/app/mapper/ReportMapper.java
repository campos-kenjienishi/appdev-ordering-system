package com.pup.taguig.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pup.taguig.app.dto.TopProductResponseDTO;

@Mapper
public interface ReportMapper {

    Integer getTotalOrders();

    Double getTotalRevenue();

    List<TopProductResponseDTO> getTopSellingProducts();
}