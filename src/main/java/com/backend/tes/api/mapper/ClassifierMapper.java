package com.backend.tes.api.mapper;

import com.backend.tes.api.dto.ClassifierDto;
import com.backend.tes.domain.Brand;
import com.backend.tes.domain.Color;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface ClassifierMapper {

    ClassifierMapper INSTANCE = Mappers.getMapper(ClassifierMapper.class);

    default List<String> mapColors(List<Color> colors) {
        return colors.stream().map(Color::getName).collect(Collectors.toList());
    }

    default List<String> mapBrands(List<Brand> brands) {
        return brands.stream().map(Brand::getName).collect(Collectors.toList());
    }

    @Mapping(target = "colors", expression = "java(mapColors(colors))")
    @Mapping(target = "brands", expression = "java(mapBrands(brands))")
    ClassifierDto classifiersToClassifierDto(List<Brand> brands, List<Color> colors);
}
