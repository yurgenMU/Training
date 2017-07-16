package ru.splat.DAO;


import ru.splat.model.Node;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

public class NodeDAOImpl implements NodeDAO {
    private static String userName;
    private static String password;
    private static String db1;
    private static String url;
    private Connection connection;

    public NodeDAOImpl() {
        connection = connect();
        checkTable();
    }

    public void checkTable() {
        Statement st = null;
        try {
            st = connection.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS NODE (ID BIGINT NOT NULL," +
                    " NAME VARCHAR (255) NOT NULL, PARENT_ID BIGINT (20), PRIMARY KEY(ID));");
            st.execute("CREATE TABLE IF NOT EXISTS REMOVED_NODES (ID BIGINT NOT NULL, PRIMARY KEY(ID));");
        } catch (SQLException e) {
            System.out.println("Error while creating node " + e.getMessage());
        }
    }

    @Override
    public List<Node> getChildNodes(long id) {
        final String sql = "SELECT * FROM node WHERE parent_id = " + id + ";";
        List<Node> nodes = new ArrayList<>();
        Statement st;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                Node node = new Node();
                node.setId(rs.getLong(0));
                node.setParentId(rs.getLong(2));
                node.setName(rs.getString(1));
                nodes.add(node);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nodes;

    }

    @Override
    public Node getRoot() {
        final String sql = "SELECT * FROM node WHERE parent_id = 0;";
        Statement st;
        Node root = new Node();
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            root.setId(rs.getLong(0));
            root.setParentId(rs.getLong(2));
            root.setName(rs.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return root;
    }

    @Override
    public long addNode(Node node) {
        Long id = createId();
        node.setId(id);
        final String sql = "INSERT INTO node (id, parent_id, name) VALUES (" + node.getId() + "," +
                node.getParentId() + "," + node.getName() + ");";
        Statement st;
        try {
            st = connection.createStatement();
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void deleteNodes(int id) {
        final String delete = "UPDATE node SET parent_id = -1 WHERE id = " + id + ";";
        final String insert = "INSERT INTO delete_nodes (id) VALUES (" + id + ");";
        Statement st;
        try {
            st = connection.createStatement();
            st.execute(delete);
            st.execute(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void renameNode(Node node) {
        final String sql = "UPDATE node SET name = "+ node.getName() +" WHERE id = "+node.getId()+";";
        Statement st;
        try {
            st = connection.createStatement();
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void moveNode(long id, long parentId) {
        final String sql = "UPDATE node SET parent_id = "+parentId+" WHERE id ="+id+";";
        Statement st;
        try {
            st = connection.createStatement();
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection connect() {
        Connection c = null;
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/resources/DBConnectionConfig.properties");
            property.load(fis);
            userName = property.getProperty("db.userName");
            password = property.getProperty("db.password");
            db1 = property.getProperty("db.name"); // База данных, с которой работаем
            url = property.getProperty("db.url");
        } catch (IOException e) {
            System.err.println("Error! Unable to find property file");
        }
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            c = DriverManager.getConnection(url + db1, userName, password);
        } catch (Exception e) {
            System.out.println("Error while connecting " + e);
        }
        return c;
    }

    public static synchronized Long createId() {
        AtomicInteger id = new AtomicInteger();
        return Long.valueOf(id.incrementAndGet());
    }
}
