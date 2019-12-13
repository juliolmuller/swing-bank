package br.ufpr.lpoo2.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class CustomerTableModel extends AbstractTableModel {

    private String[] columns = { "ID", "Nome", "Sobrenome", "RG", "CPF", "Endereço" };
    private List<Customer> customers = new ArrayList<>();

    public CustomerTableModel() {}

    public CustomerTableModel(List<Customer> customers) {
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
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer customer = this.customers.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return customer.getId();
            case 1:
                return customer.getFirstName();
            case 2:
                return customer.getLastName();
            case 3:
                return customer.getRG();
            case 4:
                return customer.getCPF();
            case 5:
                return customer.getAddress();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int colIndex) {
        Customer cliente = customers.get(rowIndex);
        switch (colIndex) {
            case 0:
                cliente.setId((Integer) value);
                break;
            case 1:
                cliente.setFirstName((String) value);
                break;
            case 2:
                cliente.setLastName((String) value);
                break;
            case 3:
                cliente.setRG((String) value);
                break;
            case 4:
                cliente.setCPF((String) value);
                break;
            case 5:
                cliente.setAddress((String) value);
                break;
        }
        fireTableCellUpdated(rowIndex, colIndex);
    }

    public boolean removeCustomer(Customer customer) {
        int row = this.customers.indexOf(customer);
        boolean result = this.customers.remove(customer);
        this.fireTableRowsDeleted(row, row);
        return result;
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
        fireTableRowsInserted(customers.size() - 1, customers.size() - 1);
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
        fireTableDataChanged();
        fireTableRowsInserted(0, customers.size() - 1);
    }

    public void clean() {
        int lastRow = customers.size() - 1;
        if (lastRow < 0)
            lastRow = 0;
        this.customers = new ArrayList<>();
        fireTableRowsDeleted(0, lastRow);
    }

    public Customer getCustomer(int rowIndex) {
        return customers.get(rowIndex);
    }
}
