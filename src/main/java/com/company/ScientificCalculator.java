package com.company;
import java.util.Scanner;
import java.util.Stack;
public class ScientificCalculator implements Super {
    private float x, result;
    public ScientificCalculator(){}
    public void setValue(float value) {
        this.x = value;
    }
    public float getResult() {
        return result;
    }
    double roundDigits(double num){
        num*=1000;
        double r =Math.floor(Math.round(num));
        return r/1000;
    }
    public float normalTrigonometricFunction(byte choice) {
        switch (choice) {
            case 1 -> result = (float) roundDigits(Math.sin(x));
            case 2 -> result = (float) roundDigits(Math.cos(x));
            case 3 -> result = (float) roundDigits(Math.tan(x));
            case 4 -> result = (float) roundDigits(1/Math.tan(x));
            case 5 -> result = (float) roundDigits(1/Math.cos(x));
            case 6 -> result = (float) roundDigits(1/Math.sin(x));
            default -> {
                System.out.println("Invalid input\nEnter again");
                normalTrigonometricFunction(new Scanner(System.in).nextByte());
            }
        }
        return result;
    }
    public float arcTrigonometricFunction(byte choice) {
        switch (choice) {
            case 1 -> result = (float) roundDigits(Math.toDegrees(Math.asin(x)));
            case 2 -> result = (float) roundDigits(Math.toDegrees(Math.acos(x)));
            case 3 -> result = (float) roundDigits(Math.toDegrees(Math.atan(x)));
            default -> System.out.println("Invalid input");
        }
        return result;
    }
    public float hyperbolicTrigonometricFunction(byte choice) {
        switch (choice) {
            case 1 -> result = (float) roundDigits(Math.sinh(x));
            case 2 -> result = (float) roundDigits(Math.cosh(x));
            case 3 -> result = (float) roundDigits(Math.tanh(x));
            default -> System.out.println("Invalid input");
        }
        return result;
    }
    public void trigonometricFunction(byte ch) {
        switch (ch) {
            case 1 -> {
                System.out.println("Enter angle in Degree");
                setValue((float) Math.toRadians(new Scanner(System.in).nextFloat()));
                System.out.println("Enter function which you need :-\n\n==> 1. sin\n==> 2. cos\n==> 3. tan\n==> 4. cot\n==> 5. sec\n==> 6. csc\n\n0. Exit\n");
                result = normalTrigonometricFunction(new Scanner(System.in).nextByte());
            }
            case 2 -> {
                System.out.println("Enter value");
                setValue(new Scanner(System.in).nextFloat());
                System.out.println("Enter arc function which you need :-\n\n==> 1. sin\n==> 2. cos\n==> 3. tan");
                result = arcTrigonometricFunction(new Scanner(System.in).nextByte());
            }
            case 3 -> {
                System.out.println("Enter angle in Degree");
                setValue((float) Math.toRadians(new Scanner(System.in).nextFloat()));
                System.out.println("Enter hyperbolic function which you need :-\n\n==> 1. sin\n==> 2. cos\n==> 3. tan");
                result = hyperbolicTrigonometricFunction(new Scanner(System.in).nextByte());
            }
            default -> System.out.println("Invalid input");
        }
    }
    public float otherOperations(byte ch) {
        switch (ch) {
            case 1 -> {
                System.out.println("Enter value");
                result = (float) Math.sqrt(new Scanner(System.in).nextFloat());
            }
            case 2 -> {
                System.out.println("Enter base to power");
                result = (float) Math.pow(new Scanner(System.in).nextFloat(), new Scanner(System.in).nextFloat());
            }
            case 3 -> {
                System.out.println("Enter value");
                result = Math.abs(new Scanner(System.in).nextFloat());
            }
            case 4 -> {
                System.out.println("Enter value");
                result = (float) Math.round(new Scanner(System.in).nextFloat());
            }
            case 5 -> {
                System.out.println("Enter value");
                result = (float) Math.ceil(new Scanner(System.in).nextFloat());
            }
            case 6 -> {
                System.out.println("Enter value");
                result = (float) Math.floor(new Scanner(System.in).nextFloat());
            }
            default -> System.out.println("Invalid input");
        }
        return result;
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
                System.out.println("Enter which Trigonometric Function :\n\n==> 1. Normal\n==> 2. Arc\n==> 3. Hyperbolic\n\n==> 0. Exit\n");
                trigonometricFunction(new Scanner(System.in).nextByte());
            }
            case 2 -> {
                System.out.println("Enter choice :\n\n==> 1. Square Root\n2. Power Function\n==> 3. Absolute Value\n==> 4. Round\n==> 5. Smallest Integer Value\n==> 6. Largest Integer Value\n\n==> 0. Exit\n");
                result = otherOperations(new Scanner(System.in).nextByte());
            }
            default -> {
                System.out.println("Enter again");
                choice(new Scanner(System.in).nextByte());
            }
        }
        history(result);
    }
    @Override
    public boolean isFound(double num) {
        return sk.search(num) != -1;
    }
}