package com.issler.patrick.QoSystem.telegram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.issler.patrick.QoSystem.entity.TelegramUser;


public class TelegramDataBase {

	public void editUserById(String id, String column, String newValue) {
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			 connection = getConnection();

			StringBuffer query = new StringBuffer();
			query.append("UPDATE telegram_user SET `"+column+"` = "+newValue+" WHERE (`id` = '"+id+"');");

			 stmt = connection.prepareStatement(query.toString());

			 stmt.execute();

		} catch (SQLException sql) {
			throw new RuntimeException(sql);
		} finally {
			closeStatement(stmt);
			closeConnection(connection);
		}
	}
	
	public void addNewUser(String chatid) {
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = getConnection();
			
			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO `qosystem`.`telegram_user` (`passo`, `chatid`, `registration_completed`) VALUES ('1', '"+chatid+"', False);");
			
			stmt = connection.prepareStatement(query.toString());
			
			stmt.execute();
			
		} catch (SQLException sql) {
			throw new RuntimeException(sql);
		} finally {
			closeStatement(stmt);
			closeConnection(connection);
		}
	}
	
	public TelegramUser findUserById(String chatid) {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			TelegramUser telegramUser = null;
			 connection = getConnection();

			StringBuffer query = new StringBuffer();
			query.append("SELECT * FROM telegram_user ");
			query.append("WHERE chatid = '" + chatid + "'");

			 stmt = connection.prepareStatement(query.toString());

			 result = stmt.executeQuery();

			while (result.next()) {
				telegramUser = new TelegramUser();
				telegramUser.setId(result.getLong(1));
				telegramUser.setAdress(result.getString(2));
				telegramUser.setName(result.getString(3));
				telegramUser.setNumber(result.getString(4));
				telegramUser.setPasso(result.getInt(5));
				telegramUser.setChatid(result.getString(6));
				telegramUser.setRegistrationCompleted(result.getBoolean(7));
			}
			return telegramUser;
		} catch (SQLException sql) {
			throw new RuntimeException(sql);
		} finally {
			closeResultSet(result);
			closeStatement(stmt);
			closeConnection(connection);
		}
	}
	
	
	
	
	
	protected void closeResultSet(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException sqle) {
			//logger.fatal(sqle);
		}
	}
	
	protected void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException sqle) {
			//logger.fatal(sqle);
		}
	}

	protected void closeStatement(PreparedStatement stmt) {
		try {
			stmt.close();
		} catch (SQLException sqle) {
			//logger.fatal(sqle);
		}
	}
	
	protected Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/qosystem", "root","root");
	}
	
}
