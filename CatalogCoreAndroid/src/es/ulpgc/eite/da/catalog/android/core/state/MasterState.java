package es.ulpgc.eite.da.catalog.android.core.state;


import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.framework.CatalogCode;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenState;

import java.util.ArrayList;
import java.util.List;

public class MasterState implements I_ScreenState {

    private List<? extends I_CatalogData> _collection;
    private int _position;
    private int _code;


    public MasterState() {
        setCollection(new ArrayList<I_CatalogData>());
        setPosition(0);
        setCode(CatalogCode.NULL);
    }

    public List<? extends I_CatalogData> getCollection() {
        return _collection;
    }

    public void setCollection(List<? extends I_CatalogData> collection) {
        _collection = collection;
    }

    public int getPosition(I_CatalogData data) {
        return _collection.indexOf(data);
    }

    public I_CatalogData getData() {
        return getCollection().get(getPosition());
    }


    public int getPosition() {
        return _position;
    }

    public void setPosition(int position) {
        _position = position;
    }

    public int getSize() {
        return getCollection().size();
    }


    public int getCode() {
        return _code;
    }

    public void setCode(int code) {
        _code = code;
    }

}
