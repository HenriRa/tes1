package com.backend.tes.service;

import com.backend.tes.api.dto.ClassifierDto;
import com.backend.tes.api.mapper.ClassifierMapper;
import com.backend.tes.domain.Brand;
import com.backend.tes.domain.Color;
import com.backend.tes.domain.PriceInterval;
import com.backend.tes.domain.ProductGroup;
import com.backend.tes.repository.BrandRepository;
import com.backend.tes.repository.ColorRepository;
import com.backend.tes.repository.PriceIntervalRepository;
import com.backend.tes.repository.ProductGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassifierService {

    private final ProductGroupRepository productGroupRepository;
    private final ColorRepository colorRepository;
    private final BrandRepository brandRepository;
    private final PriceIntervalRepository priceIntervalRepository;

    private final ClassifierMapper classifierMapper;

    public ClassifierDto findAllClassifiers() {
        List<ProductGroup> productGroups = productGroupRepository.findAll();
        List<Color> colors = colorRepository.findAll();
        List<Brand> brands = brandRepository.findAll();
        List<PriceInterval> priceIntervals = priceIntervalRepository.findAll();

        return classifierMapper.classifiersToClassifierDto(productGroups, brands, colors, priceIntervals);
    }

    // Product Group CRUD
    public ProductGroup createProductGroup(String name) {
        ProductGroup productGroup = new ProductGroup();
        productGroup.setName(name);
        return productGroupRepository.save(productGroup);
    }

    public ProductGroup updateProductGroup(Long id, String name) {
        ProductGroup productGroup = productGroupRepository.findById(id).orElse(null);
        if (productGroup != null) {
            productGroup.setName(name);
            return productGroupRepository.save(productGroup);
        }
        return null;
    }

    public void deleteProductGroup(Long id) {
        productGroupRepository.deleteById(id);
    }

    // Color CRUD
    public Color createColor(String name) {
        Color color = new Color();
        color.setName(name);
        return colorRepository.save(color);
    }

    public Color updateColor(Long id, String name) {
        Color color = colorRepository.findById(id).orElse(null);
        if (color != null) {
            color.setName(name);
            return colorRepository.save(color);
        }
        return null;
    }

    public void deleteColor(Long id) {
        colorRepository.deleteById(id);
    }

    // Brand CRUD
    public Brand createBrand(String name) {
        Brand brand = new Brand();
        brand.setName(name);
        return brandRepository.save(brand);
    }

    public Brand updateBrand(Long id, String name) {
        Brand brand = brandRepository.findById(id).orElse(null);
        if (brand != null) {
            brand.setName(name);
            return brandRepository.save(brand);
        }
        return null;
    }

    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }

    // Price Interval CRUD
    public PriceInterval createPriceInterval(String name, BigDecimal minPrice, BigDecimal maxPrice) {
        PriceInterval priceInterval = new PriceInterval();
        priceInterval.setName(name);
        priceInterval.setMinPrice(minPrice);
        priceInterval.setMaxPrice(maxPrice);
        return priceIntervalRepository.save(priceInterval);
    }

    public PriceInterval updatePriceInterval(Long id, String name, BigDecimal minPrice, BigDecimal maxPrice) {
        PriceInterval priceInterval = priceIntervalRepository.findById(id).orElse(null);
        if (priceInterval != null) {
            priceInterval.setName(name);
            priceInterval.setMinPrice(minPrice);
            priceInterval.setMaxPrice(maxPrice);
            return priceIntervalRepository.save(priceInterval);
        }
        return null;
    }

    public void deletePriceInterval(Long id) {
        priceIntervalRepository.deleteById(id);
    }

}
