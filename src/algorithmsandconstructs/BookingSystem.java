/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmsandconstructs;

import algorithmsandconstructs.enums.Make;
import java.io.BufferedReader;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ruben
 */
public class BookingSystem implements BookingSystemInterface{

    @Override
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {
        String name = in.readLine();
        String line = in.readLine(); //starts on second line
        String make = "";
        String dailyRate = "";
        int numberOfCars = 0;
        int id = 1;
        String[] info;            // based on https://www.geeksforgeeks.org/split-string-java-examples/
        
        List<CarInterface> cars = new ArrayList<CarInterface>();
        
        while(line != null){
            info = line.split(":");
            make = info[0];
            dailyRate = info[1];
            numberOfCars = Integer.parseInt(info[2]);
            for(int i=0; i< numberOfCars; i++){
                Car car = new Car(Make.valueOf(make), parseDouble(dailyRate), id);
                cars.add(car);
            }
            id++;
            line = in.readLine();
        }
        
        RentACarInterface carRental = new RentACar(name, cars);
        
        return carRental;
    }
    
}
