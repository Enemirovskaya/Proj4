

//import proj4.Artist;
//import proj4.Album;
//import proj4.MusicDB;
//import java.sql.*;
//import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author elena
 */
public class Proj4 {

    
    public static void main(String[] args) {
        try {
            List<Artist> artists = MusicDB.getAllArtists();
            List<Album> albums = MusicDB.getAllAlbums();
            MusicDB.populateAlbumsForArtists(artists);

            Collections.sort(artists, (a1, a2) ->
                    a1.getName().compareToIgnoreCase(a2.getName()));
            Collections.sort(albums, (a1, a2) ->
                    a1.getName().compareToIgnoreCase(a2.getName()));

            System.out.println("Artists");
            for (Artist artist : artists) {
                System.out.println(artist.getName());
            }

            System.out.println("Albums");
            for (Album album : albums) {
                System.out.println(album.getName());
            }

            System.out.println("Albums by Artist");
            for (Artist artist : artists) {
                System.out.println(artist.getName());
                for (Album album : artist.getAlbums()) {
                    System.out.println(album.getName());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}