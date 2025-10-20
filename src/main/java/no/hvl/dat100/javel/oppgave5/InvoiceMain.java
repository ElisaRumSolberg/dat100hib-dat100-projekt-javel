package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;
import no.hvl.dat100.javel.oppgave2.MonthPowerData;

public class InvoiceMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 5");
        System.out.println("==============");
        System.out.println();



        // c)
         int customer_Id =c1.getCustomer_id();
         String name = c1.getName();
         String email = c1.getEmail();
         PowerAgreementType agreement = c1.getAgreement();
         String month = "January";
         Double usage = 600.25;
         Double amount = 1100.50;

        Invoice invoice = new Invoice(Customer c1, name, email, agreement, month, usage, amount);

        invoice.printInvoice();


    }
}
