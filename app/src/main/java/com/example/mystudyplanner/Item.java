package com.example.mystudyplanner;

public class Item {
    String tenMH;
    String noiDung;

    public Item(String tenMH, String noiDung) {
        this.tenMH = tenMH;
        this.noiDung = noiDung;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
