package br.ufpr.lpoo2.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import br.ufpr.lpoo2.model.Customer;
import br.ufpr.lpoo2.services.ConnectionFactory;;

public class CustomerDAO {

    private final ConnectionFactory connection;
    private final String INSERT_CUSTOMER = "INSERT INTO customers (first_name, last_name, rg, cpf, address) VALUES (?, ?, ?, ?, ?)";
    private final String SELECT_ALL_CUSTOMERS = "SELECT id, first_name, last_name, rg, cpf, address FROM customers";
    private final String SELECT_CUSTOMER_BY_CPF = "SELECT first_name, last_name, rg, address FROM customers WHERE cpf = ?";
    private final String UPDATE_CUSTOMER = "UPDATE customers SET first_name = ?, last_name = ?, rg = ?, cpf = ?, address = ? WHERE id = ?";
    private final String DELETE_CUSTOMER = "DELETE FROM customers WHERE id = ?";

    public CustomerDAO(ConnectionFactory conn) throws SQLException {
        this.connection = conn;
        connection.getConnection();
    }

    public List<Customer> list() throws SQLException {
        try (Connection conn = connection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_CUSTOMERS);
            ResultSet rs = stmt.executeQuery();
            List<Customer> customers = new ArrayList<>();
            while (rs.next()) {
                customers.add(new Customer(
                    rs.getInt("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("rg"),
                    rs.getString("cpf"),
                    rs.getString("address")
                ));
            }
            return customers;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao consultar uma lista de clientes. Origem: " + ex.getMessage());
        }
    }

    public Customer get(String cpf) throws SQLException {
        try (Connection conn = connection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(SELECT_CUSTOMER_BY_CPF);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Customer(
                    null,
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("rg"),
                    cpf,
                    rs.getString("address")
                );
            }
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao consultar um cliente. Origem=" + ex.getMessage());
        }
    }

    public void insert(Customer customer) throws SQLException {
        try (Connection conn = connection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(INSERT_CUSTOMER, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setString(3, customer.getRG());
            stmt.setString(4, customer.getCPF());
            stmt.setString(5, customer.getAddress());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            customer.setId(rs.getInt(1));
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir um cliente no banco de dados. Origem: " + ex.getMessage());
        }
    }

    public void update(Customer customer) throws SQLException {
        try (Connection conn = connection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(UPDATE_CUSTOMER);
            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setString(3, customer.getRG());
            stmt.setString(4, customer.getCPF());
            stmt.setString(5, customer.getAddress());
            stmt.setInt(6, customer.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar um cliente no banco de dados. Origem: " + ex.getMessage());
        }
    }

    public void delete(Customer customer) throws SQLException {
        try (Connection conn = connection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(DELETE_CUSTOMER);
            stmt.setInt(1, customer.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao excluir um cliente no banco de dados. Origem: " + ex.getMessage());
        }
    }
}
