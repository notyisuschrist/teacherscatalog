package mx.changosuave.helper;

import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import mx.changosuave.entity.User;
import mx.changosuave.integracion.ServiceFacadeLocator;

public class UserHelper implements Serializable {
    public User login(String email, String password) {
        return ServiceFacadeLocator.getInstanceUserFacade().login(password, email);
    }

    public void logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public void saveUser(User user) {
        ServiceFacadeLocator.getInstanceUserFacade().saveUser(user);
    }

    public void modifyUser(User user) {
        ServiceFacadeLocator.getInstanceUserFacade().modifyUser(user);
    }

    public User getUser(int userId) {
        return ServiceFacadeLocator.getInstanceUserFacade().getUser(userId);
    }

    public List<User> getAllUsers() {
        return ServiceFacadeLocator.getInstanceUserFacade().getAllUsers();
    }

    public void deleteUser(User user) {
        ServiceFacadeLocator.getInstanceUserFacade().deleteUser(user);
    }
}
