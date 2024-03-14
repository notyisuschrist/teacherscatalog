package mx.changosuave.beanUI;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mx.changosuave.entity.Teacher;
import mx.changosuave.helper.TeacherHelper;

@ManagedBean(name = "modifyTeacherBeanUI")
@ViewScoped
public class ModifyTeacherBeanUI implements Serializable {
    private TeacherHelper teacherHelper;
    private Teacher teacher;
    private int teacherId;

    public ModifyTeacherBeanUI() {
        teacherHelper = new TeacherHelper();
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String teacherIdParam = facesContext.getExternalContext().getRequestParameterMap().get("teacherId");
        if (teacherIdParam != null && !teacherIdParam.isEmpty()) {
            teacherId = Integer.parseInt(teacherIdParam);
            teacher = teacherHelper.getTeacher(teacherId);
        } else {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("teachers.xhtml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void saveTeacherChanges() {
        teacherHelper.modifyTeacher(teacher);
        // Redirigir a la página de lista de profesores después de modificar
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("teachers.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
