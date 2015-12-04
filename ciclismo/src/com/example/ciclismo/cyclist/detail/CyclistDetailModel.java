package com.example.ciclismo.cyclist.detail;

import com.example.ciclismo.cyclist.data.CyclistData;
import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.detail.DetailModel;

import java.util.ArrayList;
import java.util.List;

public class CyclistDetailModel extends DetailModel implements I_CyclistDetailModel {

    private List<? extends I_CatalogData> _collection1;

    public CyclistDetailModel() {
        super(null);
        setCollection(new ArrayList<CyclistData>());
    }

    public List<? extends I_CatalogData> getCollection() {
        return _collection1;
    } //No Necesario

    @Override
    public void setCollection(List<? extends I_CatalogData> collection) {
        _collection1 = collection;
    }
}
