package com.jersson.arrivasplata.swtvap.api.inventory.mapper;

import com.jersson.arrivasplata.swtvap.api.inventory.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CatalogMapper {
    CatalogMapper INSTANCE = Mappers.getMapper(CatalogMapper.class);

    @Mapping(target = "id", ignore = true)
    Catalog catalogRequestToCatalog(CatalogRequest catalogRequest);

    CatalogRequest catalogToCatalogRequest(Catalog catalog);

    CatalogResponse catalogToCatalogResponse(Catalog catalog);

    List<CatalogResponse> mapCatalogsToResponses(List<Catalog> catalogs);
}
