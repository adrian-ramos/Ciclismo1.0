package es.ulpgc.eite.da.catalog.android.core.master;


public interface I_MasterPresenter {

    public void setMasterCode(int code);
    public int getMasterCode();

    public abstract void onMasterButtonClick(int code);

}
