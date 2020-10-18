package oop.polymorphism.tempconvert;

public class FahrenheitConverter implements TemperatureConvertor{

    @Override
    public double convert(double t) {
        return 1.8 * t + 32;
    }
}
