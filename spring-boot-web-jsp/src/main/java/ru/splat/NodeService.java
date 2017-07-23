package ru.splat;

import java.util.*;

public class NodeService {
    List<Node> nodes = new ArrayList<Node>();

    public NodeService() {
        addNode(new Node(1, "child1",0));     //Просто чтобы протестировать
        addNode(new Node(2,"child2",0));
    }

    public Map<Long, String> getNodes(Long parentId){
        Map<Long,String> ans = new HashMap<>();
        for(Node n : nodes){
            System.out.println(n.getId() + "; " + n.getName());
            if (n.getId() == parentId){
                ans.put(n.getId(), n.getName());
            }
        }
        return ans;
    }

    public void addNode(Node node){
        nodes.add(node);
    }
}
