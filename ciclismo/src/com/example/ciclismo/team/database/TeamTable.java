package com.example.ciclismo.team.database;


import com.example.ciclismo.team.data.TeamData;
import org.droidpersistence.dao.TableDefinition;

public class TeamTable extends TableDefinition<TeamData> {

	public TeamTable() {
		super(TeamData.class);
	}

}
