package br.ufpr.lpoo2.model;

import java.util.List;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class CpfComboBoxModel extends DefaultComboBoxModel<String> {

    public CpfComboBoxModel(List<Customer> clientes) {
        clientes.forEach(c -> this.addElement(c.getCPF()));
    }

    public void atualizar(List<Customer> clientes) {
        this.removeAllElements();
        clientes.forEach(c -> this.addElement(c.getCPF()));
    }

    public void addCpf(String cpf) {
        this.addElement(cpf);
    }

    public void removeCpf(String cpf) {
        this.removeElement(cpf);
    }
}
