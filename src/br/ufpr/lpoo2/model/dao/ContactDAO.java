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
import br.ufpr.lpoo2.model.Contact;
import br.ufpr.lpoo2.services.ConnectionFactory;

public class ContactDAO {

    private final ConnectionFactory connectionFactory;
    private final String insert = "INSERT INTO contatos (nome, email, endereco, data_nasc) VALUES (?, ?, ?, ?)";
    private final String select = "SELECT id, nome, email, endereco, data_nasc FROM contatos";
    private final String update = "UPDATE contatos SET nome = ?, email = ?, endereco = ?, data_nasc = ? WHERE id = ?";
    private final String delete = "DELETE FROM contatos WHERE id=?";

    public ContactDAO(ConnectionFactory conFactory) {
        this.connectionFactory = conFactory;
        connectionFactory.getConnection();
    }

    public void insert(Contact contact) {
        Connection conn = connectionFactory.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(this.insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getEmail());
            stmt.setString(3, contact.getAddress());
            stmt.setDate(4, Date.valueOf(contact.getDateBirth()));
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            long i = rs.getLong(1);
            contact.setId(i);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Contact> getList() throws SQLException {
        Connection conn = connectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = conn.prepareStatement(this.select);
        try {
            rs = stmt.executeQuery();
            List<Contact> contacts = new ArrayList<>();
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("nome");
                String email = rs.getString("email");
                String address = rs.getString("endereco");
                LocalDate dateBirth = rs.getDate("data_nasc").toLocalDate();
                contacts.add(new Contact(id, name, email, address, dateBirth));
            }

            return contacts;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            rs.close();
            stmt.close();
        }
    }

    public void update(Contact contact) throws SQLException {
        Connection conn = connectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(this.update);
        try {
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getEmail());
            stmt.setString(3, contact.getAddress());
            stmt.setDate(4, Date.valueOf(contact.getDateBirth()));
            stmt.setLong(5, contact.getId());
            stmt.executeUpdate();
        } finally {
            stmt.close();
        }
    }

    public void delete(Contact contact) throws SQLException {
        Connection conn = connectionFactory.getConnection();
        PreparedStatement stmt = conn.prepareStatement(delete);
        try {
            stmt.setLong(1, contact.getId());
            stmt.executeUpdate();
        } finally {
            stmt.close();
        }
    }
}
