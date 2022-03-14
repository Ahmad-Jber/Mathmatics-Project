package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("\nSelect your calculator :-\n\n==> 1. Simple Calculator\n==> 2. Scientific Calculator\n==> 3. Game\n\n==> 0. Exit\n");
            byte choice = new Scanner(System.in).nextByte();
            switch (choice) {
                case 1 -> {
                    Super.sk.clear();
                    while (true) {
                        System.out.println("\nEnter choice :-\n\n==> 1. sum\n==> 2. sub\n==> 3. multi\n==> 4. divide\n==> 5. mouduls\n\n==> 0. Exit\n");
                        byte oper = new Scanner(System.in).nextByte();
                        if (oper == 0) {
                            break;
                        } else {
                            if (oper == 1 || oper == 2 || oper == 3 || oper == 4 || oper == 5) {
                                System.out.println("\nEnter 1st number and 2nd number :\n\n");
                                SimpleCalculator simple = new SimpleCalculator(new Scanner(System.in).nextFloat(), oper, new Scanner(System.in).nextFloat());
                                simple.choice(oper);
                                System.out.println("The result = " + simple.getResult());
                            } else {
                                System.out.println("Invalid operation character");
                            }
                        }
                    }
                }
                case 2 -> {
                    Super.sk.clear();
                    while (true) {
                        System.out.println("\nEnter type of operation :-\n\n==> 1. Trigonometric Function\n==> 2. Other Operations\n\n==> 0. Exit\n");
                        choice = new Scanner(System.in).nextByte();
                        if (choice == 0) {
                            break;
                        } else {
                            ScientificCalculator sc = new ScientificCalculator();
                            if (choice == 1 || choice == 2) {
                                sc.choice(choice);
                                System.out.println("The result = " + sc.getResult());
                            } else {
                                System.out.println("Invalid input");
                            }
                        }
                    }
                }
                case 3 -> {
                    Super.sk.clear();
                    while (true) {
                        Game g = new Game();
                        System.out.println("Enter how many time you want to play or 0 to  go back :\n===>");
                        g.setAttempt(new Scanner(System.in).nextByte());
                        if (g.getAttempt()==0) break;
                        while (true) {
                            if (g.getAttempt() == 0) {
                                break;
                            } else {
                                System.out.println("Enter type of game :\n==> 1. Guess the number\n==> 2. Multiplication table\n\n==> 0. Exit");
                                g.choice(new Scanner(System.in).nextByte());
                            }
                        }
                    }
                }
                case 0 -> {
                    System.out.println("Do you want to exit?");
                    System.out.println("y. Yes\t\tn. No");
                    switch (new Scanner(System.in).next().charAt(0)) {
                        case 'y' -> System.exit(0);
                        case 'n' -> {continue;}
                        default -> System.out.println("Invalid input\n\n");
                    }
                }
                default -> System.out.println("Invalid choice select again");
            }
        }
    }
}