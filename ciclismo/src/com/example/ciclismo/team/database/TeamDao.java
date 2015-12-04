package com.example.ciclismo.team.database;


import android.database.sqlite.SQLiteDatabase;
import com.example.ciclismo.team.data.TeamData;
import org.droidpersistence.dao.DroidDao;
import org.droidpersistence.dao.TableDefinition;

public class TeamDao extends DroidDao<TeamData, Long> {

	public TeamDao(TableDefinition<TeamData> td, SQLiteDatabase db) {

		super(TeamData.class, td, db);
	}

}
