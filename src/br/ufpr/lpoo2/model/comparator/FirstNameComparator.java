package br.ufpr.lpoo2.model.comparator;

import java.util.Comparator;
import br.ufpr.lpoo2.model.Customer;

public class FirstNameComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer customer1, Customer customer2) {
        return customer1.getFirstName().toUpperCase().compareTo(customer2.getFirstName().toUpperCase());
    }
}
