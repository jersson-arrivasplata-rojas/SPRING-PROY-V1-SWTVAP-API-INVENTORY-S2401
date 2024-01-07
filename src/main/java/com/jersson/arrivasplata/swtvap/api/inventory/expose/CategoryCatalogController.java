package com.jersson.arrivasplata.swtvap.api.inventory.expose;

import com.jersson.arrivasplata.swtvap.api.inventory.model.Catalog;
import com.jersson.arrivasplata.swtvap.api.inventory.model.Category;
import com.jersson.arrivasplata.swtvap.api.inventory.model.CategoryCatalog;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryCatalogController {
    Mono<ResponseEntity<CategoryCatalog>> getCategoryCatalogById(Long id);

    Mono<ResponseEntity<CategoryCatalog>> createCategoryCatalog(CategoryCatalog categoryCatalog);

    Mono<ResponseEntity<CategoryCatalog>> updateCategoryCatalog(Long id, CategoryCatalog updatedCategoryCatalog);

    Mono<ResponseEntity<Void>> deleteCategoryCatalog(Long id);

    Flux<Catalog> getCatalogsByCategory(Long categoryId);

    Flux<Category> getCategoriesByCatalog(Long catalogId);
}
