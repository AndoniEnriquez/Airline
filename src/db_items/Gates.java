package db_items;
// Generated 04-ene-2017 11:51:08 by Hibernate Tools 5.1.0.Alpha1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Gates generated by hbm2java
 */

@Entity
@Table(name="Gates")
public class Gates implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	private int id;

	@Column(name="terminals")
	private Terminals terminals;
	
	@Column(name="name")
	private String name;

	public Gates() {
	}

	public Gates(int id, Terminals terminals) {
		this.id = id;
		this.terminals = terminals;
	}

	public Gates(int id, Terminals terminals, String name) {
		this.id = id;
		this.terminals = terminals;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Terminals getTerminals() {
		return this.terminals;
	}

	public void setTerminals(Terminals terminals) {
		this.terminals = terminals;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
