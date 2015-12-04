package com.example.ciclismo.team.detail;

import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.detail.I_DetailModel;

import java.util.List;

public interface I_TeamDetailModel extends I_DetailModel{
    public void setCollection(List<? extends I_CatalogData> collection);
}
