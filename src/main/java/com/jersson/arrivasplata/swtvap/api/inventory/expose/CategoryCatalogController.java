package com.jersson.arrivasplata.swtvap.api.inventory.expose;

import com.jersson.arrivasplata.swtvap.api.inventory.model.Catalog;
import com.jersson.arrivasplata.swtvap.api.inventory.model.Category;
import com.jersson.arrivasplata.swtvap.api.inventory.model.CategoryCatalog;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryCatalogController {
    Mono<CategoryCatalog> getCategoryCatalogById(Long id);

    Mono<CategoryCatalog> createCategoryCatalog(CategoryCatalog categoryCatalog);

    Mono<CategoryCatalog> updateCategoryCatalog(Long id, CategoryCatalog updatedCategoryCatalog);

    Mono<Void> deleteCategoryCatalog(Long id);

    /*Flux<Catalog> getCatalogsByCategory(Long categoryId);

    Flux<Category> getCategoriesByCatalog(Long catalogId);*/
}
