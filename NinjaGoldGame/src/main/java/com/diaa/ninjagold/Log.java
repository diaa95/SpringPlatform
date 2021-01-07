package com.diaa.ninjagold;

public class Log {
    private String massage;
    private String color;

    public Log(int num, String location){
        if(num > 0) {
            this.massage = String.format("Earned %d golds from the %s!", num, location);
            this.color = "green";
        }else {
            this.massage = String.format("Lost %d golds from the %s!", num, location);
            this.color = "red";
        }
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
