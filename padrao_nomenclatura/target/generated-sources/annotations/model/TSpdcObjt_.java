package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.TSpdcPrfx;
import model.TSpdcPrpdObjt;
import model.TSpdcVocbCntld;
import model.TTipoObjt;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-11T12:44:40")
@StaticMetamodel(TSpdcObjt.class)
public class TSpdcObjt_ { 

    public static volatile SingularAttribute<TSpdcObjt, TTipoObjt> idTipoObjt;
    public static volatile SingularAttribute<TSpdcObjt, String> dcObjt;
    public static volatile SingularAttribute<TSpdcObjt, String> nmObjt;
    public static volatile CollectionAttribute<TSpdcObjt, TSpdcVocbCntld> tSpdcVocbCntldCollection;
    public static volatile SingularAttribute<TSpdcObjt, Integer> idObjt;
    public static volatile SingularAttribute<TSpdcObjt, TSpdcPrfx> idPrfx;
    public static volatile CollectionAttribute<TSpdcObjt, TSpdcPrpdObjt> tSpdcPrpdObjtCollection;

}