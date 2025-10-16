package no.hvl.dat100.javel.oppgave1;

import no.hvl.dat100.javel.oppgave2.MonthlyPower;

public class DayMain {

    public static void main(String[] args) {

        // test data
        double[] powerusage_day = DayPowerData.powerusage_day;

        double[] powerprices_day = DayPowerData.powerprices_day;

        System.out.println("==============");
        System.out.println("OPPGAVE 1");
        System.out.println("==============");
        System.out.println();

        System.out.println("=== STRØMPRISER ===");
        DailyPower.printPowerPrices(powerprices_day);

        System.out.println("\n=== STRØMBRUK ===");
        DailyPower.printPowerUsage(powerusage_day);

        // c) compute total power usage
        double totalUsage = DailyPower.computePowerUsage(powerusage_day);
        System.out.printf("C: Totalt strømforbruk: %.3f kWh%n", totalUsage);

        // d) compute total spot price (uten støtte)
        double totalSpotPrice = DailyPower.computeSpotPrice(powerusage_day, powerprices_day);
        System.out.printf("D: Total spotpris (uten støtte): %.3f NOK%n", totalSpotPrice);

        // f) compute total power support
        double totalSupport = DailyPower.computePowerSupport(powerusage_day, powerprices_day);
        System.out.printf("F: Total strømstøtte: %.3f NOK%n", totalSupport);

        //g   Norgespris: total cost with fixed price 0.5 NOK/kWh
        double norgespris = DailyPower.computeNorgesPrice(powerusage_day);
        System.out.println("G: Totalt Norgespris: " + norgespris + " kr");

        //h  Peak (maximum hourly usage)
        double peak = DailyPower.findPeakUsage(powerusage_day);
        System.out.println("H: Maksimum (peak) forbruk: " + peak + " kWh");

        //i  Peak (maximum hourly usage)
        double average = DailyPower.findAvgPower(powerusage_day);
        System.out.printf("i: Gjennomsnittlig forbruk (per time): %.3f kWh%n", average);

    }
}
