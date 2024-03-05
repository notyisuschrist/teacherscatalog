package mx.changosuave.facade;

import mx.changosuave.delegate.LearningUnitDelegate;
import mx.changosuave.entity.Learningunit;

import java.util.List;

public class LearningUnitFacade {
    private final LearningUnitDelegate learningUnitDelegate;

    public LearningUnitFacade() {
        this.learningUnitDelegate = new LearningUnitDelegate();
    }

    public void saveLearningUnit(Learningunit learningUnit) {
        learningUnitDelegate.saveLearningUnit(learningUnit);
    }

    public void modifyLearningUnit(Learningunit learningUnit) {
        learningUnitDelegate.modifyLearningUnit(learningUnit);
    }

    public Learningunit getLearningUnit(int learningUnitId) {
        return learningUnitDelegate.getLearningUnit(learningUnitId);
    }

    public List<Learningunit> getAllLearningUnits() {
        return learningUnitDelegate.getAllLearningUnits();
    }

    public void deleteLearningUnit(Learningunit learningUnit) {
        learningUnitDelegate.deleteLearningUnit(learningUnit);
    }
}
