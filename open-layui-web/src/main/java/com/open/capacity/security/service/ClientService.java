package com.open.capacity.security.service;

import com.open.capacity.security.dto.ClientDto;

public interface ClientService {

    void saveClient(ClientDto clientDto);

    void deleteClient(Long id);
}
