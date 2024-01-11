package com.jersson.arrivasplata.swtvap.api.inventory.expose;

import com.jersson.arrivasplata.swtvap.api.inventory.model.*;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CategoryController {
    Flux<CategoryResponse> getAllCategories();
    Mono<CategoryResponse> getCategoryById(Long id);
    Mono<CategoryResponse> createCategory(CategoryRequest categoryRequest);
    Mono<CategoryResponse> updateCategory(Long id, CategoryRequest categoryRequest);
    Mono<Void> deleteCategory(Long id);
    Mono<ResponseEntity<String>> performUsefulOperationWithResponse();
    // Otros métodos relacionados con catalogo usando Reactor Core
}
