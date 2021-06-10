package ru.other_world.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.other_world.model.Client;
import ru.other_world.model.Role;
import ru.other_world.repository.ClientRepository;
import ru.other_world.repository.RoleRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    RoleRepository roleRepository;
    /*@Autowired
    BCryptPasswordEncoder passwordEncoder;*/

    @Override
    public Client add(Client user) {
        return clientRepository.save(user);
    }

    @Transactional
    @Override
    public Client add(Client user, List<Role> roles) {
        user.setRoles(roles);
        return clientRepository.save(user);
    }

    @Transactional
    @Override
    public boolean removeByEmail(String email) {
        clientRepository.delete(clientRepository.findByEmail(email));
        return true;
    }

    @Transactional
    @Override
    public boolean remove(Client user) {
        clientRepository.delete(user);
        return true;
    }

    @Transactional
    @Override
    public Client getById(Long id) {
        return clientRepository.getOne(id);
    }

    @Transactional
    @Override
    public Client getByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Transactional
    @Override
    public Client update(Client user, List<Role> roles) {
        user.setRoles(roles);
        return clientRepository.save(user);
    }

    @Transactional
    @Override
    public List<Client> listClients() {
        return clientRepository.findAll();
    }
}
