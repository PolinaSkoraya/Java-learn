package com.main;

import java.util.Formatter;
import java.util.Objects;

abstract public class Income {
    private String sourceName;
    protected Integer amount;

    protected Income(Integer amount, String sourceName) {
        this.amount = amount;
        this.sourceName = sourceName;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Income income = (Income) o;
        return Objects.equals (sourceName, income.sourceName) &&
                Objects.equals (amount, income.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash (sourceName, amount);
    }

    @Override
    public String toString() {
        return new Formatter().format("%27s  | %8d  | ", sourceName, amount).toString();
    }
}

class MainEmployment extends Income {
    MainEmployment(Integer amount, String sourceName) {
        super(amount, sourceName);
    }
}

class AdditionalEmployment extends Income {
    AdditionalEmployment(Integer amount, String sourceName) {
        super(amount, sourceName);
    }
}

class Royalties extends Income {
    Royalties(Integer amount, String sourceName) {
        super(amount, sourceName);
    }
}

class RealEstate extends Income {
    RealEstate(Integer amount, String sourceName) {
        super(amount, sourceName);
    }
}

class Gifts extends Income {
    Gifts(Integer amount, String sourceName) {
        super(amount, sourceName);
    }
}

class TransferFunds extends Income {
    TransferFunds(Integer amount, String sourceName) {
        super(amount, sourceName);
    }
}

class Privileges extends Income {
    Privileges(Integer amount, String sourceName) {
        super(amount, sourceName);
    }
}