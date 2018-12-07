import java.sql.*;

public class App {
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://10.0.10.3:3306/baza";
   // Rafał Pędzisz
   static final String USER = "rpedzisz"; 
   static final String PASS = "abc";
   
   public static void main(String[] args) {
	   boolean czybazaonline = false;
   Connection conn = null;
   Statement stmt = null;
	  System.out.println("Sprawdzanie połączenia z bazą"); 
	   
	   while (czybazaonline == false) // sprawdzanie czy baza jest online
	   {
		try{
      		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Baza Online");
			czybazaonline = true;
			
			conn.close();
		}
		catch(SQLException se){
			
      			System.out.println("Baza Offline");
			
   		}
		catch(Exception e){
			System.out.println("Baza Offline");
      		
   		}
		   
		  TimeUnit.SECONDS.sleep(2); // sprawdzanie połączenia z bazą co 2s 
	   }
	   
	   
	   
	   
	 	   
	if (czybazaonline == true)   // jeśli baza jest online to wykonywanie zapytań
	{
   try{
      Class.forName(JDBC_DRIVER);

      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
	   System.out.println("Create Table...");
stmt.executeUpdate("CREATE TABLE Tabela (id int, Dane1 varchar(255), Dane2 varchar(255));"); // Stworzenie tabeli
	   System.out.println("Insert...");
stmt.executeUpdate("INSERT INTO Tabela  (id, Dane1, Dane2) VALUES (3, 'jakiesdane1', 'jakiesdane2');"); //dodanie jakichś danych	   
stmt.executeUpdate("INSERT INTO Tabela  (id, Dane1, Dane2) VALUES (7, 'jakiesdane132', 'jakiesdane243');"); //dodanie jakichś danych
stmt.executeUpdate("INSERT INTO Tabela  (id, Dane1, Dane2) VALUES (14, 'jakiesdane13432', 'jakiesdane243443');"); //dodanie jakichś danych
			    System.out.println("Select...");  
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
   }finally
	   
   {
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
	
}

