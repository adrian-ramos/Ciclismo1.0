package es.ulpgc.eite.da.catalog.android.core.master;


import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;

import java.util.List;

public interface I_MasterModel {

    public int getPosition(I_CatalogData data);
    public int getPosition();
    public void setPosition(int position);
    public void addData();
    public int getSize();
    public I_CatalogData getData();
    public void delData();

    public abstract List<? extends I_CatalogData> getCollection();

}
