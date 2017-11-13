package Module_8_JDBC.Task_Two.DAO;

import Module_8_JDBC.Task_Two.ConnectionPool.ConnectionPool;
import Module_8_JDBC.Task_Two.model.Gun;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Optional;

public class GunDAO implements GunDAOInt {
    private ConnectionPool connectionPool;

    public GunDAO() {
        connectionPool = new ConnectionPool();
    }


    @Override
    public Optional<HashSet<Gun>> getAllGuns() {
       withStatementResultSet(this::showDB, connectionPool.getConnection(), GunDAOInt.showBase);
       return null;
    }

    @Override
    public Optional<Gun> getGunById() {
        return null;
    }

    @Override
    public Optional<Gun> getGunByName() {
        return null;
    }

    @Override
    public Optional<Gun> getGunsByCaliber() {
        return null;
    }

    @Override
    public void updateGun(int id, String name, Double caliber) {

    }

    @Override
    public void insertGun(String name, Double caliber) {

    }

    @Override
    public boolean deleteGun(int id) {
        return false;
    }

    @Override
    public boolean deleteGun(String name) {
        return false;
    }

    @Override
    public boolean deleteGun(Double caliber) {
        return false;
    }

    @Override
    public void dropTable() {

    }
}
