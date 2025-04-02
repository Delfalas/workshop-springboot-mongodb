package com.delfalas.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delfalas.workshopmongo.domain.User;
import com.delfalas.workshopmongo.dto.UserDTO;
import com.delfalas.workshopmongo.repository.UserRepository;
import com.delfalas.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	//READ
	public List<User> findAll() {
		return repo.findAll();
	}
	
	//READ
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
 		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	//CREATE
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	//DELETE
	public void delete(String id) {
 		findById(id);
 		repo.deleteById(id);
 	}
	
	public User fromDTO(UserDTO objDto) {
 		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
 	}

}
