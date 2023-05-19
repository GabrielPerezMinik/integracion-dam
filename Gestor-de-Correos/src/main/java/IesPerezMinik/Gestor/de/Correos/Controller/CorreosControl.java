package IesPerezMinik.Gestor.de.Correos.Controller;

public class CorreosControl {

	public static void main(String[] args) {

		control();

	}

	public static void control() {
		String emailMicrosoft = "^[a-zA-Z0-9._%+-]+@(hotmail|outlook)\\.com$";
		String emailGmail = "^[a-zA-Z0-9._%+-]+@(gmail)\\.com";

		String email = "usuario@basura.com";
		if (email.matches(emailMicrosoft)) {
			System.out.println("El correo electrónico es de hotmail.com, outlook.com");
		} else if (email.matches(emailGmail)) {
			System.out.println("El correo electrónico es de gmail.com");
		} else {
			System.out.println("El correo electrónico no es de hotmail.com, outlook.com o gmail.com");
		}
	}

}
