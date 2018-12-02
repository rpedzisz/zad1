import java.sql.*;

public class App {
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://10.0.10.3:3306/baza";
   // Rafał Pędzisz
   static final String USER = "rpedzisz"; 
   static final String PASS = "abc";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
	  System.out.println("Przed blokiem try"); 
   try{
      Class.forName(JDBC_DRIVER);

      System.out.println("Łączenie...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
	   
stmt.executeUpdate("CREATE TABLE Tabela (id int, Dane1 varchar(255), Dane2 varchar(255));"); // Stworzenie tabeli
stmt.executeUpdate("INSERT INTO Tabela  (id, Dane1, Dane2) VALUES (3, 'jakiesdane1', 'jakiesdane2');"); //dodanie jakichś danych	   
stmt.executeUpdate("INSERT INTO Tabela  (id, Dane1, Dane2) VALUES (7, 'jakiesdane132', 'jakiesdane243');"); //dodanie jakichś danych
stmt.executeUpdate("INSERT INTO Tabela  (id, Dane1, Dane2) VALUES (14, 'jakiesdane13432', 'jakiesdane243443');"); //dodanie jakichś danych
ResultSet result = stmt.executeQuery("SELECT * FROM Tabela"); //select danych

      while(result.next()){
         int id  = result.getInt("id");
         String dane1 = result.getString("Dane1");
         String dane2 = result.getString("Dane2");
		 
         System.out.print("ID: " + id); // wyświetlenie danych
         System.out.print(", Dane1: " + dane1);
         System.out.print(", Dane1: " + dane2 +"\n");
		 
      }
      result.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){
      e.printStackTrace();
   }finally{
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
 }
	
}

