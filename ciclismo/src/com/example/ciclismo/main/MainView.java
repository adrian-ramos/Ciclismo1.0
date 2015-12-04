package com.example.ciclismo.main;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.example.ciclismo.cyclist.master.CyclistMasterView;
import com.example.ciclismo.team.master.TeamMasterView;
import com.example.ciclismo.R;
import es.ulpgc.eite.da.framework.android.AndroidScreenView;

public class MainView extends AndroidScreenView implements I_MainView {

    private I_MainPresenter getMainController() {
        return (I_MainPresenter) getScreenPresenter();
    }

    public void initMain(){
        setMainView();
        setMainButton();
    }

    public void setMainView() {
        setContentView(R.layout.main_view);
    }

    public void setBeachView() {
        setContentView(R.layout.cyclist_master_view);
        Intent i = new Intent(this, CyclistMasterView.class);
        startActivity(i);
    }

    public void setMountainView(){
        setContentView(R.layout.team_master_view);
        Intent i = new Intent(this, TeamMasterView.class);
        startActivity(i);
    }

    private void setMainButton() {

        Button CyclistButton = (Button) findViewById(R.id.CyclistButton);
        CyclistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBeachView();
            }
        });

        Button TeamButton = (Button) findViewById(R.id.TeamButtom);
        TeamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMountainView();
            }
        });
    }

}