package com.example.ciclismo.team.data;

import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;

public interface I_TeamData extends I_CatalogData{

;
    public void setText(String txt);
    public String getText();
    public String getImage();
    public void setImage(String txt);

}
