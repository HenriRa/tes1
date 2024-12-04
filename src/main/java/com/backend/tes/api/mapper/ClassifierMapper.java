package com.backend.tes.api.mapper;

import com.backend.tes.api.dto.ClassifierDto;
import com.backend.tes.domain.Brand;
import com.backend.tes.domain.Color;
import com.backend.tes.domain.PriceInterval;
import com.backend.tes.domain.ProductGroup;
import com.backend.tes.domain.enums.StockOptions;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ClassifierMapper {

    ClassifierDto classifiersToClassifierDto(
            List<ProductGroup> productGroups,
            List<Brand> brands,
            List<Color> colors,
            List<PriceInterval> priceIntervals,
            List<StockOptions> stockOptions);

    default List<String> mapProductGroups(List<ProductGroup> productGroups) {
        return productGroups.stream().map(ProductGroup::getName).collect(Collectors.toList());
    }

    default List<String> mapColors(List<Color> colors) {
        return colors.stream().map(Color::getName).collect(Collectors.toList());
    }

    default List<String> mapBrands(List<Brand> brands) {
        return brands.stream().map(Brand::getName).collect(Collectors.toList());
    }

    default List<String> mapPriceIntervals(List<PriceInterval> priceIntervals) {
        return priceIntervals.stream().map(PriceInterval::getName).collect(Collectors.toList());
    }

    default List<String> mapStockOptions(List<StockOptions> stockOptions) {
        return stockOptions.stream().map(String::valueOf).collect(Collectors.toList());
    }

}
