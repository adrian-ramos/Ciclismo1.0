package com.example.ciclismo.cyclist.database;

import com.example.ciclismo.cyclist.data.CyclistData;
import org.droidpersistence.dao.TableDefinition;

public class CyclistTable extends TableDefinition<CyclistData> {

	public CyclistTable() {
		super(CyclistData.class);
	}
}
