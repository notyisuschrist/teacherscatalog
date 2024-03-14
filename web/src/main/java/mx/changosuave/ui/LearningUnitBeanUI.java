package mx.changosuave.ui;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mx.changosuave.entity.Learningunit;
import mx.changosuave.helper.LearningUnitHelper;

@ManagedBean(name = "learningUnitUI")
@ViewScoped
public class LearningUnitBeanUI implements Serializable {
    private LearningUnitHelper learningUnitHelper;
    private List<Learningunit> learningUnits;

    public LearningUnitBeanUI() {
        learningUnitHelper = new LearningUnitHelper();
        refreshLearningUnits();
    }

    private void refreshLearningUnits() {
        List<Learningunit> userLearningUnits = (List<Learningunit>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userLearningUnits");

        if (userLearningUnits != null && !userLearningUnits.isEmpty()) {
            learningUnits = userLearningUnits;
        } else {
            learningUnits = learningUnitHelper.getAllLearningUnits();
        }
    }

    public List<Learningunit> getLearningUnits() {
        return learningUnits;
    }

    public void setLearningUnits(List<Learningunit> learningUnits) {
        this.learningUnits = learningUnits;
    }

    public String redirectToModify(Learningunit learningUnit) {
        return "modifylearningunit.xhtml?learningUnitId=" + learningUnit.getIdLearningUnit() + "&faces-redirect=true";
    }

    public void deleteLearningUnit(Learningunit learningUnit) {
        try {
            learningUnitHelper.deleteLearningUnit(learningUnit);
            learningUnits.remove(learningUnit);
            refreshLearningUnits();

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "La unidad de aprendizaje ha sido eliminada.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo eliminar la unidad de aprendizaje.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}