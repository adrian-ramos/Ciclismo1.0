package es.ulpgc.eite.da.catalog.android.core.master;


import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;

import java.util.List;

public interface I_MasterView {

    public void initMaster();

    public void setMasterContent();
    public int getListPosition();
    public void updateMasterContent(List<? extends I_CatalogData> collection);

}
