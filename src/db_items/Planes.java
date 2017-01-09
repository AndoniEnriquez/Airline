package db_items;
// Generated 04-ene-2017 11:51:08 by Hibernate Tools 5.1.0.Alpha1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Planes generated by hbm2java
 */

@Entity
@Table(name="Planes")
public class Planes implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="Airline_id")
	private int airline_id;
	
	@Column(name="Plane_Model_id")
	private int planeModel_id;
	
	@Column(name="Plane_Status_id")
	private int planeStatu_id;

	public Planes() {
	}

	public Planes(int id, int airlines, int planeModels, int planeStatus) {
		this.id = id;
		this.airline_id = airlines;
		this.planeModel_id = planeModels;
		this.planeStatu_id = planeStatus;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAirline_id() {
		return airline_id;
	}

	public void setAirline_id(int airline_id) {
		this.airline_id = airline_id;
	}

	public int getPlaneModel_id() {
		return planeModel_id;
	}

	public void setPlaneModel_id(int planeModel_id) {
		this.planeModel_id = planeModel_id;
	}

	public int getPlaneStatu_id() {
		return planeStatu_id;
	}

	public void setPlaneStatu_id(int planeStatu_id) {
		this.planeStatu_id = planeStatu_id;
	}
}
