package IesPerezMinik.Gestor.de.Correos.ControllerInterfaz;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;

import IesPerezMinik.Gestor.de.Correos.appVista;
import IesPerezMinik.Gestor.de.Correos.Api.GeneradorCuerpo;
import IesPerezMinik.Gestor.de.Correos.Api.llamadaSMTP;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class GmailController implements Initializable {

	llamadaSMTP SMTP = new llamadaSMTP();

	Properties pro = null;
	
	@FXML
	private CheckBox checkGmail;

	@FXML
	private CheckBox checkMicro;

	@FXML
	private CheckBox checkStartlls;

	@FXML
	private CheckBox checkYahoo;

	@FXML
	private PasswordField contrasenaSmtp;

	@FXML
	private Button enviarButton;

	@FXML
	private Slider modoOscuro;

	@FXML
	private ChoiceBox<String> selectorTema;
	
	@FXML
	private Label labelModo;

	@FXML
	private Button salirButton;

	@FXML
	private TextField textAsunto;

	@FXML
	private TextArea textCuerpo;

	@FXML
	private TextField textRemitente;
	
	@FXML
	private TextField textDestinatario;

	@FXML
	private TextField textPuerto;

	@FXML
	private TextField textServidor;

	@FXML
	private Button vaciarButton;

	 @FXML
	 private GridPane vistaGmail;


	public GmailController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Gmail.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		selectorTema.getItems().add("Casual");
		selectorTema.getItems().add("Escuela");
		selectorTema.getItems().add("Corporativo");
		
		selectorTema.setValue("elije un tema");
		
		modoOscuro.setMajorTickUnit(1);
		modoOscuro.setMinorTickCount(0);
		modoOscuro.setSnapToTicks(true);

		DoubleProperty modoOscuroProperty = new SimpleDoubleProperty(modoOscuro.getValue());

		modoOscuro.valueProperty().addListener((observable, oldValue, newValue) -> {
			modoOscuroProperty.set(newValue.doubleValue());

			modoOscuroOn(newValue.doubleValue());

		});

		// Obtener el valor inicial del Slider
//		double valorModoOscuro = modoOscuro.getValue();

	}

	void modoOscuroOn(double x) {

		if (x == 1) {
			labelModo.setText("Modo Oscuro:");
			vistaGmail.getStyleClass().add("modoOscuro");
			//vistaSMTP.getStyleClass().remove("vistaSMTP");
		} else {
			labelModo.setText("Modo Claro:");
			vistaGmail.getStyleClass().remove("modoOscuro");
			//vistaSMTP.getStyleClass().add("vistaSMTP");
		}
	}

    @FXML
    void onEnviar(ActionEvent event) {

    }

    @FXML
    void onGenerar(ActionEvent event) {

    	if(selectorTema.getValue()=="Casual") {
    		String[] nombres = textDestinatario.getText().split(",");
            
    	       
            for (String nombre : nombres) {
                System.out.println(nombre);
                textCuerpo.setText(GeneradorCuerpo.Casual(nombre));
            }
    	}
    	
    	if(selectorTema.getValue()=="Corporativo") {
    		String[] nombres = textDestinatario.getText().split(",");
            
    	       
            for (String nombre : nombres) {
                System.out.println(nombre);
                textCuerpo.setText(GeneradorCuerpo.Corporativo(nombre,textRemitente.getText()));
            }
    	}
    	
    	if(selectorTema.getValue()=="Escuela") {
//    		String[] nombres = textDestinatario.getText().split(",");
//            
//    	       
//            for (String nombre : nombres) {
//                System.out.println(nombre);
//                textCuerpo.setText(GeneradorCuerpo.Corporativo(nombre,textRemitente.getText());
//            }
    		System.out.println("Elegido escuela");
    	}
    	
    	
    	
    	//textCuerpo.setText(GeneradorCuerpo.Corporativo(textDestinatario.getText(),textRemitente.getText()));
    	
    }

    @FXML
    void onSalir(ActionEvent event) {

    	Alert alertaConfi= new Alert(AlertType.CONFIRMATION);
		alertaConfi.setTitle("Salir de la aplicacion");
		alertaConfi.setHeaderText("se va a salir de la aplicacion ");
		alertaConfi.setContentText("¿Está seguro?");
		Optional<ButtonType> result=alertaConfi.showAndWait();
		
		if(result.get() == ButtonType.OK)
			appVista.primaryStage.close();
    	
    }

    @FXML
    void onVaciar(ActionEvent event) {

    	contrasenaSmtp.setText("");
    	textDestinatario.setText("");
    	textRemitente.setText("");
    	textAsunto.setText("");
    	textCuerpo.setText("");
    	textPuerto.setText("");
    	textServidor.setText("");
    	contrasenaSmtp.setText("");
    	checkGmail.setSelected(false);
    	checkMicro.setSelected(false);
    	checkYahoo.setSelected(false);
    	checkStartlls.setSelected(false);
    	
    }

    public GridPane getVistaGmail() {
		return vistaGmail;
	}
	
}
