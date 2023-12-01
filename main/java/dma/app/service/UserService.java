package dma.app.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dma.app.model.User;

@Service
public interface UserService {
	public void saveUser(User user);
    public boolean isUserPresent(User user);
    public Optional<User> findByUsername(String username);
}
