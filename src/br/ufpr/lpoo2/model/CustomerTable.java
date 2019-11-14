package br.ufpr.lpoo2.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CustomerTable extends AbstractTableModel {

    private String[] columns = new String[] { "ID", "Nome", "Sobrenome", "Nascimento", "Endereço" };
    private List<Customer> customers = new ArrayList<>();

    public CustomerTable() {}

    public CustomerTable(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public int getRowCount() {
        return this.customers.size();
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
        Customer customer = this.customers.get(rowIndex);
        switch (colIndex) {
            case 0:
                return customer.getId();
            case 1:
                return customer.getFirstName();
            case 2:
                return customer.getLastName();
            case 3:
                return customer.getDateBirth();
            case 4:
                return customer.getAddress();
        }
        return null;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int colIndex) {
        Customer customer = this.customers.get(rowIndex);
        switch (colIndex) {
            case 0:
                customer.setId((Long) value);
                break;
            case 1:
                customer.setFirstName((String) value);
                break;
            case 2:
                customer.setLastName((String) value);
                break;
            case 3:
                customer.setDateBirth(LocalDate.parse((String) value));
                break;
            case 4:
                customer.setAddress((String) value);
                break;
        }
        fireTableCellUpdated(rowIndex, colIndex);
    }

    public boolean removeContact(Customer customer) {
        int rowIndex = this.customers.indexOf(customer);
        boolean result = this.customers.remove(customer);
        fireTableRowsDeleted(rowIndex, rowIndex);
        return result;
    }

    public void createCustomer(Customer customer) {
        this.customers.add(customer);
        fireTableRowsInserted(this.customers.size() - 1, this.customers.size() - 1);
    }

    public void setContacts(List<Customer> customers) {
        this.customers = customers;
        fireTableDataChanged();
    }

    public void cleanTable() {
        int customersCount = customers.size() - 1;
        if (customersCount < 0)
            customersCount = 0;
        this.customers = new ArrayList<>();
        fireTableRowsDeleted(0, customersCount);
    }

    public Customer getContact(int rowIndex) {
        return this.customers.get(rowIndex);
    }
}
