package br.ufpr.lpoo2.controller;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import br.ufpr.lpoo2.model.Contact;
import br.ufpr.lpoo2.model.ContactTableModel;
import br.ufpr.lpoo2.model.dao.ContactDAO;
import br.ufpr.lpoo2.view.ContactView;

public class ContactController {

    private final ContactTableModel model;
    private final ContactView view;
    private int selectedRow = -1;
    private final ContactDAO dao;

    public ContactController(ContactTableModel model, ContactView view, ContactDAO dao) {
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
                checkSelectedContact(event);
            }
        });
        this.view.getCleanButton().addActionListener(event -> cleanViewTable());
        this.view.getDeleteButton().addActionListener(event -> deleteContacts());
        this.view.getNewButton().addActionListener(event -> createContact());
        this.view.getUpdateButton().addActionListener(event -> updateContact());
        initView();
    }

    public void initView() {
        EventQueue.invokeLater(() -> this.view.setVisible(true));
    }

    private void listAll() {
        try {
            List<Contact> contacts = this.dao.getList();
            this.model.setContacts(contacts);
        } catch (Exception ex) {
            this.view.showError("Erro ao listar contato. Ex.:" + ex);
        }
    }

    private void checkSelectedContact(MouseEvent event) {
        this.selectedRow = view.getSelectedLine(event);
        Contact contact = this.model.getContact(this.selectedRow);
        this.view.setContact(contact);
    }

    private void cleanViewTable() {
        this.model.cleanTable();
    }

    private void deleteContacts() {
        try {
            int[] selectedRows = view.getViewTable().getSelectedRows();
            List<Contact> deletionList = new ArrayList<>();
            for (int i = 0; i < selectedRows.length; i++) {
                Contact contact = this.model.getContact(selectedRows[i]);
                this.dao.delete(contact);
                deletionList.add(contact);

            }
            deletionList.forEach(contact -> this.model.removeContact(contact));

        } catch (Exception ex) {
            this.view.showError("Erro ao excluir contato. " + ex);
        }
    }

    private void createContact() {
        try {
            Contact contact = view.getContact();
            this.dao.insert(contact);
            this.model.createContact(contact);
        } catch (Exception ex) {
            this.view.showError("Erro ao incluir contato. " + ex);
        }
    }

    private void updateContact() {
        try {
            if (this.selectedRow != -1) {
                Contact contact = this.model.getContact(this.selectedRow);
                dao.update(contact);
                Contact viewContact = this.view.getContact();
                contact.clone(viewContact);
                this.model.fireTableRowsUpdated(this.selectedRow, this.selectedRow);
            }
        } catch (Exception ex) {
            this.view.showError("Erro ao atualizar contato. " + ex);
        }
    }
}
