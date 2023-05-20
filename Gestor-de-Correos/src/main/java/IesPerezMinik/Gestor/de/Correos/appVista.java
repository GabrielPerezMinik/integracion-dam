package IesPerezMinik.Gestor.de.Correos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class appVista extends Application{

		public static Stage primaryStage;
		private Controller2 control;

		@Override
		public void start(Stage primaryStage) throws Exception {
			control = new Controller2();
			appVista.primaryStage=primaryStage;
			primaryStage.setTitle("Enviar Email");
			primaryStage.setScene(new Scene(control.getVista()));
			//primaryStage.getIcons().add(new Image("/images/email-send-icon-32x32 (1).png"));
			primaryStage.show();
		}

		public static void main(String[] args) {
			launch(args);

		}
		
	}

