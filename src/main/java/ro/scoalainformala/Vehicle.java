package ro.scoalainformala;

public class Vehicle {
    private int availableFuel;
    private String chassisNumber;
    private boolean ignitionOn;
    private double kmCounter;
    private int fuelTankSize;
    private int gears;
    private double consumptionPer100Km;
    private double consumedFuel;



    public Vehicle(int availableFuel, String chassisNumber){
        this.availableFuel=availableFuel;
        this.chassisNumber=chassisNumber;
        this.ignitionOn=false;
        this.kmCounter =0;
        this.fuelTankSize=50;
        this.gears=6;
        this.consumptionPer100Km=5;
        this.consumedFuel=0;
    }

    public int getGears() {
        return gears;
    }
    public void setGears(int gears) {
        this.gears = gears;
    }

    public int getFuelTankSize() {
        return fuelTankSize;
    }
    public void setFuelTankSize(int fuelTankSize) { this.fuelTankSize = fuelTankSize; }

    public int getAvailableFuel() {
        return availableFuel;
    }
    public void setAvailableFuel(int availableFuel) {
        this.availableFuel = availableFuel;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }
    public boolean getIgnitionOn() {
        return ignitionOn;
    }
    public void setIgnitionOn(boolean ignitionOn) {
        this.ignitionOn = ignitionOn;
    }

    public double getKmCounter() {
        return kmCounter;
    }
    public void setKmCounter(double kmCounter) {
        this.kmCounter = kmCounter;
    }

    public double getConsumptionPer100Km() {
        return consumptionPer100Km;
    }
    public void setConsumptionPer100Km(double consumptionPer100Km) {
        this.consumptionPer100Km = consumptionPer100Km;
    }
    public double getConsumedFuel() {
        return consumedFuel;
    }

    public void start(){
        this.ignitionOn=true;
        consumedFuel=0;
    }
    public void stop(){
        this.ignitionOn=false;
    }

    public void shiftGear(int gear){
        if(gear<=6) {
            gears = gear;
        }
    }

    public void drive(double km){
        while(getIgnitionOn()==true){
            this.kmCounter += km;
            break;
        }
        if(gears==1){
            availableFuel-=(consumptionPer100Km * km / 100);
            consumedFuel += (consumptionPer100Km * km / 100);
        }else if(gears==2){
            availableFuel-=(consumptionPer100Km * km / 100)*0.9;
            consumedFuel += (consumptionPer100Km * km / 100)*0.9;
        }else if(gears==3){
            availableFuel-=(consumptionPer100Km * km / 100)*0.8;
            consumedFuel += (consumptionPer100Km * km / 100)*0.8;
        }else if(gears==4){
            availableFuel-=(consumptionPer100Km * km / 100)*0.7;
            consumedFuel += (consumptionPer100Km * km / 100)*0.7;
        }else if(gears==5){
            availableFuel-=(consumptionPer100Km * km / 100)*0.6;
            consumedFuel += (consumptionPer100Km * km / 100)*0.7;
        }else if(gears==6){
            availableFuel-=(consumptionPer100Km * km / 100)*0.5;
            consumedFuel += (consumptionPer100Km * km / 100)*0.5;
        }
    }
    public double getAverageFuelConsumption(){
        return (double)100*consumedFuel/kmCounter;

    }

}
