package pl.coderslab.dao;

import pl.coderslab.dbUtil.DBUtil;
import pl.coderslab.models.Group;
import pl.coderslab.models.User;


import java.sql.*;
import java.util.Arrays;

public class GroupDao {
    private static final String CREATE_GROUP_QUERY =
            "INSERT INTO users_group(group_name) VALUES (?)";
    private static final String READ_GROUP_QUERY = "SELECT * FROM users_group where group_id = ?";
    private static final String UPDATE_GROUP_QUERY =
            "UPDATE users_group SET group_name = ? where group_id = ?";
    private static final String DELETE_GROUP_QUERY = "DELETE FROM users_group WHERE group_id = ?";
    private static final String FIND_ALL_GROUP_QUERY = "SELECT * FROM users_group";


    public Group create(Group group) {
        try (Connection conn = DBUtil.getConnection()){
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_GROUP_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, group.getGroupName());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                group.setGroupId(resultSet.getInt(1));
            }
            return group;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Group read(int groupId) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_GROUP_QUERY);
            statement.setInt(1, groupId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Group group = new Group();
                group.setGroupId(resultSet.getInt("group_id"));
                group.setGroupName(resultSet.getString("group_name"));
                return group;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Group group) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_GROUP_QUERY);
            statement.setString(1, group.getGroupName());
            statement.setInt(2, group.getGroupId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int groupId) {
        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_GROUP_QUERY);
            statement.setInt(1, groupId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Group[] findAll() {
        try (Connection conn = DBUtil.getConnection()) {
            Group[] groups = new Group[0];
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_GROUP_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Group group = new Group();
                group.setGroupId(resultSet.getInt("group_id"));
                group.setGroupName(resultSet.getString("group_name"));
                groups = addToArray(group, groups);
            }
            return groups;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Group[] addToArray(Group g, Group[] groups) {
        Group[] tmpGroups = Arrays.copyOf(groups, groups.length + 1);
        tmpGroups[groups.length] = g;
        return tmpGroups;
    }



}

