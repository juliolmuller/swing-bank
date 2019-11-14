package br.ufpr.lpoo2.controller;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import br.ufpr.lpoo2.model.Customer;
import br.ufpr.lpoo2.model.CustomerTable;
import br.ufpr.lpoo2.model.dao.CustomerDAO;
import br.ufpr.lpoo2.view.CustomerView;

public class CustomerController {

    private final CustomerTable model;
    private final CustomerView view;
    private int selectedRow = -1;
    private final CustomerDAO dao;

    public CustomerController(CustomerTable model, CustomerView view, CustomerDAO dao) {
        this.model = model;
        this.view = view;
        this.dao = dao;
    }

    public void initController() {
        this.view.getViewTable().setModel(this.model);
        this.view.getListButton().addActionListener(event -> listAll());
        this.view.getViewTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                selectCustomer(event);
            }
        });
        this.view.getCleanButton().addActionListener(event -> cleanTable());
        this.view.getDeleteButton().addActionListener(event -> deleteCustomers());
        this.view.getNewButton().addActionListener(event -> createCustomer());
        this.view.getUpdateButton().addActionListener(event -> updateCustomer());
        initView();
    }

    public void initView() {
        EventQueue.invokeLater(() -> this.view.setVisible(true));
    }

    private void listAll() {
        try {
            List<Customer> customers = this.dao.selectAll();
            this.model.setContacts(customers);
        } catch (Exception ex) {
            this.view.showError("Erro ao listar clientes.\n" + ex);
        }
    }

    private void selectCustomer(MouseEvent event) {
        this.selectedRow = view.getSelectedLine(event);
        Customer customer = this.model.getContact(this.selectedRow);
        this.view.setContact(customer);
    }

    private void cleanTable() {
        this.model.cleanTable();
    }

    private void deleteCustomers() {
        try {
            int[] selectedRows = view.getViewTable().getSelectedRows();
            List<Customer> deletionList = new ArrayList<>();
            for (int i = 0; i < selectedRows.length; i++) {
                Customer customer = this.model.getContact(selectedRows[i]);
                this.dao.delete(customer);
                deletionList.add(customer);

            }
            deletionList.forEach(contact -> this.model.removeContact(contact));

        } catch (Exception ex) {
            this.view.showError("Erro ao excluir cliente.\n" + ex);
        }
    }

    private void createCustomer() {
        try {
            Customer customer = view.getCustomer();
            this.dao.insert(customer);
            this.model.createCustomer(customer);
        } catch (Exception ex) {
            this.view.showError("Erro ao salvar novo cliente.\n" + ex);
        }
    }

    private void updateCustomer() {
        try {
            if (this.selectedRow != -1) {
                Customer customer = this.model.getContact(this.selectedRow);
                dao.update(customer);
                Customer viewCustomer = this.view.getCustomer();
                customer.clone(viewCustomer);
                this.model.fireTableRowsUpdated(this.selectedRow, this.selectedRow);
            }
        } catch (Exception ex) {
            this.view.showError("Erro ao atualizar cliente.\n" + ex);
        }
    }
}
