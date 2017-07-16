package ru.splat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.splat.model.Node;
import ru.splat.model.NodeService;

import java.util.List;


@Controller
@RequestMapping
public class MainController {

    @Autowired
    NodeService nodeService;


    @GetMapping(value = "/")
    public String getMainPage(final Model model)
    {
        model.addAttribute("root", nodeService.getRoot());
        return "index";
    }


    @GetMapping(value = "/root")
    public @ResponseBody Node getRoot()
    {
        return nodeService.getRoot();
    }


    @PostMapping(value = "/move_node")
    public @ResponseBody void moveNodes(@RequestParam("id") final long id, @RequestParam("parentId") final long parentId)
    {
        nodeService.moveNode(id, parentId);
    }


    @GetMapping("/node")
    public @ResponseBody List<Node> getChildNodes(@RequestParam("id") final long id)
    {
        return nodeService.getChildNodes(id);
    }


    @PostMapping("/node")
    public @ResponseBody long addNode(@RequestBody final Node node)
    {
        return nodeService.addNode(node);
    }


    @PostMapping("/delete_node")
    public @ResponseBody void deleteNodes(@RequestParam("id") final Integer id)
    {
        nodeService.deleteNodes(id);
    }


    @PostMapping("/rename_node")
    public @ResponseBody void renameNode(@RequestBody final Node node)
    {
        nodeService.renameNode(node);
    }
}