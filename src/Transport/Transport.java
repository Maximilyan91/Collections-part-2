package Transport;

import Drivers.Driver;
import Drivers.NoDriverLicenseException;
import Mechanic.Mechanics;

import java.util.ArrayList;

public abstract class Transport<T extends Driver> implements Racing {

    private final String brand;
    private final String model;
    private double engineVolume;
    private T driver;
    private final ArrayList<Mechanics> mechanics = new ArrayList<>();
    private final String DEFAULT_VALUE = "default";
    private final double DEFAULT_ENGINE_VOLUME = 0.1;

    public Transport(String brand, String model, double engineVolume, T driver) {
        if (brand == null || brand.isEmpty() || brand.isBlank()) {
            this.brand = DEFAULT_VALUE;
        } else {
            this.brand = brand;
        }

        if (model == null || model.isEmpty() || model.isBlank()) {
            this.model = DEFAULT_VALUE;
        } else {
            this.model = model;
        }
        this.engineVolume = engineVolume;
        this.driver = driver;
    }

    public void addMechanic(Mechanics mechanics) {
        getMechanics().add(mechanics);
    }


    abstract void printType();

    abstract boolean doDiagnostic() throws NoDriverLicenseException;

    public void printInfo() {
        System.out.println("водитель " + driver.getFullName() + " управляет автомобилем " + getBrand() + " и будет участвовать в заезде");
    }

    @Override
    public String toString() {
        return "Бренд - " + brand + ", Модель - " + model + ", Объем мотора - " + engineVolume;
    }

    protected void startDriving() {
        System.out.println("Начинаю ехать");
    }

    protected void stopDriving() {
        System.out.println("Прекращаю ехать");
    }

    public T getDriver() {
        return driver;
    }

    public void setDriver(T driver) {
        this.driver = driver;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
        if (Double.compare(this.engineVolume,0)==0) {
            this.engineVolume = DEFAULT_ENGINE_VOLUME;
        }

    }

    public ArrayList<Mechanics> getMechanics() {
        return mechanics;
    }
}

