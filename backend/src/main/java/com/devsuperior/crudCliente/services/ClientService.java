package com.devsuperior.crudCliente.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.crudCliente.dto.ClientDTO;
import com.devsuperior.crudCliente.entities.Client;
import com.devsuperior.crudCliente.exceptions.DataBaseException;
import com.devsuperior.crudCliente.exceptions.ResourceNotFoundException;
import com.devsuperior.crudCliente.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest){
		Page<Client> list = repository.findAll(pageRequest);
		return list.map(x -> new ClientDTO(x));
	}
	
	@Transactional(readOnly = true)
		public ClientDTO findById(Long id) {
			Optional<Client> cli = repository.findById(id);
			Client client = cli.orElseThrow(()-> new ResourceNotFoundException("Client Not found"));
			return new ClientDTO(client); 
		}
	
	@Transactional(readOnly = true)
		public ClientDTO insert(ClientDTO dto) {
		Client client = new Client();
		client.setName(dto.getName());
		client.setCpf(dto.getCpf());
		client.setIncome(dto.getIncome());
		client.setBirthDate(dto.getBirthDate());
		client.setChildren(dto.getChildren());
		client = repository.save(client);
		return new ClientDTO(client);
	}
	
	@Transactional
		public ClientDTO update (Long id,ClientDTO dto) {
		
			try {
				Client cli = repository.getOne(id);
				cli.setName(dto.getName());
				cli.setCpf(dto.getCpf());
				cli.setIncome(dto.getIncome());
				cli.setBirthDate(dto.getBirthDate());
				cli.setChildren(dto.getChildren());
				cli = repository.save(cli);
				return new ClientDTO(cli);
			}
			catch(EntityNotFoundException e){
				throw new ResourceNotFoundException("Id not found");
			}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found");
		}
		catch(DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity violation");
		}

	}
	
	
	}

