package ru.milovtim.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import ru.milovtim.domain.Category;

public interface CategoryMapper {

    List<Category> getCategoryList();

    Category getCategory(@Param("categoryId") String categoryId);

    void createCategory(Category category);
}
