package edu.cms.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cms.entity.User;
import edu.cms.repository.UserRepository;
import edu.cms.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public User login(String userName, String password) {
		return userRepository.findByUserNameAndPassword(userName, password);

}
}