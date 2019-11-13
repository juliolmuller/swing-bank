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
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement stmtAdiciona = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmtAdiciona.setString(1, contact.getName());
            stmtAdiciona.setString(2, contact.getEmail());
            stmtAdiciona.setString(3, contact.getAddress());
            stmtAdiciona.setDate(4, Date.valueOf(contact.getDataNascimento()));
            stmtAdiciona.execute();
            ResultSet rs = stmtAdiciona.getGeneratedKeys();
            rs.next();
            long i = rs.getLong(1);
            contact.setId(i);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Contact> getList() throws SQLException {
        Connection connection = connectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmtLista = connection.prepareStatement(select);
        try {
            rs = stmtLista.executeQuery();
            List<Contact> contatos = new ArrayList();
            while (rs.next()) {
                // criando o objeto Contato
                // Contato contato = new Contato();
                long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String endereco = rs.getString("endereco");
                LocalDate dataNascimento = rs.getDate("data_nasc").toLocalDate();

                // adicionando o objeto à lista
                contatos.add(new Contact(id, nome, email, endereco, dataNascimento));
            }

            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            rs.close();
            stmtLista.close();
        }

    }

    public void update(Contact contact) throws SQLException {
        Connection connection = connectionFactory.getConnection();
        PreparedStatement stmtAtualiza = connection.prepareStatement(update);
        try {
            stmtAtualiza.setString(1, contact.getName());
            stmtAtualiza.setString(2, contact.getEmail());
            stmtAtualiza.setString(3, contact.getAddress());
            stmtAtualiza.setDate(4, Date.valueOf(contact.getDataNascimento()));
            stmtAtualiza.setLong(5, contact.getId());
            stmtAtualiza.executeUpdate();
        } finally {
            stmtAtualiza.close();
        }

    }

    public void delete(Contact contact) throws SQLException {
        Connection connection = connectionFactory.getConnection();
        PreparedStatement stmtExcluir;
        stmtExcluir = connection.prepareStatement(delete);
        try {
            stmtExcluir.setLong(1, contact.getId());
            stmtExcluir.executeUpdate();
        } finally {
            stmtExcluir.close();
        }
    }
}
