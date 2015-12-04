package com.example.ciclismo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.ciclismo.cyclist.database.CyclistTable;
import com.example.ciclismo.team.database.TeamTable;

public class DatabaseGenericCatalogUtils extends SQLiteOpenHelper {

    public DatabaseGenericCatalogUtils(Context ctx, String name, CursorFactory factory, int ver) {
        super(ctx, name, factory, ver);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {

            CyclistTable CyclistTable = new CyclistTable();
            CyclistTable.onCreate(db);
            TeamTable TeamTable = new TeamTable();
            TeamTable.onCreate(db);

        } catch (Exception e) {
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        try {

            CyclistTable CyclistTable = new CyclistTable();
            CyclistTable.onUpgrade(db, oldVer, newVer);
            TeamTable TeamTable = new TeamTable();
            TeamTable.onUpgrade(db, oldVer, newVer);

        } catch (Exception e) {
        }

    }
}
