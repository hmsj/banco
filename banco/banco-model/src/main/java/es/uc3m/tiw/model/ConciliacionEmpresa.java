package es.uc3m.tiw.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ConciliacionEmpresa implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idConciliacionEmpresa;
	
	@Column(nullable=false)
	private Integer day;
	
	@Column(nullable=false)
	private Integer month;
	
	@Column(nullable=false)
	private Integer year;
	

	public ConciliacionEmpresa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConciliacionEmpresa(Integer day, Integer month, Integer year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public Long getIdConciliacionEmpresa() {
		return idConciliacionEmpresa;
	}

	public void setIdConciliacionEmpresa(Long idConciliacionEmpresa) {
		this.idConciliacionEmpresa = idConciliacionEmpresa;
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
	
}
