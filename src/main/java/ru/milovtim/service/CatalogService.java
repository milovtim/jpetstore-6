/**
 * Copyright 2010-2017 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.milovtim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.milovtim.domain.Category;
import ru.milovtim.domain.Product;
import ru.milovtim.mapper.CategoryMapper;
import ru.milovtim.mapper.ProductMapper;

@SuppressWarnings("SpringJavaAutowiringInspection")
@Service
public class CatalogService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductMapper productMapper;

    public List<Category> getCategoryList() {
        return categoryMapper.getCategoryList();
    }

    public Category addCategory(String catName, String catDescr) {
        String catId = catName.toUpperCase().replace(" ", "_");
        Category cat = new Category();
        cat.setCategoryId(catId);
        cat.setName(catName);
        cat.setDescription(catDescr);
        categoryMapper.createCategory(cat);
        return cat;
    }

    public Product addProductToCategory(Product product) {
        Objects.requireNonNull(product, "Cant add null product");
        Objects.requireNonNull(product.getCategoryId(), "Cant add product in null category");
        productMapper.createProduct(product);
        return product;
    }

    public Category getCategory(String categoryId) {
        return categoryMapper.getCategory(categoryId);
    }

    public List<Product> getProductListByCategory(String categoryId) {
        return productMapper.getProductListByCategory(categoryId);
    }

    /**
     * Search product list.
     *
     * @param keywords the keywords
     * @return the list
     */
    public List<Product> searchProductList(String keywords) {
        List<Product> products = new ArrayList<Product>();
        for (String keyword : keywords.split("\\s+")) {
            products.addAll(productMapper.searchProductList("%" + keyword.toLowerCase() + "%"));
        }
        return products;
    }

    public void editProduct(Integer prodId, String name, String description) {
        productMapper.editProductNameAndDescription(prodId, name, description);
    }
}