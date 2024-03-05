package mx.changosuave.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.changosuave.entity.Teacher;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-03T17:35:45")
@StaticMetamodel(Learningunit.class)
public class Learningunit_ { 

    public static volatile SingularAttribute<Learningunit, Integer> workshopHours;
    public static volatile SingularAttribute<Learningunit, String> name;
    public static volatile SingularAttribute<Learningunit, Integer> laboratoryHours;
    public static volatile ListAttribute<Learningunit, Teacher> teacherList;
    public static volatile SingularAttribute<Learningunit, Integer> classHours;
    public static volatile SingularAttribute<Learningunit, Integer> idLearningUnit;

}