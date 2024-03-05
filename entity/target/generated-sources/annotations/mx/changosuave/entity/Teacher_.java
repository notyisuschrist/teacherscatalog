package mx.changosuave.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.changosuave.entity.Learningunit;
import mx.changosuave.entity.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-03T17:35:45")
@StaticMetamodel(Teacher.class)
public class Teacher_ { 

    public static volatile ListAttribute<Teacher, Learningunit> learningunitList;
    public static volatile ListAttribute<Teacher, User> userList;
    public static volatile SingularAttribute<Teacher, Integer> idTeacher;
    public static volatile SingularAttribute<Teacher, String> surname;
    public static volatile SingularAttribute<Teacher, String> name;
    public static volatile SingularAttribute<Teacher, String> rfc;

}