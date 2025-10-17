package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;

public class Customers {

    private Customer[] customers;

    // a) Complete constructor    alissa
    public Customers(int size) {

       if(size<0){
           throw new IllegalArgumentException("size must be non-negative");
       }
       this.customers = new Customer[size];
    }

    // b) count number of non-null references   elisa
    public int countNonNull() {


        int count = 0;

        // TODO

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

        if(c==null) return false;

        if(getCustomer(c.getId())!=null){
            return false;
        }

        for(int i=0;i<customers.length;i++){
            if(customers[i]==null){
                customers[i]=c;
                return true;
            }
        }

        return inserted;
    }

    // e) remove customer with given id from reference table elisa
    public Customer removeCustomer(int customer_id) {

        boolean deleted = false;
        Customer c = null;

        // TODO

        return c;
    }

    // f) return reference table with all customers samsam
    public Customer[] getCustomers() {

        Customer[] customers = null;

        // TODO

        return customers;
    }
}