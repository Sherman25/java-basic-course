package model;

import javax.swing.*;
import java.util.Random;

public class Start {
    public static void main(String[] args) {
        Random random = new Random();
        int target = random.nextInt(10);
        int choice;
        while(true) {
            try {
                choice = Integer.parseInt(JOptionPane.showInputDialog("input your choice"));
                if(choice == target) {
                    System.out.println(choice + " was correct");
                    break;
                } else if(choice < target) {
                    System.out.println(choice + " is less than target");
                } else {
                    System.out.println(choice + " is greater than target");
                }
            }catch (NumberFormatException e) {
                e.printStackTrace();
            }

        }
    }
}
