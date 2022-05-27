package com.example.controller;

import com.example.constants.PageNameConstants;
import com.example.dto.CoffeeDto;
import com.example.dto.RequestCoffeeCountChangeDto;
import com.example.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ShopPageController {

    private final CoffeeService coffeeService;

    @GetMapping("/shop")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String mainPage(Model model) {
        List<CoffeeDto> allCoffee = coffeeService.getCoffeeList();
        model.addAttribute("coffeeList", allCoffee);
        return PageNameConstants.COFFEE_LIST_PAGE;
    }

    @PostMapping("/add-coffee")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addCoffeeCount(@Valid RequestCoffeeCountChangeDto coffeeDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            coffeeService.addCoffee(coffeeDto);
        }
        return "redirect:/shop";
    }

    @PostMapping("/remove-coffee")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String removeCoffee(@Valid RequestCoffeeCountChangeDto coffeeDto, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            if (!coffeeService.removeCoffee(coffeeDto)) {
                model.addAttribute("countError", "Введено некорректное значение количества!");
                List<CoffeeDto> allCoffee = coffeeService.getCoffeeList();
                model.addAttribute("coffeeList", allCoffee);
                return PageNameConstants.COFFEE_LIST_PAGE;
            }
        }
        return "redirect:/shop";
    }
}
