package ru.other_world.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.other_world.model.Client;
import ru.other_world.model.Role;
import ru.other_world.service.ClientService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientRestController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello world!";
    }

    @GetMapping("/putuser")
    public String put(){
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("User"));
        Client client = new Client("First name", "Last name",
                "1@mail.ru", "88888", "123", roles);
        if(clientService.add(client) != null){
            return "error";
        } else {
            return "Success";
        }
    }

    @GetMapping("/getall")
    public List<Client> getClientsList() {
        return clientService.listClients();
    }

    @GetMapping("user/{email}")
    public Client getClientById(@PathVariable String email){
        return clientService.getByEmail(email);
    }
}