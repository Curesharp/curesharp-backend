package com.curesharp.config.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryH2 {
    public Connection conexao() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/curesharp", "admin", "admin");
    }
}
