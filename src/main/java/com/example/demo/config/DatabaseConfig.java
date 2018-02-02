package com.example.demo.config;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "demoEntityManagerFactory", basePackages = {"com.example.demo.ras"})
public class DatabaseConfig {

    @Configuration
    @Profile("!cloud")
    static class DatabaseLocalConfig {

        @Bean
        @Primary
        LocalContainerEntityManagerFactoryBean demoEntityManagerFactory(EntityManagerFactoryBuilder builder) throws IOException {
            return builder.dataSource(postgresDb())
                    .packages("com.example.demo.domain", "com.example.demo.domain.ras.converters")
                    .persistenceUnit("demoDb")
                    .properties(jpaProperties())
                    .build();
        }

        @Bean
        @Primary
        @FlywayDataSource
        @ConfigurationProperties(prefix = "datasource.demodb")
        DataSource postgresDb() throws IOException {
            EmbeddedPostgres pg = EmbeddedPostgres.builder().setPort(13579).start();
            return pg.getPostgresDatabase();
        }

        private Map<String, Object> jpaProperties() {
            Map<String, Object> props = new HashMap<>();
            props.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
            return props;
        }
    }
}
