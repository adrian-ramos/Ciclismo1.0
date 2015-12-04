package com.example.ciclismo.cyclist.database;

import android.database.sqlite.SQLiteDatabase;
import com.example.ciclismo.cyclist.data.CyclistData;
import org.droidpersistence.dao.DroidDao;
import org.droidpersistence.dao.TableDefinition;

public class CyclistDao extends DroidDao<CyclistData, Long> {

	public CyclistDao(TableDefinition<CyclistData> td, SQLiteDatabase db) {
		super(CyclistData.class, td, db);
	}

}
