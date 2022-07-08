/**
 * 
 */
package bbdd.Vista;

import bbdd.Controlador.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * @author Ruben
 *
 */
public class swPantPrincipalController {

	@FXML
	private Button btnInicio;
	@FXML
	private Button btnSeresFaccRaza;
	@FXML
	private Button btnSeresNoSens;
	@FXML
	private Button btnPlanetBattle;
	@FXML
	private Button btnSeresSens;
	@FXML
	private Button btnPlanetSerBatalla;
	
	private MainApp main;
	
	public swPantPrincipalController() {
		this.btnInicio = new Button();
		this.btnPlanetBattle = new Button();
		this.btnPlanetSerBatalla = new Button();
		this.btnSeresFaccRaza = new Button();
		this.btnSeresNoSens = new Button();
		this.btnSeresSens = new Button();
		this.btnInicio.setOnAction(e -> BotonInicioClicked(e));
		this.btnPlanetBattle.setOnAction(e -> BotonPlanetBttlClicked(e));
		this.btnPlanetSerBatalla.setOnAction(e -> BotonPlanetSerBattleClicked(e));
		this.btnSeresFaccRaza.setOnAction(e -> BotonSeresFaccRazaClicked(e));
		this.btnSeresNoSens.setOnAction(e -> BotonSeresNoSenClicked(e));
		this.btnSeresSens.setOnAction(e -> BotonSeresSensibClicked(e));
	}
	
	@FXML
	private void initialize() {
		/*this.btnInicio = new Button();
		this.btnPlanetBattle = new Button();
		this.btnPlanetSerBatalla = new Button();
		this.btnSeresFaccRaza = new Button();
		this.btnSeresNoSens = new Button();
		this.btnSeresSens = new Button();
		this.btnInicio.setOnAction(e -> BotonInicioClicked(e));
		this.btnPlanetBattle.setOnAction(e -> BotonPlanetBttlClicked(e));
		this.btnPlanetSerBatalla.setOnAction(e -> BotonPlanetSerBattleClicked(e));
		this.btnSeresFaccRaza.setOnAction(e -> BotonSeresFaccRazaClicked(e));
		this.btnSeresNoSens.setOnAction(e -> BotonSeresNoSenClicked(e));
		this.btnSeresSens.setOnAction(e -> BotonSeresSensibClicked(e));*/
	}
	
	@FXML
	private void BotonInicioClicked(ActionEvent e) {
		this.main.mostrarInicio();
	}
	@FXML
	private void BotonPlanetBttlClicked(ActionEvent e) {
		this.main.mostrarSeresPlanetaBatallado();
	}
	@FXML
	private void BotonPlanetSerBattleClicked(ActionEvent e) {
		this.main.mostrarEjercitoFaccion();
	}
	@FXML
	private void BotonSeresFaccRazaClicked(ActionEvent e) {
		this.main.mostrarListaObservableStarWarsSerFaccionRaza();
	}
	@FXML
	private void BotonSeresNoSenClicked(ActionEvent e) {
		
	}
	@FXML
	private void BotonSeresSensibClicked(ActionEvent e) {
		this.main.mostrarSeresSensibles();
	}
	public void setMainApp(MainApp mainApp) {
		this.main=mainApp;
	}
	

}
