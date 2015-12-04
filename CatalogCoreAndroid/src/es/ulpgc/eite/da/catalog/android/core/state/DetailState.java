package es.ulpgc.eite.da.catalog.android.core.state;


import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.framework.CatalogCode;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenState;

public class DetailState implements I_ScreenState {

    private I_CatalogData _data;
    private int _mCode;
    private int _dCode;
    private int _position;
    private int _size;

    public DetailState(I_CatalogData _data) {
        setData(_data);
        setMasterCode(CatalogCode.NULL);
        setDetailCode(CatalogCode.NULL);
        setPosition(0);
        setSize(0);
    }

    public I_CatalogData getData() {
        return _data;
    }

    public void setData(I_CatalogData data) {
        _data = data;
    }

    public int getMasterCode() {
        return _mCode;
    }

    public void setMasterCode(int code) {
        _mCode = code;
    }

    public int getDetailCode() {
        return _dCode;
    }

    public void setDetailCode(int code) {
        _dCode = code;
    }


    public int getPosition() {
        return _position;
    }

    public void setPosition(int position) {
        _position = position;
    }

    public int getSize() {
        return _size;
    }

    public void setSize(int size) {
        _size = size;
    }


}
