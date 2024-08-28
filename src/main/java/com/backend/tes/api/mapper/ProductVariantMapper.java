package com.backend.tes.api.mapper;

import com.backend.tes.api.dto.ProductDto;
import com.backend.tes.api.dto.ProductVariantDto;
import com.backend.tes.domain.Product;
import com.backend.tes.domain.ProductVariant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductVariantMapper {

    ProductVariantMapper INSTANCE = Mappers.getMapper(ProductVariantMapper.class);

    @Mapping(target = "color", source="color.name")
    @Mapping(target = "qtyInStock", source="stock.qtyInStock")
    ProductVariantDto ProductVariantToProductVariantDto(ProductVariant productVariant);

//    @Mapping(target = "color.name", source="color")
//    @Mapping(target = "stock.qtyInStock", source="qtyInStock")
//    Product ProductVariantDtoToProductVariant(ProductVariantDto productVariantDto, String color, Integer qtyInStock);

    // Example for updating entity from dto
    // void updateProductVariantFromDto(ProductVariantDto productVariantDto, @MappingTarget ProductVariant productVariant);
}
