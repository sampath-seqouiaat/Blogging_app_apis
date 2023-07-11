package com.sampath.blog.services.impel;


import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.sampath.blog.entity.User;
import com.sampath.blog.exceptions.ResourceNotFoundException;
import com.sampath.blog.playloads.UserDto;
import com.sampath.blog.respositories.UserRepo;
import com.sampath.blog.services.UserService;


public class UserServiceImple implements UserService {
    @Autowired
	private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
	
	@Override
	public UserDto creatUser(UserDto userdto) {
		User user = this.convertingDtoToUser(userdto);
		User savedUser = this.userRepo.save(user);
	   return this.convertingUserToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPasssword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User userUpdated = this.userRepo.save(user);
		UserDto userDtoUpadted = this.convertingUserToDto(userUpdated);
		return userDtoUpadted;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user", "id", userId));
		return this.convertingUserToDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> user1 = this.userRepo.findAll();
	   List<UserDto> userDtos = user1.parallelStream().map(user -> this.convertingUserToDto(user)).collect(Collectors.toList());
	    return userDtos;
	}

	@Override
	public void deletUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
		this.userRepo.delete(user);
		
	}
	private UserDto convertingUserToDto(User user) {
		UserDto userDto = this.modelMapper.map(user,UserDto.class);
		
		return userDto;
	}
	private User convertingDtoToUser(UserDto userDto) {
		 User user = this.modelMapper.map(userDto,User.class);
		 
		 return user;
	}

}
