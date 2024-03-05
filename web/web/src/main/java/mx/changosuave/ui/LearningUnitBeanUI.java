package mx.changosuave.beanUI;

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
        learningUnitHelper.deleteLearningUnit(learningUnit);
        refreshLearningUnits();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Learning Unit deleted successfully.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("learningUnitForm");
    }
}