package mx.changosuave.integracion;

import mx.changosuave.DAO.TeacherDAO;
import mx.changosuave.DAO.LearningUnitDAO;
import mx.changosuave.DAO.UserDAO;

public class ServiceLocator {
    private static TeacherDAO teacherDAO;
    private static LearningUnitDAO learningUnitDAO;
    private static UserDAO userDAO;

    public static TeacherDAO getInstanceTeacherDAO() {
        if (teacherDAO == null) {
            teacherDAO = new TeacherDAO();
            return teacherDAO;
        } else {
            return teacherDAO;
        }
    }

    public static LearningUnitDAO getInstanceLearningUnitDAO() {
        if (learningUnitDAO == null) {
            learningUnitDAO = new LearningUnitDAO();
            return learningUnitDAO;
        } else {
            return learningUnitDAO;
        }
    }

    public static UserDAO getInstanceUserDAO() {
        if (userDAO == null) {
            userDAO = new UserDAO();
            return userDAO;
        } else {
            return userDAO;
        }
    }
}