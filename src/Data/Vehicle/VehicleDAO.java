/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data.Vehicle;

import Business.Entity.Vehicle;
import Data.FileManager;
import Data.IFileManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author tanng
 */
public final class VehicleDAO implements IVehicleDAO{
    private final IFileManager<Vehicle> fileManager;
    private final List<Vehicle> vehicleList;

    public VehicleDAO() throws Exception {
        this.fileManager = new FileManager("vehicle.txt");
        this.vehicleList = new ArrayList<>();
        loadVehicleFromFile();
    }
    
    

    @Override
    public void loadVehicleFromFile() throws Exception{
        String ID, name, color, brand, type;
        int price;
        LocalDate productYear;
        List<String> vehicleData = fileManager.readDataFromFile();
        for (String a : vehicleData){
            List<String> subData = Arrays.asList(a.split(","));
            ID = subData.get(0).trim();
            name = subData.get(1).trim();
            color = subData.get(2).trim();
            price = Integer.parseInt(subData.get(3).trim());
            brand = subData.get(4).trim();
            type = subData.get(5).trim();
            productYear = LocalDate.parse(subData.get(6).trim());
            addNew(new Vehicle(ID, name, color, price, brand, type, productYear));
        }
    }

    @Override
    public void writeVehicleToFile(List<String> result) throws Exception {
        if (result.isEmpty()){
            return;
        }
        fileManager.writeDataToFile(result);
    }

    @Override
    public void addNew(Vehicle vehicle) throws Exception {
        vehicleList.add(vehicle);
    }

    @Override
    public List<Vehicle> getList() throws Exception {
        return vehicleList;
    }
    
}
