package IesPerezMinik.Gestor.de.Correos.Api;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class GeneradorCuerpo {

	public static String Casual(String destinatario) {
		String[] saludos = { "Hola", "Buenos días", "Buenas tardes", "Buenas noches", "Qué tal" };
		//String[] nombres = { "Juan", "María", "Pedro", "Lucía", "Antonio", "Carmen" };
		String[] temas = { "Viaje", "Comida", "Trabajo", "Deporte", "Películas", "Música" };
		String[] verbos = { "me gusta", "no me gusta", "quiero hablar de", "quiero comentar", "quiero compartir" };
		String[] adverbios = { "mucho", "poco", "bastante", "muy poco", "muy bien", "mal" };
		String[] sobre = {"¿Qué opinas tú?","¿Qué piensas tú?"};

		Random rand = new Random();

		String mensaje = saludos[rand.nextInt(saludos.length)] + " " + destinatario + ", "
				+ verbos[rand.nextInt(verbos.length)] + " " + "sobre tu " + temas[rand.nextInt(temas.length)] + ". "
				+ "Me interesa hablar " + adverbios[rand.nextInt(adverbios.length)] + " de ello. " + sobre[rand.nextInt(sobre.length)];

		return mensaje;
	}

	
	public static String Escuela(String destinatario) {
		
		String[] saludos = { "Hola", "Buenos días", "Buenas tardes", "Buenas noches", "Qué tal" };
		//String[] nombres = { "Juan", "María", "Pedro", "Lucía", "Antonio", "Carmen" };
		String[] temas = { "Viaje", "Comida", "Trabajo", "Deporte", "Películas", "Música" };
		String[] verbos = { "me gusta", "no me gusta", "quiero hablar de", "quiero comentar", "quiero compartir" };
		String[] adverbios = { "mucho", "poco", "bastante", "muy poco", "muy bien", "mal" };
		
		Random rand = new Random();

		String mensaje = saludos[rand.nextInt(saludos.length)] + " " + destinatario + ", "
				+ verbos[rand.nextInt(verbos.length)] + " " + "sobre " + temas[rand.nextInt(temas.length)] + ". "
				+ "Me interesa " + adverbios[rand.nextInt(adverbios.length)] + ". " + "¿Qué piensas tú?";

		return mensaje;
		
	}
	
	public static String Corporativo(String destinatario, String remitente) {

		final String[] saludos = { "Estimado/a", "Hola", "Buen día" };
		final String[] despedidas = { "Saludos cordiales", "Atentamente", "Gracias" };
		final String[] temas = { "sobre una nueva funcionalidad", "para una posible colaboración",
				"sobre una oferta especial" };
		final String[] adjetivos = { "interesante", "innovador", "emocionante", "exclusivo" };
		final String[] frasesComunes = { "Esperamos que se encuentre bien", "Le agradecemos por su tiempo",
				"Queríamos compartir con ustedes" };
		final String[] llamadosAccion = { "No dude en contactarnos para más información",
				"Le invitamos a visitar nuestro sitio web para más detalles",
				"Le pedimos que nos informe de su decisión" };
		final String[] despedidasFinales = { "Quedamos a la espera de su respuesta", "Muchas gracias por su atención",
				"Esperamos tener noticias suyas pronto" };

		Random r = new Random();
		StringBuilder cuerpo = new StringBuilder();
		cuerpo.append(saludos[r.nextInt(saludos.length)]);
		cuerpo.append(" ");
		cuerpo.append(destinatario);
		cuerpo.append(",");
		cuerpo.append("\n\n");
		cuerpo.append(frasesComunes[r.nextInt(frasesComunes.length)]);
		cuerpo.append(", ");
		cuerpo.append(temas[r.nextInt(temas.length)]);
		cuerpo.append(" ");
		cuerpo.append(adjetivos[r.nextInt(adjetivos.length)]);
		cuerpo.append(". ");
		cuerpo.append(llamadosAccion[r.nextInt(llamadosAccion.length)]);
		cuerpo.append(".");
		cuerpo.append("\n\n");
		cuerpo.append(despedidasFinales[r.nextInt(despedidasFinales.length)]);
		cuerpo.append("\n\n");
		cuerpo.append(despedidas[r.nextInt(despedidas.length)]);
		cuerpo.append(",");
		cuerpo.append("\n");
		cuerpo.append(remitente);
		return cuerpo.toString();
	}

	public static List<String> generarCuerposMensajes(List<String> destinatarios,String tema) {
		
		List<String> cuerposMensajes = new ArrayList<>();
		
		if(tema.contains("Corporativo")) {
			
			for (String destinatario : destinatarios) {
				cuerposMensajes.add(Corporativo(destinatario,tema));
			}
			return cuerposMensajes;
		}
		if(tema.contains("casual")) {
			for (String destinatario : destinatarios) {
				cuerposMensajes.add(Casual(destinatario));
			}
			return cuerposMensajes;
		}
		
		return cuerposMensajes;
		
	}

}