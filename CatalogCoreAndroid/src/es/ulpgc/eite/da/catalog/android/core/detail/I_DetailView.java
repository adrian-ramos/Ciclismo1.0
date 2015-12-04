package es.ulpgc.eite.da.catalog.android.core.detail;


import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;

public interface I_DetailView {

    public void initDetail();

    public void setDetailContent();
    public abstract void setDetailContent(I_CatalogData data);

}
