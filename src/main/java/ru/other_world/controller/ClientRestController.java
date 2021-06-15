package ru.other_world.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.other_world.model.Client;
import ru.other_world.model.Event;
import ru.other_world.model.Role;
import ru.other_world.model.TypeOfEvent;
import ru.other_world.repository.EventRepository;
import ru.other_world.service.ClientService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientRestController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/hello")
    public String hello(){
        return "Hello world!";
    }

    @GetMapping("/putuser")
    public String put(){
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("User"));
        List<Event> events = new ArrayList<>();
        events.add(new Event(TypeOfEvent.hallRental,"No com",
                LocalDateTime.now(), LocalDateTime.parse("2021-11-15T08:22:12")));
        Client client = new Client("First name", "Last name",
                "1@mail.ru", "88888", events, "123", roles);
        Client client1 = clientService.add(client);
        if(client1 == null){
            return "error";
        } else {
            return "Success with id=" + client1.getId();
        }
    }

    @GetMapping("/getall")
    public List<Client> getClientsList() {
        return clientService.listClients();
    }

    @GetMapping("/getevents")
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    @GetMapping("user/{email}")
    public Client getClientById(@PathVariable String email){
        return clientService.getByEmail(email);
    }
}