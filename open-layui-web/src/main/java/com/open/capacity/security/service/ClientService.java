package com.open.capacity.security.service;

import com.open.capacity.security.dto.OauthClientDetailsDto;

public interface ClientService {

    void saveClient(OauthClientDetailsDto clientDto);

    void deleteClient(Long id);
}
