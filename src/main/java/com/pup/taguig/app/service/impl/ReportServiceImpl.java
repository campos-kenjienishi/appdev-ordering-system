package com.pup.taguig.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pup.taguig.app.dto.SalesReportResponseDTO;
import com.pup.taguig.app.dto.TopProductResponseDTO;
import com.pup.taguig.app.mapper.OrderMapper;
import com.pup.taguig.app.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public SalesReportResponseDTO getSalesReport() {

        SalesReportResponseDTO response =
                new SalesReportResponseDTO();

        response.setTotalOrders(
                orderMapper.getTotalOrders());

        response.setTotalRevenue(
                orderMapper.getTotalRevenue());

        return response;
    }

    @Override
    public List<TopProductResponseDTO> getTopSellingProducts() {

        return orderMapper.getTopSellingProducts();
    }
}