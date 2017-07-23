package ru.splat;

public class Node {
    private long id;
    private String name;
    private long parentId;

    public Node(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Node() {

    }

    public Node(long id, String name, long parentId) {

        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
}
