package com.jersson.arrivasplata.swtvap.api.inventory.repository;


import com.jersson.arrivasplata.swtvap.api.inventory.model.Catalog;
import com.jersson.arrivasplata.swtvap.api.inventory.model.Category;
import com.jersson.arrivasplata.swtvap.api.inventory.model.CategoryCatalog;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryCatalogRepository extends ReactiveCrudRepository<CategoryCatalog, Long> {

    Mono<CategoryCatalog> findById(Long id);

    Mono<CategoryCatalog> save(CategoryCatalog categoryCatalog);

    Mono<Void> deleteById(Long id);

    // Agregar métodos para encontrar catálogos por categoría y viceversa
    Flux<Catalog> findCatalogsByCategoryId(Long categoryId);

    Flux<Category> findCategoriesByCatalogId(Long catalogId);
}
