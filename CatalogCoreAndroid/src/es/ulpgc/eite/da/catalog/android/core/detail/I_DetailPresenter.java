package es.ulpgc.eite.da.catalog.android.core.detail;


public interface I_DetailPresenter {

    public void setMasterCode(int code);
    public int getMasterCode();
    public int getDetailCode();
    public void setDetailCode(int code);
    public int getPosition();
    public void setPosition(int position);
    public int getSize();
    public void setSize(int size);

}
