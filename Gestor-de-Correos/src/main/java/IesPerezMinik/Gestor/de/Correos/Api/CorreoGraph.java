package IesPerezMinik.Gestor.de.Correos.Api;

import java.util.Arrays;

import com.microsoft.graph.models.BodyType;
import com.microsoft.graph.models.EmailAddress;
import com.microsoft.graph.models.ItemBody;
import com.microsoft.graph.models.Message;
import com.microsoft.graph.models.Recipient;
import com.microsoft.graph.requests.GraphServiceClient;

public class CorreoGraph {

	
	public void GraphServiceClient () {
	
	GraphServiceClient graphClient = GraphServiceClient.builder()
		    .authenticationProvider(request -> {
		        request.addHeader("Authorization", "Bearer " + "cavavasev");
		    }).buildClient();
	}
	
	public void SendEmail() {
		Message message = new Message();
		message.subject = "Asunto del correo";
		message.body = new ItemBody();
		message.body.content = "Contenido del correo.";
		message.body.contentType = BodyType.TEXT;
		message.toRecipients = Arrays.asList(new Recipient() {{
		    emailAddress = new EmailAddress() {{
		        address = "destinatario@example.com";
		    }};
		}});

		graphClient.me().send(message).buildRequest().post();

	}
	
}
