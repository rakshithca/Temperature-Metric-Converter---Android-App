package com.example.rakshu.temperatureconverter;

public class TempertureConverter {

    public static double celsiusTofahrenheit(double c)
    {
        return (c*1.8)+32;
    }
    public static double fahrenheitTocelsius(double f)
    {
        return (f-32.0)/1.8;
    }
}
