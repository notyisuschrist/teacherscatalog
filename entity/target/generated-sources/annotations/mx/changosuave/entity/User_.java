package mx.changosuave.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.changosuave.entity.Teacher;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-03T17:35:45")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Integer> idUser;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Teacher> idTeacher;
    public static volatile SingularAttribute<User, Integer> isAdmin;
    public static volatile SingularAttribute<User, String> username;

}