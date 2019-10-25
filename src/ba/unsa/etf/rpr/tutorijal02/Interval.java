package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    double pocetna, krajnja;
    boolean pocPripada, kraPripada;

    Interval(double pocetna, double krajnja, boolean pripada1, boolean pripada2) {
        if(pocetna > krajnja)
            throw new IllegalArgumentException("Pocetna veca od krajnje!");

        this.pocetna = pocetna;
        this.krajnja = krajnja;
        pocPripada = pripada1;
        kraPripada = pripada2;
    }

    Interval() {
        pocetna = 0;
        krajnja = 0;
        pocPripada = false;
        kraPripada = false;
    }

    boolean isNull() {
        return (pocetna == 0 && pocetna == krajnja && !pocPripada && pocPripada == kraPripada);
    }

    boolean isIn(double tacka) {
        return tacka >= pocetna && tacka <= krajnja;
    }

    Interval intersect(Interval interval) {
        boolean jedan = true, dva = true;
        double poc, kra;

        if(this.pocetna > interval.pocetna) {
            poc = pocetna;
            jedan = interval.pocPripada;
        }
        else {
            poc = interval.pocetna;
        }
    }

    Interval intersect(Interval prvi, Interval drugi) {
        if(prvi.pocetna > )
    }
}
