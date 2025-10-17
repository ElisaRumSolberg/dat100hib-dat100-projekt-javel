package no.hvl.dat100.javel.oppgave2;

import no.hvl.dat100.javel.oppgave1.DailyPower;

public class MonthlyPower {

    // a) print power usage for a month    samsam
    public static void print_PowerUsage(double[][] usage) {

        // TODO

    }

    // b) print power prices for a month    alissa
    public static void print_PowerPrices(double[][] prices) {
        if(prices==null){
            throw new IllegalArgumentException("Prices matrix is null");
        }
        for(int day=0; day<prices.length; day++){
            if(prices[day]==null){
                throw new IllegalArgumentException("Prices row (day"+(day+1)+") is null");
            }
            system.out.printf("===POWER PRICES - DAY %02d ===%n",day +1);
            DailyPower.printPowerPrices(prices[day]);
            System.out.println();
        }
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
        validateSAmeShape(usage,prices);
        double price = 0;

        for(int day=0; day<prices.length; day++){
            price +=DailyPower.computeSpotPrice(usage[day],prices[day]);
        }

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
