
/**
 *
 * @author elena
 */
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

public class MusicDB {
private static final String DATABASE_URL = "jdbc:sqlite:music_artists.sqlite";
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DATABASE_URL);
    }
    
    public static List<Artist>getAllArtists()throws SQLException{
        List<Artist>artists=new ArrayList<>();
        
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM artists")){
            while(resultSet.next()){
                String artistName = resultSet.getString("name");
                Artist artist = new Artist(artistName);
                artists.add(artist);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
       return artists;         
    }
    
    public static List <Album> getAllAlbums()throws SQLException{
        List<Album>albums = new ArrayList<>();
        
        try (Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM album")){
            while(resultSet.next()){
                String albumName = resultSet.getString("name");
                Album album = new Album(albumName);
                albums.add(album);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        } return albums;         
    }
    public static void populateAlbumsForArtists(List<Artist> artists)throws SQLException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM artist_album")) {
            while (resultSet.next()) {
                String artistName = resultSet.getString("artist_name");
                String albumName = resultSet.getString("album_name");
                Artist artist = findArtistByName(artists, artistName);
                if (artist != null) {
                    Album album = findAlbumByName(artist.getAlbums(), albumName);
                    if (album != null) {
                        artist.addAlbum(album);
                    }
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    private static Artist findArtistByName(List<Artist> artists, String name) {
    for (Artist artist : artists) {
        if (artist.getName().equals(name)) {
            return artist;
        }
    }
    return null;
}

    
    private static Album findAlbumByName(List<Album> albums, String name){
        for(Album album: albums){
            if(album.getName().equals(name)){
                return album;
            }
        }return null;
    }
}//end MusicDB
