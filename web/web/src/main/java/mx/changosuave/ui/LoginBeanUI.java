package mx.changosuave.beanUI;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import mx.changosuave.entity.User;
import mx.changosuave.helper.UserHelper;

@ManagedBean(name = "loginUI")
@SessionScoped
public class LoginBeanUI implements Serializable {
    private final UserHelper userHelper;
    private User user;
    
    public LoginBeanUI() {
        userHelper = new UserHelper();
    }
    
    @PostConstruct
    public void init() {
        user = new User();
    }

   public void login() throws IOException {
        String appURL = "/learningunits.xhtml";
        
        User foundUser = new User();
        foundUser.setIdUser(0);
        foundUser = userHelper.login(user.getUsername(), user.getPassword());
        
        if (foundUser != null && foundUser.getIdUser() != null) {
            user = foundUser;
            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userLearningUnits", user.getIdTeacher().getLearningunitList());
            FacesContext.getCurrentInstance().getExternalContext().redirect(
                FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + appURL
            );
        } else {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect username or password:", "Try again")
            );
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public void logout() {
        userHelper.logout();
        user = new User();
       
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
            ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
