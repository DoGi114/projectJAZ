package main.beans;

import java.io.Serializable;
import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import main.classes.Position;
import main.implementations.PositionManagerPSQL;

@RequestScoped
@ManagedBean(name="positionBean")
public class PositionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Position position = new Position();
	
	private ListDataModel<Position> positions = new ListDataModel<Position>();
	
	public ListDataModel<Position> getPositions() {
		return positions;
	}

	public void setPositions(ListDataModel<Position> positions) {
		this.positions = positions;
	}


	@Inject
	private PositionManagerPSQL pm;
	
	public Position getPosition(){
		return position;
	}
	
	public void setPosition(Position position){
		this.position = position;
	}
	
	public String getAll() throws SQLException{
		positions.setWrappedData(pm.getAll());
		return "getPositions";
		
	}
	
	public String addPosition() throws SQLException{
		pm.addPosition(position);
		positions.setWrappedData(pm.getAll());
		return "getPosition";
	}
	
	
	public String deletePosition() throws SQLException{
		pm.deletePosition(position);
		positions.setWrappedData(pm.getAll());
		return "getPosition";
	}
}
