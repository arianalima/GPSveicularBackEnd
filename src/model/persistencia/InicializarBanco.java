package model.persistencia;

import java.sql.*;
import java.util.Date;



public class InicializarBanco {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/";
	
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "";
	
	public static void main(String[] args) {
		try {
			InicializarBanco inicializar = new InicializarBanco();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public InicializarBanco() throws SQLException{
		inicializarBanco();
	}
	
	
	public void inicializarBanco() throws SQLException{
		Connection conn = null;
		Statement stmt = null;
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			//STEP 3: Open a connection
		    conn = DriverManager.getConnection(DB_URL, USER, PASS);
		   
		    //STEP 4: Execute a query
		    stmt = conn.createStatement();

		    String sql = "drop schema if exists gpscircular;";
		    stmt.executeUpdate(sql);
		    		    
		    String sql1 = "CREATE SCHEMA if not exists gpscircular;";
		    stmt.executeUpdate(sql1);
		    
		    String sql2 = "ALTER DATABASE gpscircular CHARACTER SET utf8 COLLATE utf8_unicode_ci ;";
		    stmt.executeUpdate(sql2);
		    
		    String sql3 = "use gpscircular;";
		    stmt.executeUpdate(sql3);
		    
		    String sql31 = "SET @@global.time_zone = '-3:00';";
		    stmt.executeUpdate(sql31);
		    
		    String sql4 = "CREATE TABLE gpscircular.localizacao ("
		    		+ "id int(50) NOT NULL AUTO_INCREMENT,"
		    		+ "idNode int(50) NOT NULL,"
		    		+ "utf_time datetime,"
		    		+ "altitude int(50),"
		    		+ "direcao float(50),"
		    		+ "velocidade float(50),"
		    		+ "satelites int(50),"
		    		+ "latitude float(50),"
		    		+ "longitude float(50),"
		    		+ "PRIMARY KEY (id)"
		    		+ ") ENGINE=innoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ;";
		    stmt.executeUpdate(sql4);
		    
		    }catch(SQLException se){
		    	//Handle errors for JDBC
		        se.printStackTrace();
		    }catch(Exception e){
		    	//Handle errors for Class.forName
		    	e.printStackTrace();
		    }finally{
		    	//finally block used to close resources
		    	try{
		    		if(stmt!=null)
		    			stmt.close();
		    	}catch(SQLException se2){
		    	}// nothing we can do
		    	try{
		    		if(conn!=null)
		    			conn.close();
		    	}catch(SQLException se){
		    		se.printStackTrace();
		    	}//end finally try
		    }//end try
	}
	
}