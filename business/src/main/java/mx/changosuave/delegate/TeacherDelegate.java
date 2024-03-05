package mx.changosuave.delegate;

import java.util.List;
import mx.changosuave.entity.Teacher;
import mx.changosuave.integracion.ServiceLocator;

public class TeacherDelegate {
    public void saveTeacher(Teacher teacher) {
        ServiceLocator.getInstanceTeacherDAO().save(teacher);
    }

    public void modifyTeacher(Teacher teacher) {
        ServiceLocator.getInstanceTeacherDAO().update(teacher);
    }

    public Teacher getTeacher(int teacherId) {
        return ServiceLocator.getInstanceTeacherDAO().find(teacherId);
    }

    public List<Teacher> getAllTeachers() {
        return ServiceLocator.getInstanceTeacherDAO().findAll();
    }

    public void deleteTeacher(Teacher teacher) {
        ServiceLocator.getInstanceTeacherDAO().delete(teacher);
    }
}
