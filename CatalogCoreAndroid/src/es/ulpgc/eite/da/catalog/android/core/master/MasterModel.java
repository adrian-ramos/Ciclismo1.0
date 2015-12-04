package es.ulpgc.eite.da.catalog.android.core.master;


import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.framework.android.AndroidScreenModel;

public abstract class MasterModel
extends AndroidScreenModel implements I_MasterModel {

    private int _position;

    public MasterModel() {
        setPosition(0);
    }

    @Override
    public int getPosition(I_CatalogData data) {
        return getCollection().indexOf(data);
    }

    @Override
    public int getPosition() {
        return _position;
    }

    @Override
    public void setPosition(int position) {
        _position = position;
    }

    @Override
    public void addData() {
        setPosition(getSize() - 1);
    }

    @Override
    public int getSize() {
        return getCollection().size();
    }

    @Override
    public I_CatalogData getData() {


        if(getPosition() < 0) {
            setPosition(0);
        }

        if(getPosition() > getSize() - 1) {
            setPosition(getSize() - 1);
        }

        debug("getData", "position", getPosition());
        debug("getData", "size", getSize());

        if(getSize() != 0) {
            return getCollection().get(getPosition());
        }

        return null;
    }

    @Override
    public void delData() {
        if(getPosition() > getSize() - 1) {
            setPosition(getSize() - 1);
        }
    }


}
