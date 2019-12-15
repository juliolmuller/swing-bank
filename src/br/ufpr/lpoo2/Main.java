package br.ufpr.lpoo2;

import javax.swing.JOptionPane;
import br.ufpr.lpoo2.model.CustomerTableModel;
import br.ufpr.lpoo2.controller.BankController;
import br.ufpr.lpoo2.model.CpfComboBoxModel;
import br.ufpr.lpoo2.model.dao.CustomerDAO;
import br.ufpr.lpoo2.model.dao.AccountDAO;
import br.ufpr.lpoo2.services.ConnectionFactory;
import br.ufpr.lpoo2.view.BankView;

public class Main {

    public static void main(String[] args) {
        try {
            CustomerDAO clienteDao = new CustomerDAO(new ConnectionFactory());
            AccountDAO contaDao = new AccountDAO(new ConnectionFactory());
            CustomerTableModel model = new CustomerTableModel();
            BankView view = new BankView();
            CpfComboBoxModel cpfModel = new CpfComboBoxModel(clienteDao.list());
            BankController controller = new BankController(model, view, clienteDao, contaDao, cpfModel);
            controller.initController();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao iniciar a aplicação. \n" + ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }
}
