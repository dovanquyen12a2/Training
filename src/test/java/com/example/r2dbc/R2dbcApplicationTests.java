package com.example.r2dbc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.r2dbc.spi.Connection;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import reactor.core.publisher.Flux;

@SpringBootTest
class R2dbcApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void testConnection(){
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
				" DROP TABLE APPLUUDONG.APPLICATION_GROUP")
      		.execute())
			
      		.flatMap(result ->
        	result.map(row -> row.get(0, String.class))),
  			Connection::close)
  			.doOnNext(System.out::println)
  			.doOnError(Throwable::printStackTrace)
  			.subscribe();
	}

	@Test
	void testProcedureAdd(){
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
				"CALL APPLUUDONG.APPLICATION_GROUP_ADD(:p_ID,:p_APPGROUP_NAME,:p_APPGROUP_DESCRIPTION)")
			.bind("p_ID",1)
			.bind("p_APPGROUP_NAME","APPLICATION_GROUP.APPGROUP_NAME")
			.bind("p_APPGROUP_DESCRIPTION","APPLICATION_GROUP.APPGROUP_DESCRIPTION")
      		.execute())
      		.flatMap(result ->
        	result.map(row -> row.get(0, String.class))),
  			Connection::close)
  			.doOnNext(System.out::println)
  			.doOnError(Throwable::printStackTrace)
  			.subscribe();
	}

	@Test
	void testProcedureGETALL(){
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
	@Test
	void testProcedureGETBYID(){
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
				"CALL APPLUUDONG.APPLICATION_GROUP_GETBYID(:pID)")
				.bind("pID", 1)
      		.execute())
      		.flatMap(result ->
        	result.map(row -> row.get(0, String.class))),
  			Connection::close)
  			.doOnNext(System.out::println)
  			.doOnError(Throwable::printStackTrace)
  			.subscribe();
	}

}
