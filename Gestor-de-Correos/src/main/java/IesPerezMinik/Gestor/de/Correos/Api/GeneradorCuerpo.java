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

	
	public static String Escuela(String destinatarioCorreo, String nombre) {
		
//		String nombreEscuela = null;
//		String tuNombre = null;
		 String[] destinatarios = {
		        "Profesor/a",
		        "Director/a",
		        "Padres y tutores",
		        "Estudiantes",
		        "Personal administrativo"
		    };

		     String[] temas = {
		        "La importancia de la participación de los padres en la educación",
		        "El uso responsable de las redes sociales por parte de los estudiantes",
		        "La promoción de la diversidad e inclusión en el entorno escolar",
		        "El fomento de la educación ambiental en la comunidad educativa",
		        "La implementación de programas de salud y bienestar para los estudiantes",
		        "La importancia de la educación financiera en la formación de los jóvenes",
		        "El fortalecimiento de la comunicación y colaboración entre docentes y personal administrativo",
		        "La promoción de la lectura y el amor por los libros en los estudiantes",
		        "El desarrollo de habilidades socioemocionales en el currículo escolar",
		        "La incorporación de la tecnología en el proceso de enseñanza-aprendizaje"
		    };

		        Random random = new Random();
		        String destinatario = destinatarios[random.nextInt(destinatarios.length)];
		        String tema = temas[random.nextInt(temas.length)];

		        String mensaje = "Estimado " + destinatario +" " + destinatarioCorreo + ",\n\n";
		        mensaje += "Espero que este mensaje te encuentres bien. Soy "+nombre+ ", [tu rol o posición] en [nombre de la escuela]. \nMe pongo en contacto contigo para discutir un tema importante relacionado con " + tema + ".\n\n";
		        mensaje += "[Explica brevemente el propósito de la correspondencia y por qué es relevante para la escuela].\n\n";
		        mensaje += "Me gustaría invitar a [participantes clave] a una reunión o discusión para abordar este tema y explorar posibles soluciones o acciones. \nCreo que es fundamental que [agrega una razón o beneficio].\n\n";
		        mensaje += "Por favor, házmelo saber si estás disponible para reunirnos y discutir más a fondo este tema. Agradezco tu tiempo y colaboración.\n\n";
		        mensaje += "Saludos cordiales,\n " + nombre;

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