package es.ulpgc.eite.da.catalog.android.core.detail;


import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.framework.CatalogCode;
import es.ulpgc.eite.da.catalog.android.core.state.DetailState;
import es.ulpgc.eite.da.framework.android.AndroidScreenPresenter;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenObservable;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenView;

public abstract class DetailPresenter extends AndroidScreenPresenter
implements I_DetailPresenter, I_ScreenObservable {


    private int _mCode;
    private int _dCode;
    private int _position;
    private int _size;

    public abstract I_DetailModel getDetailModel();
    public abstract I_DetailView getDetailView();
    public abstract void updateDetailState(
    Class<? extends I_ScreenView> view, int code, I_ScreenState state);

    public DetailPresenter() {
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
    public int getDetailCode() {
        return _dCode;
    }

    @Override
    public void setDetailCode(int code) {
        _dCode = code;
    }

    @Override
    public int getPosition() {
        return _position;
    }

    @Override
    public void setPosition(int pos) {
        _position = pos;
    }

    @Override
    public int getSize() {
        return _size;
    }

    @Override
    public void setSize(int size) {
        _size = size;
    }


    @Override
    public void rotateScreen() {
        debug("rotateScreen");
    }

    @Override
    public void createScreen() {
        debug("createScreen");

        getDetailView().initDetail();
    }

    @Override
    public void backScreen() {

    }


    @Override
    public void resumeScreen() {
        debug("resumeScreen", "data", getDetailModel().getData());

        getDetailView().setDetailContent(getDetailModel().getData());
    }

    @Override
    public void pauseScreen() {

    }


    public void updateMasterContent(I_CatalogData data, int code) {

        debug("updateMasterRowContent", "dcode", code);
        debug("updateMasterRowContent", "data", data);

        notifyScreenObservers(this, code, new DetailState(data));
    }


    @Override
    public void updateObservableState(
    Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        DetailState _state = (DetailState) state;
        if(_state.getMasterCode() == CatalogCode.FINISH) {
            finishScreen();
            return;
        }

        updateDetailState(view, code, state);
    }


    public void updateDetailContent(int code) {

        updateMasterContent(getDetailModel().getData(), code);
        getDetailView().setDetailContent(getDetailModel().getData());
    }


}
