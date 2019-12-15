package br.ufpr.lpoo2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.EventQueue;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import br.ufpr.lpoo2.model.Customer;
import br.ufpr.lpoo2.model.CustomerTableModel;
import br.ufpr.lpoo2.model.Account;
import br.ufpr.lpoo2.model.CheckingAccount;
import br.ufpr.lpoo2.model.InvestmentAccount;
import br.ufpr.lpoo2.model.CpfComboBoxModel;
import br.ufpr.lpoo2.model.comparator.FirstNameComparator;
import br.ufpr.lpoo2.model.comparator.LastNameComparator;
import br.ufpr.lpoo2.model.dao.CustomerDAO;
import br.ufpr.lpoo2.model.dao.AccountDAO;
import br.ufpr.lpoo2.view.BankView;

public class BankController {

    private final CustomerTableModel model;
    private final BankView view;
    private final CustomerDAO customerDAO;
    private final AccountDAO accountDAO;
    private final CpfComboBoxModel cpfModel;
    private int clickedRow = -1;

    public BankController(CustomerTableModel model, BankView view, CustomerDAO customerDAO, AccountDAO accountDAO, CpfComboBoxModel cpfModel) {
        this.model = model;
        this.view = view;
        this.customerDAO = customerDAO;
        this.accountDAO = accountDAO;
        this.cpfModel = cpfModel;
    }

    public void initController() {
        this.view.getTable().setModel(this.model);
        this.view.getCpfCombo().setModel(this.cpfModel);
        this.view.getCpfCombo2().setModel(this.cpfModel);
        this.view.getListBtn().addActionListener(evt -> listAll(0));
        this.view.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectCustomers(evt);
            }
        });
        this.view.getClenaBtn().addActionListener(evt -> cleanTable());
        this.view.getAssignBtn().addActionListener((ActionEvent evt) -> {
            try {
                disassignAccount();
            } catch (SQLException ex) {
                Logger.getLogger(BankController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.view.getDeleteBtn().addActionListener(evt -> deleteCustomer());
        this.view.getInsertBtn().addActionListener(evt -> addCustomer());
        this.view.getUpdateBtn().addActionListener(evt -> updateCustomer());
        this.view.getAccountCombo().addActionListener(evt -> {
            try {
                viewAccount();
            } catch (SQLException ex) {
                Logger.getLogger(BankController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.view.getCpfCombo().addActionListener(evt -> {
            try {
                setAssignmentFields();
            } catch (SQLException ex) {
                Logger.getLogger(BankController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.view.getCpfCombo2().addActionListener(evt -> {
            try {
                setAccountFields();
            } catch (SQLException ex) {
                Logger.getLogger(BankController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.view.getDepositBtn().addActionListener(evt -> {
            try {
                deposit();
            } catch (SQLException ex) {
                Logger.getLogger(BankController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.view.getWithdrawalBtn().addActionListener(evt -> {
            try {
                withdraw();
            } catch (SQLException ex) {
                Logger.getLogger(BankController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.view.getPaymentBtn().addActionListener(evt -> {
            try {
                pay();
            } catch (SQLException ex) {
                Logger.getLogger(BankController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.view.getCleanFormBtn().addActionListener(evt -> cleanForm());
        this.view.getDisassignBtn().addActionListener(evt -> {
            try {
                disassign(view.getCpfCombo2().getSelectedItem().toString());
            } catch (SQLException ex) {
                Logger.getLogger(BankController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.view.getSortFirstNameBtn().addActionListener(evt -> listAll(1));
        this.view.getSortLastNameBtn().addActionListener(evt -> listAll(2));
        this.view.getInvestmentAccountsPanel().setVisible(false);
        this.view.getCheckingAccountsPanel().setVisible(false);
        this.view.getAccNumberField().setEditable(false);
        this.view.getFirstNameField2().setEditable(false);
        this.view.getLastNameField2().setEditable(false);
        this.view.getAccNumberField().setEditable(false);
        this.view.getAccTypeField().setEditable(false);
        this.view.getBalanceField().setEditable(false);
        this.view.getGeneralStatusField().setEditable(false);
        this.view.getAccountCombo().addItem("Conta Corrente");
        this.view.getAccountCombo().addItem("Conta Investimento");
        this.view.getDepositBtn().setEnabled(false);
        this.view.getWithdrawalBtn().setEnabled(false);
        this.view.getPaymentBtn().setEnabled(false);
        this.view.getDepositField().setEditable(false);
        this.view.getWithdrawalField().setEditable(false);
        this.view.getDepositField().setText("");
        this.view.getWithdrawalField().setText("");
        this.view.getGeneralStatusField().setText("");
        this.view.getFirstNameToAssignField().setText("");
        this.view.getFirstNameToAssignField().setEditable(false);
        this.view.getLastNameToassignField().setText("");
        this.view.getLastNameToassignField().setEditable(false);
        this.view.getAccNameToAssignField().setText("");
        this.view.getAccNameToAssignField().setEditable(false);
        this.view.getAccTypeToAssignField().setText("");
        this.view.getAccTypeToAssignField().setEditable(false);
        this.view.getFormStatusField().setEditable(false);
        this.view.getAssignmentStatusField().setEditable(false);
        this.view.getAccNumberField().setEditable(false);
        this.view.getUpdateBtn().setEnabled(false);
        this.view.getDeleteBtn().setEnabled(false);
        this.view.getDisassignBtn().setEnabled(false);
        initView();
    }

    public void initView() {
        EventQueue.invokeLater(() -> view.setVisible(true));
    }

    private void listAll(int option) {
        try {
            List<Customer> customers = this.customerDAO.list();
            if (option == 1) {
                Set<Customer> orderedSet = new TreeSet<>(new FirstNameComparator());
                for (Customer c : customers) {
                    orderedSet.add(c);
                }
                customers = new ArrayList<>(orderedSet);
            } else if (option == 2) {
                Set<Customer> orderedSet = new TreeSet<>(new LastNameComparator());
                for (Customer c : customers) {
                    orderedSet.add(c);
                }
                customers = new ArrayList<>(orderedSet);
            }
            this.model.setCustomers(customers);
        } catch (Exception ex) {
            view.showError("Erro ao listar contato. Ex.:" + ex);
        }
    }

    private void selectCustomers(MouseEvent evt) {
        this.clickedRow = view.getSelectedLine(evt);
        Customer customer = model.getCustomer(this.clickedRow);
        this.view.setCliente(customer);
        this.view.getUpdateBtn().setEnabled(true);
        this.view.getInsertBtn().setEnabled(false);
        this.view.getCpfField().setEditable(false);
        this.view.getDeleteBtn().setEnabled(true);
    }

    private void cleanTable() {
        model.clean();
    }

    private void deleteCustomer() {
        String notification = "";
        try {
            int[] selectedRows = view.getTable().getSelectedRows();
            List<Customer> deletionList = new ArrayList<>();
            for (int i = 0; i < selectedRows.length; i++) {
                Customer cliente = model.getCustomer(selectedRows[i]);
                int input = JOptionPane.showConfirmDialog(null, "Deletando o cliente: " + cliente.getCPF() + " sua conta (caso existir) será apagada também. Deseja continuar?");
                if (input == 0) {
                    this.accountDAO.delete(cliente.getCPF());
                    this.customerDAO.delete(cliente);
                    notification += "Cliente: " + cliente.getCPF() + " excluído com sucesso!\n";
                    deletionList.add(cliente);
                }
            }
            deletionList.forEach((cliente) -> {
                this.model.removeCustomer(cliente);
                this.cpfModel.removeCpf(cliente.getCPF());
            });
            cleanForm();
            view.getFormStatusField().setText(notification);
        } catch (Exception ex) {
            view.showError("Erro ao excluir contato. " + ex);
        }
    }

    private void addCustomer() {
        String notification = "";
        try {
            Customer customer = this.view.getCliente();
            if (validade(customer) == true) {
                this.customerDAO.insert(customer);
                this.model.addCustomer(customer);
                notification += "Cliente adicionado com sucesso";
                notification += "\nNome completo: " + customer.getFirstName() + " " + customer.getLastName();
                notification += "\nRG: " + customer.getRG();
                notification += "\nCPF: " + customer.getCPF();
                this.view.getFormStatusField().setText(notification);
                this.cpfModel.addCpf(customer.getCPF());
                cleanForm();
            } else {
                notification += "É preciso preencher todos os campos para adicionar um cliente";
                this.view.getFormStatusField().setText(notification);
            }
        } catch (Exception ex) {
            this.view.showError("Erro ao incluir contato. " + ex);
        }
    }

    private void updateCustomer() {
        try {
            if (this.clickedRow != -1) {
                String notification = "";
                Customer customer = this.model.getCustomer(clickedRow);
                String oldCpf = customer.getCPF();
                Customer customerView = view.getCliente();
                customer.clone(customerView);
                if (validade(customer) == true) {
                    this.customerDAO.update(customer);
                    this.model.fireTableRowsUpdated(clickedRow, clickedRow);
                    this.cpfModel.removeCpf(oldCpf);
                    this.cpfModel.addCpf(customer.getCPF());
                    notification += "Cliente atualizado com sucesso";
                    notification += "\nCPF: " + customer.getCPF();
                    cleanForm();
                } else {
                    notification += "Preencha todos os campos para atualizar";
                }
                this.view.getFormStatusField().setText(notification);
            }
        } catch (Exception ex) {
            this.view.showError("Erro ao atualizar contato. " + ex);
        }
    }

    private void viewAccount() throws SQLException {
        if (this.view.getAccountCombo().getSelectedIndex() == 0) {
            this.view.getCheckingAccountsPanel().setVisible(true);
            this.view.getInvestmentAccountsPanel().setVisible(false);
        } else {
            this.view.getCheckingAccountsPanel().setVisible(false);
            this.view.getInvestmentAccountsPanel().setVisible(true);
        }
        this.view.getAccNumberField().setText(Integer.toString(this.accountDAO.nextAccount()));
    }

    private void disassignAccount() throws SQLException {
        String notification = "";
        if (this.view.getAccountCombo().getSelectedIndex() == 0) {
            CheckingAccount account = new CheckingAccount(this.customerDAO.get(this.view.getCpfCombo().getSelectedItem().toString()), Integer.parseInt(view.getAccNumberField().getText()), Double.parseDouble(view.getInitialDepositField().getText()), Double.parseDouble(view.getInitialDepositField().getText()), Double.parseDouble(view.getMaxLimitField().getText()));
            this.accountDAO.insertCheckingAccount(account);
            notification += "Conta Corrente vinculada com sucesso!";
            notification += "\nCliente: " + this.view.getFirstNameToAssignField().getText() + " " + this.view.getLastNameToassignField().getText();
            notification += "\nCPF: " + this.view.getCpfCombo2().getSelectedItem().toString();
            notification += "\nConta corrente: " + account.getNumber();
        } else {
            try {
                double amount, deposit;
                deposit = Double.parseDouble(this.view.getInitialDepositField().getText());
                amount = Double.parseDouble(this.view.getMinBalanceField().getText());
                if (deposit < amount) {
                    throw new RuntimeException("Depósito inicial é menor que o montante mínimo\n Conta Investimento não vinculada");
                }
                InvestmentAccount account = new InvestmentAccount(this.customerDAO.get(this.view.getCpfCombo().getSelectedItem().toString()), Integer.parseInt(view.getAccNumberField().getText()), Double.parseDouble(view.getInitialDepositField().getText()), Double.parseDouble(view.getInitialDepositField().getText()), Double.parseDouble(view.getMinBalanceField().getText()), Double.parseDouble(view.getMinDepositField().getText()));
                this.accountDAO.insertInvestmentAccount(account);
                notification += "Conta Investimento vinculada com sucesso!";
                notification += "\nCliente: " + this.view.getFirstNameToAssignField().getText() + " " + view.getLastNameToassignField().getText();
                notification += "\nCPF: " + this.view.getCpfCombo2().getSelectedItem().toString();
                notification += "\nConta corrente: " + account.getNumber();
            } catch (RuntimeException ex) {
                notification += ex.getMessage();
            }
        }
        this.view.getAssignmentStatusField().setText(notification);
    }

    private void setAccountFields() throws SQLException {
        Customer customer = this.customerDAO.get(this.view.getCpfCombo2().getSelectedItem().toString());
        this.view.getFirstNameField2().setText(customer.getFirstName());
        this.view.getLastNameField2().setText(customer.getLastName());
        Account account = this.accountDAO.find(customer.getCPF());
        if (account != null) {
            this.view.getDisassignBtn().setEnabled(true);
            this.view.getDepositBtn().setEnabled(true);
            this.view.getWithdrawalBtn().setEnabled(true);
            this.view.getPaymentBtn().setEnabled(true);
            this.view.getDepositField().setEditable(true);
            this.view.getWithdrawalField().setEditable(true);
            this.view.getAccNumberField().setText(Integer.toString(account.getNumber()));
            this.view.getAccTypeField().setText(account.getType());
            this.view.getBalanceField().setText(Double.toString(account.getBalance()));
        } else {
            this.view.getDisassignBtn().setEnabled(false);
            this.view.getDepositBtn().setEnabled(false);
            this.view.getWithdrawalBtn().setEnabled(false);
            this.view.getPaymentBtn().setEnabled(false);
            this.view.getDepositField().setEditable(false);
            this.view.getWithdrawalField().setEditable(false);
            this.view.getDepositField().setText("");
            this.view.getWithdrawalField().setText("");
            this.view.getGeneralStatusField().setText("");
            this.view.getAccNumberField().setText("Sem conta vinculada");
            this.view.getAccTypeField().setText("Sem conta vinculada");
            this.view.getBalanceField().setText("Sem conta vinculada");
        }
    }

    private void deposit() throws SQLException {
        try {
            double value = Double.parseDouble(this.view.getDepositField().getText());
            Account account = this.accountDAO.find(this.view.getCpfCombo2().getSelectedItem().toString());
            if (account.deposit(value) == true) {
                this.accountDAO.updateBalance(account.getNumber(), account.getBalance());
                this.view.getBalanceField().setText(Double.toString(account.getBalance()));
                String notification = "";
                notification += "**Depósito efetuado com sucesso**\n";
                notification += "Conta: ";
                notification += account.getNumber();
                notification += " - Valor: R$";
                notification += value;
                this.view.getGeneralStatusField().setText(notification);
                this.view.getDepositField().setText("");
            } else {
                String notification = "";
                notification += ("**Depósito não realizado**\n");
                if (account.getType().toLowerCase().equals("conta corrente")) {
                    notification += ("Valor inválido.");
                } else {
                    notification += "Valor abaixo do depósito mínimo";
                }
                this.view.getGeneralStatusField().setText(notification);
            }

        } catch (NumberFormatException ex) {
            view.getGeneralStatusField().setText("Valor informado é inválido. Tente novamente\n" + ex.getMessage());
        } catch (RuntimeException ex) {
            view.getGeneralStatusField().setText("Valor inválido. Tente novamente\n" + ex.getMessage());
        }

    }

    private void withdraw() throws SQLException {
        try {
            double value = Double.parseDouble(this.view.getWithdrawalField().getText());
            Account account = accountDAO.find(this.view.getCpfCombo2().getSelectedItem().toString());
            if (account.withdraw(value) == true) {
                this.accountDAO.updateBalance(account.getNumber(), account.getBalance());
                this.view.getBalanceField().setText(Double.toString(account.getBalance()));
                String notification = "";
                notification += ("**Saque efetuado com sucesso**\n");
                notification += ("Conta: ");
                notification += (account.getNumber());
                notification += (" - Valor: R$");
                notification += (value);
                this.view.getGeneralStatusField().setText(notification);
                this.view.getWithdrawalField().setText("");
            } else {
                String notification = "";
                notification += ("**Saque não realizado**\n");
                if (account.getType().toLowerCase().equals("conta corrente")) {
                    notification += ("Valor ultrapassa o limite. Saldo: " + account.getBalance());
                } else {
                    notification += "Saldo remanescente abaixo do montante mínimo da conta";
                }
                this.view.getGeneralStatusField().setText(notification);
            }
        } catch (NumberFormatException ex) {
            this.view.getGeneralStatusField().setText("Valor informado é inválido. Tente novamente\n\n" + ex.getMessage());
        } catch (RuntimeException ex) {
            String status = "**Saque não realizado**\n" + ex.getMessage();
            this.view.getGeneralStatusField().setText(status);
        }
    }

    private void pay() throws SQLException {
        Account account = this.accountDAO.find(view.getCpfCombo2().getSelectedItem().toString());
        BigDecimal oldBalance = BigDecimal.valueOf(account.getBalance());
        oldBalance = oldBalance.setScale(2, RoundingMode.FLOOR);
        account.pay();
        BigDecimal newBalance = BigDecimal.valueOf(account.getBalance());
        newBalance = newBalance.setScale(2, RoundingMode.FLOOR);
        accountDAO.updateBalance(account.getNumber(), newBalance.doubleValue());
        view.getBalanceField().setText(newBalance.toString());
        newBalance = newBalance.subtract(oldBalance);
        newBalance = newBalance.setScale(2, RoundingMode.FLOOR);
        String status = "**Remuneração aplicada com sucesso**\nSaldo anterior: R$" + oldBalance.toString() + "\nRemuneração: R$" + newBalance.toString();
        this.view.getGeneralStatusField().setText(status);
    }

    private void setAssignmentFields() throws SQLException {
        Customer customer = this.customerDAO.get(this.view.getCpfCombo().getSelectedItem().toString());
        this.view.getFirstNameToAssignField().setText(customer.getFirstName());
        this.view.getLastNameToassignField().setText(customer.getLastName());
        Account account = accountDAO.find(customer.getCPF());
        if (account != null) {
            this.view.getAccNameToAssignField().setText(Integer.toString(account.getNumber()));
            this.view.getAccTypeToAssignField().setText(account.getType());
            this.view.getAssignBtn().setEnabled(false);
            this.view.getAccountCombo().setEnabled(false);
            this.view.getMinBalanceField().setEditable(false);
            this.view.getInitialDepositField().setEditable(false);
            this.view.getMinDepositField().setEditable(false);
            this.view.getMaxLimitField().setEditable(false);
            this.view.getMinBalanceField().setText("");
            this.view.getInitialDepositField().setText("");
            this.view.getMinDepositField().setText("");
            this.view.getMaxLimitField().setText("");
            String notification = "";
            if (account.getType().toLowerCase().equals("conta corrente")) {
                CheckingAccount cAccount = (CheckingAccount) this.accountDAO.find(customer.getCPF());
                view.getCheckingAccountsPanel().setVisible(true);
                this.view.getInvestmentAccountsPanel().setVisible(false);
                this.view.getInitialDepositField().setText(Double.toString(cAccount.getInitialDeposit()));
                this.view.getMaxLimitField().setText(Double.toString(cAccount.getMaxLimit()));
                notification += "+--- Contato com conta corrente vinculada ---+\n";
                notification += "Conta Corrente número: " + cAccount.getNumber() + "\n";
                notification += "Saldo: R$" + cAccount.getBalance();
                notification += "\nLimite: R$" + cAccount.getMaxLimit();
            } else {
                InvestmentAccount iAccount = (InvestmentAccount) this.accountDAO.find(customer.getCPF());
                this.view.getCheckingAccountsPanel().setVisible(false);
                this.view.getInvestmentAccountsPanel().setVisible(true);
                this.view.getInitialDepositField().setText(Double.toString(iAccount.getInitialDeposit()));
                this.view.getMinBalanceField().setText(Double.toString(iAccount.getMinBalance()));
                this.view.getMinDepositField().setText(Double.toString(iAccount.getMinDeposit()));
                notification += "+--- Contato com conta investimento vinculada ---+\n";
                notification += "Conta Investimento número: " + iAccount.getNumber() + "\n";
                notification += "Saldo: R$" + iAccount.getBalance();
                notification += "\nMontante mínimo: R$" + iAccount.getMinBalance();
                notification += "\nDepósito mínimo: R$" + iAccount.getMinDeposit();
            }
            this.view.getAssignmentStatusField().setText(notification);
        } else {
            resetAssignment();
            this.view.getAccNameToAssignField().setText("Sem conta vinculada");
            this.view.getAccTypeToAssignField().setText("Sem conta vinculada");
            this.view.getAssignmentStatusField().setText("Cliente ainda não possui uma conta vinculada");
        }
    }

    private boolean validade(Customer customer) {
        return !(
            (customer.getCPF().equals(null) || customer.getCPF().equals("")) ||
            (customer.getRG().equals(null) || customer.getRG().equals("")) ||
            (customer.getFirstName().equals(null) || customer.getFirstName().equals("")) ||
            (customer.getLastName().equals(null) || customer.getLastName().equals("")) ||
            (customer.getAddress().equals(null) || customer.getAddress().equals(""))
        );
    }

    private void cleanForm() {
        this.view.getUpdateBtn().setEnabled(false);
        this.view.getInsertBtn().setEnabled(true);
        this.view.getCpfField().setEditable(true);
        this.view.getFirstNameField().setText("");
        this.view.getLastNameField().setText("");
        this.view.getAddressField().setText("");
        this.view.getRgField().setText("");
        this.view.getCpfField().setText("");
        this.view.getDeleteBtn().setEnabled(false);
    }

    private void disassign(String cpf) throws SQLException {
        Account account = this.accountDAO.find(cpf);
        if (account != null) {
            int input = JOptionPane.showConfirmDialog(null, "Deseja desvincular conta do cliente: " + cpf + "?");
            if (input == 0) {
                this.accountDAO.delete(cpf);
                this.view.getAssignmentStatusField().setText("Conta do cliente: " + cpf + " desvinculada com sucesso!");
                resetAssignment();
            }
        }
    }

    private void resetAssignment() {
        this.view.getAssignBtn().setEnabled(true);
        this.view.getAccountCombo().setEnabled(true);
        this.view.getMinBalanceField().setEditable(true);
        this.view.getMinBalanceField().setText("");
        this.view.getInitialDepositField().setEditable(true);
        this.view.getInitialDepositField().setText("");
        this.view.getMinDepositField().setEditable(true);
        this.view.getMinDepositField().setText("");
        this.view.getMaxLimitField().setEditable(true);
        this.view.getMaxLimitField().setText("");
        this.view.getDisassignBtn().setEnabled(false);
    }
}
