 package mx.changosuave.beanUI;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mx.changosuave.entity.Learningunit;
import mx.changosuave.helper.LearningUnitHelper;

@ManagedBean(name = "modifyLearningUnitUI")
@ViewScoped
public class ModifyLearningUnitBeanUI implements Serializable {
    private LearningUnitHelper learningUnitHelper;
    private Learningunit learningUnit;

    public ModifyLearningUnitBeanUI() {
        learningUnitHelper = new LearningUnitHelper();
        String learningUnitId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("learningUnitId");
        if (learningUnitId != null) {
            learningUnit = learningUnitHelper.getLearningUnit(Integer.parseInt(learningUnitId));
        } else {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("learningunits.xhtml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Learningunit getLearningUnit() {
        return learningUnit;
    }

    public void setLearningUnit(Learningunit learningUnit) {
        this.learningUnit = learningUnit;
    }

    public void saveLearningUnit() {
        learningUnitHelper.modifyLearningUnit(learningUnit);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Learning Unit modified successfully.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("learningunits.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}