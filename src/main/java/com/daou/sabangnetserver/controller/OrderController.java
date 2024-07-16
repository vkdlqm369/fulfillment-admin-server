package com.daou.sabangnetserver.controller;

import com.daou.sabangnetserver.dto.OrderRequestDto;
import com.daou.sabangnetserver.dto.OrderResponseDto;
import com.daou.sabangnetserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/seller/{sellerNo}/")
    public ResponseEntity<OrderResponseDto> getOrderList(
            @PathVariable String sellerNo,
            @RequestBody OrderRequestDto requestDto) {
        OrderResponseDto responseDto = orderService.getOrders(sellerNo, requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
