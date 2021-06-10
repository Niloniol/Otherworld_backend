package ru.other_world.service;

import ru.other_world.model.Client;
import ru.other_world.model.Role;

import java.util.List;

public interface ClientService {
    Client add(Client user);
    Client add(Client user, List<Role> roles);
    boolean remove(Client user);
    boolean removeByEmail(String email);
    Client getById(Long id);
    Client getByEmail(String email);
    Client update(Client user, List<Role> roles);
    List<Client> listClients();
}
