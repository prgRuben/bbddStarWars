/**
 * 
 */
package bbdd.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Ruben
 *
 */
public class MySQLstarwarsSeresPlanetaBatallado extends ConexionStarWars {

	private final ObservableList<starwarsSeresPlanetaBatallado> listaDatos;

	public MySQLstarwarsSeresPlanetaBatallado(String server, String bbdd, String user, String passwd, String consulta) {
		super(server, bbdd, user, passwd, consulta);
		this.listaDatos = MySQL2FX(this.getDatosBBDD());
	}
	public MySQLstarwarsSeresPlanetaBatallado(String consulta) {
		super(consulta);
		this.listaDatos = MySQL2FX(this.getDatosBBDD());
	}
	private ObservableList<starwarsSeresPlanetaBatallado> MySQL2FX(ResultSet datos){	
		ObservableList<starwarsSeresPlanetaBatallado> Outlist = FXCollections.observableArrayList();
		int numResultados = 0;
		try {
			if(datos.last()) {
				numResultados = datos.getRow();
				datos.beforeFirst();
			}
			if(numResultados>0) {
				while(datos.next()) {
					starwarsSeresPlanetaBatallado dat = new starwarsSeresPlanetaBatallado(
															datos.getInt("ID"),
															new String(datos.getString("Nombre_Ser")),
															new String(datos.getString("Facciones")),
															new String(datos.getString("Planeta_Batallado"))
															);
															Outlist.add(dat);
				}
			}
		}catch(SQLException excepcion) {
			System.out.println("SQLExcepcion: " + excepcion.getMessage());
			System.out.println("SQLState: " + excepcion.getSQLState());
			System.out.println("SQLError: " + excepcion.getErrorCode());
		}
		return Outlist;
	}
	public ObservableList<starwarsSeresPlanetaBatallado> getObservableList(){
		return this.listaDatos;
	}
}
