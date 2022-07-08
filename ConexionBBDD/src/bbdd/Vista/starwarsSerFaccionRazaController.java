package bbdd.Vista;

import bbdd.Controlador.MainApp;
import bbdd.Modelo.starwarsSerFaccionRaza;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class starwarsSerFaccionRazaController {
	@FXML
	private TableView<starwarsSerFaccionRaza> tableViewNombre;
	@FXML
	private TableColumn<starwarsSerFaccionRaza, String> tableColumnNombre;
	@FXML
	private Label labelNombre;
	@FXML
	private Label labelFaccion;
	@FXML
	private Label labelRaza;
	
	private MainApp mainApp;
	
	@FXML
	private void initialize() {
		tableColumnNombre.setCellValueFactory(cellData -> cellData.getValue().getNombreProperty());
		DetallesSerFaccionRaza(null);
		tableViewNombre.getSelectionModel().selectedItemProperty().addListener(
				(observable,oldValue,newValue) -> DetallesSerFaccionRaza(newValue)
		);
	}
	public void setMainApp(MainApp main) {
		this.mainApp = main;
		tableViewNombre.setItems(mainApp.getListaObservableSerFaccionRaza());
	}
	
	private void DetallesSerFaccionRaza(starwarsSerFaccionRaza Data) {
		if(Data != null) {
			labelNombre.setText(Data.getNombreProperty().getValue().toString());
			labelFaccion.setText(Data.getFaccionProperty().getValue().toString());
			labelRaza.setText(Data.getRazaProperty().getValue().toString());
		}	
		else {
			labelNombre.setText("");
			labelFaccion.setText("");
			labelRaza.setText("");
		}
	}
	
}

