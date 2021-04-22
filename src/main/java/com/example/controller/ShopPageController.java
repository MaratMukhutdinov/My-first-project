package com.example.controller;

import com.example.constants.PageNameConstants;
import com.example.dto.ProductDto;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ShopPageController {

    private final ProductService productService;

    @GetMapping("/shop")
    public String pageVisitCounter(Model model) {
        List<ProductDto> allProducts = productService.getProducts();
        model.addAttribute("product", new ProductDto());
        model.addAttribute("productList", allProducts);
        return PageNameConstants.SHOP_PAGE;
    }

    @PostMapping("/add-coffee")
    public String addCoffeeCount(ProductDto productDto) {
        productService.addCoffee(productDto);
        return "redirect:/shop";
    }
}
