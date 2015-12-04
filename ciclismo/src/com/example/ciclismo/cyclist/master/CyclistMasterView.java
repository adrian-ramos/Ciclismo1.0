package com.example.ciclismo.cyclist.master;

import android.view.View;
import android.widget.TextView;
import com.example.ciclismo.cyclist.data.CyclistData;
import com.example.ciclismo.R;
import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.master.MasterView;

public class CyclistMasterView extends MasterView implements I_CyclistMasterView {

    public I_CyclistMasterPresenter getMasterPresenter() { //todo
        return (I_CyclistMasterPresenter) getScreenPresenter();
    }

    @Override
    public int getMasterLayout() {
        return R.layout.cyclist_master_view;
    }

    @Override
    public int getMasterList() {
        return R.id.lst_master;
    }

    @Override
    public int getMasterRowLayout() {
        return R.layout.cyclist_master_row;
    }

    @Override
    public void setMasterRowContent(View row, I_CatalogData data) { //todo

        TextView title = (TextView) row.findViewById(R.id.lbl_title);
        CyclistData _data = (CyclistData) data;
        title.setText(_data.toString());

    }
}

