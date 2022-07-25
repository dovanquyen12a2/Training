package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// import com.example.demo.integration.respository.InitQuery;

@SpringBootTest
class DemoApplicationTests {
	//Test Connect to Oracle Database
	@Test
	void contextLoads() throws SQLException {
		try {
			
            Class.forName("oracle.jdbc.OracleDriver");
            Connection _connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=localhost)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=orclpdb)))",
                    "APPLUUDONG", "12345");
            Statement statement = _connection.createStatement();
			statement.executeQuery("CREATE TABLE APPLUUDONG.TESTTABLE(	ID NUMBER(19,0)) SEGMENT CREATION DEFERRED PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING TABLESPACE USERS");
            statement.executeQuery("DROP TABLE APPLUUDONG.TESTTABLE");
            _connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	

}
