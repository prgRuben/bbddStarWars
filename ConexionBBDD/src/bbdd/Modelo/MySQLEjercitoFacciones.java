/**
 * 
 */
package bbdd.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Rubén
 *
 */
public class MySQLEjercitoFacciones extends ConexionStarWars {

	private final ObservableList<starwarsEjercitoFacciones> listaDatos;
	
	public MySQLEjercitoFacciones(String server, String bbdd, String user, String passwd, String consulta) {
		super(server, bbdd, user, passwd, consulta);
		this.listaDatos = MySQL2FX(this.getDatosBBDD());
	}
	public MySQLEjercitoFacciones(String consulta) {
		super(consulta);
		this.listaDatos = MySQL2FX(this.getDatosBBDD());
	}
	private ObservableList<starwarsEjercitoFacciones> MySQL2FX(ResultSet datos){	
		ObservableList<starwarsEjercitoFacciones> Outlist = FXCollections.observableArrayList();
		int numResultados = 0;
		try {
			if(datos.last()) {
				numResultados = datos.getRow();
				datos.beforeFirst();
			}
			if(numResultados>0) {
				while(datos.next()) {
					starwarsEjercitoFacciones dat = new starwarsEjercitoFacciones(
															datos.getInt("ID"),
															new String (datos.getString("Faccion")),
															datos.getString("Soldado"),
															datos.getString("Vehiculo")
															
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
	public ObservableList<starwarsEjercitoFacciones> getObservableList(){
		return this.listaDatos;
	}
}
