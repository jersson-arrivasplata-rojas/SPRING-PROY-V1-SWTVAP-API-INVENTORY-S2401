package com.jersson.arrivasplata.swtvap.api.inventory.mapper;

import com.jersson.arrivasplata.swtvap.api.inventory.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    //@Mapping(target = "id", ignore = true)
    Category categoryRequestToCategory(CategoryRequest categoryRequest);

    CategoryRequest categoryToCategoryRequest(Category category);

    CategoryResponse categoryToCategoryResponse(Category category);

    List<CategoryResponse> mapCategoriesToResponses(List<Category> categories);
}
