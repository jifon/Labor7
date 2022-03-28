package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRep clientRep;

    public ClientServiceImpl(ClientRep clientRep) {
        this.clientRep = clientRep;
    }

    @Override
    public List<Client> clients(){
        return clientRep.findAll();
    }

    @Override
    public void createClient(Client client){
        clientRep.save(client);
    }

    @Override
    public void deleteClient(Long id){
        clientRep.deleteById(id);
    }

    @Override
    public Client updateClient(Long id){
        return clientRep.findById(id).get();
    }

}
