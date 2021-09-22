/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmsandconstructs;

import algorithmsandconstructs.enums.Make;
import algorithmsandconstructs.enums.Month;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ruben
 */
public class Car implements CarInterface{
    
    private Make make;
    private double dailyRate;
    private int id;
    private Map<Month, boolean[]> availability;

    public Car(Make make, double dailyRate, int id, Map<Month, boolean[]> availability) {
        this.make = make;
        this.dailyRate = dailyRate;
        this.id = id;
        this.availability = createAvailability();
    }
    
    @Override
    public Map<Month, boolean[]> createAvailability() {
        Map<Month, boolean[]> map = new HashMap<Month, boolean[]>();
        for (Month month : Month.values()) { 
                map.put(month, new boolean[month.getNumberOfDays()]);
        }
        return map;
    }

    @Override
    public Make getMake() {
        return this.make;
    }

    @Override
    public void setMake(Make make) {
        this.make = make;
    }

    @Override
    public double getRate() {
        return this.dailyRate;
    }

    @Override
    public void setRate(double rate) {
        this.dailyRate = rate;
    }

    @Override
    public Map<Month, boolean[]> getAvailability() {
        return this.availability;
    }

    @Override
    public void setAvailability(Map<Month, boolean[]> availability) {
        this.availability = availability;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public boolean isAvailable(Month month, int day) {
        return (this.availability.get(month))[day];
    }

    @Override
    public boolean book(Month month, int day) {
        if(this.availability.get(month)[day]==false){
            this.availability.get(month)[day] = true;
            return true;
        } else if (this.availability.get(month)[day] == true){
            return false;
        } return false;
    }
    
}
