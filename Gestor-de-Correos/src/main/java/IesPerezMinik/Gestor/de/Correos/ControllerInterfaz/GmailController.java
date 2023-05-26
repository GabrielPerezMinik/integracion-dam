package IesPerezMinik.Gestor.de.Correos.ControllerInterfaz;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import IesPerezMinik.Gestor.de.Correos.appVista2;
import IesPerezMinik.Gestor.de.Correos.Api.GeneradorCuerpo;
import IesPerezMinik.Gestor.de.Correos.Controller.GMailer;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class GmailController implements Initializable {

	RegistroController root;
		
	String correo;
	
	List<String> correos;

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
	private ImageView gmailLogo;
	
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
		
		gmailLogo.setImage(new Image("/images/logo_gmail.png"));
		
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

	}

	void modoOscuroOn(double x) {

		if (x == 1) {
			labelModo.setText("Modo Oscuro:");
			vistaGmail.getStyleClass().add("modoOscuro");
		} else {
			labelModo.setText("Modo Claro:");
			vistaGmail.getStyleClass().remove("modoOscuro");
		}
	}

    @FXML
    void onEnviar(ActionEvent event) {

    	try {
    		
    		if(correos==null) {
        		
        		String[] nombres = textDestinatario.getText().split(",");
                correos=List.of(nombres);
        		
        	}
			new GMailer().sendMail(textAsunto.getText(), textCuerpo.getText(), textRemitente.getText(), correos);
			
			Alert alertCon = new Alert(AlertType.CONFIRMATION);
			alertCon.initOwner(appVista2.primaryStage);
			alertCon.setHeaderText("Mensaje enviado con éxito a '"+  textDestinatario.getText()  +"'.");
			alertCon.setGraphic(new ImageView(new Image("/images/ok.png")));
			enviarButton.setContentDisplay(ContentDisplay.TEXT_ONLY);
			alertCon.show();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			Alert alertErr = new Alert(AlertType.ERROR);
			alertErr.initOwner(appVista2.primaryStage);
			alertErr.setHeaderText("No se pudo enviar el email.");
			alertErr.setContentText("Complete todos los campos");
			alertErr.setGraphic(new ImageView(new Image("/images/no.png")));
			enviarButton.setContentDisplay(ContentDisplay.TEXT_ONLY);
			alertErr.show();
		}
    	
    }

    @FXML
    void onGenerar(ActionEvent event) {

    	if(selectorTema.getValue()=="Casual") {
    		String[] nombres = textDestinatario.getText().split(",");
    		 correos=List.of(nombres);
    	       
            for (String nombre : nombres) {
                System.out.println(nombre);
                textCuerpo.setText(GeneradorCuerpo.Casual(nombre));
            }
    	}
    	
    	if(selectorTema.getValue()=="Corporativo") {
    		String[] nombres = textDestinatario.getText().split(",");
    		 correos=List.of(nombres);
    	       
            for (String nombre : nombres) {
                System.out.println(nombre);
                textCuerpo.setText(GeneradorCuerpo.Corporativo(nombre,textRemitente.getText()));
            }
    	}
    	
    	if(selectorTema.getValue()=="Escuela") {
    		String[] nombres = textDestinatario.getText().split(",");
    		 correos=List.of(nombres);
    		 
            for (String nombre : nombres) {
                System.out.println(nombre);
                textCuerpo.setText(GeneradorCuerpo.Escuela(nombre,textRemitente.getText()));
            }
    		
    	} 	
    	
    }

    @FXML
    void onSalir(ActionEvent event) {

    	Alert alertaConfi= new Alert(AlertType.CONFIRMATION);
		alertaConfi.setTitle("Salir de la aplicacion");
		alertaConfi.setHeaderText("se va a salir de la aplicacion ");
		alertaConfi.setContentText("¿Está seguro?");
		Optional<ButtonType> result=alertaConfi.showAndWait();
		
		if(result.get() == ButtonType.OK)
			appVista2.primaryStage.close();
			appVista2.aplicationContext.close();
    	
    }

    @FXML
    void onVaciar(ActionEvent event) {

    	//contrasenaSmtp.setText("");
    	//textRemitente.setText("");
    	
    	textDestinatario.setText("");
    	textAsunto.setText("");
    	textCuerpo.setText("");
    	
    	
    }

    public GridPane getVistaGmail() {
		return vistaGmail;
	}
	
    public void setCorreoGmail(String correo) {
    	this.correo=correo;
    	getCorreoGmail();
    }
    
    public void getCorreoGmail() {
    	textRemitente.setText(correo);
    }
}
