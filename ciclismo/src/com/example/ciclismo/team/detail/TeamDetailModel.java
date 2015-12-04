package com.example.ciclismo.team.detail;

import com.example.ciclismo.team.data.TeamData;
import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.detail.DetailModel;

import java.util.ArrayList;
import java.util.List;

public class TeamDetailModel extends DetailModel implements I_TeamDetailModel {

    private List<? extends I_CatalogData> _collection1;

    public TeamDetailModel() {
        super(null);
        setCollection(new ArrayList<TeamData>());
    }

    public List<? extends I_CatalogData> getCollection() {
        return _collection1;
    } //No Necesario

    @Override
    public void setCollection(List<? extends I_CatalogData> collection) {
        _collection1 = collection;
    }
}
