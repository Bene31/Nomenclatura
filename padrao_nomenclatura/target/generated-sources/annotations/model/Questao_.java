package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Prova;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-20T19:20:17")
@StaticMetamodel(Questao.class)
public class Questao_ { 

    public static volatile SingularAttribute<Questao, String> tipoQuestao;
    public static volatile SingularAttribute<Questao, Prova> prova;
    public static volatile SingularAttribute<Questao, Integer> idQuestao;
    public static volatile SingularAttribute<Questao, String> descricaoQuestao;

}