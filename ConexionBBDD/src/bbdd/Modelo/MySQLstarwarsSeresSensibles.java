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
public class MySQLstarwarsSeresSensibles extends ConexionStarWars {

	private final ObservableList<starwarsSeresSensibles> listaDatos;
	
	
	public MySQLstarwarsSeresSensibles(String server, String bbdd, String user, String passwd, String consulta) {
		super(server, bbdd, user, passwd, consulta);
		this.listaDatos = MySQL2FX(this.getDatosBBDD());
	}

	public MySQLstarwarsSeresSensibles(String consulta) {
		super(consulta);
		this.listaDatos = MySQL2FX(this.getDatosBBDD());
	}
	private ObservableList<starwarsSeresSensibles> MySQL2FX(ResultSet datos){
		ObservableList<starwarsSeresSensibles> Outlist = FXCollections.observableArrayList();
		try {
			while(datos.next()) {
				String Nombre = datos.getString("Nombre");
				String Sabiduria = datos.getString("Sabiduria");
				starwarsSeresSensibles dat = new starwarsSeresSensibles(Nombre, Sabiduria);
				Outlist.add(dat);
			}
		}catch(SQLException excepcion) {
			System.out.println("SQLExcepcion: " + excepcion.getMessage());
			System.out.println("SQLState: " + excepcion.getSQLState());
			System.out.println("SQLError: " + excepcion.getErrorCode());
		}
		return Outlist;
	}
	public ObservableList<starwarsSeresSensibles> getObservableList(){
		return this.listaDatos;
	}

}
