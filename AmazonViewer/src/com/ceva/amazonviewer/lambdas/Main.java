/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceva.amazonviewer.lambdas;

/**
 *
 * @author PC
 */
public class Main {
    public static void main(String[] args) {
        OnOneListener onOneListener = new OnOneListener() {
            @Override
            public void onOne(String message) {
                System.out.println("One: " + message);
            }
        };
        
        //Lambda style
        OnOneListener onOneListener2 = (String message) -> 
        {
            System.out.println("One Lambda: " + message);
        };
        
        onOneListener.onOne("Prueba sin lambda :(");
        onOneListener2.onOne("Prueba con lambda :)");
        
        OnOneListener onOneListener3 = (String msg) -> System.out.println("Lambda como variable " + msg);
        onOneListener3.onOne("3");
    }
}
