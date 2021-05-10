package com.raggerbreak.ecommerce.config;

import com.raggerbreak.ecommerce.domain.Country;
import com.raggerbreak.ecommerce.domain.Product;
import com.raggerbreak.ecommerce.domain.ProductCategory;
import com.raggerbreak.ecommerce.domain.State;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.ExposureConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@RequiredArgsConstructor
@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    private final EntityManager entityManager;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST,HttpMethod.PATCH, HttpMethod.DELETE};

        // disable HTTP methods: PUT, POST, PATCH and DELETE
        disableHttpMethods(Product.class, config, theUnsupportedActions);
        disableHttpMethods(ProductCategory.class, config, theUnsupportedActions);
        disableHttpMethods(Country.class, config, theUnsupportedActions);
        disableHttpMethods(State.class, config, theUnsupportedActions);

        // call an internal helper method
        exposeIds(config);
    }

    private ExposureConfigurer disableHttpMethods(Class domainType, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
        return config.getExposureConfiguration()
                .forDomainType(domainType)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }

    private void exposeIds(RepositoryRestConfiguration config) {

        //get entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // create array of the entity types
        List<Class> entityClasses = new ArrayList<>();

        // get entity types for the entities
        for (EntityType tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }

        // expose entity ids for the array of entity/domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);

    }
}
