package com.backend.tes.api.mapper;

import com.backend.tes.api.dto.ProductVariantDto;
import com.backend.tes.api.dto.StockDto;
import com.backend.tes.domain.ProductVariant;
import com.backend.tes.domain.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductVariantMapper {

    @Mapping(source="color.name", target = "color")
    ProductVariantDto ProductVariantToProductVariantDto(ProductVariant productVariant);

    @Mapping(source="color", target = "color.name")
    ProductVariant ProductVariantDtoToProductVariant(ProductVariantDto productVariantDto);

    default StockDto stockToStockDto(Stock stock) {
        return Mappers.getMapper(StockMapper.class)
                .stockToStockDto(stock);

    }

}
