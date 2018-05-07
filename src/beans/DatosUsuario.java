package beans;

import java.util.Date;

import javax.persistence.Column;

public class DatosUsuario {

	private String nombre;
	private String apellido;
	private String direccion;
	private Date fechaAlta;
	private String password;
	private String tipoUsuario;
	private Usuario usuario;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "DatosUsuario [nombre=" + nombre + ", direccion=" + direccion + ", fechaAlta=" + fechaAlta
				+ ", password=" + password + ", tipoUsuario=" + tipoUsuario + ", usuario=" + usuario + "]";
	}
	public void setFechaAlta(String parameter) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
