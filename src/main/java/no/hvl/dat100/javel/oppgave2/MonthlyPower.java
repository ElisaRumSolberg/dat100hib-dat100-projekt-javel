package no.hvl.dat100.javel.oppgave2;

import no.hvl.dat100.javel.oppgave1.DailyPower;

public class MonthlyPower {

    // a) print power usage for a month    samsam
    public static void print_PowerUsage(double[][] usage) {

          // i = dag, går gjennom alle dagene i tabellen
        for (int i = 0; i < usage.length; i++) {
            System.out.print("Day" + (i+1) + ":");
        for (int j = 0; j < usage[i].length; j++) {    // j = timene
            System.out.printf(" %.2f kWh", usage[i][j]);
        }

        }

    }
    }

    // b) print power prices for a month    alissa
    public static void print_PowerPrices(double[][] prices) {

        // TODO

    }

    // c) compute total power usage for a month  elisa
    public static double computePowerUsage(double[][] usage) {

        double sum = 0;

        // TODO

        return sum;
    }

    // d) determine whether a given threshold in powerusage for the month has been exceeded  samsam
    public static boolean exceedThreshold(double[][] powerusage, double threshold) {

        boolean exceeded = false;
        double usage = 0;

        // TODO

        return exceeded;
    }

    // e) compute spot price alissa
    public static double computeSpotPrice(double[][] usage, double[][] prices) {

        double price = 0;

        // TODO

        return price;
    }

    // f) power support for the month  elisa
    public static double computePowerSupport(double[][] usage, double[][] prices) {

        double support = 0;

        // TODO

        return support;
    }

    // g) Norgesprice for the month  samsam
    public static double computeNorgesPrice(double[][] usage) {

        double price = 0;

        // TODO

        return price;
    }
}
