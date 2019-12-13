package br.ufpr.lpoo2.model.comparator;

import java.util.Comparator;
import br.ufpr.lpoo2.model.Customer;

public class LastNameComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer customer1, Customer customer2) {
        return customer1.getLastName().toUpperCase().compareTo(customer2.getLastName().toUpperCase());
    }
}
