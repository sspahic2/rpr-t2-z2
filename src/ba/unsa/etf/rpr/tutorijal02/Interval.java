package ba.unsa.etf.rpr.tutorijal02;

import javax.swing.*;
import java.util.Objects;

public class Interval {
    private double pocetna, krajnja;
    private boolean pripada1, pripada2;

    Interval(double pocetna, double krajnja, boolean pripada1, boolean pripada2) {
        if(pocetna > krajnja)
            throw new IllegalArgumentException("Pocetna veca od krajnje!");

        this.pocetna = pocetna;
        this.krajnja = krajnja;
        this.pripada1 = pripada1;
        this.pripada2 = pripada2;
    }

    Interval() {
        pocetna = 0;
        krajnja = 0;
        pripada1 = false;
        pripada2 = false;
    }

    boolean isNull() {
        return (pocetna == 0 && pocetna == krajnja && !pripada1 && pripada1 == pripada2);
    }

    boolean isIn(double tacka) {
        if(tacka >= pocetna && tacka < krajnja && pripada1)
            return true;
        else if(tacka > pocetna && tacka <= krajnja && pripada2)
            return true;

        return false;
    }

    Interval intersect(Interval interval) {
        return intersect(this, interval);
    }

    static Interval intersect(Interval prvi, Interval drugi) {
        boolean jedan = prvi.pripada1, dva = prvi.pripada2;
        double poc = 0, kra = 0;

        if(prvi.pocetna > drugi.pocetna) {
            poc = prvi.pocetna;
            jedan = prvi.pripada1;
        }
        else if(prvi.pocetna < drugi.pocetna) {
            poc = drugi.pocetna;
            jedan = drugi.pripada1;
        }

        if(prvi.krajnja > drugi.krajnja) {
            kra = drugi.krajnja;
            dva = drugi.pripada2;
        }
        else if(prvi.krajnja < drugi.krajnja){
            kra = prvi.krajnja;
            dva = prvi.pripada2;
        }

        return new Interval(poc, kra, jedan, dva);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return Double.compare(interval.pocetna, pocetna) == 0 &&
                Double.compare(interval.krajnja, krajnja) == 0 &&
                pripada1 == interval.pripada1 &&
                pripada2 == interval.pripada2;
    }

    @Override
    public String toString() {
        String ispis1, ispis2;
        if(this.isNull())
            return "()";
        if(pripada1)
            ispis1 = "[";
        else
            ispis1 = "(";
        if(pripada2)
            ispis2 = "]";
        else
            ispis2 = ")";

        return ispis1 + pocetna + "," + krajnja + ispis2;
    }
}
