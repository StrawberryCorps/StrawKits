package bzh.strawberry.kits.util;

import bzh.strawberry.kits.StrawKits;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StorageUtil {

    private static StorageUtil storageUtil;
    private DataSource dataSource;

    public static StorageUtil getInstance() {
        if (storageUtil == null)
            storageUtil = new StorageUtil();
        return storageUtil;
    }

    private StorageUtil() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:" + StrawKits.getInstance().getDataFolder() + File.separator + "strawkits.db");
        dataSource.setInitialSize(1);
        dataSource.setMaxTotal(10);
        this.dataSource = dataSource;
    }

    public PreparedStatement preparedStatement(String sql) throws SQLException {
        Connection connection =  this.dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        connection.close();
        return preparedStatement;
    }

    public void close() throws SQLException {
        BasicDataSource basicDataSource = (BasicDataSource) this.dataSource;
        basicDataSource.close();
    }

}
