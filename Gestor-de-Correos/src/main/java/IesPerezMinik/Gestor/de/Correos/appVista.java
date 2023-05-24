package IesPerezMinik.Gestor.de.Correos;

import IesPerezMinik.Gestor.de.Correos.ControllerInterfaz.Controller1;
import IesPerezMinik.Gestor.de.Correos.ControllerInterfaz.LoginController;
import IesPerezMinik.Gestor.de.Correos.ControllerInterfaz.RootController;
import IesPerezMinik.Gestor.de.Correos.ControllerInterfaz.smtpController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class appVista extends Application{

	public static Scene scene;
	
		public static Stage primaryStage;
		//private Controller1 control;
		//private smtpController control;
		//private RootController root;
		private LoginController login;
		
		@Override
		public void start(Stage primaryStage) throws Exception {
		//	control = new smtpController();
		//	control = new Controller1();
		//	root = new RootController();
			login = new LoginController();
			appVista.primaryStage=primaryStage;
			primaryStage.setTitle("Enviar Email");
			primaryStage.setScene(new Scene(login.getVista()));
		//	primaryStage.setScene(new Scene(root.getVistaLogo()));
		//	primaryStage.setScene(new Scene(control.getVistaSMTP()));
		//	primaryStage.setScene(new Scene(control.getVista()));
			primaryStage.getIcons().add(new Image("/images/emailLogo.png"));
			primaryStage.show();
		}

		public static void main(String[] args) {
			launch(args);

		}
		
	}