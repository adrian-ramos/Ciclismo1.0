package com.example.ciclismo.team.master;

import android.view.View;
import android.widget.TextView;
import com.example.ciclismo.team.data.TeamData;
import com.example.ciclismo.R;
import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.master.MasterView;

public class TeamMasterView extends MasterView implements I_TeamMasterView {

    public I_TeamMasterPresenter getMasterPresenter() {
        return (I_TeamMasterPresenter) getScreenPresenter();
    }

    @Override
    public int getMasterLayout() {
        return R.layout.team_master_view;
    }

    @Override
    public int getMasterList() {
        return R.id.lst_master;
    }

    @Override
    public int getMasterRowLayout() {
        return R.layout.team_master_row;
    }

    @Override
    public void setMasterRowContent(View row, I_CatalogData data) {

        TextView title = (TextView) row.findViewById(R.id.lbl_title);
        TeamData _data = (TeamData) data;
        title.setText(_data.toString());
    }
}

