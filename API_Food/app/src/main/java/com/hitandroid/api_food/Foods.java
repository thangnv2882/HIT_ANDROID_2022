package com.hitandroid.api_food;

import java.io.Serializable;

public class Foods implements Serializable {
    private int monanId;
    private String monanname;
    private String avt;
    private String nguyenlieu;
    private String congthuc;
    private String tien;

    public Foods() {
    }

    public Foods(int monanId, String monanname, String avt, String nguyenlieu, String congthuc, String tien) {
        this.monanId = monanId;
        this.monanname = monanname;
        this.avt = avt;
        this.nguyenlieu = nguyenlieu;
        this.congthuc = congthuc;
        this.tien = tien;
    }

    public int getMonanId() {
        return monanId;
    }

    public void setMonanId(int monanId) {
        this.monanId = monanId;
    }

    public String getMonanname() {
        return monanname;
    }

    public void setMonanname(String monanname) {
        this.monanname = monanname;
    }

    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    public String getNguyenlieu() {
        return nguyenlieu;
    }

    public void setNguyenlieu(String nguyenlieu) {
        this.nguyenlieu = nguyenlieu;
    }

    public String getCongthuc() {
        return congthuc;
    }

    public void setCongthuc(String congthuc) {
        this.congthuc = congthuc;
    }

    public String getTien() {
        return tien;
    }

    public void setTien(String tien) {
        this.tien = tien;
    }
}
