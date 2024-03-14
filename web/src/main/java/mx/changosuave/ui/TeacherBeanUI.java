package mx.changosuave.beanUI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mx.changosuave.entity.Learningunit;
import mx.changosuave.entity.Teacher;
import mx.changosuave.helper.LearningUnitHelper;
import mx.changosuave.helper.TeacherHelper;

@ManagedBean(name = "teacherBeanUI")
@ViewScoped
public class TeacherBeanUI implements Serializable {
    private TeacherHelper teacherHelper;
    private LearningUnitHelper learningUnitHelper;
    private List<Teacher> teachers;
    private List<Learningunit> availableLearningUnits;
    private Teacher selectedTeacher;

    @PostConstruct
    public void init() {
        teacherHelper = new TeacherHelper();
        learningUnitHelper = new LearningUnitHelper();
        teachers = teacherHelper.getAllTeachers();
        availableLearningUnits = learningUnitHelper.getAllLearningUnits();
        sortTeachersByName();
    }
    
    

    private void sortTeachersByName() {
        for (int i = 0; i < teachers.size() - 1; i++) {
            for (int j = i + 1; j < teachers.size(); j++) {
                Teacher teacher1 = teachers.get(i);
                Teacher teacher2 = teachers.get(j);
                if (teacher1.getName().compareToIgnoreCase(teacher2.getName()) > 0) {
                    // Swap teachers
                    teachers.set(i, teacher2);
                    teachers.set(j, teacher1);
                }
            }
        }
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Learningunit> getAvailableLearningUnits() {
        return availableLearningUnits;
    }

    public void setAvailableLearningUnits(List<Learningunit> availableLearningUnits) {
        this.availableLearningUnits = availableLearningUnits;
    }

    public Teacher getSelectedTeacher() {
        return selectedTeacher;
    }

    public void setSelectedTeacher(Teacher selectedTeacher) {
        this.selectedTeacher = selectedTeacher;
    }

    public String redirectToModify(Teacher teacher) {
        return "/modifyteacher.xhtml?teacherId=" + teacher.getIdTeacher() + "&faces-redirect=true";
    }

    public void deleteTeacher(Teacher teacher) {
        teacherHelper.deleteTeacher(teacher);
        teachers.remove(teacher);
        
        try {
            teacherHelper.deleteTeacher(teacher);
            teachers.remove(teacher);

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "El registro ha sido eliminado.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo eliminar el registro.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
