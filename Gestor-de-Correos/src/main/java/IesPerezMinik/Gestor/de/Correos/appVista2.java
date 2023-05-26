package IesPerezMinik.Gestor.de.Correos;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class appVista2 extends Application{

	public static ConfigurableApplicationContext aplicationContext;
	
	public static Scene scene;
	
		public static Stage primaryStage;
		
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			
		aplicationContext = SpringApplication.run(GestorDeCorreosApplication.class);
		FXMLLoader loader = new FXMLLoader(GestorDeCorreosApplication.class.getResource("/vista/login.fxml"));
		loader.setControllerFactory(aplicationContext::getBean);	
		scene = new Scene(loader.load());
			
			appVista2.primaryStage=primaryStage;
			primaryStage.setTitle("Correos Goy");
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image("/images/emailLogo.png"));
			primaryStage.show();
		}

		public static void main(String[] args) {
			launch(args);

		}

		public static ConfigurableApplicationContext getAplicationContext() {
			return aplicationContext;
		}
		
	}