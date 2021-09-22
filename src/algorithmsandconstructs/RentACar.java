/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmsandconstructs;

import algorithmsandconstructs.enums.Make;
import algorithmsandconstructs.enums.Month;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ruben
 */
public class RentACar implements RentACarInterface{
    
    private List<CarInterface> cars;
    private String name;

    public RentACar(String name, List<CarInterface> cars) {
        this.cars = cars;
        this.name = name;
    }


    @Override
    public List<CarInterface> getCars() {
        return this.cars;
    }

    @Override
    public void setCars(List<CarInterface> cars) {
        this.cars = cars;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent) {
        for(CarInterface car : cars){
            int i;
            boolean isAvailable = false;
            for(i=0;i<lengthOfRent;i++){
                if(car.isAvailable(month, day + i))
                    isAvailable = true;
                else
                    isAvailable = false;
            }
            
            if(car.getMake() == make && isAvailable)
                return true;
            else
                return false;
        }
        return false;
    }

    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {
        for(CarInterface car : cars){
            int i;
            boolean isAvailable = false;
            for(i=0;i<lengthOfRent;i++){
                if(car.isAvailable(month, day + i))
                    isAvailable = true;
                else
                    isAvailable = false;
            }
            
            if(car.getMake() == make && isAvailable)
                return car.getId();
            else
                return -1;
        }
        return -1;
    }

    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
        for(CarInterface car : cars){
            int i;
            boolean isAvailable = false;
            for(i=0;i<lengthOfRent;i++){
                if(car.isAvailable(month, day + i))
                    isAvailable = true;
                else
                    isAvailable = false;
            }
            
            if(car.getMake() == make && isAvailable){
                for(i=0;i<lengthOfRent;i++){
                    car.book(month, day);
                }
                return true;
            }
            
            else
                return false;
        }
        return false;
    }

    @Override
    public int getNumberOfCars() {
        return this.cars.size();
    }
    
}
