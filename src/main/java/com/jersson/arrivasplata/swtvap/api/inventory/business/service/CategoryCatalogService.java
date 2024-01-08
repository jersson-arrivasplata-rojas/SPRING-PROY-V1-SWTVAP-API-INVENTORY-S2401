package com.jersson.arrivasplata.swtvap.api.inventory.business.service;

import com.jersson.arrivasplata.swtvap.api.inventory.model.Catalog;
import com.jersson.arrivasplata.swtvap.api.inventory.model.Category;
import com.jersson.arrivasplata.swtvap.api.inventory.model.CategoryCatalog;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryCatalogService {

    Flux<CategoryCatalog> findAll();

    Mono<CategoryCatalog> findById(Long id);

    Mono<CategoryCatalog> save(CategoryCatalog categoryCatalog);

    Mono<Void> deleteById(Long id);
    Flux<CategoryCatalog> findByCategoryName(String categoryName);
}
