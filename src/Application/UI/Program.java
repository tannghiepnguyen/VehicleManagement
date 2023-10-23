/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.UI;

import Business.Service.VehicleService;
import java.util.Collections;

/**
 *
 * @author tanng
 */
public class Program {
    public static void main(String[] args){
        int choice;
        System.out.println(String.join("", Collections.nCopies(10, "**********")));
        try {
            VehicleService vehicleService = new VehicleService();
            do {                
                Menu.print("******Vehicle Management******|1.Add new vehicle|2.Check exist vehicle|3.Update vehicle|4.Delete vehicle|5.Search vehicle|6.Display vehicles|7.Save to files|8.Print|9.Find car in range|10.Exit|Select: ");
                choice = Menu.getUserChoice();
                switch (choice) {
                    case 1 -> {
                        vehicleService.add();
                    }
                    case 2 -> {
                        vehicleService.checkExist();
                    }
                    case 3 -> {
                        vehicleService.update();
                    }
                    case 4 -> {
                        vehicleService.delete();
                    }
                    case 5 -> {
                        Menu.manageSearch(vehicleService);
                    }
                    case 6 -> {
                        Menu.manageDisplay(vehicleService);
                    }
                    case 7 -> {
                        vehicleService.writeVehicleToFile();
                    }
                    case 8 -> {
                        Menu.managePrint(vehicleService);
                    }
                    case 9 -> {
                        vehicleService.findCarInRange();
                    }
                    default -> {
                        System.out.println("Good bye !");
                        System.exit(0);
                    }
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
