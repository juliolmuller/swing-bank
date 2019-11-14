package br.ufpr.lpoo2;

import javax.swing.JOptionPane;
import br.ufpr.lpoo2.controller.CustomerController;
import br.ufpr.lpoo2.model.CustomerTable;
import br.ufpr.lpoo2.model.dao.CustomerDAO;
import br.ufpr.lpoo2.services.ConnectionFactory;
import br.ufpr.lpoo2.view.CustomerView;

public class Main {

    public static void main(String[] args) {
        try {
            CustomerDAO dao = new CustomerDAO(new ConnectionFactory());
            CustomerTable model = new CustomerTable();
            CustomerView view = new CustomerView();
            CustomerController controller = new CustomerController(model, view, dao);
            controller.initController();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao iniciar a aplicação. \n" + ex.getLocalizedMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }
}
