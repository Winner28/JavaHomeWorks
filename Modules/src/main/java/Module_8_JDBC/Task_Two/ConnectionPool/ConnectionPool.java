package Module_8_JDBC.Task_Two.ConnectionPool;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool implements Closeable {

    private static final int DEFAULT_POOL_SIZE = 5;
    private BlockingQueue<PooledConnection> connectionQueue;

    public ConnectionPool() {

        Properties properties = new Properties() {
             Properties load(String path) {
                try (InputStream inputStream = getClass().getResourceAsStream(path)) {
                    load(inputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return this;
            }
        }.load("/jdbc.properties");


        try {
            Class.forName((String) properties.remove("driver"));
            String url = (String) properties.remove("url");

            connectionQueue = new ArrayBlockingQueue<>(5);
            for (int i = 0; i < 5; i++) {
                connectionQueue.add(new PooledConnection(DriverManager.getConnection(url, properties), connection -> {
                       connectionQueue.offer(connection);
                }));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Connection getConnection() {
        try {
            return connectionQueue.take();
        } catch (InterruptedException e) {
            throw new ConnectionPoolException("Connection Pool Exception!");
        }
    }




    @Override
    public void close() throws IOException {
        Iterator<PooledConnection> iterator = connectionQueue.iterator();
        while(iterator.hasNext()) {
            iterator.next().reallyClose();
            iterator.remove();
        }
    }
}
