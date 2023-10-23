/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Data.Vehicle;

import Business.Entity.Vehicle;
import Data.IDataDAO;
import java.util.List;

/**
 *
 * @author tanng
 */
public interface IVehicleDAO extends IDataDAO<Vehicle>{
    void loadVehicleFromFile() throws Exception;
    void writeVehicleToFile(List<String> result) throws Exception;
}
