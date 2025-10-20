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


        // 1) Customers (match the example in the assignment)
        Customer c1 = new Customer("Charlie Rose", "charlie@example.com", 1003, PowerAgreementType.POWERSUPPORT);
        Customer c2 = new Customer("Diana Prince",  "diana@example.com",  1004, PowerAgreementType.NORGESPRICE);
        Customer c3 = new Customer("Ethan Hunt",    "ethan@example.com",  1005, PowerAgreementType.SPOTPRICE);

        // 2) Usage matrices (kWh) from your provided data
        double[][] usage1 = CustomerPowerUsageData.usage_month_customer1;
        double[][] usage2 = CustomerPowerUsageData.usage_month_customer2;
        double[][] usage3 = CustomerPowerUsageData.usage_month_customer3;

        // 3) Prices matrix (NOK/kWh) from oppgave2

        double[][] prices = MonthPowerData.powerprices_month;

        // 4) Build invoices for "January"
        Invoice inv1 = new Invoice(c1, "January", usage1, prices);
        Invoice inv2 = new Invoice(c2, "January", usage2, prices);
        Invoice inv3 = new Invoice(c3, "January", usage3, prices);


        // 5) Process & print all
        Invoice[] all = { inv1, inv2, inv3 };
        Invoices.processInvoices(all);


    }
}
