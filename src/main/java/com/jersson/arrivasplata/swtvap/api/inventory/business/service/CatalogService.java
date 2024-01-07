package com.jersson.arrivasplata.swtvap.api.inventory.business.service;

import com.jersson.arrivasplata.swtvap.api.inventory.model.Catalog;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CatalogService {
    Flux<List<Catalog>> getAllCatalogs();
    Mono<Catalog> getCatalogById(Long id);
    Mono<Catalog> createCatalog(Catalog catalog);
    Mono<Catalog> updateCatalog(Catalog catalog);
    Mono<Void> deleteCatalogById(Long id);
    // Otros métodos relacionados con catalogo usando Reactor Core
}
