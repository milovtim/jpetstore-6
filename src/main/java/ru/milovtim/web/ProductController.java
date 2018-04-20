package ru.milovtim.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.milovtim.domain.Category;
import ru.milovtim.domain.Product;
import ru.milovtim.service.CatalogService;
import ru.milovtim.service.Spring3CorsFilter;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/ajax")
public class ProductController {

    private final CatalogService catalogService;

    @Autowired
    public ProductController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }


    @RequestMapping(value = "/cat-list", method = GET)
    @ResponseBody()
    @Spring3CorsFilter
    public List<Category> categoryList() {
        return this.catalogService.getCategoryList();
    }


    @RequestMapping(value = "/prod-list", method = GET)
    @ResponseBody()
    @Spring3CorsFilter
    public List<Product> prodList(@RequestParam("cat-id") String catId) {
        return this.catalogService.getProductListByCategory(catId);
    }
}
