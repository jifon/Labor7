package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.service.ClientServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sale-manager")
public class SaleManagerCntrl {
    private final ClientServiceImpl clientServiceImpl;

    public SaleManagerCntrl(ClientServiceImpl clientServiceImpl) {
        this.clientServiceImpl = clientServiceImpl;
    }
    @GetMapping
    public String saleManager(){
        return "saleManager/manager";
    }
    @GetMapping("/client")
    public String clientList(Model model){
        model.addAttribute("clients", clientServiceImpl.clients());
        return "saleManager/clientList";
    }
    @GetMapping("/client/newClient")
    public String  newClient(Model model){
        model.addAttribute("client", new Client());
        return "saleManager/client_form";
    }
    @PostMapping("/client/save")
    public String createClient(Client client){
        clientServiceImpl.createClient(client);
        return "redirect:/sale-manager/client";
    }
    @GetMapping("/client/delete/{id}")
    public String deleteClient(@PathVariable("id") Long id){
        clientServiceImpl.deleteClient(id);
        return "redirect:/sale-manager/client";
    }
    @GetMapping("/client/edit/{id}")
    public String editClient(@PathVariable("id") Long id, Model model){
        Client client = clientServiceImpl.updateClient(id);
        model.addAttribute("client", client);
        return "/saleManager/client_form";
    }
}
