package com.company;
import java.util.Stack;
public interface Super {
    Stack sk = new Stack();
    byte sysNumber = (byte)(Math.random()*10);
    void history(float element);
    void choice(byte ch);
    boolean isFound(double num);
}
