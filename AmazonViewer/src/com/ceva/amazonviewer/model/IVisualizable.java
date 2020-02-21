/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceva.amazonviewer.model;

import java.util.Date;

/**
 *
 * 
 */
public interface IVisualizable {
    /**
     * Este metodo captura el tiempo exacto de inicio de visualizacion
     * @param dateI es un objeto {@code Date} con el tiempo de inicio exacto
     * @return Devuelve la fecha y hora capturada
     */
    Date startToSee(Date dateI);
    
    /**
     * Este metodo captura el tiempo exacto de inicio y fin de visualizacion
     * @param dateI es un objeto {@code Date} con el tiempo de inicio exacto
     * @param dateF es un objeto {@code Date} con el tiempo de fin exacto
     */
    void stopToSee(Date dateI, Date dateF);
}
