package service;
import connector.Conexion_MV;
import model.anime;


import java.sql.*;
import java.util.List;

public class animeService {


    public static void insertar(anime Anime) {
        String sql = "INSERT INTO anime (nome, descripcion,data,puntuacion) VALUES (?,?,?,?)";
        try (Connection coneccion = Conexion_MV.getConnection();
             PreparedStatement toInsert = coneccion.prepareStatement(sql)
        ) {
            toInsert.setString(1, Anime.getNombre());
            toInsert.setString(2, Anime.getDescripcion());
            toInsert.setDate(3, Anime.getData());
            toInsert.setInt(4, Anime.getPuntuacion());
            toInsert.executeUpdate();
            System.out.println("añadido con exito");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    public static void lerTodos() {
        String sql = "SELECT * FROM anime";
        try (Connection coneccion = Conexion_MV.getConnection();
             PreparedStatement toInsert = coneccion.prepareStatement(sql);
             ResultSet resultado = toInsert.executeQuery();
        ) {
            while (resultado.next()) {
                System.out.println("Nome: " + resultado.getString("nome"));
                System.out.println("Descripcion  " + resultado.getString("descripcion"));
                System.out.println("Date: " + resultado.getDate("data"));
                System.out.println("puntuacion: " + resultado.getInt("puntuacion"));

            }
            System.out.println("leido con exito");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }




    }

    public static void  lerPorNome(anime Anime) {
    String sql = "SELECT * FROM anime WHERE nome = ?";
        try (Connection coneccion = Conexion_MV.getConnection();
             PreparedStatement toInsert = coneccion.prepareStatement(sql);

        ) {
            toInsert.setString(1, Anime.getNombre());
            try(ResultSet resultado = toInsert.executeQuery()){
                while (resultado.next()) {
                    System.out.println("Nome: " + resultado.getString("nome"));
                    System.out.println("Descripcion  " + resultado.getString("descripcion"));
                    System.out.println("Date: " + resultado.getDate("data"));
                    System.out.println("puntuacion: " + resultado.getInt("puntuacion"));
                }

            }

            System.out.println("leido con exito");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    public static void actualizar(String nomeOriginal, anime Nuevo) {
        String sql = "UPDATE anime SET nome = ?, descripcion = ?, data = ?, puntuacion = ? WHERE nome = ?";
        try (Connection coneccion = Conexion_MV.getConnection();
             PreparedStatement toUpdate = coneccion.prepareStatement(sql)
        ) {
            toUpdate.setString(1, Nuevo.getNombre());
            toUpdate.setString(2, Nuevo.getDescripcion());
            toUpdate.setDate(3, Nuevo.getData());
            toUpdate.setInt(4, Nuevo.getPuntuacion());
            toUpdate.setString(5, nomeOriginal);

            toUpdate.executeUpdate();
            System.out.println("actualizar con exito");
            lerPorNome(Nuevo);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public  static void eliminar(String nome) {
        String sql = "DELETE FROM anime WHERE nome = ?";

        try (Connection coneccion = Conexion_MV.getConnection();
             PreparedStatement ps = coneccion.prepareStatement(sql)) {

            ps.setString(1, nome);

            ps.executeUpdate();
            System.out.println("Anime eliminado con éxito.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }





    }


}
