package com.jersson.arrivasplata.swtvap.api.inventory.business.service;

import com.jersson.arrivasplata.swtvap.api.inventory.model.Catalog;
import com.jersson.arrivasplata.swtvap.api.inventory.model.Category;
import com.jersson.arrivasplata.swtvap.api.inventory.model.CategoryCatalog;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryCatalogService {
    Mono<CategoryCatalog> getCategoryCatalogById(Long id);

    Mono<CategoryCatalog> createCategoryCatalog(CategoryCatalog categoryCatalog);

    Mono<CategoryCatalog> updateCategoryCatalog(CategoryCatalog updatedCategoryCatalog);

    Mono<Void> deleteCategoryCatalogById(Long id);

    Flux<Catalog> getCatalogsByCategory(Long categoryId);

    Flux<Category> getCategoriesByCatalog(Long catalogId);
}
