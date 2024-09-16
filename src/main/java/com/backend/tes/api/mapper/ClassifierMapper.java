package com.backend.tes.api.mapper;

import com.backend.tes.api.dto.ClassifierDto;
import com.backend.tes.domain.Brand;
import com.backend.tes.domain.Color;
import com.backend.tes.domain.PriceInterval;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ClassifierMapper {

    default List<String> mapColors(List<Color> colors) {
        return colors.stream().map(Color::getName).collect(Collectors.toList());
    }

    default List<String> mapBrands(List<Brand> brands) {
        return brands.stream().map(Brand::getName).collect(Collectors.toList());
    }

    default List<String> mapPriceIntervals(List<PriceInterval> priceIntervals) {
        return priceIntervals.stream().map(PriceInterval::getName).collect(Collectors.toList());
    }

    @Mapping(target = "colors", expression = "java(mapColors(colors))")
    @Mapping(target = "brands", expression = "java(mapBrands(brands))")
    @Mapping(target = "priceIntervals", expression = "java(mapPriceIntervals(priceIntervals))")
    ClassifierDto classifiersToClassifierDto(List<Brand> brands, List<Color> colors, List<PriceInterval> priceIntervals);
}
