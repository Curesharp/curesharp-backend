package com.curesharp.config.h2;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DatabaseInitialazer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("[INFO] Provisionando banco de dados no ambiente de DEV");

        try {
            Class.forName("org.h2.Driver");
            Connection connection = DriverManager.getConnection("jdbc:h2:~/curesharp", "admin", "admin");
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("create_tables.sql");

            if (inputStream != null) {
                Statement statement = connection.createStatement();
                statement.execute(new String(inputStream.readAllBytes()));

                statement.close();
                connection.close();

                System.out.println("[INFO] Banco de dados provisionado");
                System.out.println("[INFO] Acesse o console do H2 pelo endereço http://localhost:8080/curesharp/h2");
                System.out.println("[INFO] JDBC URL: jdbc:h2:~/curesharp");
                System.out.println("[INFO] User Name: admin");
                System.out.println("[INFO] Password: admin");

            } else {
                System.out.println("Arquivo SQL não encontrado!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {    }
}
