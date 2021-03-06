package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.AirlinesDAO;
import db_items.Airlines;

public class AirlinesAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Airlines airline;
	private List<Airlines> airlinesList;
	private int id;
	private int totalAirlines;
	private AirlinesDAO airlinesDao;

	public AirlinesAction() {
		airlinesDao = new AirlinesDAO();
	}
	
	public String execute() {
		this.airlinesList = airlinesDao.list();
		this.totalAirlines = airlinesDao.list().size();
		return SUCCESS;
	}
	
	public String add() {
		try {
			Airlines airline = getAirline();
			airline.setId(airlinesDao.list().get(airlinesDao.list().size() - 1).getId() + 1);
			airlinesDao.add(airline);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.airlinesList = airlinesDao.list();
		this.totalAirlines = airlinesDao.list().size();
		return SUCCESS;
	}
	
	public String list(){
		this.airlinesList = airlinesDao.list();
		return SUCCESS;
	}
	
	public String delete(){
		airlinesDao.delete(getId());
		return SUCCESS;
	}

	public Airlines getAirline() {
		return airline;
	}

	public void setAirline(Airlines airline) {
		this.airline = airline;
	}

	public List<Airlines> getAirlinesList() {
		return airlinesList;
	}

	public void setAirlinesList(List<Airlines> airlinesList) {
		this.airlinesList = airlinesList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotalAirlines() {
		return totalAirlines;
	}

	public void setTotalAirlines(int totalAirlines) {
		this.totalAirlines = totalAirlines;
	}
}