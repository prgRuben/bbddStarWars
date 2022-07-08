/**
 * 
 */
package bbdd.Vista;


import bbdd.Controlador.MainApp;
import bbdd.Modelo.starwarsEjercitoFacciones;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;

/**
 * @author Rubén
 *
 */
public class starwarsEjercitoFaccionesController {

	@FXML
	private TableView<starwarsEjercitoFacciones> tableViewFacciones;
	@FXML
	private TableView<starwarsEjercitoFacciones> tablaSolVeh;
	@FXML
	private TableColumn<starwarsEjercitoFacciones, String> tablaFacciones;
	@FXML
	private TableColumn<starwarsEjercitoFacciones,String> columSolVeh;
	@FXML
	private Button btnSoldados, btnVehiculos;
	
	TableViewSelectionModel<starwarsEjercitoFacciones> selectionModel;
	
	
	private MainApp mainApp;
	
	
	@FXML
	private void initialize() {
		tablaFacciones.setCellValueFactory(cellData -> cellData.getValue().getFacciones());
		tableViewFacciones.getSelectionModel().selectedItemProperty().addListener(
				(observable,oldValue,newValue) -> DetallesEjercitoFaccion(newValue)
				);
		selectionModel = tableViewFacciones.getSelectionModel();
		tableViewFacciones.setSelectionModel(null);
		
		
		//this.btnSoldados = new Button();
		//this.btnVehiculos = new Button();
		//this.btnSoldados.setOnAction(e -> BotonSoldadosClicked(e));
		//this.btnVehiculos.setOnAction(e -> BotonVehiculosClicked(e));
	}
	
	public void setMainApp (MainApp main) {
		this.mainApp = main;
		tableViewFacciones.setItems(this.mainApp.getListaFacciones());
	}
	
	private void DetallesEjercitoFaccion(starwarsEjercitoFacciones Data) {
		if(Data != null) {
			tablaSolVeh.setItems(this.mainApp.getFacciones(Data.getID().getValue()));
			
			//columSoldados.setCellValueFactory(cellData -> cellData.getValue().getSoldados());
			//ColumVehiculos.setCellValueFactory(cellData -> cellData.getValue().getVehiculos());
		}
		else {
			tablaSolVeh.getColumns().clear();
		}
	}
	
	public starwarsEjercitoFaccionesController() {
		this.btnSoldados = new Button();
		this.btnVehiculos = new Button();
		this.btnSoldados.setOnAction(e -> BotonSoldadosClicked(e));
		this.btnVehiculos.setOnAction(e -> BotonVehiculosClicked(e));
	}
	
	@FXML
	public void BotonSoldadosClicked(ActionEvent e) {
		columSolVeh.setCellValueFactory(cellData -> cellData.getValue().getSoldados());
		columSolVeh.setText("Soldados");
		tableViewFacciones.setSelectionModel(selectionModel);
	}
	@FXML
	public void BotonVehiculosClicked(ActionEvent e) {
		columSolVeh.setCellValueFactory(cellData -> cellData.getValue().getVehiculos());
		columSolVeh.setText("Vehiculos");
		tableViewFacciones.setSelectionModel(selectionModel);
		
	}
	
}
