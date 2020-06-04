package cs544.group1.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs544.group1.project.domain.User;
import cs544.group1.project.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepository;
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(int userid) {
		Optional<User> user = userRepository.findById(userid);
		return user.isPresent() ? user.get(): null; 
	}
	
	public User update(int userId, String password) {
		User oldUser = findById(userId);
    	if(oldUser == null){
    		return null;
    	}
    	oldUser.setPassword(password);
    	return userRepository.save(oldUser);
	}
	
	public void delete(int userId) {
		User oldUser = findById(userId);
    	if(oldUser == null){
    		return;
    	}
		userRepository.deleteById(userId);
	}

}
