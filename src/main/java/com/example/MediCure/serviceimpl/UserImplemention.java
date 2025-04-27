package com.example.MediCure.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MediCure.dao.UserRepository;
import com.example.MediCure.entity.User;
import com.example.MediCure.exception.ResourceNotFoundException;
import com.example.MediCure.payloads.LoginDTO;
import com.example.MediCure.payloads.UserDTO;
import com.example.MediCure.service.UserService;

@Service
public class UserImplemention implements UserService {

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDTO createUser(UserDTO userdto) {
		User user=mapper.map(userdto, User.class);
		repo.save(user);
		return mapper.map(user, UserDTO.class);
	}

	@Override
	public List<UserDTO> viewAll() {
		List<User> users=repo.findAll();
		List<UserDTO> dto=users.stream().map(c->mapper.map(c, UserDTO.class)).collect(Collectors.toList());
		return dto;
	}

	@Override
	public UserDTO updateUser(UserDTO userdto, Integer id) {
		User user= repo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","UserId",id));
		user.setUsername(userdto.getUsername()); 
	    user.setEmail(userdto.getEmail());  
	    user.setPassword(userdto.getPassword()); 
	    user.setRole(userdto.getRole());

	    // Save the updated user
	    User updatedUser = repo.save(user);

	    // Convert to DTO and return
	    return mapper.map(updatedUser, UserDTO.class);
	}

	@Override
	public Boolean deleteUser(Integer id) {
		User user= repo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","UserId",id));
		if(user!=null) {
			repo.delete(user);
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public UserDTO getUser(Integer id) {
		User user= repo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","UserId",id));
		return mapper.map(user, UserDTO.class);
	}

	@Override
	public LoginDTO loginUser(LoginDTO dto) {
		User user= repo.findByUsername(dto.getUsername());
		if(user!=null) {
			if(user.getPassword().equals(dto.getPassword())) {
				LoginDTO login=new LoginDTO();
				login.setUsername(user.getUsername());
				String str="";
				int len=user.getPassword().length();
				for (int i = 0; i < len; i++) {
					str+='*';
				}
				login.setPassword(str);
				return mapper.map(login, LoginDTO.class);
			}
			else {
				
				 throw new IllegalArgumentException("Invalid password");
				
				 
			}
		}
		else {
			 throw new IllegalArgumentException("Invalid username and password");
		}
		
	}

	@Override
	public List<UserDTO> getUserByRole(String role) {
		List<User> user=repo.findByRole(role);
		if(user.isEmpty()) {
			throw new IllegalArgumentException("Invalid role");
		}
		else {
			List<UserDTO> dtos=	user.stream().map(dto->mapper.map(dto, UserDTO.class)).collect(Collectors.toList());
			return dtos;
		}
		
	}

}
