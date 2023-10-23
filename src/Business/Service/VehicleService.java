/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Service;

import Application.Ultility.DataInput;
import Business.Component.DataValidation;
import Business.Entity.Vehicle;
import Data.Vehicle.VehicleDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author tanng
 */
public class VehicleService {
    class sortByNameDescending implements Comparator<Vehicle>{
        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            return o2.getName().compareTo(o1.getName());
        }  
    }
    
    class sortByProductYearDescending implements Comparator<Vehicle>{
        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            if (o2.getProductYear().isAfter(o1.getProductYear())){
                return 1;
            }
            else {
                return -1;
            }
        }   
    }
    
    class sortbyPriceDescending implements Comparator<Vehicle>{

        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            return o2.getPrice() - o1.getPrice();
        }  
    }
    
    class sortbyPriceAscending implements Comparator<Vehicle>{

        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            return o1.getPrice() - o2.getPrice();
        }  
    }

    private static List<Vehicle> vehicleList;
    private final VehicleDAO vehicleDAO;

    public VehicleService() throws Exception {
        vehicleDAO = new VehicleDAO();
        vehicleList = vehicleDAO.getList();
    }
    
    public int indexOf(String ID) {
        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getID().equals(ID)) {
                return i;
            }
        }
        return -1;
    }

    public void add() {
        boolean continueAddingVehicle = true;
        do {
            vehicleList.add(VehicleService.createVehicle());
            System.out.println("Add successfully");
            String continueChoice = DataInput.getString("Do you want to continue(Y/N): ");
            if (!continueChoice.equalsIgnoreCase("Y")) {
                continueAddingVehicle = false;
            }
        } while (continueAddingVehicle);
    }

    public void checkExist() {
        String ID;
        do {            
            ID = DataInput.getString("Enter ID: ");
        } while (DataValidation.isEmptyString(ID));
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getID().equals(ID)) {
                System.out.println("Existed vehicle!");
                return;
            }
        }
        System.out.println("No vehicle found!");
    }

    public void update(){
        String ID;
        do {            
            ID = DataInput.getString("Enter ID: ");
        } while (DataValidation.isEmptyString(ID));
        int index = this.indexOf(ID);
        if (index != -1){
            Vehicle oldVehicle = vehicleList.get(index);
            vehicleList.set(index, updateVehicle(oldVehicle));
            System.out.println("Update successfully");
        }
        else{
            System.out.println("Product does not exist");
        }
    }
    
    public void delete(){
        String ID;
        do {            
            ID = DataInput.getString("Enter ID: ");
        } while (DataValidation.isEmptyString(ID));
        String confirmMessage = DataInput.getString("Are you sure you want to delete this?(Y/N): ");
        if (!confirmMessage.equalsIgnoreCase("Y")){
            return;
        }
        int index = this.indexOf(ID);
        if (index != -1){
            vehicleList.remove(index);
            System.out.println("Delete successfully");
        }
        else{
            System.out.println("Vehicle does not exist");
        }
    }
    
    public void searchByID(){
        String ID;
        do {            
            ID = DataInput.getString("Enter ID: ");
        } while (DataValidation.isEmptyString(ID));
        int index = this.indexOf(ID);
        if (index != -1){
            System.out.println(vehicleList.get(index)); 
        }
        else{
            System.out.println("Vehicle does not exist");
        }
    }
    
    public void searchByName(){
        String name;
        do {            
            name = DataInput.getString("Enter name: ");
        } while (DataValidation.isEmptyString(name));
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : vehicleList){
            if (vehicle.getName().contains(name)){
                result.add(vehicle);
            }
        }
        Collections.sort(result, new sortByNameDescending());
        for (Vehicle vehicle : result){
            System.out.println(vehicle);
        }
    }
    
    public void findCarInRange(){
        String low, high;
        do {            
            low = DataInput.getString("Enter minimum price: ");
        } while (!DataValidation.isNumber(low));
        
        do {            
            high = DataInput.getString("Enter maximum price: ");
        } while (!DataValidation.isNumber(high));
        
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : vehicleList){
            if (vehicle.getPrice() >= Integer.parseInt(low) && vehicle.getPrice() <= Integer.parseInt(high)){
                result.add(vehicle);
            }
        }
        Collections.sort(result, new sortbyPriceAscending());
        for (Vehicle vehicle : result){
            System.out.println(vehicle);
        }
    }
    
    public void displayAll(){
       for (Vehicle vehicle : vehicleList){
            System.out.println(vehicle);
        } 
    }
    
    public void displayByPrice(){
        String price;
        do {            
            price = DataInput.getString("Enter price: ");
        } while (Integer.parseInt(price) <= 0);
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : vehicleList){
            if (vehicle.getPrice() < Integer.parseInt(price)){
                result.add(vehicle);
            }
        }
        Collections.sort(result, new sortbyPriceDescending());
        for (Vehicle vehicle : result){
            System.out.println(vehicle);
        }
    }
    
    public void writeVehicleToFile() throws Exception{
        List<String> result = new ArrayList<>();
        for (Vehicle vehicle : vehicleList){
            String vehicleString = "";
            vehicleString += (vehicle.getID() + ",");
            vehicleString += (vehicle.getName() + ",");
            vehicleString += (vehicle.getColor() + ",");
            vehicleString += (vehicle.getPrice() + ",");
            vehicleString += (vehicle.getBrand() + ",");
            vehicleString += (vehicle.getType() + ",");
            vehicleString += (vehicle.getProductYear().toString());
            result.add(vehicleString);
        }
        vehicleDAO.writeVehicleToFile(result);
        System.out.println("Saving successfully");
    }
    
    public void printByYear(){
        String year;
        do {            
            year = DataInput.getString("Enter year: ");
        } while (Integer.parseInt(year) <= 0);
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : vehicleList){
            if (vehicle.getProductYear().getYear() >= Integer.parseInt(year)){
                result.add(vehicle);
            }
        }
        Collections.sort(result, new sortByProductYearDescending());
        for (Vehicle vehicle : result){
            System.out.println(vehicle);
        }
    }
    public static Vehicle createVehicle() {
        String ID, name, color, price, brand, type, productYear;
        do {            
            ID = DataInput.getString("Enter ID: ");
        } while (!DataValidation.isValidID(ID) || DataValidation.isExistID(vehicleList, ID));
        do {            
            name = DataInput.getString("Enter name: ");
        } while (DataValidation.isEmptyString(name));
        do {            
            color = DataInput.getString("Enter color: ");
        } while (DataValidation.isEmptyString(color));
        do {            
            price = DataInput.getString("Enter price: ");
        } while (!DataValidation.isNumber(price));
        do {            
            brand = DataInput.getString("Enter brand: ");
        } while (DataValidation.isEmptyString(brand));
        do {            
            type = DataInput.getString("Enter type: ");
        } while (DataValidation.isEmptyString(type));
        do {            
            productYear = DataInput.getString("Enter product year: ");
        } while (DataValidation.isEmptyString(productYear) || !DataValidation.isValidDate(productYear));
        return new Vehicle(ID, name, color, Integer.parseInt(price), brand, type, LocalDate.parse(productYear));
    }
    
    public static Vehicle updateVehicle(Vehicle oldVehicle){
        String name, color, price, brand, type, productYear;
        do {            
            name = DataInput.getString("Enter name: ");
            if (name.equals("")){
                name = oldVehicle.getName();
            }
        } while (DataValidation.isEmptyString(name));
        do {            
            color = DataInput.getString("Enter color: ");
            if (color.equals("")){
                color = oldVehicle.getColor();
            }
        } while (DataValidation.isEmptyString(color));
        do {            
            price = DataInput.getString("Enter price: ");
            if (price.equals("")){
                price = String.valueOf(oldVehicle.getPrice());
            }
        } while (!DataValidation.isNumber(price));
        do {            
            brand = DataInput.getString("Enter brand: ");
            if (brand.equals("")){
                brand = oldVehicle.getBrand();
            }
        } while (DataValidation.isEmptyString(brand));
        do {            
            type = DataInput.getString("Enter type: ");
            if (type.equals("")){
                type = oldVehicle.getType();
            }
        } while (DataValidation.isEmptyString(type));
        do {            
            productYear = DataInput.getString("Enter product year: ");
            if (productYear.equals("")){
                productYear = oldVehicle.getProductYear().toString();
            }
        } while (DataValidation.isEmptyString(productYear) || !DataValidation.isValidDate(productYear));
        return new Vehicle(oldVehicle.getID(), name, color, Integer.parseInt(price), brand, type, LocalDate.parse(productYear));
    } 
}
