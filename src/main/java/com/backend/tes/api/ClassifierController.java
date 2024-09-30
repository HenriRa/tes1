package com.backend.tes.api;

import com.backend.tes.api.dto.ClassifierDto;
import com.backend.tes.domain.Brand;
import com.backend.tes.domain.Color;
import com.backend.tes.domain.PriceInterval;
import com.backend.tes.domain.ProductGroup;
import com.backend.tes.service.ClassifierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/classifiers")
public class ClassifierController {

    private final ClassifierService classifierService;

    @GetMapping
    public @ResponseBody ClassifierDto getAllClassifiers(){
        return classifierService.findAllClassifiers();
    }

    // Create
    @PostMapping("/productGroups")
    public ProductGroup createProductGroup(@RequestParam String name){
        return classifierService.createProductGroup(name);
    }

    @PostMapping("/brands")
    public Brand createBrand(@RequestParam String name){
        return classifierService.createBrand(name);
    }

    @PostMapping("/colors")
    public Color createColor(@RequestParam String name){
        return classifierService.createColor(name);
    }

    @PostMapping("/priceIntervals")
    public PriceInterval createPriceInterval(
            @RequestParam String name,
            @RequestParam BigDecimal minPrice,
            @RequestParam BigDecimal maxPrice){
        return classifierService.createPriceInterval(name, minPrice, maxPrice);
    }

    // Update
    @PutMapping("/productGroups/{id}")
    public ProductGroup updateProductGroup(@PathVariable Long id, @RequestParam String name){
        return classifierService.updateProductGroup(id, name);
    }

    @PutMapping("/brands/{id}")
    public Brand updateBrand(@PathVariable Long id, @RequestParam String name){
        return classifierService.updateBrand(id, name);
    }

    @PutMapping("/colors/{id}")
    public Color updateColor(@PathVariable Long id, @RequestParam String name){
        return classifierService.updateColor(id, name);
    }

    @PutMapping("/priceIntervals/{id}")
    public PriceInterval updatePriceInterval(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam BigDecimal minPrice,
            @RequestParam BigDecimal maxPrice){
        return classifierService.updatePriceInterval(id, name, minPrice, maxPrice);
    }

    // Delete
    @DeleteMapping("/productGroups/{id}")
    public void deleteProductGroup(@PathVariable Long id){
        classifierService.deleteProductGroup(id);
    }

    @DeleteMapping("/brands/{id}")
    public void deleteBrand(@PathVariable Long id){
        classifierService.deleteBrand(id);
    }

    @DeleteMapping("/colors/{id}")
    public void deleteColor(@PathVariable Long id){
        classifierService.deleteColor(id);
    }

    @DeleteMapping("/priceIntervals/{id}")
    public void deletePriceInterval(@PathVariable Long id){
        classifierService.deletePriceInterval(id);
    }

}
