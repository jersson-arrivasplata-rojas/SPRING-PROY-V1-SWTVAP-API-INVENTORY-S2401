package com.jersson.arrivasplata.swtvap.api.inventory.business.implementation;

import com.jersson.arrivasplata.swtvap.api.inventory.business.service.CategoryCatalogService;
import com.jersson.arrivasplata.swtvap.api.inventory.model.Catalog;
import com.jersson.arrivasplata.swtvap.api.inventory.model.Category;
import com.jersson.arrivasplata.swtvap.api.inventory.model.CategoryCatalog;
import com.jersson.arrivasplata.swtvap.api.inventory.repository.CategoryCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoryCatalogServiceImpl implements CategoryCatalogService {
    private final CategoryCatalogRepository categoryCatalogRepository;

    @Autowired
    public CategoryCatalogServiceImpl(CategoryCatalogRepository categoryCatalogRepository) {
        this.categoryCatalogRepository = categoryCatalogRepository;
    }

    @Override
    public Mono<CategoryCatalog> getCategoryCatalogById(Long id) {
        return categoryCatalogRepository.findById(id).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<CategoryCatalog> createCategoryCatalog(CategoryCatalog categoryCatalog) {
        return categoryCatalogRepository.save(categoryCatalog);
    }

    @Override
    public Mono<CategoryCatalog> updateCategoryCatalog(CategoryCatalog updatedCategoryCatalog) {
        return categoryCatalogRepository.save(updatedCategoryCatalog);
    }

    @Override
    public Mono<Void> deleteCategoryCatalogById(Long id) {
        return Mono.fromRunnable(() -> categoryCatalogRepository.deleteById(id));
    }

    @Override
    public Flux<Catalog> getCatalogsByCategory(Long categoryId) {
        // Implementa lógica para obtener los catálogos por categoría
        return categoryCatalogRepository.findCatalogsByCategoryId(categoryId)
                .flatMap(catalog -> Flux.just(catalog))
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Flux<Category> getCategoriesByCatalog(Long catalogId) {
        // Implementa lógica para obtener las categorías por catálogo
        return categoryCatalogRepository.findCategoriesByCatalogId(catalogId)
                .flatMap(category -> Flux.just(category))
                .switchIfEmpty(Flux.empty());
    }
}
