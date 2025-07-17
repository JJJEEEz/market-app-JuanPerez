package com.tecdesoftware.market.web.controller;

import com.tecdesoftware.market.domain.Purchase;
import com.tecdesoftware.market.domain.service.ProductService;
import com.tecdesoftware.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    public List<Purchase> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK).getBody();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable Integer id) {
        return purchaseService.getByClient(id)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}
