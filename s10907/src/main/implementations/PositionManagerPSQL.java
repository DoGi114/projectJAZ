package main.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.ListDataModel;

import main.classes.Position;
import main.dataBase.PSQL;
import main.interfaces.PositionManagerInt;

@ApplicationScoped
public class PositionManagerPSQL implements PositionManagerInt {

	@Override
	public void addPosition(Position position) throws SQLException {
		Connection dbConnection = null;
		java.sql.Statement statement = null;
		try {

			dbConnection = PSQL.getConnection();
			statement = dbConnection.createStatement();
			String addPosition = "insert into position(id_position, name, sallary) values ('"
					+ position.getId()
					+ "' , '"
					+ position.getName()
					+ "' , '"
					+ position.getSallary() + "')";
			statement.executeUpdate(addPosition);
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	@Override
	public void deletePosition(Position position) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String deletePosition = "DELETE FROM position WHERE id_position = '"
				+ position.getId() + "'";
		try {
			dbConnection = PSQL.getConnection();
			preparedStatement = dbConnection.prepareStatement(deletePosition);

			// execute delete SQL stetement
			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	@Override
	public void updateSallary(Position position) throws SQLException {
		Connection dbConnection = null;
		java.sql.Statement statement = null;
		try {

			dbConnection = PSQL.getConnection();
			statement = dbConnection.createStatement();
			String positionUpdate = "UPDATE position SET sallary = "
					+ position.getSallary() + "  WHERE id = "
					+ position.getName() + ";";
			statement.executeUpdate(positionUpdate);

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	@Override
	public List<Position> getAll() throws SQLException {
		List<Position> results = new ArrayList<Position>();
		Connection dbConnection = null;
		java.sql.Statement statement = null;
		String selectCourses = "SELECT id_position, name, sallary FROM position";
		try {
			dbConnection = PSQL.getConnection();
			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery(selectCourses);

			while (rs.next()) {
				Position position = new Position();
				int id = rs.getInt("id_position");
				String name = rs.getString("name");
				int sallary = rs.getInt("sallary");
				position.setId(id);
				position.setName(name);
				position.setSallary(sallary);
				results.add(position);
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		return results;

	}

}
