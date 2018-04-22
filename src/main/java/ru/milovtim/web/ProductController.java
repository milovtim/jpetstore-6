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

@Controller
@RequestMapping("/ajax")
@Spring3EnableCors
public class ProductController {

    private final CatalogService catalogService;

    @Autowired
    public ProductController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }


    @RequestMapping(value = "/cat", method = GET)
    @ResponseBody()
    public List<Category> categoryList() {
        return this.catalogService.getCategoryList();
    }

    @RequestMapping(value = "/cat/{id}", method = GET)
    @ResponseBody()
    public Category categoryList(@PathVariable("id") String catId) {
        return this.catalogService.getCategory(catId);
    }

    @RequestMapping(value = "/cat", method = POST)
    public ResponseEntity<Map> categoryAdd(@RequestBody Category cat, UriComponentsBuilder uriComponentsBuilder) {
        Category newCat = this.catalogService.addCategory(cat.getName(), cat.getDescription());

        URI newEntityUri = uriComponentsBuilder.path("/ajax/cat/" + newCat.getCategoryId()).build().toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(newEntityUri);

        HashMap<String, Object> respBody = new HashMap<String, Object>();
        respBody.put("location", newEntityUri);
        return new ResponseEntity<Map>(respBody, headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/prod-list", method = GET)
    @ResponseBody()
    public List<Product> prodList(@RequestParam("cat-id") String catId) {
        return this.catalogService.getProductListByCategory(catId);
    }
}
