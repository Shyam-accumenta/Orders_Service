package com.example.oderservice.controller;

import com.example.oderservice.model.Products;
import com.example.oderservice.productdto.ResponseWrapper;
import com.example.oderservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/saveProducts",produces ="application/json")
    public ResponseEntity<ResponseWrapper> saveProducts(@RequestBody Products products)
    {
        Products dbpProducts1=this.productService.addProducts(products);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbpProducts1));
    }
    @GetMapping(value="/getProducts",produces="application/json")
    public ResponseEntity<ResponseWrapper> getProducts()
    {
        List<Products> dbProducts=this.productService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(new ResponseWrapper<>(dbProducts)));
    }
    @PutMapping(value="/updateProduct/{id}",produces="application/json")
    public ResponseEntity<ResponseWrapper> updateProducts(@RequestBody Products products,@PathVariable long id)
    {
        Products dbProducts1=this.productService.updateProducts(id,products);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbProducts1));
    }

    @GetMapping(value = "/getProduct/{id}",produces="application/json")
    public ResponseEntity<ResponseWrapper> getProducts(@PathVariable long id)
    {
        Products dbProducts=this.productService.getProducts(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbProducts));
    }
    @DeleteMapping(value = "/deleteProduct/{id}",produces="application/json")
    public ResponseEntity<ResponseWrapper> deleteProducts(@PathVariable long id)
    {
        Products dbProducts=this.productService.deleteProducts(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbProducts));
    }
}
