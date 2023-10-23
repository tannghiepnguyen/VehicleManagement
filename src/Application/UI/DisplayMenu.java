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
public class DisplayMenu {

    private final VehicleService vehicleService;

    public DisplayMenu(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public void processMenuForDisplay() {
        boolean stop = false;
        try {
            do {
                Menu.print("******Display Menu******|1.Show all|2.Show by price|3.Return to main menu|Select: ");
                int choice = Menu.getUserChoice();
                switch (choice) {
                    case 1 -> {
                        vehicleService.displayAll();
                    }
                    case 2 -> {
                        vehicleService.displayByPrice();
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
