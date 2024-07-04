import java.sql.*;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*Cadena de conexión*/
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/clase";
        String user = "root";
        String password = "123456";
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            System.out.println("Conectado a la base de datos");
            System.out.print("Ingrese la cedula a buscar: ");
            int cedula = sc.nextInt();
            String query = "select * from estudiantes where cedula=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, cedula);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("Nombre: "+rs.getString("nombre"));
                int nota1 = rs.getInt("b1");
                int nota2 = rs.getInt("b2");
                int nota3 = nota1+nota2;
                if (nota3<28){
                    System.out.println("No paso");
                } else {
                    System.out.println("Paso");
                }
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}