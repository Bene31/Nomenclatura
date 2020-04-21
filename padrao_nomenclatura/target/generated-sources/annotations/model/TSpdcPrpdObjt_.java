package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.TSpdcObjt;
import model.TSpdcPrfx;
import model.TSpdcPrpdVocbCntld;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-21T18:28:36")
@StaticMetamodel(TSpdcPrpdObjt.class)
public class TSpdcPrpdObjt_ { 

    public static volatile SingularAttribute<TSpdcPrpdObjt, String> dcPrpdObjt;
    public static volatile CollectionAttribute<TSpdcPrpdObjt, TSpdcPrpdVocbCntld> tSpdcPrpdVocbCntldCollection;
    public static volatile SingularAttribute<TSpdcPrpdObjt, String> nmPrpdObjt;
    public static volatile SingularAttribute<TSpdcPrpdObjt, Integer> idPrpdObjt;
    public static volatile SingularAttribute<TSpdcPrpdObjt, TSpdcObjt> idObjt;
    public static volatile SingularAttribute<TSpdcPrpdObjt, TSpdcPrfx> idPrfx;

}