package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Prova;
import model.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-20T19:20:17")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile SingularAttribute<Curso, String> sigla;
    public static volatile ListAttribute<Curso, Usuario> usuarioList;
    public static volatile ListAttribute<Curso, Prova> provaList;
    public static volatile SingularAttribute<Curso, Integer> idCurso;
    public static volatile SingularAttribute<Curso, String> nmCurso;

}