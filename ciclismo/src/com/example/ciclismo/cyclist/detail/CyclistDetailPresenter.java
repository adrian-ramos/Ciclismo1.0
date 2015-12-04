package com.example.ciclismo.cyclist.detail;

import com.example.ciclismo.cyclist.data.CyclistData;
import es.ulpgc.eite.da.catalog.android.core.detail.DetailPresenter;
import es.ulpgc.eite.da.catalog.android.core.state.DetailState;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenView;

public class CyclistDetailPresenter extends DetailPresenter implements I_CyclistDetailPresenter {

    public CyclistDetailPresenter() {
        super();
    }

    @Override
    public I_CyclistDetailModel getDetailModel() {
        return (I_CyclistDetailModel) getScreenModel();
    }

    public I_CyclistDetailView getDetailView() {
        return (I_CyclistDetailView) getScreenView();
    }

    @Override
    public String getDetailText() {
        CyclistData _data = (CyclistData) getDetailModel().getData();
        return _data.getText();
    }

    @Override
    public void setScreenState(Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("setScreenState", "view", view.getSimpleName());
        debug("setScreenState", "code", code);

        DetailState _state = (DetailState) state;
        CyclistData data = (CyclistData) _state.getData();
        getDetailModel().setData(data);
        setDetailCode(_state.getDetailCode());  //todo
        setMasterCode(_state.getMasterCode());
        setPosition(_state.getPosition());
        setSize(_state.getSize());

    }

    @Override
    public I_ScreenState getScreenState() {

        debug("getScreenState", "data", getDetailModel().getData());

        DetailState state = new DetailState(getDetailModel().getData());
        state.setDetailCode(getDetailCode());
        state.setMasterCode(getMasterCode());
        state.setPosition(getPosition());
        state.setSize(getSize());

        return state;
    }

    @Override
    public I_ScreenState getNextState(Class<? extends I_ScreenView> view, int code) {

        return null;
    }

    @Override
    public void updateDetailState(Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

    }

}
