/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Component;

import Business.Entity.Vehicle;
import java.util.List;

/**
 *
 * @author tanng
 */
public class DataValidation {
    public static boolean isValidID(String ID){
        return ID.matches("VE\\d{3}");
    }
    
    public static boolean isNumber(String number){
        return number.matches("\\d{1,}");
    }
    
    public static boolean isEmptyString(String str){
        return str.isEmpty();
    }
    
    public static boolean isExistID(List<Vehicle> vehicleList, String ID){
        for (Vehicle vehicle : vehicleList){
            if (vehicle.getID().equals(ID)){
                return true;
            }
        }
        return false;
    }
    
    public static boolean isValidDate(String fullDate) {
        String[] fullDateItem = fullDate.split("-");
        int dd = Integer.parseInt(fullDateItem[2]);
        int mm = Integer.parseInt(fullDateItem[1]);
        int yy = Integer.parseInt(fullDateItem[0]);
        if(mm>=1 && mm<=12)
        {
            //check days
            if((dd>=1 && dd<=31) && (mm==1 || mm==3 || mm==5 || mm==7 || mm==8 || mm==10 || mm==12))
                return true;
            else if((dd>=1 && dd<=30) && (mm==4 || mm==6 || mm==9 || mm==11))
                return true;
            else if((dd>=1 && dd<=28) && (mm==2))
                return true;
            else return dd==29 && mm==2 && (yy%400==0 ||(yy%4==0 && yy%100!=0));
        }
        else
        {
            return false;
        }
    }
}
