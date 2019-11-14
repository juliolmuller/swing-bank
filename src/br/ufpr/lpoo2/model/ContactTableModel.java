package br.ufpr.lpoo2.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ContactTableModel extends AbstractTableModel {

    private String[] columns = new String[] { "ID", "Nome", "email", "Nascimento", "Endereco" };
    private List<Contact> contacts = new ArrayList<>();

    public ContactTableModel() {}

    public ContactTableModel(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public int getRowCount() {
        return this.contacts.size();
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.columns[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        Contact contact = contacts.get(rowIndex);
        switch (colIndex) {
            case 0:
                return contact.getId();
            case 1:
                return contact.getName();
            case 2:
                return contact.getEmail();
            case 3:
                return contact.getDateBirth();
            case 4:
                return contact.getAddress();
        }
        return null;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int colIndex) {
        Contact contact = contacts.get(rowIndex);
        switch (colIndex) {
            case 0:
                contact.setId((Long) value);
                break;
            case 1:
                contact.setNome((String) value);
                break;
            case 2:
                contact.setEmail((String) value);
                break;
            case 3:
                LocalDate dateBirth = LocalDate.parse((String) value);
                contact.setDateBirth(dateBirth);
                break;
            case 4:
                contact.setAddress((String) value);
                break;
        }
        fireTableCellUpdated(rowIndex, colIndex);
    }

    public boolean removeContact(Contact contact) {
        int rowIndex = this.contacts.indexOf(contact);
        boolean result = this.contacts.remove(contact);
        fireTableRowsDeleted(rowIndex, rowIndex);
        return result;
    }

    public void createContact(Contact contact) {
        this.contacts.add(contact);
        fireTableRowsInserted(this.contacts.size() - 1, this.contacts.size() - 1);
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
        fireTableDataChanged();
    }

    public void cleanTable() {
        int contactsCount = contacts.size() - 1;
        if (contactsCount < 0)
            contactsCount = 0;
        this.contacts = new ArrayList<>();
        fireTableRowsDeleted(0, contactsCount);
    }

    public Contact getContact(int rowIndex) {
        return this.contacts.get(rowIndex);
    }
}
