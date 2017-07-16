package ru.splat.DAO;

import ru.splat.model.Node;

import java.util.List;

public interface NodeDAO
{
    List<Node> getChildNodes(final long id);


    Node getRoot();


    long addNode(final Node node);


    void deleteNodes(final int id);


    void renameNode(final Node node);


    void moveNode(long id, long parentId);
}