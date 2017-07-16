package ru.splat.model;

import ru.splat.DAO.NodeDAO;

import java.util.List;

/**
 * Created by Женя on 15.07.2017.
 */
public class NodeService {
    NodeDAO nodeDAO;


    public List<Node> getChildNodes(final long id)
    {
        return nodeDAO.getChildNodes(id);
    }


    public Node getRoot()
    {
        return nodeDAO.getRoot();
    }


    public long addNode(final Node node)
    {
        return nodeDAO.addNode(node);
    }


    public void deleteNodes(final int id)
    {
        nodeDAO.deleteNodes(id);
    }


    public void renameNode(final Node node)
    {
        nodeDAO.renameNode(node);
    }


    public void moveNode(long id, long parentId)
    {
        nodeDAO.moveNode(id, parentId);
    }
}
