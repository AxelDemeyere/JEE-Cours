package org.app.exo3.dao;

import org.app.exo3.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CatDAO {

    public void addCat(String name, String favoriteFood, String birthDate) throws SQLException {
        String sql = "INSERT INTO cats (name, favorite_food, birth_date) VALUES (?, ?, ?)";
        System.out.println("Requête SQL : " + sql);
        System.out.println("Données : " + name + ", " + favoriteFood + ", " + birthDate);


        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, favoriteFood);
            pstmt.setString(3, birthDate);
            pstmt.executeUpdate();
        }
    }
}