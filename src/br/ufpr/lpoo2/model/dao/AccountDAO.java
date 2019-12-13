package br.ufpr.lpoo2.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.ufpr.lpoo2.model.Account;
import br.ufpr.lpoo2.model.CheckingAccount;
import br.ufpr.lpoo2.model.InvestmentAccount;
import br.ufpr.lpoo2.services.ConnectionFactory;;

public class AccountDAO {

    private final ConnectionFactory connection;
    private final String INSERT_CHECKING_ACCOUNT = "INSERT INTO accounts(id, customer_cpf, type, balance, initial_deposit , max_limit) VALUES (?, ?, ?, ?, ?, ?)";
    private final String INSERT_INVESTMENT_ACCOUNT = "INSERT INTO accounts(id, customer_cpf, type, balance, initial_deposit , min_balance, min_deposit) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String SELECT_LAST_ACCOUNT_ID = "SELECT MAX(id) AS id FROM accounts";
    private final String SELECT_ACCOUNT_BY_CUSTOMER = "SELECT id, type, balance, max_limit, initial_deposit, min_balance, min_deposit FROM accounts WHERE customer_cpf = ?";
    private final String UPDATE_ACCOUNT_BALANCE = "UPDATE accounts SET balance = ? WHERE id = ?";
    private final String DELETE_ACCOUNT = "DELETE FROM accounts WHERE customer_cpf = ?";

    public AccountDAO(ConnectionFactory con) throws SQLException {
        this.connection = con;
        connection.getConnection();
    }

    public void insertCheckingAccount(CheckingAccount conta) throws SQLException {
        try (Connection con = connection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(INSERT_CHECKING_ACCOUNT, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, conta.getNumber());
            stmt.setString(2, conta.getOwner().getCPF());
            stmt.setString(3, "Conta Corrente");
            stmt.setDouble(4, conta.getInitialDeposit());
            stmt.setDouble(5, conta.getInitialDeposit());
            stmt.setDouble(6, conta.getMaxLimit());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir uma conta no banco de dados. Origem: " + ex.getMessage());
        }
    }

    public Account find(String cpf) throws SQLException {
        try (Connection con = connection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(SELECT_ACCOUNT_BY_CUSTOMER);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int contaNum = rs.getInt("id");
                String tipoConta = rs.getString("type");
                double saldoConta = rs.getDouble("balance");
                double limiteConta = rs.getDouble("max_limit");
                double depIni = rs.getDouble("initial_deposit");
                double montMin = rs.getDouble("min_amount");
                double depMin = rs.getDouble("min_deposit");
                if (tipoConta.toLowerCase().equals("conta corrente")) {
                    CheckingAccount ct = new CheckingAccount(null, contaNum, saldoConta, depMin, limiteConta);
                    ct.setType(tipoConta);
                    return ct;
                } else {
                    InvestmentAccount ct = new InvestmentAccount(null, contaNum, saldoConta, depIni, montMin, depMin);
                    ct.setType(tipoConta);
                    return ct;
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar conta no banco de dados. Origem: " + ex.getMessage());
        }
    }

    public void updateBalance(int id, double saldo) {
        try {
            Connection con = connection.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE_ACCOUNT_BALANCE);
            ps.setDouble(1, saldo);
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar saldo no banco de dados. Origem: " + ex.getMessage());
        }

    }

    public void insertInvestmentAccount(InvestmentAccount conta) throws SQLException {
        try (Connection con = connection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(INSERT_INVESTMENT_ACCOUNT, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, conta.getNumber());
            stmt.setString(2, conta.getOwner().getCPF());
            stmt.setString(3, "Conta Investimento");
            stmt.setDouble(4, conta.getInitialDeposit());
            stmt.setDouble(5, conta.getInitialDeposit());
            stmt.setDouble(6, conta.getMinBalance());
            stmt.setDouble(7, conta.getMinDeposit());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir uma conta no banco de dados. Origem: " + ex.getMessage());
        }
    }

    public int nextAccount() throws SQLException {
        try (Connection con = connection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(SELECT_LAST_ACCOUNT_ID);
            ResultSet rs = stmt.executeQuery();
            int id;
            if (rs.next()) {
                id = rs.getInt("id") + 1;
            } else {
                id = 0;
            }
            return id;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao consultar contas. Origem=" + ex.getMessage());
        }
    }

    public void delete(String cpf) throws SQLException {
        try (Connection con = connection.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(DELETE_ACCOUNT);
            stmt.setString(1, cpf);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar conta no banco de dados. Origem: " + ex.getMessage());
        }

    }
}
