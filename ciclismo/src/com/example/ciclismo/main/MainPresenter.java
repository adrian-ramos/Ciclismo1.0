package com.example.ciclismo.main;

import es.ulpgc.eite.da.framework.android.AndroidScreenPresenter;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenView;

public class MainPresenter extends AndroidScreenPresenter implements I_MainPresenter{

    private I_MainModel getMainModel() {
        return (I_MainModel) getScreenModel();
    }

    private I_MainView getMainView() {
        return (I_MainView) getScreenView();
    }

    @Override
    public void rotateScreen() {
        debug("rotateScreen");
    }

    @Override
    public void createScreen() {
        debug("createScreen");
        getMainView().initMain();
    }

    @Override
    public void backScreen() {
        debug("backScreen");
        getMainView().initMain();
    }

    @Override
    public void resumeScreen() {
        debug("resumeScreen");
        getMainView().initMain();
    }

    @Override
    public void pauseScreen() {
        debug("pauseScreen");
    }

    @Override
    public void setScreenState(Class<? extends I_ScreenView> view, int code, I_ScreenState state) {
//        getMainModel().set_mountain();
//        getMainModel().set_beach();
    }

    @Override
    public I_ScreenState getScreenState() {
        return null;
    }

    @Override
    public I_ScreenState getNextState(Class<? extends I_ScreenView> view, int code) {
        return null;
    }

}
