import java.util.*;

interface Converter {

    Object convert(Object x);
}


abstract class TemperatureConverter implements Converter {

    abstract protected boolean isHot(double temperature);
}

abstract class SpeedConverter implements Converter {

    abstract protected boolean isFast(double speed);
}


class Thermometer extends TemperatureConverter {

    public Object convert(Object celsius) {

        double double_celsius = (double) celsius;

        double fahrenheit = ((9.0/5.0) * double_celsius) + 32;

        return fahrenheit;
    }

    protected boolean isHot(double temperature) {
        
        return temperature > 30;
    }
    
}


class Thermocouple extends TemperatureConverter {

    public Object convert(Object celsius) {

        double double_celsius = (double) celsius;

        double kelvin = double_celsius + 273.15;

        return kelvin;
    }

    protected boolean isHot(double temperature) {
        
        return temperature > 30;

    }
    
}


class PitotTube extends SpeedConverter {

    public Object convert(Object kmh) {

        double double_kmh = (double) kmh;

        double mach = double_kmh * 0.000816327;

        return mach;
    }

    protected boolean isFast(double speed) {

        return speed > 80;
    }
}


class ShaftLog extends SpeedConverter {

    public Object convert(Object kmh) {

        double double_kmh = (double) kmh;

        double mph = double_kmh * 0.62;

        return mph;
    }

    protected boolean isFast(double speed) {

        return speed > 80;
    }
}


class Assignment {

    public static void main(String[] args) {
        
        Converter converter;

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter a choice of object: ");
        int choice = sc.nextInt();

        switch(choice) {

            case 1: 
                    converter = new Thermometer();
                    System.out.println(converter.convert(36.88));
                    // System.out.println(converter.isHot(36.88)); // Fails
                    System.out.println(((Thermometer)converter).isHot(36.88)); // Works
                    break;

            case 2: 
                    converter = new Thermocouple();
                    System.out.println(converter.convert(36.88));
                    // System.out.println(converter.isHot(36.88)); // Fails
                    System.out.println(((Thermocouple)converter).isHot(36.88)); // Works
                    break;

            case 3: 
                    converter = new PitotTube();
                    System.out.println(converter.convert(110.54));
                    // System.out.println(converter.isFast(110.54)); // Fails
                    System.out.println(((PitotTube)converter).isFast(110.54)); // Works
                    break;

            case 4:
                    converter = new ShaftLog();
                    System.out.println(converter.convert(110.54));
                    // System.out.println(converter.isFast(110.54)); // Fails
                    System.out.println(((ShaftLog)converter).isFast(110.54)); // Works
            
        }

        sc.close();
    }
}