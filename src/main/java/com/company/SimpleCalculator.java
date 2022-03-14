package com.company;
import java.util.Scanner;
public class SimpleCalculator implements Super {
    private float num1, num2;
    private float result;
    private byte oper;
    public SimpleCalculator(){}
    public SimpleCalculator(float num1, byte oper, float num2){
        setNum1(num1);
        setOper(oper);
        setNum2(num2);
    }
    public void setNum1(float num1) {
        this.num1 = num1;
    }
    public void setNum2(float num2) {
        this.num2 = num2;
    }
    public float getResult() {
        return result;
    }
    public void setOper(byte oper) {
        this.oper = oper;
    }
    public float sum(){return num1 + num2;}
    public float sub(){return num1 - num2;}
    public float multi(){return num1 * num2;}
    public float divide(){return num1 / num2;}
    public float modules(){return num1 % num2;}
    @Override
    public void history(float x){
        if (isFound(x)){
            System.out.println("Your input value is already existing");
        }else{
            sk.push(x);
            System.out.println("Your values = " + sk);
        }
    }
    @Override
    public void choice(byte ch){
        switch (ch) {
            case 1 -> result = sum();
            case 2 -> result = sub();
            case 3 -> result = multi();
            case 4 -> result = divide();
            case 5 -> result = modules();
            default -> {
                System.out.println("Enter again");
                choice(new Scanner(System.in).nextByte());
            }
        }
        history(result);
    }
    @Override
    public boolean isFound(double num){return sk.search(num)!=-1;}
}