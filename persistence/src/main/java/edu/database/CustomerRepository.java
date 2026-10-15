package edu.database;

import java.sql.*;

public class CustomerRepository {

    public void save(Customer customer) throws SQLException {

        String sql = """
            INSERT INTO customer (customer_name, customer_email)
            VALUES (?, ?)
            RETURNING customer_id
            """;

        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    customer.setId(rs.getInt("customer_id"));
                }
            }
        }
    }

    public Customer findById(int id) throws SQLException {

        String sql = """
            SELECT customer_id, customer_name, customer_email
            FROM customer
            WHERE customer_id = ?
            """;

        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("customer_name"),
                        rs.getString("customer_email")
                    );
                }
            }
        }

        return null;
    }

    public void update(Customer customer) throws SQLException {

        if (customer.getId() == null) {
            throw new IllegalArgumentException("Customer has no database ID");
        }

        String sql = """
            UPDATE customer
            SET customer_name = ?, customer_email = ?
            WHERE customer_id = ?
            """;

        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setInt(3, customer.getId());

            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {

        String sql = "DELETE FROM customer WHERE customer_id = ?";

        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}