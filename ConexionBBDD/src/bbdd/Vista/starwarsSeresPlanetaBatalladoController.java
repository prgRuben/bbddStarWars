/**
 * 
 */
package bbdd.Vista;

import bbdd.Controlador.MainApp;
import bbdd.Modelo.starwarsSeresPlanetaBatallado;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * @author Ruben
 *
 */
public class starwarsSeresPlanetaBatalladoController {

	@FXML
	private TableView<starwarsSeresPlanetaBatallado> tablaSeres;
	@FXML
	private TableView<starwarsSeresPlanetaBatallado> tablaDetalles;
	@FXML
	private TableColumn<starwarsSeresPlanetaBatallado, String> columNombreSer;
	@FXML
	private TableColumn<starwarsSeresPlanetaBatallado,String> tablanombres;
	@FXML
	private TableColumn<starwarsSeresPlanetaBatallado,String> tablaPlaneta;
	@FXML
	private TableColumn<starwarsSeresPlanetaBatallado,String> tablaFacciones;
	
	private MainApp mainApp;
	
	
	@FXML
	private void initialize() {
		columNombreSer.setCellValueFactory(cellData -> cellData.getValue().getNombreSer());
		//DetallesSeresPlanetBatallado(null);
		tablaSeres.getSelectionModel().selectedItemProperty().addListener(
				(observable,oldValue,newValue) -> DetallesSeresPlanetBatallado(newValue)
		);	
	}
	public void setMainApp(MainApp main) {
		this.mainApp = main;
		tablaSeres.setItems(mainApp.getObservableListSeresPlanetaBatallado());
	}
	private void DetallesSeresPlanetBatallado(starwarsSeresPlanetaBatallado Data) {
		if(Data != null) {
			tablaDetalles.setItems(this.mainApp.getSeresPlanetaBatallado(Data.getID().getValue()));
			tablanombres.setCellValueFactory(cellData -> cellData.getValue().getNombre_Ser());
			tablaPlaneta.setCellValueFactory(cellData -> cellData.getValue().getPlaneta_Batallado());
			tablaFacciones.setCellValueFactory(cellData -> cellData.getValue().getFacciones());
		}
		else {
			tablaDetalles.getColumns().clear();
		}
	}
}
