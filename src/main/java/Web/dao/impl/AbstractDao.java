/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.dao.impl;

import Web.dao.IGenericDao;
import static Web.dao.impl.CategoryDAO.getConnection;
import Web.mapper.IRowMapper;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class AbstractDao<T> implements IGenericDao<T> {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/javaweb";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "riengminhem123";

    public static Connection getConnection(String dbURL, String userName,
            String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("connect failure!");
        }
        return conn;
    }

    @Override
    public <T> List<T> querỵ̣(String sql, IRowMapper<T> rowMapper, Object... os) {
        List<T> results = new ArrayList<>();
        Connection connection = getConnection(DB_URL, USER_NAME, PASSWORD);
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            setParameter(statement, os);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                results.add(rowMapper.mapRow(resultSet));
            }
            return results;
        } catch (SQLException ex) {
            Logger.getLogger(AbstractDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    private void setParameter(PreparedStatement statement, Object... os) throws SQLException {
        for (int i = 0; i < os.length; i++) {
            int index = i + 1;
            Object ost = os[i];
            if (ost instanceof Long) {
                statement.setLong(index, (Long) ost);
            } else if (ost instanceof String) {
                statement.setString(index, (String) ost);
            } else if (ost instanceof Integer) {
                statement.setInt(index, (Integer) ost);
            } else if (ost instanceof Timestamp) {
                statement.setTimestamp(index, (Timestamp) ost);
            } else if (ost instanceof Float) {
                statement.setFloat(index, (Float) ost);
            } else if (ost instanceof Timestamp) {
                statement.setTimestamp(index, (Timestamp) ost);
            } else if (ost instanceof Blob) {
                statement.setBlob(index, (Blob) ost);
            }
        }
    }

    @Override
    public void update(String sql, Object... os) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = getConnection(DB_URL, USER_NAME, PASSWORD);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            setParameter(statement, os);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Long insert(String sql, Object... os) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Long id = null;
        Connection connection = null;
        try {
            connection = getConnection(DB_URL, USER_NAME, PASSWORD);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameter(statement, os);
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getLong(1);
            }
            connection.commit();
            return id;
        } catch (SQLException ex) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public int count(String sql, Object... os) {
        Connection connection = getConnection(DB_URL, USER_NAME, PASSWORD);
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            int count = 0;
            statement = connection.prepareStatement(sql);
            setParameter(statement, os);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(AbstractDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
}
