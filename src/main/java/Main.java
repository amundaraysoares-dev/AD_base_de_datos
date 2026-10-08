import connector.Conexion_MV;
import service.animeService;
import java.text.SimpleDateFormat;
import java.sql.Date;
import model.anime;

public class Main {

    public static Date stringToDate(String dataStr) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            java.util.Date dataUtil = formato.parse(dataStr);
            return new Date(dataUtil.getTime());
        } catch (Exception e) {
            System.out.println("petou: " + e.getMessage());
            return null;
        }
    }

    static void main(String[] args) {
        anime JoJo = new anime(
                "JoJo",
                "es una historia multigeneracional que narra la lucha de la familia Joestar contra fuerzas sobrenaturales y villanos a lo largo de distintas épocas",
                stringToDate("06/10/2012"),
                10
        );
//        animeService.insertar(quintillizas);
//        animeService.lerTodos();
//        animeService.lerPorNome(quintillizas);
//        animeService.actualizar("Las Quintillizas",JoJo);
//        animeService.eliminar("JoJo");




    }
}
