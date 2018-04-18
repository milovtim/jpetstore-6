package ru.milovtim.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import ru.milovtim.domain.Product;

public interface ProductMapper {

  List<Product> getProductListByCategory(@Param("categoryId") String categoryId);

  Product getProduct(@Param("productId") String productId);

  List<Product> searchProductList(@Param("keywords") String keywords);

}
