package com.backend.tes.api.mapper;

import com.backend.tes.api.dto.StockDto;
import com.backend.tes.domain.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StockMapper {

    StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);

    StockDto StockToStockDto(Stock stock);
}
