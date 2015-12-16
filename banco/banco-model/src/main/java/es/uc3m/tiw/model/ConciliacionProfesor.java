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
	private Long idConciliacionProfesor;
	
	@Column(nullable=false)
	private Integer day;
	
	@Column(nullable=false)
	private Integer month;
	
	@Column(nullable=false)
	private Integer year;
	
	@Column(nullable=false)
	private Double importe;

	@Column(nullable=false)
	private Long idProfesor;
	
	public ConciliacionProfesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConciliacionProfesor(Integer day, Integer month, Integer year,
			Double importe, Long idProfesor) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
		this.importe = importe;
		this.idProfesor = idProfesor;
	}

	public Long getIdConciliacionProfesor() {
		return idConciliacionProfesor;
	}

	public void setIdConciliacionProfesor(Long idConciliacionProfesor) {
		this.idConciliacionProfesor = idConciliacionProfesor;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Long getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Long idProfesor) {
		this.idProfesor = idProfesor;
	}
	
}
