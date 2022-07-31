package com.example.r2dbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import io.r2dbc.spi.Connection;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import reactor.core.publisher.Flux;

@Configuration
@SpringBootApplication(exclude = {R2dbcAutoConfiguration.class})
public class R2dbcApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(R2dbcApplication.class, args);
		ConnectionFactory _connection = ConnectionFactories.get(ConnectionFactoryOptions.builder()
		.option(ConnectionFactoryOptions.DRIVER, "oracle")
		.option(ConnectionFactoryOptions.HOST, "localhost")
		.option(ConnectionFactoryOptions.PORT, 1521)
		.option(ConnectionFactoryOptions.USER, "APPLUUDONG")
		.option(ConnectionFactoryOptions.PASSWORD, "12345")
		.option(ConnectionFactoryOptions.DATABASE, "orclpdb")
		.build());
		
		Flux.usingWhen(
  			_connection.create(),
  			connection ->
    		Flux.from(connection.createStatement(
				"CALL APPLUUDONG.APPLICATION_GROUP_GETALL()")
      		.execute())
      		.flatMap(result ->
        	result.map(row -> row.get(0, String.class))),
  			Connection::close)
  			.doOnNext(System.out::println)
  			.doOnError(Throwable::printStackTrace)
  			.subscribe();
		
	}

}
