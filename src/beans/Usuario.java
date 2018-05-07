package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the USUARIOS database table.
 * 
 */
@Entity
@Table(name="USUARIOS")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUARIO")
	private String idUsuario;

	private String apellido;

	private String direccion;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ALTA")
	private Date fechaAlta;

	private String nombre;

	private String password;

	@Column(name="TIPO_USUARIO")
	private String tipoUsuario;

	public Usuario() {
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", fechaAlta=" + fechaAlta + ", nombre=" + nombre + ", password=" + password + ", tipoUsuario="
				+ tipoUsuario + "]";
	}

	public void setFechaAlta(String parameter) {
		// TODO Auto-generated method stub
		
	}


	
	

}