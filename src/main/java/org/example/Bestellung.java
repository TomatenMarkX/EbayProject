package org.example;

public class Bestellung {
    private String vorname;
    private String nachname;
    private Product product;
    private Status status;

    enum Status {
        IN_BEARBEITUNG, ABGESCHLOSSEN
    }

    public Bestellung(String vorname, String nachname, Status status) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.status = status;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
