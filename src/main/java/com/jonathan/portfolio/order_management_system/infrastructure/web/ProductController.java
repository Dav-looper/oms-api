package com.jonathan.portfolio.order_management_system.infrastructure.web;

import com.jonathan.portfolio.order_management_system.application.ports.in.CreateProductInputPort;
import com.jonathan.portfolio.order_management_system.infrastructure.dtos.RequestProductDto;
import com.jonathan.portfolio.order_management_system.infrastructure.dtos.ResponseProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("oms/v1/products")
public class ProductController {
    private final CreateProductInputPort createProductInputPort;

    @Autowired
    public ProductController(CreateProductInputPort createProductInputPort) {
        this.createProductInputPort = createProductInputPort;
    }

    @PostMapping
    ResponseEntity<ResponseProductDto> saveProduct(@RequestBody RequestProductDto requestProductDto) {
        ResponseProductDto savedProduct = createProductInputPort.execute(requestProductDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @GetMapping("/test")
    String hello() {
        return "hello, the app is working";
    }
}
