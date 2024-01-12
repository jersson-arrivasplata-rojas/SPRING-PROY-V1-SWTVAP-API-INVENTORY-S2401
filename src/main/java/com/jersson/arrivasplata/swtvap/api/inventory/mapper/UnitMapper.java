package com.jersson.arrivasplata.swtvap.api.inventory.mapper;

import com.jersson.arrivasplata.swtvap.api.inventory.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UnitMapper {
    UnitMapper INSTANCE = Mappers.getMapper(UnitMapper.class);

    //@Mapping(target = "id", ignore = true)
    Unit unitRequestToUnit(UnitRequest unitRequest);

    UnitRequest unitToUnitRequest(Unit unit);

    UnitResponse unitToUnitResponse(Unit unit);

    List<UnitResponse> mapUnitsToResponses(List<Unit> units);
}
