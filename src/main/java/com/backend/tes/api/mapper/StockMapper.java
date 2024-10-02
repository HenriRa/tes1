package com.backend.tes.api.mapper;

import com.backend.tes.api.dto.StockDto;
import com.backend.tes.domain.Stock;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StockMapper {

    StockDto stockToStockDto(Stock stock);

    Stock stockDtoToStock(StockDto stockDto);
}
