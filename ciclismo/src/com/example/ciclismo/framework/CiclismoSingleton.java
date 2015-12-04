package com.example.ciclismo.framework;

import es.ulpgc.eite.da.framework.android.AndroidMediatorSingleton;

public class CiclismoSingleton extends AndroidMediatorSingleton {
    private static CiclismoSingleton singleton;

    @Override
    public void createMediator() {
        setCustomConfig(new CiclismoConfig(this));
        singleton = this;
    }
}
