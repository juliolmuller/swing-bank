package br.ufpr.lpoo2.view;

import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import br.ufpr.lpoo2.model.Customer;

public class CustomerView extends JFrame {

    private JLabel firstNameLabel;
    private JTextField firstNameField;
    private JLabel lastNameLabel;
    private JTextField lastNameField;
    private JLabel birthdateLabel;
    private JFormattedTextField dateBirthField;
    private JLabel addressLabel;
    private JTextField addressField;
    private JButton cleanButton;
    private JPanel contactFormPanel;
    private JButton deleteButton;
    private JButton listButton;
    private JButton newButton;
    private JScrollPane scrollPanel;
    private JButton updateButton;
    private JTable viewTable;

    public CustomerView() {
        initComponents();
    }

    public JButton getUpdateButton() {
        return this.updateButton;
    }

    public JFormattedTextField getBirthdateField() {
        return this.dateBirthField;
    }

    public JTextField getEmailField() {
        return this.lastNameField;
    }

    public JTextField getAdressField() {
        return this.addressField;
    }

    public JButton getDeleteButton() {
        return this.deleteButton;
    }

    public JButton getCleanButton() {
        return this.cleanButton;
    }

    public JButton getListButton() {
        return this.listButton;
    }

    public JTextField getNameField() {
        return this.firstNameField;
    }

    public JButton getNewButton() {
        return this.newButton;
    }

    public JTable getViewTable() {
        return this.viewTable;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        this.scrollPanel = new JScrollPane();
        this.viewTable = new JTable();
        this.listButton = new JButton();
        this.cleanButton = new JButton();
        this.deleteButton = new JButton();
        this.contactFormPanel = new JPanel();
        this.newButton = new JButton();
        this.updateButton = new JButton();
        this.firstNameLabel = new JLabel();
        this.birthdateLabel = new JLabel();
        this.lastNameLabel = new JLabel();
        this.firstNameField = new JTextField();
        this.dateBirthField = new JFormattedTextField();
        this.lastNameField = new JTextField();
        this.addressLabel = new JLabel();
        this.addressField = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        this.scrollPanel.setViewportView(viewTable);
        this.listButton.setText("Listar");
        this.cleanButton.setText("Limpar");
        this.deleteButton.setText("Excluir");
        this.newButton.setText("Novo");
        this.updateButton.setText("Atualizar");
        this.firstNameLabel.setText("Nome:");
        this.birthdateLabel.setText("Data Nascimento:");
        this.lastNameLabel.setText("E-mail:");
        this.addressLabel.setText("Endereço:");
        try {
            this.dateBirthField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        GroupLayout contactFormPanelLayout = new GroupLayout(contactFormPanel);
        contactFormPanel.setLayout(contactFormPanelLayout);
        contactFormPanelLayout.setHorizontalGroup(
            contactFormPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(contactFormPanelLayout.createSequentialGroup()
                .addGroup(contactFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(contactFormPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(addressLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addressField))
                    .addGroup(contactFormPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(contactFormPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(contactFormPanelLayout.createSequentialGroup()
                                .addComponent(lastNameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastNameField))
                            .addGroup(contactFormPanelLayout.createSequentialGroup()
                                .addComponent(birthdateLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateBirthField))
                            .addGroup(contactFormPanelLayout.createSequentialGroup()
                                .addComponent(firstNameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(firstNameField, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(contactFormPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(newButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateButton)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contactFormPanelLayout.setVerticalGroup(
            contactFormPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, contactFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contactFormPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contactFormPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(birthdateLabel)
                    .addComponent(dateBirthField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contactFormPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contactFormPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel)
                    .addComponent(addressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(contactFormPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(newButton)
                    .addComponent(updateButton))
                .addContainerGap())
        );
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(contactFormPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPanel, GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(listButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cleanButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPanel, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(listButton)
                    .addComponent(cleanButton)
                    .addComponent(deleteButton))
                .addGap(11, 11, 11)
                .addComponent(contactFormPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public Customer getCustomer() {
        return new Customer(
            null,
            this.firstNameField.getText(),
            this.lastNameField.getText(),
            LocalDate.parse(dateBirthField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            this.addressField.getText(),
            null,
            null
        );
    }

    public void setContact(Customer customer) {
        this.firstNameField.setText(customer.getFirstName());
        this.lastNameField.setText(customer.getLastName());
        this.dateBirthField.setText(customer.getDateBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        this.addressField.setText(customer.getAddress());
    }

    public int getSelectedLine(MouseEvent event) {
        return getViewTable().rowAtPoint(event.getPoint());
    }
}
