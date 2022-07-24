package com.tutorial.apidemo.database;
import com.tutorial.apidemo.models.Product;
import com.tutorial.apidemo.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    private static    Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository){

        return  new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product ProductA = new Product("Macbook Pro 16",2020,2400.0,"");
                Product ProductB = new Product("Macbook Pro 16",2020,2400.0,"");
                logger.info(""+ productRepository.save(ProductA));
                logger.info(""+ productRepository.save(ProductB));
            }
        };
    }
}
