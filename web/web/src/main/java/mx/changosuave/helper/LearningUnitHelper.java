package mx.changosuave.helper;

import java.io.Serializable;
import java.util.List;
import mx.changosuave.entity.Learningunit;
import mx.changosuave.integracion.ServiceFacadeLocator;

public class LearningUnitHelper implements Serializable {
    public void saveLearningUnit(Learningunit learningUnit) {
        ServiceFacadeLocator.getInstanceLearningUnitFacade().saveLearningUnit(learningUnit);
    }

    public void modifyLearningUnit(Learningunit learningUnit) {
        ServiceFacadeLocator.getInstanceLearningUnitFacade().modifyLearningUnit(learningUnit);
    }

    public Learningunit getLearningUnit(int learningUnitId) {
        return ServiceFacadeLocator.getInstanceLearningUnitFacade().getLearningUnit(learningUnitId);
    }

    public List<Learningunit> getAllLearningUnits() {
        return ServiceFacadeLocator.getInstanceLearningUnitFacade().getAllLearningUnits();
    }

    public void deleteLearningUnit(Learningunit learningUnit) {
        ServiceFacadeLocator.getInstanceLearningUnitFacade().deleteLearningUnit(learningUnit);
    }
}
