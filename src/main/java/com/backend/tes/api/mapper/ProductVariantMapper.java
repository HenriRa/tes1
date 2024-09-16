package com.backend.tes.api.mapper;

import com.backend.tes.api.dto.ProductDto;
import com.backend.tes.api.dto.ProductVariantDto;
import com.backend.tes.domain.Product;
import com.backend.tes.domain.ProductVariant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductVariantMapper {

    @Mapping(source="color.name", target = "color")
    @Mapping(source="stock.qtyInStock", target = "qtyInStock")
    ProductVariantDto ProductVariantToProductVariantDto(ProductVariant productVariant);

}
