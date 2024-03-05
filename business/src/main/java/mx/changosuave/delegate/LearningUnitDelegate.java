package mx.changosuave.delegate;

import java.util.List;
import mx.changosuave.entity.Learningunit;
import mx.changosuave.integracion.ServiceLocator;

public class LearningUnitDelegate {

    public void saveLearningUnit(Learningunit learningUnit) {
        ServiceLocator.getInstanceLearningUnitDAO().save(learningUnit);
    }

    public void modifyLearningUnit(Learningunit learningUnit) {
        ServiceLocator.getInstanceLearningUnitDAO().update(learningUnit);
    }

    public Learningunit getLearningUnit(int learningUnitId) {
        return ServiceLocator.getInstanceLearningUnitDAO().find(learningUnitId);
    }

    public List<Learningunit> getAllLearningUnits() {
        return ServiceLocator.getInstanceLearningUnitDAO().findAll();
    }

    public void deleteLearningUnit(Learningunit learningUnit) {
        ServiceLocator.getInstanceLearningUnitDAO().delete(learningUnit);
    }
}
