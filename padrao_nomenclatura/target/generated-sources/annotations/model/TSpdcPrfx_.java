package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.TSpdcObjt;
import model.TSpdcPrpdObjt;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-21T18:28:36")
@StaticMetamodel(TSpdcPrfx.class)
public class TSpdcPrfx_ { 

    public static volatile SingularAttribute<TSpdcPrfx, String> sgPrfx;
    public static volatile SingularAttribute<TSpdcPrfx, String> dsTipoDadoPrfx;
    public static volatile SingularAttribute<TSpdcPrfx, Integer> idPrfx;
    public static volatile CollectionAttribute<TSpdcPrfx, TSpdcObjt> tSpdcObjtCollection;
    public static volatile SingularAttribute<TSpdcPrfx, String> dsCntdPrfx;
    public static volatile SingularAttribute<TSpdcPrfx, String> dsDfncPrfx;
    public static volatile SingularAttribute<TSpdcPrfx, String> dsExploPrfx;
    public static volatile CollectionAttribute<TSpdcPrfx, TSpdcPrpdObjt> tSpdcPrpdObjtCollection;

}