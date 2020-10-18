package oop.polymorphism.tempconverter;

import oop.polymorphism.tempconvert.FahrenheitConverter;
import oop.polymorphism.tempconvert.KelvinConvertor;
import oop.polymorphism.tempconvert.TemperatureConvertor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TempConverterTest {

    double bodyTemp = 36.6;
    TemperatureConvertor tc;

    @Test
    public void testKelvin() {
        tc = new KelvinConvertor();
        Assert.assertEquals(tc.convert(bodyTemp), 309.75);
    }

    @Test
    public void testFahrenheit() {
        tc = new FahrenheitConverter();
        Assert.assertEquals(tc.convert(bodyTemp), 97.88000000000001);
    }
}
