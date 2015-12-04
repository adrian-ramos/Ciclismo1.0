package com.example.ciclismo.cyclist.database;

import com.example.ciclismo.cyclist.data.CyclistData;
import com.example.ciclismo.database.DatabaseClauseArg;
import java.util.List;

public interface I_CyclistDatabase {

    public CyclistData getCyclist(Long dataId);
    public CyclistData getCyclistBy(DatabaseClauseArg[] args);
    public List<CyclistData> getCyclistListBy(DatabaseClauseArg[] args);
    public List<CyclistData> getCyclistList();
    public boolean deleteCyclist(Long dataId);
    public boolean deleteCyclistList();
    public Long saveCyclist(CyclistData data);
    public boolean updateCyclist(CyclistData data);

}
