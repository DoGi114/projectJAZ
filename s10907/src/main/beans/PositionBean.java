package main.beans;

import java.io.Serializable;
import java.sql.SQLException;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import main.classes.Position;
import main.implementations.PositionManagerPSQL;

@SessionScoped
@Named("positionBean")
public class PositionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Position position = new Position();
	
	@Inject
	private PositionManagerPSQL pm;
	
	public Position getPosition(){
		return position;
	}
	
	public void setPosition(Position position){
		this.position = position;
	}
	
	public void getAll() throws SQLException{
		pm.getAll();
	}
	
	public String addPosition() throws SQLException{
		pm.addPosition(position);
		return null;
	}
}
