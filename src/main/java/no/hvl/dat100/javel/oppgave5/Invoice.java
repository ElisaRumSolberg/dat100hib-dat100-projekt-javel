package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

public class Invoice {

    private Customer c; // customer associated with this invoice
    private String month; // month that the invoice covers
    private double[][] usage; // power usage this month (per day and per hour)
    private double[][] prices; // power prices for this month

    private double amount; // power price for this month

    // --- Adjust these per your course rules if needed ---
    private static final double SUPPORT_THRESHOLD_NOK_PER_KWH = 0.70; // example threshold
    private static final double SUPPORT_RATE = 0.90;                   // state covers 90% above threshold



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

    public void computeAmount() {
        if (c == null || c.getAgreement() == null) {
            throw new IllegalArgumentException("Customer/agreement cannot be null");
        }

        PowerAgreementType agreement = c.getAgreement();
        switch (agreement) {
            case SPOTPRICE:
                this.amount = spotCostNOK();
                break;
            case POWERSUPPORT:
                this.amount = powerSupportCost();
                break;
            case NORGESPRICE:
                this.amount = norgesPriceCost();
                break;
            default:
                throw new IllegalArgumentException("Unknown agreement: " + agreement);
        }
    }

    public void printInvoice() { //samsam
        System.out.println("Customer Number" +  c.getCustomer_id());
        System.out.println("Name" +  c.getName());
        System.out.println("Email" +  c.getEmail());
        System.out.println("Agreement" +  c.getAgreement());
        System.out.println();
        System.out.println("Month: " +  month);
        System.out.printf("Usage:  %.2f kWh\n", usage);
        System.out.printf("Amount:  %.2f\n", amount);


    }

    // ---- helpers ----

    // Sum of kWh * hourly price (spot)
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

    // POWERSUPPORT example rule: pay full up to threshold, above-threshold part discounted by SUPPORT_RATE
    private double powerSupportCost() {
        double sum = 0.0;
        for (int d = 0; d < usage.length; d++) {
            double[] uday = usage[d];
            double[] pday = prices[d];
            if (uday == null || pday == null) continue;

            int len = Math.min(uday.length, pday.length);
            for (int h = 0; h < len; h++) {
                double kwh = uday[h];
                double price = pday[h];

                if (price <= SUPPORT_THRESHOLD_NOK_PER_KWH) {
                    sum += kwh * price;
                } else {
                    double base = SUPPORT_THRESHOLD_NOK_PER_KWH;
                    double over = price - base;
                    double userPaysOver = over * (1.0 - SUPPORT_RATE);
                    sum += kwh * (base + userPaysOver);
                }
            }
        }
        return sum;
    }

    // NORGESPRICE example: simple monthly average price * total kWh
    private double norgesPriceCost() {
        double avg = simpleMonthlyAveragePrice();
        return totalUsageKWh() * avg;
    }

    // unweighted average of hourly prices
    private double simpleMonthlyAveragePrice() {
        double sum = 0.0;
        int count = 0;
        for (double[] day : prices) {
            if (day == null) continue;
            for (double p : day) { sum += p; count++; }
        }
        return count == 0 ? 0.0 : sum / count;
    }
}
