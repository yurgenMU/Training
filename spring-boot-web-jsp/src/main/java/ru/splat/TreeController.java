package ru.splat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class TreeController {
    NodeService nodeService = new NodeService();

    @RequestMapping(value = "/get_nodes", method = RequestMethod.GET)
//    @ResponseBody
    public Map<Long, String> getStrings(@RequestBody Node node){
//        return Arrays.asList("zlp", "залупа", "очко");
        return nodeService.getNodes(node.getId());
    }


    @RequestMapping(value = "/add_node", method = RequestMethod.POST)
    @ResponseBody
    public void addNode(Node node){
        nodeService.addNode(node);
    }
}
