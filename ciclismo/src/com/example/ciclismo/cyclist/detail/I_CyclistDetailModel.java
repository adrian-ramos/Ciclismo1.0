package com.example.ciclismo.cyclist.detail;

import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.detail.I_DetailModel;

import java.util.List;

public interface I_CyclistDetailModel extends I_DetailModel{
    public void setCollection(List<? extends I_CatalogData> collection);

}
