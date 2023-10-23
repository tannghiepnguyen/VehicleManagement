/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application.UI;

import Application.Ultility.DataInput;
import Business.Service.VehicleService;
import java.util.Arrays;

/**
 *
 * @author tanng
 */
public class Menu {
    public static void print(String str) {
        var menuList = Arrays.asList(str.split("\\|"));
        menuList.forEach(menuItem -> {
            if (menuItem.equalsIgnoreCase("Select")) {
                System.out.print(menuItem);
            } else {
                System.out.println(menuItem);
            }

        });
    }
    
    public static int getUserChoice() {
        int number = 0;
        try {
            number = DataInput.getIntegerNumber();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return number;
    }
    
    public static void managePrint(VehicleService vehicleService){
        PrintMenu printMenu = new PrintMenu(vehicleService);
        printMenu.processMenuForPrint();
    }
    
    public static void manageDisplay(VehicleService vehicleService){
        DisplayMenu displayMenu = new DisplayMenu(vehicleService);
        displayMenu.processMenuForDisplay();
    }
    
    public static void manageSearch(VehicleService vehicleService){
        SearchMenu searchMenu = new SearchMenu(vehicleService);
        searchMenu.processMenuForSearch();
    }
}
