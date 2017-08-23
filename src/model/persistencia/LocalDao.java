package model.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.Connection;

import model.dominio.LocalCircular;

public class LocalDao {
	
	public String addLocal(LocalCircular local) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		String query = "insert into gpscircular.localizacao (localizacao.idNode, localizacao.utf_time, "
				+ "localizacao.altitude, localizacao.direcao, localizacao.velocidade, localizacao.satelites, "
				+ "localizacao.latitude, localizacao.longitude) values ( ?, ?, ?, ?, ?, ?, ?, ?);";
		try{	
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, local.getId());
			java.sql.Date novaData = new java.sql.Date(local.getUtf_time().getTime());
			stmt.setDate(2, novaData);
			stmt.setInt(3, local.getAltitude());
			stmt.setFloat(4, local.getDiracao());
			stmt.setFloat(5, local.getVelocidade());
			stmt.setInt(6, local.getSatelites());
			stmt.setFloat(7, local.getLatitude());
			stmt.setFloat(8, local.getLongitude());
			
			stmt.executeUpdate();
			return "sucesso";
		}catch (SQLException ex){
			return "falha";
		}
		finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
	}
	
	public LocalCircular getUltimoLocal() {
		LocalCircular localCircular;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String consulta = "SELECT * FROM gpscircular.localizacao;";
		try{	
			stmt = connection.prepareStatement(consulta);
			resultSet = stmt.executeQuery();
			
			
			while (resultSet.next()){
				localCircular = new LocalCircular();
				localCircular.setId(resultSet.getInt("idNode"));
				localCircular.setUtf_time(resultSet.getDate("utf_time"));
				localCircular.setAltitude(resultSet.getInt("altitude"));
				localCircular.setDiracao(resultSet.getFloat("direcao"));
				localCircular.setSatelites(resultSet.getInt("satelites"));
				localCircular.setLatitude(resultSet.getFloat("latitude"));
				localCircular.setLongitude(resultSet.getFloat("longitude"));
				
				return localCircular;
			}
			
			
		}catch (SQLException ex){
			return null;
		}
		finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		
		return null;
	}
	
}
