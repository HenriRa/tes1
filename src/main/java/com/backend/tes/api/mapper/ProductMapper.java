package com.backend.tes.api.mapper;

import com.backend.tes.api.dto.ProductDto;
import com.backend.tes.api.dto.ProductVariantDto;
import com.backend.tes.domain.Product;
import com.backend.tes.domain.ProductVariant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring"/*, uses = {ProductVariantMapper.class}*/)
public interface ProductMapper {

    @Mapping(source = "productGroup.name", target = "productGroup")
    @Mapping(source="brand.name", target = "brand")
    ProductDto productToProductDto(Product product);

    @Mapping(source = "productGroup", target = "productGroup.name")
    @Mapping(source="brand", target = "brand.name")
    Product productDtoToProduct(ProductDto productDto);

    default ProductVariantDto ProductVariantToProductVariantDto(ProductVariant productVariant) {
        return Mappers.getMapper(ProductVariantMapper.class)
                .ProductVariantToProductVariantDto(productVariant);
    }

    default ProductVariant ProductVariantDtoToProductVariant(ProductVariantDto productVariantDto) {
        return Mappers.getMapper(ProductVariantMapper.class)
                .ProductVariantDtoToProductVariant(productVariantDto);
    }

}
