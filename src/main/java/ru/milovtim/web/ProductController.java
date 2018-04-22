package ru.milovtim.web;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.milovtim.domain.Category;
import ru.milovtim.domain.Product;
import ru.milovtim.service.CatalogService;
import ru.milovtim.service.Spring3EnableCors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@Controller
@RequestMapping("/ajax")
public class ProductController {

    private final CatalogService catalogService;

    @Autowired
    public ProductController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }


    @RequestMapping(value = "/cat", method = GET)
    @ResponseBody()
    public List<Category> categoryById() {
        return this.catalogService.getCategoryList();
    }

    @RequestMapping(value = "/cat/{id}", method = GET)
    @ResponseBody()
    public Category categoryById(@PathVariable("id") String catId) {
        return this.catalogService.getCategory(catId);
    }

    @RequestMapping(value = "/cat", method = POST)
    public ResponseEntity<Map> categoryAdd(@RequestBody Category cat, UriComponentsBuilder uriComponentsBuilder) {
        Category newCat = this.catalogService.addCategory(cat.getName(), cat.getDescription());

        URI newEntityUri = uriComponentsBuilder.path("/ajax/cat/" + newCat.getCategoryId()).build().toUri();
        HttpHeaders headers = createHeadersWithLocation(newEntityUri);
        HashMap<String, Object> respBody = createResponseMapWithLocation(newEntityUri);
        return new ResponseEntity<Map>(respBody, headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/prod", method = POST)
    public ResponseEntity<Product> productAdd(@RequestBody Product product) {
        Product newProd = this.catalogService.addProductToCategory(product);
        return new ResponseEntity<>(newProd, HttpStatus.CREATED);
    }

    /* Через cors хедер Location может быть недоступен */
    private HashMap<String, Object> createResponseMapWithLocation(URI newEntityUri) {
        HashMap<String, Object> respBody = new HashMap<>();
        respBody.put("location", newEntityUri);
        return respBody;
    }

    private HttpHeaders createHeadersWithLocation(URI newEntityUri) {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(newEntityUri);
        return headers;
    }


    @RequestMapping(value = "/cat/{catId}/prod", method = GET)
    @ResponseBody()
    public List<Product> prodList(@PathVariable("catId") String catId) {
        return this.catalogService.getProductListByCategory(catId);
    }


    @RequestMapping(value = "/prod/edit/{prodId}", method = POST)
    public ResponseEntity<Void> prodEdit(@PathVariable("prodId") Integer prodId, @RequestBody Product product) {
        this.catalogService.editProduct(prodId, product.getName(), product.getDescription());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
