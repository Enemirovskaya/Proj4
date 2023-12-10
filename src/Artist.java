/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author elena
 */
//import java.sql.*;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

public class Artist {
    private String name;
    private List <Album> albums;
    
    public Artist(String name){
        this.name = name;
        this.albums = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public List<Album>getAlbums(){
        return albums;
    }
    public void addAlbum(Album album) {
        albums.add(album);
    }
}//End Artist
