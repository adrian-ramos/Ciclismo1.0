package es.ulpgc.eite.da.catalog.android.core.master;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.framework.CatalogCode;
import es.ulpgc.eite.da.framework.android.AndroidScreenView;

import java.util.List;

public abstract class MasterView
extends AndroidScreenView implements I_MasterView {


    private MasterAdapter _adapter;
    private int _position;
    private ListView _list;

    public abstract I_MasterPresenter getMasterPresenter();
    public abstract int getMasterLayout();
    public abstract int getMasterList();
    public abstract int getMasterRowLayout();
    public abstract void setMasterRowContent(View row, I_CatalogData data);


    @Override
    public void initMaster() {
        setMasterContent();
        setMasterList();
    }


    @Override
    public void setMasterContent() { //todo

        //setTheme(android.R.style.Theme_Holo_Light);
        setContentView(getMasterLayout());
        //setTitle(R.string.app_catalog);
        //getActionBar().setSubtitle(getMasterTitle());
        //getActionBar().setLogo(android.R.color.transparent);
    }

    @Override
    public int getListPosition() {
        return _position;
    }


    private void setMasterList() {

        _list = (ListView) findViewById(getMasterList());
        _adapter = new MasterAdapter(this, getMasterRowLayout());
        _list.setAdapter(_adapter);
        _list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(
            AdapterView<?> parent, View view, int position, long id) {

                onMasterListClick(position);
            }
        });
    }


    public void onMasterButtonClick(int code) {
        getMasterPresenter().onMasterButtonClick(code);
    }

    private void onMasterListClick(int position){
        _position = position;
        onMasterButtonClick(CatalogCode.EDIT);
    }

    @Override
    public void updateMasterContent(List<? extends I_CatalogData> collection) {

        debug("updateMasterContent", "collection", collection);

        _adapter.clear();
        _adapter.addAll(collection);
        _adapter.notifyDataSetChanged();

        _list.setSelection(_position);
    }


    private class MasterAdapter extends ArrayAdapter<I_CatalogData> {

        private int _layout;
        private MasterView _master;

        public MasterAdapter(MasterView master, int layout) {
            super(master, layout);

            _master = master;
            _layout = layout;
        }

        private int getLayout() {
            return _layout;
        }

        private MasterView getMaster() {
            return _master;
        }


        @Override
        public View getView(int position, View row, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater)
                    getMaster().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row = inflater.inflate(getLayout(), parent, false);

            I_CatalogData data = getItem(position);
            setMasterRowContent(row, data);

            return row;
        }
    }


}
