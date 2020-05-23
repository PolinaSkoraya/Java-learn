package com.main;

import java.util.Formatter;
import java.util.Scanner;
import java.util.TreeSet;

public class RunnerTaxes {
    public static void main(String[] args) {
        new TaxExtract().calculateAndShowTaxesExtract();
    }
}

class TaxExtract {
    private TreeSet<Tax> taxes;

    TaxExtract() {
        taxes  = new TreeSet<> ();
        int[] incomes = inputIncomes ();

        Income mainEmployment = new MainEmployment(incomes[0], "Basic salary");
        Income additionalEmployment = new AdditionalEmployment(incomes[1], "Secondary salary");
        Income privileges = new Privileges(incomes[2], "Privileges for children");
        Income royalties = new Royalties(incomes[3], "Royalties");
        Income transfers = new TransferFunds(incomes[4], "Transfers from abroad");
        Income realEstate = new RealEstate(incomes[5], "Selling real estate");
        Income gifts = new Gifts(incomes[6], "Gifts");

        taxes.add(new Tax(gifts, 0.0));
        taxes.add(new Tax(additionalEmployment, 0.12));
        taxes.add(new Tax(realEstate, 0.27));
        taxes.add(new Tax(mainEmployment, 0.19));
        taxes.add(new Tax(transfers, 0.1));
        taxes.add(new Tax(royalties, 0.32));
        taxes.add(new Tax(privileges, 0.0));
    }

    public int[] inputIncomes () {
        Scanner input = new Scanner(System.in);
        int size = 7;
        int[] array = new int[size];

        System.out.println("Write your incomes (MainEmployment, AdditionalEmployment, Privileges, Royalties, TransferFunds, RealEstate, Gifts): ");

        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }

        return array;
    }

    public void calculateAndShowTaxesExtract() {
        Formatter formatter = new Formatter().format("%25s %15s %9s %10s", "Source", "Income", "Rate", "Tax");
        System.out.println(formatter.toString());

        int i = 0;
        int totalIncome = 0;
        double totalTaxes = 0.;

        for (Tax tax : taxes) {
            totalIncome += tax.income.amount;
            totalTaxes += tax.rate * tax.income.amount;
            System.out.println(++i + ". " + tax);
        }

        System.out.printf("   TOTAL  --------------------  %10d %22.2f", totalIncome, totalTaxes);
    }

}
