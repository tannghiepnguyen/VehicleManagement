/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.UI;

import Business.Service.VehicleService;

/**
 *
 * @author tanng
 */
public class SearchMenu {
    private final VehicleService vehicleService;

    public SearchMenu(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
    
    public void processMenuForSearch(){
        boolean stop = false;
        try {
            do {
                Menu.print("******Search Menu******|1.Search by name|2.Search by ID|3.Return to main menu|Select: ");
                int choice = Menu.getUserChoice();
                switch (choice) {
                    case 1 -> {
                        vehicleService.searchByName();
                    }
                    case 2 -> {
                        vehicleService.searchByID();
                    }
                    case 3 -> {
                        stop = true;
                    }
                    default ->
                        System.out.println("Invalid input");
                }
            } while (!stop);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
