package no.hvl.dat100.javel.oppgave5;

public class Invoices {

    public static void processInvoices(Invoice[] invoices) { // alissa

        if(invoices ==null) {
            throw new IllegalArgumentException("invoices array can't be null");
        }

        int processed = 0;

        for (int i = 0; i< invoices.length; i++) {
            Invoice inv = invoices[i];
            if(inv == null) {
                continue;
            }
            inv.computeAmount();

            inv.printInvoice();

            processed++;
        }

        System.out.println("==Invoices processed: " + processed + "/" + invoices.length + "==");

    }
}
