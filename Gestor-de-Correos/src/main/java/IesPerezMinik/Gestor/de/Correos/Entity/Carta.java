package IesPerezMinik.Gestor.de.Correos.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Carta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String correosClientes;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Carta(int id, String correosClientes, Usuario usuario) {
		super();
		this.id = id;
		this.correosClientes = correosClientes;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreosClientes() {
		return correosClientes;
	}

	public void setCorreosClientes(String correosClientes) {
		this.correosClientes = correosClientes;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
