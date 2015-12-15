package es.uc3m.tiw.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ConciliacionProfesor implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPedido;
	
	@Column(nullable=false, unique = true)
	private String codigoPedido;
	
	@Column(nullable=false)
	private double importe;
	
	@Column//(nullable=false)
	private String codigoOperacion;
	
	@Column(nullable=false)
	private String codigoTarjeta;
	
	@Column(nullable=false)
	private Date fechaPedido;

	public ConciliacionProfesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConciliacionProfesor(String codigoPedido, double importe, String codigoOperacion,
			String codigoTarjeta, Date fechaPedido) {
		super();
		this.codigoPedido = codigoPedido;
		this.importe = importe;
		this.codigoOperacion = codigoOperacion;
		this.codigoTarjeta = codigoTarjeta;
		this.fechaPedido = fechaPedido;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public String getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(String codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getCodigoOperacion() {
		return codigoOperacion;
	}

	public void setCodigoOperacion(String codigoOperacion) {
		this.codigoOperacion = codigoOperacion;
	}

	public String getCodigoTarjeta() {
		return codigoTarjeta;
	}

	public void setCodigoTarjeta(String codigoTarjeta) {
		this.codigoTarjeta = codigoTarjeta;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	
}
