package mx.changosuave.helper;

import java.io.Serializable;
import java.util.List;
import mx.changosuave.entity.Teacher;
import mx.changosuave.integracion.ServiceFacadeLocator;

public class TeacherHelper implements Serializable {
    public void saveTeacher(Teacher teacher) {
        ServiceFacadeLocator.getInstanceTeacherFacade().saveTeacher(teacher);
    }

    public void modifyTeacher(Teacher teacher) {
        ServiceFacadeLocator.getInstanceTeacherFacade().modifyTeacher(teacher);
    }

    public Teacher getTeacher(int teacherId) {
        return ServiceFacadeLocator.getInstanceTeacherFacade().getTeacher(teacherId);
    }

    public List<Teacher> getAllTeachers() {
        return ServiceFacadeLocator.getInstanceTeacherFacade().getAllTeachers();
    }

    public void deleteTeacher(Teacher teacher) {
        ServiceFacadeLocator.getInstanceTeacherFacade().deleteTeacher(teacher);
    }
}
