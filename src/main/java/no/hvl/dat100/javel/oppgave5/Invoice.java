package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave2.MonthlyPower;

import java.util.Arrays;

public class Invoice {

    private Customer c; // customer associated with this invoice
    private String month; // month that the invoice covers
    private double[][] usage; // power usage this month (per day and per hour)
    private double[][] prices; // power prices for this month

    private double amount; // power price for this month
    private int customerNumber ;
    private String name;
    private String email;
    private String agreement;


    public Invoice(Customer c, String month, double[][] usage, double[][] power_prices) { // elisa

        if (c == null) throw new IllegalArgumentException("Customer cannot be null");
        if (month == null) throw new IllegalArgumentException("Month cannot be null");
        if (usage == null || power_prices == null) throw new IllegalArgumentException("usage/prices cannot be null");
        if (usage.length != power_prices.length) {
            throw new IllegalArgumentException("Usage and prices must have same number of days");
        }

        this.c = c;
        this.month = month;
        this.usage = usage;
        this.prices = power_prices;
        this.amount = 0.0; // explicitly start at 0
        this.customerNumber = customerNumber;
        this.name = name;
        this.email = email;
        this.agreement = agreement;

    }

    // --- helpers ---
    private double totalUsageKWh() {
        double sum = 0.0;
        for (int d = 0; d < usage.length; d++) {
            double[] day = usage[d];
            if (day == null) continue;
            for (int h = 0; h < day.length; h++) {
                sum += day[h];
            }
        }
        return sum;
    }

    private double spotCostNOK() {
        double sum = 0.0;
        for (int d = 0; d < usage.length; d++) {
            double[] uday = usage[d];
            double[] pday = prices[d];
            if (uday == null || pday == null) continue;

            int len = Math.min(uday.length, pday.length);
            for (int h = 0; h < len; h++) {
                sum += uday[h] * pday[h];
            }
        }
        return sum;
    }

    // simple (unweighted by kWh) monthly average of price
    private double simpleMonthlyAveragePrice() {
        double sum = 0.0;
        int count = 0;
        for (double[] day : prices) {
            if (day == null) continue;
            for (double p : day) {
                sum += p;
                count++;
            }
        }
        return count == 0 ? 0.0 : sum / count;

    }

    public void computeAmount() { // Alissa

        // TODO

    }

    public void printInvoice() { //samsam
        System.out.println("Customer number" +  customerNumber);
        System.out.println("Name" +  name);
        System.out.println("Email" +  email);
        System.out.println("Agreement" +  agreement);
        System.out.println();
        System.out.println("Month: " +  month);
        System.out.printf("Usage:  %.2f kWh\n", usage);
        System.out.printf("Amount:  %.2f\n", amount);


    }
}
