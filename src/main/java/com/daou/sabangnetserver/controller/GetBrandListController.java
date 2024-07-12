package com.daou.sabangnetserver.controller;

import com.daou.sabangnetserver.dto.OrderBrandDto;
import com.daou.sabangnetserver.service.OrderBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brdlst")
public class GetBrandListController {

    @Autowired
    private OrderBrandService orderBrandService;

    @GetMapping("/collect")
    public ResponseEntity<List<OrderBrandDto>> getOrderBrand() {
        List<OrderBrandDto> orderBrand = orderBrandService.getOrderBrand();
        return ResponseEntity.ok(orderBrand);
    }
}
