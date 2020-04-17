package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.TSpdcObjt;
import model.TSpdcPrpdObjt;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-16T11:08:28")
@StaticMetamodel(TSpdcVocbCntld.class)
public class TSpdcVocbCntld_ { 

    public static volatile SingularAttribute<TSpdcVocbCntld, String> dsVocbCntld;
    public static volatile SingularAttribute<TSpdcVocbCntld, String> sgVocbCntld;
    public static volatile SingularAttribute<TSpdcVocbCntld, String> flTipoVocbCntld;
    public static volatile SingularAttribute<TSpdcVocbCntld, Integer> idVocbCntld;
    public static volatile CollectionAttribute<TSpdcVocbCntld, TSpdcObjt> tSpdcObjtCollection;
    public static volatile CollectionAttribute<TSpdcVocbCntld, TSpdcPrpdObjt> tSpdcPrpdObjtCollection;

}