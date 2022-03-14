package com.company;
import java.util.Scanner;
public class Game implements Super {
    private float result;
    private byte attempt;
    int count=attempt+1 ;
    public byte getAttempt() {
        return attempt;
    }
    public void setAttempt(byte attempt) {
        this.attempt = attempt;
    }
    public boolean hasNextAttempt(byte attempt) {
        return attempt > 0;
    }
    public void fix1(byte inNumber) {
        if (hasNextAttempt(attempt)) {
            if (inNumber == sysNumber) {
                System.out.println("Congratulation , you won !!!!");
            } else {
                --attempt;
                System.out.println("Wrong answer, you have " + attempt + " attempt");
                System.out.println("Please try again");
                history(inNumber);
            }
        } else {
            System.out.println("Sorry you lose");
        }
    }
    public void fix2() {
        for (int i = 1; i <= 10; i++) {
            if (attempt == 0){
                System.out.println("You lose");
                break;
        }else{
                for (int j = 1; j <= 10; j++) {
                    if (hasNextAttempt(attempt)) {
                        System.out.println(i + " * " + j + " = ");
                        result = new Scanner(System.in).nextFloat();

                        if (result == i * j) {
                            System.out.println("You won!!!!!");

                        } else {
                            --attempt;
                            System.out.println("Wrong answer, you have " + attempt + " attempt");
                            history(result);
                        }
                    } else {
                        System.out.println("You lose");
                        break;
                    }
                }
            }
        }
    }
    @Override
    public void history(float x) {
        if (isFound(x)) {
            System.out.println("Your input value is already existing");
        } else {
            sk.push(x);
            System.out.println(sk);
        }
    }
    @Override
    public void choice(byte ch) {
        switch (ch) {
            case 1 -> {
                System.out.print("Enter number between 1 to 10 :\n===>");
                fix1(new Scanner(System.in).nextByte());
            }
            case 2 -> fix2();
            default -> {
                System.out.println("Enter again");
                choice(new Scanner(System.in).nextByte());
            }
        }
    }
    @Override
    public boolean isFound(double num) {
        return sk.search(num) > -1;
    }
}