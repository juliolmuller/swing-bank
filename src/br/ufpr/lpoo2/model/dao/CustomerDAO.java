package br.ufpr.lpoo2.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import br.ufpr.lpoo2.model.Customer;
import br.ufpr.lpoo2.services.ConnectionFactory;

public class CustomerDAO {

    private final ConnectionFactory connectionFactory;
    private final String insert = "INSERT INTO customers(first_name, last_name, date_birth, address, rg, cpf) VALUES (?, ?, ?, ?, ?, ?)";
    private final String select = "SELECT id, first_name, last_name, date_birth, address, rg, cpf FROM customers";
    private final String update = "UPDATE customers SET first_name = ?, last_name = ?, date_birth = ?, address = ?, rg = ?, cpf = ? WHERE id = ?";
    private final String delete = "DELETE FROM customers WHERE id = ?";

    public CustomerDAO(ConnectionFactory conFactory) {
        this.connectionFactory = conFactory;
        connectionFactory.getConnection();
    }

    public void insert(Customer customer) {
        Connection conn = connectionFactory.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(this.insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setDate(3, Date.valueOf(customer.getDateBirth()));
            stmt.setString(4, customer.getAddress());
            stmt.setString(5, customer.getRG());
            stmt.setString(6, customer.getCPF());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            long i = rs.getLong(1);
            customer.setId(i);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Customer> selectAll() throws SQLException {
        Connection conn = connectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = conn.prepareStatement(this.select);
        try {
            rs = stmt.executeQuery();
            List<Customer> customers = new ArrayList<>();
            while (rs.next()) {
                customers.add(new Customer(
                    rs.getLong("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getDate("date_birth").toLocalDate(),
                    rs.getString("address"),
                    rs.getString("rg"),
                    rs.getString("cpf")
                ));
            }
            return customers;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            rs.close();
            stmt.close();
        }
    }

    public void update(Customer customer) throws SQLException {
        Connection conn = connectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(this.update);
        try {
            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setDate(3, Date.valueOf(customer.getDateBirth()));
            stmt.setString(4, customer.getAddress());
            stmt.setString(5, customer.getRG());
            stmt.setString(6, customer.getCPF());
            stmt.setLong(7, customer.getId());
            stmt.executeUpdate();
        } finally {
            stmt.close();
        }
    }

    public void delete(Customer customer) throws SQLException {
        Connection conn = connectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(this.delete);
        try {
            stmt.setLong(1, customer.getId());
            stmt.executeUpdate();
        } finally {
            stmt.close();
        }
    }
}
