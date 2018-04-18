package ru.milovtim.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(locations = 'classpath:context/applicationContext.xml')
class CatalogServiceTest extends Specification {

    @Autowired
    CatalogService catalogService

    def "GetCategoryList"() {
        when:
        def list = catalogService.categoryList

        then:
        list.size() == 5
    }
}
