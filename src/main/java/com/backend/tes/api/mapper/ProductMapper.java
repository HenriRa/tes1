package com.backend.tes.api.mapper;

import com.backend.tes.api.dto.ProductDto;
import com.backend.tes.api.dto.ProductVariantDto;
import com.backend.tes.domain.Product;
import com.backend.tes.domain.ProductVariant;
import com.backend.tes.domain.query.ProductByFilter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

//
//    @Mapping
//    ProductDto ProductByFilterToProductDto(ProductByFilter product);

//    @Mapping(source="brand.name", target = "brand")
//    ProductDto productToProductDto(Product product);
//
//    default ProductVariantDto ProductVariantToProductVariantDto(ProductVariant productVariant) {
//        return Mappers.getMapper(ProductVariantMapper.class)
//                .ProductVariantToProductVariantDto(productVariant);
//    }

}
