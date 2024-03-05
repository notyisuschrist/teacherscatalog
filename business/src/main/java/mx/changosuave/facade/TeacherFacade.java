package mx.changosuave.facade;

import mx.changosuave.delegate.TeacherDelegate;
import mx.changosuave.entity.Teacher;

import java.util.List;

public class TeacherFacade {
    private final TeacherDelegate teacherDelegate;

    public TeacherFacade() {
        this.teacherDelegate = new TeacherDelegate();
    }

    public void saveTeacher(Teacher teacher) {
        teacherDelegate.saveTeacher(teacher);
    }

    public void modifyTeacher(Teacher teacher) {
        teacherDelegate.modifyTeacher(teacher);
    }

    public Teacher getTeacher(int teacherId) {
        return teacherDelegate.getTeacher(teacherId);
    }

    public List<Teacher> getAllTeachers() {
        return teacherDelegate.getAllTeachers();
    }

    public void deleteTeacher(Teacher teacher) {
        teacherDelegate.deleteTeacher(teacher);
    }
}
