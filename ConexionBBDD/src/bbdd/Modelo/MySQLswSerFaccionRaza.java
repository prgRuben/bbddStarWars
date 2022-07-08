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
public class MySQLswSerFaccionRaza extends ConexionStarWars {

	private final ObservableList<starwarsSerFaccionRaza> listaDatos;

	public MySQLswSerFaccionRaza(String server, String bbdd, String user, String passwd, String consulta) {
		super(server, bbdd, user, passwd, consulta);
		this.listaDatos = MySQL2FX(this.getDatosBBDD());
	}
	public MySQLswSerFaccionRaza(String consulta) {
		super(consulta);
		this.listaDatos = MySQL2FX(this.getDatosBBDD());
	}
	private ObservableList<starwarsSerFaccionRaza> MySQL2FX(ResultSet datos){
		ObservableList<starwarsSerFaccionRaza> Outlist = FXCollections.observableArrayList();
		try {
			while(datos.next()) {
				String nombreSer = datos.getString("Nombre");
				String faccion = datos.getString("Faccion");
				String raza = datos.getString("Raza");
				starwarsSerFaccionRaza dat = new starwarsSerFaccionRaza(nombreSer, faccion, raza);
				Outlist.add(dat);
			}
		}catch(SQLException excepcion) {
			System.out.println("SQLExcepcion: " + excepcion.getMessage());
			System.out.println("SQLState: " + excepcion.getSQLState());
			System.out.println("SQLError: " + excepcion.getErrorCode());
		}
		return Outlist;
	}
	public ObservableList<starwarsSerFaccionRaza> getObservableList(){
		return this.listaDatos;
	}

}
