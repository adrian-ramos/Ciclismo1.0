package com.example.ciclismo.team.detail;

import com.example.ciclismo.team.data.TeamData;
import es.ulpgc.eite.da.catalog.android.core.detail.DetailPresenter;
import es.ulpgc.eite.da.catalog.android.core.state.DetailState;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenView;

public class TeamDetailPresenter extends DetailPresenter implements I_TeamDetailPresenter {

    public TeamDetailPresenter() {
        super();
    }

    @Override
    public I_TeamDetailModel getDetailModel() {
        return (I_TeamDetailModel) getScreenModel();
    }

    public I_TeamDetailView getDetailView() {
        return (I_TeamDetailView) getScreenView();
    }

    @Override
    public void setScreenState(Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("setScreenState", "view", view.getSimpleName());
        debug("setScreenState", "code", code);

        DetailState _state = (DetailState) state;
        TeamData data = (TeamData) _state.getData();
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

    @Override
    public String getDetailText() {
        TeamData _data = (TeamData) getDetailModel().getData();
        return _data.getText();
    }

//    public int getImage(){
//        TeamData _data = (TeamData) getDetailModel().getData();
//        return _data.getImage();
//    }
}
