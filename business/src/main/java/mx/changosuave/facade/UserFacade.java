package mx.changosuave.facade;

import java.util.List;
import mx.changosuave.delegate.UserDelegate;
import mx.changosuave.entity.User;

public class UserFacade {
    private final UserDelegate userDelegate;

    public UserFacade() {
        this.userDelegate = new UserDelegate();
    }
    
    public User login(String password, String correo){
        return userDelegate.login(password, correo);
    }

    public void saveUser(User user) {
        userDelegate.saveUser(user);
    }

    public void modifyUser(User user) {
        userDelegate.modifyUser(user);
    }

    public User getUser(int userId) {
        return userDelegate.getUser(userId);
    }

    public List<User> getAllUsers() {
        return userDelegate.getAllUsers();
    }

    public void deleteUser(User user) {
        userDelegate.deleteUser(user);
    }
}