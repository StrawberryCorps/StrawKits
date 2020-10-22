package bzh.strawberry.kits.util;

import bzh.strawberry.kits.StrawKits;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * This file StorageUtil is part of a project StrawKits.StrawKits.
 * It was created on 22/10/2020 22:28 by Eclixal.
 * This file as the whole project shouldn't be modify by others without the express permission from StrawberryCorps author(s).
 *  Also this comment shouldn't get remove from the file. (see Licence)
 */

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
