package Module_8_JDBC.Task_Two.ConnectionPool;

import lombok.SneakyThrows;
import lombok.experimental.Delegate;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PooledConnection implements Connection {


    @Delegate(excludes = Closeable.class)
    private Connection connection;
    private Consumer<PooledConnection> closeConnection;


    @SneakyThrows
    public PooledConnection(Connection connection, Consumer<PooledConnection> connectionConsumer) {
        this.connection = connection;
        this.closeConnection = connectionConsumer;
        connection.setAutoCommit(true);

    }

    @Override
    public void close() throws SQLException {
        if (connection.isClosed()) {
            throw new ConnectionPoolException("Connection is closed!!!");
        }

        closeConnection.accept(this);
    }


    @SneakyThrows
    public void reallyClose() {
        connection.close();
    }



}
