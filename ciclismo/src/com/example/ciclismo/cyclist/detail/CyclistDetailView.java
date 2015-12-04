package com.example.ciclismo.cyclist.detail;

import android.widget.ImageView;
import android.widget.TextView;
import com.example.ciclismo.cyclist.data.CyclistData;
import com.example.ciclismo.R;
import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.detail.DetailView;

public class CyclistDetailView extends DetailView implements I_CyclistDetailView {

    @Override
    public int getDetailLayout() {
        return R.layout.cyclist_detail_view;
    }

    public I_CyclistDetailPresenter getDetailPresenter() {
        return (I_CyclistDetailPresenter) getScreenPresenter();
    }

    @Override
    public void setDetailContent(I_CatalogData data) {

        CyclistData _data = (CyclistData) data;

        debug("setDetailContent", "data", _data);

        TextView title = (TextView) findViewById(R.id.txt_title);
        title.setText(_data.toString());

        TextView subtitle = (TextView) findViewById(R.id.lbl_subtitle);
        subtitle.setText(getDetailPresenter().getDetailText());

        ImageView image = (ImageView) findViewById(R.id.imagen);
        int resourceId = getResources().getIdentifier(_data.getImage(), "drawable", getPackageName());
        image.setImageDrawable(getResources().getDrawable(resourceId));

    }

}
