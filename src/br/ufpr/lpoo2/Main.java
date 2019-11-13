package br.ufpr.lpoo2;

import javax.swing.JOptionPane;
import br.ufpr.lpoo2.controller.ContactController;
import br.ufpr.lpoo2.model.ContactTableModel;
import br.ufpr.lpoo2.model.dao.ContactDAO;
import br.ufpr.lpoo2.services.ConnectionFactory;
import br.ufpr.lpoo2.view.ContactView;

public class Main {
    public static void main(String[] args){
        try{
            ContactDAO dao = new ContactDAO(new ConnectionFactory());
            ContactTableModel model = new ContactTableModel();
            ContactView view = new ContactView();
            ContactController controller = new ContactController(model,view,dao);
            controller.initController();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao iniciar a aplicação. \n"+ex.getLocalizedMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }

}
