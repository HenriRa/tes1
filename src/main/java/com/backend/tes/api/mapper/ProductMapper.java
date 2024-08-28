package com.backend.tes.api.mapper;

import com.backend.tes.api.dto.ProductDto;
import com.backend.tes.api.dto.ProductVariantDto;
import com.backend.tes.domain.Product;
import com.backend.tes.domain.ProductVariant;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source="brand.name", target = "brand")
    ProductDto productToProductDto(Product product);

    //@Mapping(source="brand", target = "brand.name")
//    @InheritInverseConfiguration
//    Product productDtoToProduct(ProductDto productDto);

    default ProductVariantDto ProductVariantToProductVariantDto(ProductVariant productVariant) {
        return Mappers.getMapper(ProductVariantMapper.class)
                .ProductVariantToProductVariantDto(productVariant);
    }

}
