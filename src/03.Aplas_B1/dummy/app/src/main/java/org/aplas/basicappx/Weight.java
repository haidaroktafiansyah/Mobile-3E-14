package org.aplas.basicappx;

public class Weight {

    Weight() {
        this.gram = 0;
    }
    private double gram;

    public void setGram(double gram) {
        this.gram = gram;
    }

    public void setOunce(double gram) {
        this.gram = gram*28.3495231;
    }

    public void setPound(double gram) {
        this.gram = gram*453.59237;
    }

    public double getGram() {
        return gram;
    }

    public double getOunce() {
        return gram/28.3495231;
    }

    public double getPound() {
        return gram/453.59237;
    }
    //convert


    public double convert(String oriUnit, String convUnit, double value){
        if(oriUnit.equalsIgnoreCase("Grm")){
            setGram(value);
        }else if(oriUnit.equalsIgnoreCase("Onc")){
            setOunce(value);
        }else{
            setPound(value);
        }
        if(convUnit.equalsIgnoreCase("Grm")){
            return getGram();
        }else if(convUnit.equalsIgnoreCase("Onc")){
            return  getOunce();
        }else{
            return  getPound();
        }
    }
}
