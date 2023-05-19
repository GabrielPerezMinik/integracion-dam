package IesPerezMinik.Gestor.de.Correos.Api;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Pruebas {
	

	    public static void main(String[] args) {
	        String[] saludos = {"Hola", "Buenos días", "Buenas tardes", "Buenas noches", "Qué tal"};
	        String[] nombres = {"Juan", "María", "Pedro", "Lucía", "Antonio", "Carmen"};
	        String[] temas = {"Viaje", "Comida", "Trabajo", "Deporte", "Películas", "Música"};
	        String[] verbos = {"me gusta", "no me gusta", "quiero hablar de", "quiero comentar", "quiero compartir"};
	        String[] adverbios = {"mucho", "poco", "bastante", "muy poco", "muy bien", "mal"};

	        Random rand = new Random();

	        String mensaje = saludos[rand.nextInt(saludos.length)] + " " +
	                nombres[rand.nextInt(nombres.length)] + ", " +
	                verbos[rand.nextInt(verbos.length)] + " " +
	                "sobre " + temas[rand.nextInt(temas.length)] + ". " +
	                "Me interesa " + adverbios[rand.nextInt(adverbios.length)] + ". " +
	                "¿Qué piensas tú?";

	        System.out.println(mensaje);
	    }
	    
	    



	        private static final String[] saludos = {"Estimado/a", "Hola", "Buen día"};
	        private static final String[] despedidas = {"Saludos cordiales", "Atentamente", "Gracias"};
	        private static final String[] temas = {"sobre una nueva funcionalidad", "para una posible colaboración", "sobre una oferta especial"};
	        private static final String[] adjetivos = {"interesante", "innovador", "emocionante", "exclusivo"};
	        private static final String[] frasesComunes = {"Esperamos que se encuentre bien", "Le agradecemos por su tiempo", "Queríamos compartir con ustedes"};
	        private static final String[] llamadosAccion = {"No dude en contactarnos para más información", "Le invitamos a visitar nuestro sitio web para más detalles", "Le pedimos que nos informe de su decisión"};
	        private static final String[] despedidasFinales = {"Quedamos a la espera de su respuesta", "Muchas gracias por su atención", "Esperamos tener noticias suyas pronto"};

	        public static String generarCuerpoMensaje(String destinatario) {
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
	            cuerpo.append("Nombre del remitente");
	            return cuerpo.toString();
	        }

	        public static List<String> generarCuerposMensajes(List<String> destinatarios) {
	            List<String> cuerposMensajes = new ArrayList<>();
	            for (String destinatario : destinatarios) {
	                cuerposMensajes.add(generarCuerpoMensaje(destinatario));
	            }
	            return cuerposMensajes;
	        }

}
