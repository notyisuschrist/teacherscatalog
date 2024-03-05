package mx.changosuave.integracion;

import mx.changosuave.facade.UserFacade;
import mx.changosuave.facade.TeacherFacade;
import mx.changosuave.facade.LearningUnitFacade;

public class ServiceFacadeLocator {
    private static TeacherFacade teacherFacade;
    private static LearningUnitFacade learningUnitFacade;
    private static UserFacade userFacade;

    public static TeacherFacade getInstanceTeacherFacade() {
        if (teacherFacade == null) {
            teacherFacade = new TeacherFacade();
            return teacherFacade;
        } else {
            return teacherFacade;
        }
    }

    public static LearningUnitFacade getInstanceLearningUnitFacade() {
        if (learningUnitFacade == null) {
            learningUnitFacade = new LearningUnitFacade();
            return learningUnitFacade;
        } else {
            return learningUnitFacade;
        }
    }

    public static UserFacade getInstanceUserFacade() {
        if (userFacade == null) {
            userFacade = new UserFacade();
            return userFacade;
        } else {
            return userFacade;
        }
    }
}
