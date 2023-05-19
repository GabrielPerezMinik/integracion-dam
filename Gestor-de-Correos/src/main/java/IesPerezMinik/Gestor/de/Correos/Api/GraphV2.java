package IesPerezMinik.Gestor.de.Correos.Api;

import com.microsoft.graph.authentication.IAuthenticationProvider;
import com.microsoft.graph.requests.GraphServiceClient;

public class GraphV2 {

	
	// Configurar credenciales
	IAuthenticationProvider authProvider = new UsernamePasswordProvider("client_id", "client_secret", "username", "password");

	// Crear cliente de Graph
	GraphServiceClient graphClient = GraphServiceClient.builder().authenticationProvider(authProvider).buildClient();

}
