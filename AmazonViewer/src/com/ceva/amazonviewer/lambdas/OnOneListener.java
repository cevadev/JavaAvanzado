/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceva.amazonviewer.lambdas;

/**
 * Al momento que un usuario escriba el numero 1, imprime la opcion que el usuario escribio
 * @author PC
 */
@FunctionalInterface
public interface OnOneListener {
    void onOne(String message);
}
