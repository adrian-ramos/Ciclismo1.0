package es.ulpgc.eite.da.catalog.android.core.master;


import es.ulpgc.eite.da.framework.android.AndroidScreenPresenter;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenObserver;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenView;

public abstract class MasterPresenter extends AndroidScreenPresenter
implements I_MasterPresenter, I_ScreenObserver {

    private int _mCode;

    public abstract I_MasterView getMasterView();
    public abstract I_MasterModel getMasterModel();
    public abstract I_ScreenState updateMasterState(
    Class<? extends I_ScreenView> view, int code, I_ScreenState state);

    public MasterPresenter() {
        super();
    }

    @Override
    public void setMasterCode(int code) { //todo
        _mCode = code;
    }

    @Override
    public int getMasterCode() {
        return _mCode;
    }

    @Override
    public void rotateScreen() {
        debug("rotateScreen");
    }

    @Override
    public void createScreen() {
        debug("createScreen");

        getMasterView().initMaster();
    }

    @Override
    public void backScreen() {
        debug("backScreen");
    }

    @Override
    public void resumeScreen() {
        debug("resumeScreen");

        getMasterView().updateMasterContent(getMasterModel().getCollection());
    }

    @Override
    public void pauseScreen() {
        debug("pauseScreen");
    }


    @Override
    public I_ScreenState updateObserverState(
    Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        return updateMasterState(view, code, state);
    }



}
