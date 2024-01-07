package com.jersson.arrivasplata.swtvap.api.inventory.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.inventory.business.service.CategoryService;
import com.jersson.arrivasplata.swtvap.api.inventory.expose.CategoryController;
import com.jersson.arrivasplata.swtvap.api.inventory.mapper.CategoryMapper;
import com.jersson.arrivasplata.swtvap.api.inventory.model.CatalogResponse;
import com.jersson.arrivasplata.swtvap.api.inventory.model.Category;
import com.jersson.arrivasplata.swtvap.api.inventory.model.CategoryRequest;
import com.jersson.arrivasplata.swtvap.api.inventory.model.CategoryResponse;
import com.jersson.arrivasplata.swtvap.api.inventory.util.UtilityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@RestController
@RequestMapping(value = "/api/categories", produces = "application/vnd.swtvap-api-category.v1+json")
public class CategoryControllerImpl implements CategoryController {

    private final CategoryService categoryService;
    private final UtilityService utilityService;
    private final CategoryMapper categoryMapper;


    public CategoryControllerImpl(CategoryService categoryService, CategoryMapper categoryMapper, UtilityService utilityService) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
        this.utilityService = utilityService;
    }

    @GetMapping
    public Flux<ResponseEntity<CategoryResponse>> getAllCategories() {
       return Flux.fromIterable(categoryService.getAllCategories())
                .map(category -> {
                    CategoryResponse categoryResponse = categoryMapper.categoryToCategoryResponse(category);
                    return ResponseEntity.ok(categoryResponse);
                });
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<CategoryResponse>> getCategoryById(@PathVariable Long id) {
        return Mono.just(categoryService.getCategoryById(id))
                .map(category -> {
                    CategoryResponse categoryResponse = categoryMapper.categoryToCategoryResponse(category);
                    return ResponseEntity.ok(categoryResponse);

                })
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<CategoryResponse>> createCategory(@RequestBody CategoryRequest categoryRequest) {
        Category category = categoryMapper.categoryRequestToCategory(categoryRequest);

        return Mono.just(category)
                .map(categoryService::createCategory)
                .map(newCategory -> {
                    CategoryResponse categoryResponse = categoryMapper.categoryToCategoryResponse(newCategory);
                    return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponse);
                });
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<CategoryResponse>> updateCategory(@PathVariable Long id, @RequestBody CategoryRequest categoryRequest) {
        return Mono.just(categoryService.getCategoryById(id))
                .flatMap(existingCategory -> {
                    categoryRequest.setId(id); // Actualizar el ID de la categoría
                    Category categoryUpdate = categoryMapper.categoryRequestToCategory(categoryRequest);
                    Category category = categoryService.updateCategory(categoryUpdate);
                    CategoryResponse categoryResponse = categoryMapper.categoryToCategoryResponse(category);
                    return Mono.just(categoryResponse)
                            .map(updated -> ResponseEntity.ok(updated));
                })
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteCategory(@PathVariable Long id) {
        Category existingCategory = categoryService.getCategoryById(id);
        if (existingCategory != null) {
            categoryService.deleteCategoryById(id);
            return Mono.just(ResponseEntity.noContent().<Void>build());
        } else {
            return Mono.just(ResponseEntity.notFound().<Void>build());
        }
    }

    @GetMapping("/doSomething")
    public Mono<ResponseEntity<String>> performUsefulOperationWithResponse() {
        utilityService.doSomething();
        return Mono.just(ResponseEntity.ok("Operación útil realizada de manera reactiva"));
    }

    // Implementa otros métodos del controlador si es necesario
}