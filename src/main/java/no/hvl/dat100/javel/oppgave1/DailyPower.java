package no.hvl.dat100.javel.oppgave1;

public class DailyPower {
    //Samsam
    // a) print power prices during a day
    public static void printPowerPrices(double[] prices) {
        for (int i = 0; i < prices.length; i++) {
            System.out.printf("Hour %02d: %.3f NOK/kWh%n", i, prices[i]);
        }

    }
    //Samsam

    // b) print power usage during a day
    public static void printPowerUsage(double[] usage) {
        for (int i = 0; i < usage.length; i++) {
            System.out.printf("Hour %02d: %.3f kWh%n", i, usage[i]);
        }
    }

    // Alissa
    // c) compute power usage for a single day
    public static double computePowerUsage(double[] usage) {
        if (usage == null) {
            throw new IllegalArgumentException("usage array is null");
        }
        double sum = 0;
        for (double u : usage) {
            sum += u;
        }

        return sum;
    }

    // Alissa
    // d) compute spot price for a single day
    public static double computeSpotPrice(double[] usage, double[] prices) {
        if (usage == null || prices == null) {
            throw new IllegalArgumentException("usage/price array is null");
        }
        if (usage.length != prices.length) {
            throw new IllegalArgumentException("usage and prices must have same length");
        }

        double price = 0;
        for (int i = 0; i < usage.length; i++) {
            price += usage[i] * prices[i];
        }

        return price;
    }

    //Elisa
    // e) compute power support for a given usage and price
    private static final double THRESHOLD = 0.9375;
    private static final double PERCENTAGE = 0.9;

    private static double getSupport(double usage, double price) {
        if (price > THRESHOLD && usage > 0) {
            double excess = price - THRESHOLD;
            return excess * PERCENTAGE * usage;
        }
        return 0.0;

    }

    //Elisa
    // f) compute power support for a single day
    public static double computePowerSupport(double[] usage, double[] prices) {
        double support = 0.0;
        int n = Math.min(usage.length, prices.length);
        for (int i = 0; i < n; i++) {
            support += getSupport(usage[i], prices[i]);
        }
        return support;
    }

    private static final double NORGESPRIS_KWH = 0.5;

    // g) compute norges pris for a single day
    public static double computeNorgesPrice(double[] usage) {
        if (usage == null) {
            throw new IllegalArgumentException("usage array is null");
        }

        double price = 0;
        for (double u : usage) {
            price += u * NORGESPRIS_KWH;
        }

        return price;

    }

    // h) compute peak usage during a single day
    public static double findPeakUsage(double[] usage) {

        if (usage == null) {
            throw new IllegalArgumentException("usage array is null");
        }
        if (usage.length == 0) {
            return 0; // no data -> peak is 0
        }

        double temp_max = 0;
        for (double u : usage) {
            if (u > temp_max) {
                temp_max = u;
            }
        }
        return temp_max;
    }

    //i)
    // Samsam

    public static double findAvgPower(double[] usage) {

        double average = 0;
        double total = 0;

        for (int i = 0; i < usage.length; i++) {
            total += usage[i];
        }
        average = total / usage.length;


        return average;
    }
}