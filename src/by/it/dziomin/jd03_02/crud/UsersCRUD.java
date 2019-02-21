package by.it.dziomin.jd03_02.crud;

import by.it.dziomin.jd03_02.DBConnector;
import by.it.dziomin.jd03_02.beans.Roles;
import by.it.dziomin.jd03_02.beans.Users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersCRUD {


    public boolean create(Users user) {
        try {
            String sql = String.format(
                    "INSERT INTO `dziomin`.`users` (`id`, `name`, `passport`, `phone`, `roles_id`) " +
                            "VALUES ('%d', '%s', '%s', '%s', %d);",
                    user.getId(),
                    user.getName(),
                    user.getPassport(),
                    user.getPhone(),
                    user.getRoleId());
            int count = DBConnector.getStatement().executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = DBConnector.getStatement().getGeneratedKeys();
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Users user) {
        try {
            String sql = String.format(
                    "UPDATE `users` SET `name`='%s'," + "`passport`='%s'," + "`phone`='%s'," + "`roles_id`='%d'" +
                            "WHERE `id`='%d'",
                    user.getName(),
                    user.getPassport(),
                    user.getPhone(),
                    user.getRoleId(),
                    user.getId());
            return 1 == DBConnector.getStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Users user) {
        try {
            String sql = String.format(
                    "DELETE FROM `users` WHERE `id`='%d'",
                    user.getId());

            return 1 == DBConnector.getStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Users read(long id) {
        try {
            String sql = String.format(
                    "SELECT * FROM `users` WHERE `id`='%d'",
                    id);
            ResultSet resultSet = DBConnector.getStatement().executeQuery(sql);
            if (resultSet.next()) {
                Users user = new Users();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setPassport(resultSet.getString("passport"));
                user.setPhone(resultSet.getString("phone"));
                user.setRoleId(resultSet.getLong("roles_id"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}