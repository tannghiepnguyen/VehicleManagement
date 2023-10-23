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
public class PrintMenu {
    private final VehicleService vehicleService;

    public PrintMenu(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
    
    public void processMenuForPrint(){
        boolean stop = false;
        try {
            do {
                Menu.print("******Print Menu******|1.Print all|2.Print by year|3.Return to main menu|Select: ");
                int choice = Menu.getUserChoice();
                switch (choice) {
                    case 1 -> {
                        vehicleService.displayAll();
                    }
                    case 2 -> {
                        vehicleService.printByYear();
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
