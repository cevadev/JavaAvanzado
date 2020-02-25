/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceva.amazonviewer.db;

/**
 *
 * @author PC
 */
public class DataBase {
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/";
    public static final String DB = "amazonviewer";
    public static final String USER = "root";
    public static final String PASSWORD = "admin";
    
    public static final String TMOVIE   = "movie";
    public static final String TMOVIE_ID   = "id";
    public static final String TMOVIE_TITLE   = "title";
    public static final String TMOVIE_GENRE   = "genre";
    public static final String TMOVIE_CREATOR   = "creator";
    public static final String TMOVIE_DURATION   = "duration";
    public static final String TMOVIE_YEAR   = "year";
    
    public static final String TMATERIAL   = "material";
    public static final int[] ID_MATERIALS   = {1,2,3,4,5};
    
    public static final String TUSER   = "user";
    public static final int TUSER_IDUSUARIO   = 1;
    
    public static final String TVIEWED   = "viewed";
    public static final String TVIEWED_IDMATERIAL   = "id_material";
    public static final String TVIEWED_IDELEMENT   = "id_element";
    public static final String TVIEWED_IDUSUARIO   = "id_user";
}
