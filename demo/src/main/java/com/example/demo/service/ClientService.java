package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRep;

import java.util.List;

public interface ClientService {

    public List<Client> clients();

    public void createClient(Client client);

    public void deleteClient(Long id);
    public Client updateClient(Long id);

}
