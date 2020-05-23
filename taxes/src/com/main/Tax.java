package com.main;

import java.util.Formatter;
import java.util.Objects;

public class Tax implements Comparable<Tax> {
    protected Income income;
    protected Double rate;
    protected Double tax;

    protected Tax(Income income, Double rate) {
        this.income = income;
        this.rate = rate;
        this.tax = income.amount * rate;
    }

    @Override
    public int compareTo(Tax o) {
        double result = o.income.getAmount() * o.rate - this.income.getAmount() * this.rate;

        if (result < 0) {
            return -1;
        } else if (result > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Tax tax1 = (Tax) o;
        return Objects.equals (income, tax1.income) &&
                Objects.equals (rate, tax1.rate) &&
                Objects.equals (tax, tax1.tax);
    }

    @Override
    public int hashCode() {
        return Objects.hash (income, rate, tax);
    }

    @Override
    public String toString() {
        return income.toString() + new Formatter().format("%5.2f  | %10.2f", rate, tax).toString();
    }
}