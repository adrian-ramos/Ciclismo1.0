package com.example.ciclismo.cyclist.master;

import com.example.ciclismo.cyclist.data.CyclistData;
import es.ulpgc.eite.da.catalog.android.core.framework.CatalogCode;
import es.ulpgc.eite.da.catalog.android.core.master.MasterPresenter;
import es.ulpgc.eite.da.catalog.android.core.state.DetailState;
import es.ulpgc.eite.da.catalog.android.core.state.MasterState;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenView;

public class CyclistMasterPresenter extends MasterPresenter implements I_CyclistMasterPresenter {

    public CyclistMasterPresenter(){
        super();
    }

    public I_CyclistMasterView getMasterView() {
        return (I_CyclistMasterView) getScreenView();
    }

    @Override
    public I_CyclistMasterModel getMasterModel() {
        return (I_CyclistMasterModel) getScreenModel();
    }

    @Override
    public void createScreen() {
        super.createScreen();
        getMasterModel().setCollection();
    }

    @Override
    public void resumeScreen() {
        super.resumeScreen();
        //getMasterModel().setCollection();
    }

    @Override
    public void setScreenState(
            Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        if(state != null) {

            MasterState _state = (MasterState) state;
            getMasterModel().setPosition(_state.getPosition());
            setMasterCode(_state.getCode());

            debug("setScreenState", "code", getMasterCode());
            debug("setScreenState", "pos", getMasterModel().getPosition());
        }

    }

    @Override
    public I_ScreenState getScreenState() {

        debug("getScreenState", "collection", getMasterModel().getCollection());

        MasterState state = new MasterState();
        state.setCollection(getMasterModel().getCollection());  //todo
        state.setPosition(getMasterModel().getPosition());
        state.setCode(getMasterCode());
        return state;
    }

    @Override
    public I_ScreenState getNextState(
            Class<? extends I_ScreenView> view, int code) {

        debug("getNextState", "view", view.getSimpleName());
        debug("getNextState", "code", code);

        CyclistData data = (CyclistData) getMasterModel().getData();
        debug("getNextState", "data", data);

        DetailState state = new DetailState(data);
        state.setPosition(getMasterModel().getPosition());
        state.setSize(getMasterModel().getSize());
        state.setMasterCode(getMasterCode());

        return state;
    }

    @Override
    public I_ScreenState updateMasterState(
            Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        return null;
    }

    @Override
    public void onMasterButtonClick(int code) {

        debug("onMasterButtonClick");

        setMasterCode(code);

        if(code == CatalogCode.EDIT) {
            getMasterModel().setPosition(getMasterView().getListPosition());
            startNextScreenWithObserver(this, code);
        }

    }

}


