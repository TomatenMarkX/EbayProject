package org.example;

import java.util.List;

public class Customer {
    private String vorname;
    private String nachname;
    private List<Bestellung> bestellungen;

    public Customer (String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getVorname() {
        return this.vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getNachname() {
        return this.nachname;
    }
}
