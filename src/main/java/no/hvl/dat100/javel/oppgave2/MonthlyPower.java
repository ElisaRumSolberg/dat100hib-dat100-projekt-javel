package no.hvl.dat100.javel.oppgave2;

import no.hvl.dat100.javel.oppgave1.DailyPower;

public class MonthlyPower {

    // a) print power usage for a month    samsam
    public static void print_PowerUsage(double[][] usage) {
        validateMatrix(usage);

        // i = dag, går gjennom alle dagene i tabellen
        for (int i = 0; i < usage.length; i++) {
            System.out.print("Day" + (i + 1) + ":");
            for (int j = 0; j < usage[i].length; j++) {    // j = timene
                System.out.printf(" %.2f kWh", usage[i][j]);
            }
            System.out.println();

        }
    }

    // b) print power prices for a month    alissa
    public static void print_PowerPrices(double[][] prices) {

        if (prices == null) {
            throw new IllegalArgumentException("Prices matrix is null");
        }
        for (int day = 0; day < prices.length; day++) {
            if (prices[day] == null) {
                throw new IllegalArgumentException("Prices row (day" + (day + 1) + ") is null");
            }
            System.out.printf("===POWER PRICES - DAY %02d ===%n", day + 1);
            DailyPower.printPowerPrices(prices[day]);
            System.out.println();
        }
    }

    // c) compute total power usage for a month  elisa
    public static double computePowerUsage(double[][] usage) {
        validateMatrix(usage);
        double sum = 0.0;
        for (int i = 0; i < usage.length; i++) {
            for (int j = 0; j < usage[i].length; j++) {
                sum += usage[i][j];
            }
        }
        return sum;
    }

    // d) determine whether a given threshold in powerusage for the month has been exceeded  samsam
    public static boolean exceedThreshold(double[][] powerusage, double threshold) {
        validateMatrix(powerusage);

        boolean exceeded = false;
        double usage = 0;

        int i = 0;
        while (i < powerusage.length && !exceeded) {
            int j = 0;
            while (j < powerusage[i].length && !exceeded) {
                usage += powerusage[i][j];

                if (usage > threshold) {
                    exceeded = true;
                }
                j++;
            }
            i++;
        }

        return exceeded;
    }


    // e) compute spot price alissa
    public static double computeSpotPrice(double[][] usage, double[][] prices) {
        validateSameShape(usage, prices);

        double price = 0;

        for (int day = 0; day < prices.length; day++) {
            price += DailyPower.computeSpotPrice(usage[day], prices[day]);
        }

        return price;
    }

    // f) power support for the month  elisa
    public static double computePowerSupport(double[][] usage, double[][] prices) {
        validateSameShape(usage, prices);
        double support = 0.0;
        for (int day = 0; day < usage.length; day++) {
            support += DailyPower.computePowerSupport(usage[day], prices[day]);
        }
        return support;

    }

    // g) Norgesprice for the month  samsam
    public static double computeNorgesPrice(double[][] usage) {
        validateMatrix(usage);

        double price = 0;

        for (double[] day : usage) {
            for (double hour : day) {
                price += hour;
            }
        }
        return price;
    }
    /* ---- Guard / validation helpers ---- */

    private static void validateMatrix(double[][] m) {
        if (m == null) {
            throw new IllegalArgumentException("Matrix is null");
        }
        for (int i = 0; i < m.length; i++) {
            if (m[i] == null) {
                throw new IllegalArgumentException("Row (day " + (i + 1) + ") is null");
            }
        }
    }

    private static void validateSameShape(double[][] a, double[][] b) {
        validateMatrix(a);
        validateMatrix(b);
        if (a.length != b.length) {
            throw new IllegalArgumentException("Matrices must have same number of days");
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i].length != b[i].length) {
                throw new IllegalArgumentException("Day ("
                        + (i + 1) + ") hour counts differ");
            }
        }
    }
}

