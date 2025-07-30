package org.app.exo3.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DB_URL = "jdbc:sqlite:cats.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Pilote SQLite introuvable", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL);

        String createTableSQL = """
            CREATE TABLE IF NOT EXISTS cats (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                favorite_food TEXT NOT NULL,
                birth_date TEXT NOT NULL
            )
            """;

        try (PreparedStatement stmt = conn.prepareStatement(createTableSQL)) {
            stmt.executeUpdate();
        }

        return conn;
    }
}