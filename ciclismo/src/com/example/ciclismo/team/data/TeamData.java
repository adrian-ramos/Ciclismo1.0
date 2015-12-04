package com.example.ciclismo.team.data;

import org.droidpersistence.annotation.Column;
import org.droidpersistence.annotation.PrimaryKey;
import org.droidpersistence.annotation.Table;

@Table(name="mountains")
public class TeamData implements I_TeamData {

    @PrimaryKey(autoIncrement = true)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String label;

    @Column(name = "detail")
    private String text;

    @Column(name = "image")
    private String image;

    public TeamData() {
        setLabel("");
        setId(0L);
    }

    public TeamData(String label) {
        setLabel(label);
        setId(0L);
    }

    public TeamData(String label, String text, String image) {
        setLabel(label);
        setId(0L);
        setText(text);
        setImage(image);
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public void setImage(String txt) {
        image = txt;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setLabel(String text) {
        label = text;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setId(Long dataId) {
        id = dataId;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj instanceof TeamData) {
            TeamData data = (TeamData) obj;

            if(data.getId() == getId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return getLabel();
    }
}