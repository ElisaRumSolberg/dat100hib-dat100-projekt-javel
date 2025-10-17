package no.hvl.dat100.javel.oppgave2;

import no.hvl.dat100.javel.oppgave1.DayPowerData;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MonthMain {
    public static void main(String[] args) {

        // test data
        double[][] power_prices_month = MonthPowerData.powerprices_month;

        double[][] power_usage_month = MonthPowerData.powerusage_month;

        System.out.println("==============");
        System.out.println("OPPGAVE 2");
        System.out.println("==============");
        System.out.println();

        System.out.println("=== STRØMBRUK (MÅNED) ===");
        MonthlyPower.print_PowerUsage(power_usage_month);
        System.out.println();

        //b
        System.out.println("=== STRØMPRISER (MÅNED) ===");
        MonthlyPower.print_PowerPrices(power_prices_month);
        System.out.println();

        //c
        double totalUsage = MonthlyPower.computePowerUsage(power_usage_month);
        System.out.printf("C) Total power usage this month: %.2f kWh%n", totalUsage);

        //d
        double threshold = 1200.0; // foreksemple: 1200 kWh
        boolean exceeded = MonthlyPower.exceedThreshold(power_usage_month, threshold);
        System.out.printf("D) Exceed threshold %.2f kWh? %s%n", threshold, exceeded ? "YES" : "NO");

        //e
        double totalSpotPrice = MonthlyPower.computeSpotPrice(power_usage_month, power_prices_month);
        System.out.printf("E) Total spot-price cost: %.2f NOK%n", totalSpotPrice);

        // f)
        double totalSupport = MonthlyPower.computePowerSupport(power_usage_month, power_prices_month);
        System.out.printf("F) Total power support: %.2f NOK%n", totalSupport);

        // g)
        double norgesPrice = MonthlyPower.computeNorgesPrice(power_usage_month);
        System.out.printf("G) Total Norgespris: %.2f NOK%n", norgesPrice);

        // summary
        System.out.println("\n--- SUMMARY ---");
        System.out.printf("Usage: %.2f kWh | Spot: %.2f NOK | Support: %.2f NOK | Norgespris: %.2f NOK%n",
                totalUsage, totalSpotPrice, totalSupport, norgesPrice);




          }
}