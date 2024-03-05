package mx.changosuave.beanUI;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import mx.changosuave.entity.Teacher;
import mx.changosuave.helper.TeacherHelper;

@ManagedBean(name = "createTeacherBeanUI")
@ViewScoped
public class CreateTeacherBeanUI implements Serializable {

    private TeacherHelper teacherHelper;
    private Teacher newTeacher;

    public CreateTeacherBeanUI() {
        teacherHelper = new TeacherHelper();
        newTeacher = new Teacher();
    }

    public Teacher getNewTeacher() {
        return newTeacher;
    }

    public void setNewTeacher(Teacher newTeacher) {
        this.newTeacher = newTeacher;
    }

    public void createTeacher() {
        teacherHelper.saveTeacher(newTeacher);
        newTeacher = new Teacher();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Teacher created successfully.");
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        
        try {
            ec.redirect(ec.getRequestContextPath() + "/teachers.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
