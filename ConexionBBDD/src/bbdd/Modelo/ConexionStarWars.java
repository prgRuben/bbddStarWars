/**
 * 
 */
package bbdd.Modelo;
import java.sql.*;

/**
 * @author Ruben
 *
 */
public class ConexionStarWars {

	/**
	 * Conexion a la Base de Datos
	 */
	
	private String Server = "127.0.0.1";
	private String BBDD = "starwars";
	private String user = "root";
	private String passwd = "1234";
	private String consulta;
	private ResultSet datosBBDD;
	
	
	public ConexionStarWars(String server, String bbdd, String user, String passwd, String consulta) {
		this.Server = server;
		this.BBDD = bbdd;
		this.user = user;
		this.passwd = passwd;
		this.consulta = consulta;
		
		String conexionString = creaCadenaConexion(this.Server,this.BBDD,this.user,this.passwd);
		this.datosBBDD = enviarConsultMySQL(conexionString, consulta);
	}
	
	public ConexionStarWars(String consulta) {
		String conexionString = creaCadenaConexion(this.Server,this.BBDD,this.user,this.passwd);
		this.datosBBDD = enviarConsultMySQL(conexionString, consulta);
	}
	public void actualizarDatosBBDD() {
		String conexionString = creaCadenaConexion(this.Server,this.BBDD,this.user,this.passwd);
		this.datosBBDD = enviarConsultMySQL(conexionString, consulta);
	}
	public ResultSet getDatosBBDD() {
		return this.datosBBDD;
	}

	private String creaCadenaConexion(String server, String bbdd, String user, String passwd) {
		String cadenaConexion = "";
		cadenaConexion ="jdbc:mysql://"+server+"/"+bbdd+"?";
		cadenaConexion += "user="+user+"&password="+passwd+"&useLegacyDatetimeCode=false";
		cadenaConexion += "&useUnicode=true&useJDBCCompliantTimezoneShift=true";
		cadenaConexion +="&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
		return cadenaConexion;
	}
	private ResultSet enviarConsultMySQL(String conexionString, String consulta) {
		Statement objetoConsulta = null;
		ResultSet objResultadoConsulta = null;
		try {
			Connection objetoConexion = DriverManager.getConnection(conexionString);
			objetoConsulta = objetoConexion.createStatement();
			objResultadoConsulta = objetoConsulta.executeQuery(consulta);
		}catch(SQLException excepcion) {
			System.out.println("SQLException: " + excepcion.getMessage());
			System.out.println("SQLState: " + excepcion.getSQLState());
			System.out.println("SQLError: " + excepcion.getErrorCode());
		}
		return objResultadoConsulta;
	}
}
