package org.aplas.basicappx;

public class Distance {
    private double meter;

    Distance(){
        this.meter = 0;
    }

    public void setMeter(double meter) {
        this.meter = meter;
    }

    public void setInch(double meter){
        this.meter =  meter / 39.3701;
    }

    public void setMile(double meter){
        this.meter =  meter / 0.000621371;
    }

    public void setFoot(double meter){
        this.meter = meter / 3.28084;
    }

    public double getMeter() {
        return meter;
    }

    public double getInch() {
        return meter * 39.3701;
    }

    public double getMile() {
        return meter * 0.000621371;
    }

    public double getFoot() {
        return meter * 3.28084;
    }

    public double convert(String oriUnit, String convUnit, double value){
        if(oriUnit.equalsIgnoreCase("Mtr")){
            if(convUnit.equalsIgnoreCase("Mtr")){
                return getMeter();
            }else if(convUnit.equalsIgnoreCase("Inc")){
                return getInch();
            }else if(convUnit.equalsIgnoreCase("Mil")){
                return getMile();
            }else{
                return getFoot();
            }
        }
        else if(oriUnit.equalsIgnoreCase("Inc")){
            if(convUnit.equalsIgnoreCase("Mtr")){
                setInch(value);
                return getMeter();
            }else if(convUnit.equalsIgnoreCase("Inc")){
                return getInch();
            }else if(convUnit.equalsIgnoreCase("Mil")){
                setInch(value);
                return getMile();
            }else{
                setInch(value);
                return getFoot();
            }
        }
        else if(oriUnit.equalsIgnoreCase("Mil")){
            if(convUnit.equalsIgnoreCase("Mtr")){
                setMile(value);
                return getMeter();
            }else if(convUnit.equalsIgnoreCase("Inc")){
                setMile(value);
                return getInch();
            }else if(convUnit.equalsIgnoreCase("Mil")){
                return getMile();
            }else{
                setMile(value);
                return getFoot();
            }
        }else{
            if(convUnit.equalsIgnoreCase("Mtr")){
                setFoot(value);
                return getMeter();
            }else if(convUnit.equalsIgnoreCase("Inc")){
                setFoot(value);
                return getInch();
            }else if(convUnit.equalsIgnoreCase("Mil")){
                setFoot(value);
                return getMile();
            }else{
                return getFoot();
            }
        }
    }
}
