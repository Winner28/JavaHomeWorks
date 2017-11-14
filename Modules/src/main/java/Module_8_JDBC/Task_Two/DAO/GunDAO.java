package Module_8_JDBC.Task_Two.DAO;

import Module_8_JDBC.Task_Two.ConnectionPool.ConnectionPool;
import Module_8_JDBC.Task_Two.model.Gun;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class GunDAO implements GunDAOINT {
    private ConnectionPool connectionPool;

    public GunDAO() {
        connectionPool = new ConnectionPool();
    }


    @Override
    public Optional<Set<Gun>> getAllGuns() {
       return mapStatementResultSet(resultSet -> Optional.of(getGuns(resultSet)),
               connectionPool.getConnection(), GunDAO.showBase);
    }

    @Override
    public Optional<Gun> getGunById(int id) {
        return mapPreparedStatement(preparedStatement -> {
            try {
                preparedStatement.setInt(1, id);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                return Optional.of(getGun(preparedStatement.executeQuery()));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }, connectionPool.getConnection(), GunDAOINT.getById);
    }

    @Override
    public Optional<List<Gun>> getGunsByName(String name) {
        return mapPreparedStatement(preparedStatement -> {
            try {
                preparedStatement.setString(1, name);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                return Optional.of(getGunsByParam(preparedStatement.executeQuery()));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }, connectionPool.getConnection(), GunDAOINT.getById);
    }


    @Override
    public Optional<List<Gun>> getGunsByCaliber(Double caliber) {
        return mapPreparedStatement(preparedStatement -> {
            try {
                preparedStatement.setDouble(1, caliber);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                return Optional.of(getGunsByParam(preparedStatement.executeQuery()));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }, connectionPool.getConnection(), GunDAOINT.getByCaliber);
    }

    @Override
    public void updateGun(int id, String name, Double caliber) {
        withPreparedStatement(preparedStatement -> {
            try {
                preparedStatement.setString(1, name);
                preparedStatement.setDouble(2, caliber);
                preparedStatement.setInt(3, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }, connectionPool.getConnection(), GunDAOINT.updateRow);
    }

    @Override
    public void insertGun(String name, Double caliber) {
        withPreparedStatement(preparedStatement -> {
            try {
                preparedStatement.setString(1, name);
                preparedStatement.setDouble(2, caliber);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }, connectionPool.getConnection(), GunDAOINT.insertRow);
    }

    @Override
    public void deleteGun(int id) {
        withPreparedStatement(preparedStatement -> {
            try {
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }, connectionPool.getConnection(), GunDAOINT.deleteById);
    }

    @Override
    public void deleteGun(String name) {
        withPreparedStatement(preparedStatement -> {
            try {
                preparedStatement.setString(1, name);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }, connectionPool.getConnection(), GunDAOINT.deleteByName);
    }

    @Override
    public void deleteGun(Double caliber) {
        withPreparedStatement(preparedStatement -> {
            try {
                preparedStatement.setDouble(1, caliber);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }, connectionPool.getConnection(), GunDAOINT.deleteByCaliber);
    }


    @Override
    public void dropTable() {
        withStatement(statement -> {
            try {
                statement.executeUpdate(GunDAOINT.dropBase);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            System.out.println("Base deleted!");
        }, connectionPool.getConnection());
    }
}
