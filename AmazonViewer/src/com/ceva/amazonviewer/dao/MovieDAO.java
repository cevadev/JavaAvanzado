/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceva.amazonviewer.dao;

import com.ceva.amazonviewer.db.DataBase;
import com.ceva.amazonviewer.db.IDBConnection;
import com.ceva.amazonviewer.model.Movie;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.ceva.amazonviewer.db.DataBase.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author PC
 */
public interface MovieDAO extends IDBConnection{
       
    default ArrayList<Movie> read()
    {
        ArrayList<Movie> movies = new ArrayList<>();
        try(Connection connection = connectToDB())
        {
            String sql = "SELECT * FROM " + DataBase.TMOVIE;
            PreparedStatement pstmt =  connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                Movie movie = new Movie(
                        rs.getString(TMOVIE_TITLE), 
                        rs.getString(TMOVIE_GENRE), 
                        rs.getString(TMOVIE_CREATOR), 
                        Integer.valueOf(rs.getString(TMOVIE_DURATION)), 
                        Short.valueOf(rs.getString(TMOVIE_YEAR)));
                movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));
                movie.setViewed(getMovieViewed(pstmt, connection, Integer.valueOf(rs.getString(TMOVIE_ID))));
                movies.add(movie);
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return movies;
    }
    
    default Movie setMovieViewed(Movie movie)
    {
        String sql = "INSERT INTO " + TVIEWED + "(id_material, id_element, id_user)" + " values(?, ?, ?)";
        try(Connection connection = connectToDB())
        {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, ID_MATERIALS[0]);
            pstmt.setInt(2, movie.getId());
            pstmt.setInt(3, TUSER_IDUSUARIO);
            
            int rpta = pstmt.executeUpdate();
            
            if(rpta > 0)
            {
                System.out.println("Se marco en visto");
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return movie;
    }
    
    //seleccionamos las peliculas vistas
    default boolean getMovieViewed(PreparedStatement pstmt, Connection connection, int id_movie)
    {
        boolean viewed = false; // variable que indica si la pelicula fue vista
        String sql = "SELECT * FROM " + TVIEWED + " WHERE " + TVIEWED_IDMATERIAL + " = ?"+
                " AND " + TVIEWED_IDELEMENT + " = ?" + 
                " AND " + TVIEWED_IDUSUARIO + " = ?";
        ResultSet rs = null;
        try
        {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, ID_MATERIALS[0]);
            pstmt.setInt(2, id_movie);
            pstmt.setInt(3, TUSER_IDUSUARIO);
            
            rs = pstmt.executeQuery();
            viewed = rs.next(); //si hay un registro quiere decir que la pelicula fue vista
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        return viewed;
    }
}
