package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;

public class Customers {

    private Customer[] customers;

    // a) Complete constructor    alissa
    public Customers(int size) {

        if (size < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        }
        this.customers = new Customer[size];
    }

    // b) count number of non-null references   elisa
    public int countNonNull() {
        int count = 0;
        for (Customer c : customers) {
            if (c != null) {
                count++;
            }
        }
        return count;

    }

    // c) return reference to customer with given id (if exists) samsam
    public Customer getCustomer(int customer_id) {

        boolean funnet = false;
        Customer c = null;

        for (int i = 0; i < customers.length; i++) {
            Customer kunde = customers[i];
            if (kunde != null && kunde.getCustomer_id() == customer_id) {
                c = kunde;
                funnet = true;
                break;
            }
        }

        return c;
    }

    // d) add a customer to the reference table alissa
    public boolean addCustomer(Customer c) {
        boolean inserted = false;

        // TODO

        return inserted;

    }

    // e) remove customer with given id from reference table elisa
    public Customer removeCustomer(int customer_id) {

        boolean deleted = false;
        Customer c = null;

        for (int i = 0; i < customers.length; i++) {
            Customer curr = customers[i];
            if (curr != null && curr.getCustomer_id() == customer_id) {
                c = curr;
                customers[i] = null;
                deleted = true;
                break;
            }
        }
        return c;
    }


    // f) return reference table with all customers samsam
    public Customer[] getCustomers() {

        Customer[] customers = null;

        int count = 0;

        for(int i = 0; i < this.customers.length; i++) {
            if(this.customers[i] != null) {
                count++;
            }
        }

        customers = new Customer[count] ;

        int j = 0;
        for(int i = 0; i < this.customers.length; i++ ) {
            if(this.customers[i] != null) {
                customers[j] = this.customers[i];
                j++;
            }
        }
        return customers;
    }
}
