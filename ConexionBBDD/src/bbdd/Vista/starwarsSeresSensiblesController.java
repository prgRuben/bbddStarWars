/**
 * 
 */
package bbdd.Vista;

import bbdd.Controlador.MainApp;
import bbdd.Modelo.starwarsSeresSensibles;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;


/**
 * @author Rubén
 *
 */
public class starwarsSeresSensiblesController {

	@FXML
	ListView<starwarsSeresSensibles> lsvNombres;
	@FXML
	TextArea txAreaSabiduria;
	
	private MainApp mainApp;
	
	
	@FXML
	private void initialize() {
		lsvNombres.getSelectionModel().selectedItemProperty().addListener(
				(observable,oldValue,newValue) -> DetallesstarwarsSeresSensibles(newValue));
	}
	
	public void setMainApp(MainApp main) {
		this.mainApp = main;
		lsvNombres.setItems(mainApp.getListaSeresSensibles());
	}
	
	private void DetallesstarwarsSeresSensibles(starwarsSeresSensibles Data) {
		if(Data != null) {
			txAreaSabiduria.setText(Data.getSabiduria().getValue().toString());
		}
		else
			txAreaSabiduria.setText("");
	}
	
}
