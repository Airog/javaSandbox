package oop.polymorphism.tempconvert;

public class KelvinConvertor implements TemperatureConvertor {

    @Override
    public double convert(double t) {
        return t + 273.15;
    }
}
