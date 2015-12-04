package es.ulpgc.eite.da.catalog.android.core.detail;


import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.framework.android.AndroidScreenModel;

public abstract class DetailModel
extends AndroidScreenModel implements I_DetailModel {

    private I_CatalogData _data;


    public DetailModel(I_CatalogData data) {
        _data = data;
    }

    @Override
    public I_CatalogData getData() {
        return _data;
    }

    @Override
    public void setData(I_CatalogData data) {
        _data = data;
    }
}
