package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Questao;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-20T19:20:17")
@StaticMetamodel(Resposta.class)
public class Resposta_ { 

    public static volatile SingularAttribute<Resposta, Integer> idResposta;
    public static volatile SingularAttribute<Resposta, String> opcao;
    public static volatile SingularAttribute<Resposta, Questao> questaoIdQuestao;
    public static volatile SingularAttribute<Resposta, String> justificativa;
    public static volatile SingularAttribute<Resposta, String> respostaCorreta;

}