import javax.sql.ConnectionEvent;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
       final String URL = "jdbc:mysql://localhost:3306/cadaluno";
       final String USER = "root";
       final String PASSWORD = "root99";
       final String CONSULTA = "selec * from aluno";

       try {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection(URL, USER,PASSWORD);
           System.out.println("conectado!");

           Statement st = con.createStatement();
           System.out.println("Statemant criado!");

           String query = "insert into aluno (nome, matricula) values (?,?)";

           PreparedStatement stmt = con.prepareStatement(query);

           stmt.setString(1, "Felipe");
           stmt.setInt(2, 5678);


           int linhasAfetadas = stmt.executeUpdate();
           System.out.println("dados inseridos");

           ResultSet resultSet = stmt.executeQuery(CONSULTA);

           while (resultSet.next()){
               System.out.println(resultSet.getString("nome"));
               System.out.println(resultSet.getString("Matricula"));
           }


       } catch (Exception e){
           System.out.println(e);
           e.printStackTrace();
       }
    }
}