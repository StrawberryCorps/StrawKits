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

        // Create the DB structure if not exists
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "create table if not exists kits(id INTEGER constraint kits_pk primary key autoincrement, name varchar(255) not null, utilisation text not null);" +
                    "create unique index if not exists kits_name_uindex on kits (name);" +
                    "create table if not exists kit_content(kit_id integer references kits(id) on delete cascade, item text not null, position integer not null);" +
                    "create unique index if not exists kit_content_kit_id_position_uindex on kit_content (kit_id, position);" +
                    "create table if not exists kit_history(id integer constraint kit_history_pk primary key autoincrement, kit_id integer not null references kits(id) on delete cascade, uuid VARCHAR(32) not null, date timestamp default CURRENT_TIMESTAMP not null);"
            );
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        Connection connection =  this.dataSource.getConnection();
        return connection;
    }

    public void close() throws SQLException {
        BasicDataSource basicDataSource = (BasicDataSource) this.dataSource;
        basicDataSource.close();
    }

}
