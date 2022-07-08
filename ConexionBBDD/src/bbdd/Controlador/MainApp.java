/**
 * 
 */
package bbdd.Controlador;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import bbdd.Modelo.MySQLEjercitoFacciones;
import bbdd.Modelo.MySQLstarwarsSeresPlanetaBatallado;
import bbdd.Modelo.MySQLstarwarsSeresSensibles;
import bbdd.Modelo.MySQLswSerFaccionRaza;
import bbdd.Modelo.starwarsEjercitoFacciones;
import bbdd.Modelo.starwarsSerFaccionRaza;
import bbdd.Modelo.starwarsSeresPlanetaBatallado;
import bbdd.Modelo.starwarsSeresSensibles;
import bbdd.Vista.starwarsEjercitoFaccionesController;
import bbdd.Vista.starwarsSerFaccionRazaController;
import bbdd.Vista.starwarsSeresPlanetaBatalladoController;
import bbdd.Vista.starwarsSeresSensiblesController;
import bbdd.Vista.swPantPrincipalController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Ruben
 *
 */
public class MainApp extends Application {

	private Stage VentanaPrincipal;
	private BorderPane layoutPrincipal;	
	private ObservableList<starwarsSerFaccionRaza> ListaObservableSerFaccionRaza;
	private ObservableList<starwarsSeresPlanetaBatallado> ListaSeresPlanetaBatallado;
	private ObservableList<starwarsSeresSensibles> listaSeresSensibles;
	private ObservableList<starwarsEjercitoFacciones> listaFacciones;

	public MainApp() {
		String SQLConsulta1 = "select  nombre_ser as Nombre, nombre_faccion as Faccion, nombre_raza as Raza\r\n" + 
				"from starwars.ser inner join starwars.raza using (id_raza) \r\n" + 
				"				  inner join starwars.faccion using (id_faccion)\r\n" + 
				"order by nombre_ser; ";
		
		String SQLConsulta2 = "select ser.nombre_ser as Nombre_Ser, planeta.nombre_planeta as Planeta_Batallado, batalla.facciones_enfrentadas as Facciones, ser.dni_cosmico as ID\r\n" + 
				"from starwars.ser inner join vive using (dni_cosmico)\r\n" + 
				"				  inner join planeta using (nombre_planeta)\r\n" + 
				"                  inner join se_produce using (nombre_planeta)\r\n" + 
				"                  inner join batalla using (id_batalla)\r\n" + 
				"order by ID;";
		String SQLConsulta3 = "select ser.nombre_ser as Nombre, enseña.dominios_fuerza as Sabiduria\r\n" + 
				"from starwars.ser inner join starwars.enseña using(dni_cosmico)\r\n" + 
				"where starwars.ser.sensible_fuerza = true\r\n" + 
				"group by Nombre_Ser;";
		String SQLConsulta4 = "select ejercito.tipo_soldado as Soldado, ejercito.vehiculo as Vehiculo, faccion.nombre_faccion as Faccion, faccion.id_faccion as ID\r\n" + 
				"from starwars.ejercito inner join starwars.faccion using (id_faccion);";
		MySQLswSerFaccionRaza objetoSQL1;
		objetoSQL1 = new MySQLswSerFaccionRaza(SQLConsulta1);
		this.ListaObservableSerFaccionRaza = objetoSQL1.getObservableList();
		
		MySQLstarwarsSeresPlanetaBatallado objetoSQL2;
		objetoSQL2 = new MySQLstarwarsSeresPlanetaBatallado(SQLConsulta2);
		this.ListaSeresPlanetaBatallado = objetoSQL2.getObservableList();
		
		MySQLstarwarsSeresSensibles objetoSQL3;
		objetoSQL3 = new MySQLstarwarsSeresSensibles(SQLConsulta3);
		this.listaSeresSensibles = objetoSQL3.getObservableList();
		
		MySQLEjercitoFacciones objetoSQL4;
		objetoSQL4 = new MySQLEjercitoFacciones(SQLConsulta4);
		this.listaFacciones = objetoSQL4.getObservableList();
	}

	@Override
	public void start(Stage primaryStage) {
		this.VentanaPrincipal = primaryStage;
		this.VentanaPrincipal.setTitle("Base de Datos Star Wars");
		iniciarLayoutPrincipal();
		mostrarInicio();
		//mostrarListaObservableStarWarsSerFaccionRaza();
		//mostrarSeresPlanetaBatallado();

	}
	public void iniciarLayoutPrincipal() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../Vista/PntPrincipal.fxml"));
			layoutPrincipal = (BorderPane) loader.load();
			Scene escena = new Scene(layoutPrincipal);
			VentanaPrincipal.setScene(escena);
			swPantPrincipalController ControladorPantPrincipal = loader.getController();
			ControladorPantPrincipal.setMainApp(this);
			VentanaPrincipal.show();
		}catch(IOException excepcion) {
			System.out.println("Pantalla Principal exception: " + excepcion.getMessage());
		}
	}
	
	public ObservableList<starwarsSerFaccionRaza> getListaObservableSerFaccionRaza(){
		return this.ListaObservableSerFaccionRaza;
	}
	public ObservableList<starwarsSeresPlanetaBatallado> getObservableListSeresPlanetaBatallado(){
    	FilteredList<starwarsSeresPlanetaBatallado> Filtrado = new FilteredList<>(this.ListaSeresPlanetaBatallado);
    	List<Integer> tmpList = new ArrayList<Integer>();
    	
		Filtrado.setPredicate(new Predicate<starwarsSeresPlanetaBatallado>() {
			public boolean test(starwarsSeresPlanetaBatallado Item) {
				if (tmpList.contains(Item.getID().getValue())) {
					return false;
				}else {
					tmpList.add(Item.getID().getValue());
					return true;
				}			
			}
		});
		return Filtrado;
    }
    public ObservableList<starwarsSeresPlanetaBatallado> getSeresPlanetaBatallado (int ID){
		FilteredList<starwarsSeresPlanetaBatallado> Filtrado = new FilteredList<>(this.ListaSeresPlanetaBatallado);
		Filtrado.setPredicate(new Predicate<starwarsSeresPlanetaBatallado>() {
			public boolean test(starwarsSeresPlanetaBatallado Item) {
				if (Item.getID().getValue() == ID) return true;
				return false;
			}
		});
		return Filtrado;
	}
    public ObservableList<starwarsSeresSensibles> getListaSeresSensibles(){
    	return this.listaSeresSensibles;
    }  
    public ObservableList<starwarsEjercitoFacciones> getListaFacciones(){
    	FilteredList<starwarsEjercitoFacciones> Filtrado = new FilteredList<>(this.listaFacciones);
    	List<Integer> tmpList = new ArrayList<Integer>();
    	
		Filtrado.setPredicate(new Predicate<starwarsEjercitoFacciones>() {
			public boolean test(starwarsEjercitoFacciones Item) {
				if (tmpList.contains(Item.getID().getValue())) {
					return false;
				}else {
					tmpList.add(Item.getID().getValue());
					return true;
				}			
			}
		});
		return Filtrado;
    }
    public ObservableList<starwarsEjercitoFacciones> getFacciones (int ID){
		FilteredList<starwarsEjercitoFacciones> Filtrado = new FilteredList<>(this.listaFacciones);
		Filtrado.setPredicate(new Predicate<starwarsEjercitoFacciones>() {
			public boolean test(starwarsEjercitoFacciones Item) {
				if (Item.getID().getValue() == ID) return true;
				return false;
			}
		});
		return Filtrado;
	}
    
    public void mostrarListaObservableStarWarsSerFaccionRaza(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../Vista/swSerFaccionRaza.fxml"));
			AnchorPane ListaObservableSerSensibleFuerzaOverview = (AnchorPane) loader.load();
			layoutPrincipal.setCenter(ListaObservableSerSensibleFuerzaOverview);
			starwarsSerFaccionRazaController ControladorDatosSQL1 = loader.getController();
			ControladorDatosSQL1.setMainApp(this);
			
		}catch(IOException excepcion) {
			System.out.println("StarWarsSerFaccionRaza exception: " + excepcion.getMessage());
		}
	}
	public void mostrarSeresPlanetaBatallado() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../Vista/swSeresPlanetBatallado.fxml"));
			AnchorPane listaSeresPlanetBatallado =(AnchorPane) loader.load();
			layoutPrincipal.setCenter(listaSeresPlanetBatallado);
			starwarsSeresPlanetaBatalladoController ControladorDatosSQL2 = loader.getController();
			ControladorDatosSQL2.setMainApp(this);
			
		}catch(IOException excepcion) {
			System.out.println("StarWarsSeresPlanetaBatallado excepcion: " + excepcion.getMessage());
		}
	}
	public void mostrarSeresSensibles() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../Vista/swSeresSensibles.fxml"));
			AnchorPane listSeresSensibles = (AnchorPane) loader.load();
			layoutPrincipal.setCenter(listSeresSensibles);
			starwarsSeresSensiblesController ControladorDatosSQL3 = loader.getController();
			ControladorDatosSQL3.setMainApp(this);
			
		}catch(IOException excepcion) {
			System.out.println("StarWarsSeresSensibles excepcion: " + excepcion.getMessage());
		}
	}
	public void mostrarEjercitoFaccion() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../Vista/starwarsEjercitoFacc.fxml"));
			AnchorPane listaEjercitoFaccion =(AnchorPane) loader.load();
			layoutPrincipal.setCenter(listaEjercitoFaccion);
			starwarsEjercitoFaccionesController ControladorDatosSQL4 = loader.getController();
			ControladorDatosSQL4.setMainApp(this);
			
		}catch(IOException excepcion) {
			System.out.println("StarWarsEjercitoFaccion excepcion: " + excepcion.getMessage());
		}
	} 
	public void mostrarInicio() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../Vista/Bienve.fxml"));
			AnchorPane Bienvenida = (AnchorPane) loader.load();
			layoutPrincipal.setCenter(Bienvenida);
			
		}catch(IOException excepcion) {
			System.out.println("mostrarInicio Exception: " + excepcion.getMessage());
		}
	}

	
	public Stage getPrimaryStage() {
        return VentanaPrincipal;
    }
	public static void main(String[] args) {
		launch(args);

	}

}
