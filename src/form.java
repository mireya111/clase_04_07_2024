import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class form {
    private JButton boton;
    private JLabel nombre;
    public JPanel panel;

    public form() {
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url="jdbc:mysql://localhost:3306/estudiantes2024a";
                String user="root";
                String password="";

                try (Connection connection= DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectado a la base de datos");
                    String query="select * from estudiantes where cedula=1736492203";
                    Statement statement=connection.createStatement();
                    ResultSet resultSet=statement.executeQuery(query);
                    while(resultSet.next()){
                        System.out.println(resultSet.getString("nombre"));
                        nombre.setText(resultSet.getString("nombre"));
                    }
                }catch (SQLException e1){
                    System.out.println(e1);}
            }
        });
    }
}
