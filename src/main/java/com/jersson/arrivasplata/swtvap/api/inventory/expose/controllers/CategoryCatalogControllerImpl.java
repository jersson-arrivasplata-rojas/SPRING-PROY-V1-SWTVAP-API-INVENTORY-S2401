package com.jersson.arrivasplata.swtvap.api.inventory.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.inventory.business.service.CategoryCatalogService;
import com.jersson.arrivasplata.swtvap.api.inventory.expose.CategoryCatalogController;
import com.jersson.arrivasplata.swtvap.api.inventory.model.Catalog;
import com.jersson.arrivasplata.swtvap.api.inventory.model.Category;
import com.jersson.arrivasplata.swtvap.api.inventory.model.CategoryCatalog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/category-catalogs", produces = "application/vnd.swtvap-api-category-catalogs.v1+json")
public class CategoryCatalogControllerImpl implements CategoryCatalogController {
    private final CategoryCatalogService categoryCatalogService;

    public CategoryCatalogControllerImpl(CategoryCatalogService categoryCatalogService) {
        this.categoryCatalogService = categoryCatalogService;
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<CategoryCatalog>> getCategoryCatalogById(@PathVariable Long id) {
        return categoryCatalogService.findById(id)
                .map(categoryCatalog -> new ResponseEntity<>(categoryCatalog, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Mono<ResponseEntity<CategoryCatalog>> createCategoryCatalog(@RequestBody CategoryCatalog categoryCatalog) {
        return categoryCatalogService.save(categoryCatalog)
                .map(newCategoryCatalog -> new ResponseEntity<>(newCategoryCatalog, HttpStatus.CREATED));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<CategoryCatalog>> updateCategoryCatalog(@PathVariable Long id, @RequestBody CategoryCatalog updatedCategoryCatalog) {
        return categoryCatalogService.findById(id)
                .flatMap(existingCategoryCatalog -> {
                    updatedCategoryCatalog.setId(id);
                    return categoryCatalogService.save(updatedCategoryCatalog);
                })
                .map(updated -> new ResponseEntity<>(updated, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteCategoryCatalog(@PathVariable Long id) {
        return categoryCatalogService.findById(id)
                .flatMap(existingCategoryCatalog -> {
                    categoryCatalogService.deleteById(id);
                    return Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT));
                })
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
/*
    @GetMapping("/categories/{categoryId}/catalogs")
    public Flux<Catalog> getCatalogsByCategory(@PathVariable Long categoryId) {
        return categoryCatalogService.findByCategoryName(categoryId);
    }

    @GetMapping("/catalogs/{catalogId}/categories")
    public Flux<Category> getCategoriesByCatalog(@PathVariable Long catalogId) {
        return categoryCatalogService.getCategoriesByCatalog(catalogId);
    }*/
}
