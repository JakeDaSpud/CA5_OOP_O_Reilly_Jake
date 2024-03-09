package DAOs;

// File started by Jake O'Reilly

import DTOs.Instrument;
import Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySqlInstrumentDao extends MySqlDao implements InstrumentDaoInterface {

    // Feature 1 – Get all Entities (assuming Player entities in this example)
    // e.g. getAllPlayers() - return a List of all the entities and display the returned list.
    // Ciara
    @Override
    public List<Instrument> getAllInstruments() throws DaoException {
        return null;
    }

    // Feature 2 – Find and Display (a single) Entity by Key
    // e.g. getPlayerById(id ) – return a single entity (DTO) and display its contents.
    // Ciara
    @Override
    public Instrument getInstrumentById(String id) throws DaoException {
        return null;
    }

    // Feature 3 – Delete an Entity by key
    // e.g. deletePlayerById(id) – remove specified entity from database
    // Felix
    @Override
    public void deleteInstrumentById(String id) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Instrument instrument = null;
        try
        {
            connection = this.getConnection();

            String query = "SELECT * FROM instruments";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                int ID = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getFloat("price");
                String type = resultSet.getString("type");

                instrument = new Instrument(ID, name, price, type);
                System.out.println(instrument);
            }

        } catch (SQLException e)
        {
            throw new DaoException("delete insturment() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (preparedStatement != null)
                {
                    preparedStatement.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("delete instrument error: " + e.getMessage());
            }
        }
    }

    // Feature 4 – Insert an Entity
    // (gather data, instantiate a Player object, pass into DAO method for insertion in DB)
    // e.g. Player insertPlayer(Player p)
    // return new entity (Player DTO) that includes the assigned auto-id.
    // Felix
    @Override
    public Instrument insertInstrument(Instrument i) throws DaoException {
        return null;
    }
}
