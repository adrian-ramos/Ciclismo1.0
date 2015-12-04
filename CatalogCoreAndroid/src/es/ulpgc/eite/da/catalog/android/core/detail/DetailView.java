package es.ulpgc.eite.da.catalog.android.core.detail;


import es.ulpgc.eite.da.framework.android.AndroidScreenView;

public abstract class DetailView
extends AndroidScreenView implements I_DetailView {


    public abstract int getDetailLayout();

    @Override
    public void initDetail() {
        setDetailContent();
    }

    @Override
    public void setDetailContent() {  //todo

        //setTheme(android.R.style.Theme_Holo_Light);
        setContentView(getDetailLayout());
        //setTitle(R.string.app_catalog);
        //getActionBar().setSubtitle(getDetailTitle());
        //getActionBar().setLogo(android.R.color.transparent);
    }

}
