package mx.changosuave.delegate;

import java.util.List;
import mx.changosuave.entity.User;
import mx.changosuave.integracion.ServiceLocator;

public class UserDelegate {
    public User login(String password, String username) {
        User user = null;
        List<User> users = ServiceLocator.getInstanceUserDAO().findAll();

        for (User u : users) {
            if (u.getPassword().equalsIgnoreCase(password) && u.getUsername().equalsIgnoreCase(username)) {
                user = u;
                break;
            }
        }
        return user;
    }

    public void saveUser(User user) {
        ServiceLocator.getInstanceUserDAO().save(user);
    }

    public void modifyUser(User user) {
        ServiceLocator.getInstanceUserDAO().update(user);
    }

    public User getUser(int userId) {
        return ServiceLocator.getInstanceUserDAO().find(userId);
    }

    public List<User> getAllUsers() {
        return ServiceLocator.getInstanceUserDAO().findAll();
    }

    public void deleteUser(User user) {
        ServiceLocator.getInstanceUserDAO().delete(user);
    }
}