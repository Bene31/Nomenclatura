package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Curso;
import model.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-20T19:20:17")
@StaticMetamodel(Prova.class)
public class Prova_ { 

    public static volatile SingularAttribute<Prova, Integer> idProva;
    public static volatile SingularAttribute<Prova, Date> ano;
    public static volatile ListAttribute<Prova, Usuario> usuarioList;
    public static volatile SingularAttribute<Prova, Curso> idCurso;

}