package mx.changosuave.beanUI;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import mx.changosuave.entity.Learningunit;
import mx.changosuave.helper.LearningUnitHelper;

@ManagedBean(name = "createLearningUnitUI")
@ViewScoped
public class CreateLearningUnitBeanUI implements Serializable {
    private LearningUnitHelper learningUnitHelper;
    private Learningunit learningUnit;

    public CreateLearningUnitBeanUI() {
        learningUnitHelper = new LearningUnitHelper();
        learningUnit = new Learningunit();
    }

    public Learningunit getLearningUnit() {
        return learningUnit;
    }

    public void setLearningUnit(Learningunit learningUnit) {
        this.learningUnit = learningUnit;
    }

    public void saveLearningUnit() {
        learningUnitHelper.saveLearningUnit(learningUnit);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Learning Unit created successfully.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        
        try {
            ec.redirect(ec.getRequestContextPath() + "/learningunits.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}