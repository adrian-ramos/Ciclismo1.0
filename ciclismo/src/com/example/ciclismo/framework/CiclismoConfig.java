package com.example.ciclismo.framework;

import com.example.ciclismo.cyclist.detail.CyclistDetailModel;
import com.example.ciclismo.cyclist.detail.CyclistDetailPresenter;
import com.example.ciclismo.cyclist.detail.CyclistDetailView;
import com.example.ciclismo.cyclist.master.CyclistMasterModel;
import com.example.ciclismo.cyclist.master.CyclistMasterPresenter;
import com.example.ciclismo.cyclist.master.CyclistMasterView;
import com.example.ciclismo.database.DatabaseCiclismo;
import com.example.ciclismo.main.MainModel;
import com.example.ciclismo.main.MainPresenter;
import com.example.ciclismo.main.MainView;
import com.example.ciclismo.team.detail.TeamDetailModel;
import com.example.ciclismo.team.detail.TeamDetailPresenter;
import com.example.ciclismo.team.detail.TeamDetailView;
import com.example.ciclismo.team.master.TeamMasterModel;
import com.example.ciclismo.team.master.TeamMasterPresenter;
import com.example.ciclismo.team.master.TeamMasterView;
import es.ulpgc.eite.da.catalog.android.core.framework.CatalogCode;
import es.ulpgc.eite.da.framework.core.mediator.I_MediatorSingleton;
import es.ulpgc.eite.da.framework.core.mediator.MediatorConfig;
import es.ulpgc.eite.da.framework.core.mediator.MediatorScreen;
import es.ulpgc.eite.da.framework.core.mediator.MediatorTransition;

public class CiclismoConfig extends MediatorConfig {

    public CiclismoConfig(I_MediatorSingleton mediator) {
        super(mediator);
    }

    @Override
    public void setCustomConfig() {
        setCatalogConfig();
    }

    public void setCatalogConfig() {
        setCatalogTransitionCollection();
        setCatalogScreenCollection();
    }

    // Transiciones de Pantalla //
    private void setCatalogTransitionCollection() {

        //Main --> Playas //
        getTransitions().add(new MediatorTransition(
                MainView.class, CyclistMasterView.class,
                CatalogCode.EDIT));

        //Main --> Montañas//
        getTransitions().add(new MediatorTransition(
                MainView.class, TeamMasterView.class,
                CatalogCode.EDIT));

        //Playas --> Detalle de playas //
        getTransitions().add(new MediatorTransition(
                CyclistMasterView.class, CyclistDetailView.class,
                CatalogCode.EDIT));

        //Montañas --> Detalle de Montañas //
        getTransitions().add(new MediatorTransition(
                TeamMasterView.class, TeamDetailView.class,
                CatalogCode.EDIT));
    }

    // Colección de Pantallas //
    private void setCatalogScreenCollection() {

        //Main V-P-M //
        getScreens().add(new MediatorScreen(MainView.class,
                MainPresenter.class, MainModel.class));

        //Playas V-P-M //
        getScreens().add(new MediatorScreen(CyclistMasterView.class,
                CyclistMasterPresenter.class, CyclistMasterModel.class, DatabaseCiclismo.class));

        //Playas Detalle V-P-M//
        getScreens().add(new MediatorScreen(CyclistDetailView.class,
                CyclistDetailPresenter.class, CyclistDetailModel.class, DatabaseCiclismo.class));

        //Montañas V-P-M //
        getScreens().add(new MediatorScreen(TeamMasterView.class,
                TeamMasterPresenter.class, TeamMasterModel.class, DatabaseCiclismo.class));

        //Montañas Detalle V-P-M //
        getScreens().add(new MediatorScreen(TeamDetailView.class,
                TeamDetailPresenter.class, TeamDetailModel.class, DatabaseCiclismo.class));
    }
}
