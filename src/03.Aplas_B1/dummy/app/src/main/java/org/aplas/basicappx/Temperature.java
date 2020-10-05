package org.aplas.basicappx;

public class Temperature {

    private double celcius;


    Temperature(){
        this.celcius=0;
    }


    public void setCelcius(double celcius) {
        this.celcius = celcius;
    }

    public void setFahrenheit(double celcius) {
        this.celcius = (celcius-32)/9*5;
    }

    public void setKelvins(double celcius) {
        this.celcius = celcius-273.15;
    }

    public double getCelcius() {
        return celcius;
    }

    public double getFahrenheit() {
        return celcius*9/5 + 32;
    }

    public double getKelvins() {
        return celcius + 273.15;
    }

    public double convert(String oriUnit, String convUnit, double value){
        if(oriUnit.equalsIgnoreCase("°C")){
            if (convUnit.equalsIgnoreCase("°F")){
                return getFahrenheit();
            }
            else if(convUnit.equalsIgnoreCase("°C")){
                return getCelcius();
            }
            else{
                return getKelvins();
            }
        }else{
            if(oriUnit.equalsIgnoreCase("°F")){
                if(convUnit.equalsIgnoreCase("°C")){
                    setFahrenheit(value);
                    return getCelcius();
                }else{
                    if (convUnit.equalsIgnoreCase("°F")){
                        return getFahrenheit();
                    }else {
                        setFahrenheit(value);
                        return getKelvins();
                    }
                }
            }
            else{
                if(convUnit.equalsIgnoreCase("°C")){
                    setKelvins(value);
                    return getCelcius();
                }
                else{
                    if(convUnit.equalsIgnoreCase("°F")){
                        setKelvins(value);
                        return getFahrenheit();
                    }else{
                        return getKelvins();
                    }
                }
            }
        }

    }
}
