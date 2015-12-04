package com.example.ciclismo.database;

import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import com.example.ciclismo.R;
import com.example.ciclismo.cyclist.data.CyclistData;
import com.example.ciclismo.cyclist.database.CyclistDao;
import com.example.ciclismo.cyclist.database.CyclistTable;
import com.example.ciclismo.cyclist.database.I_CyclistDatabase;
import com.example.ciclismo.team.data.TeamData;
import com.example.ciclismo.team.database.I_TeamDatabase;
import com.example.ciclismo.team.database.TeamDao;
import com.example.ciclismo.team.database.TeamTable;
import es.ulpgc.eite.da.framework.android.AndroidScreenDatabase;
import es.ulpgc.eite.da.framework.android.I_AndroidMediator;

import java.util.List;

public class DatabaseCiclismo extends AndroidScreenDatabase implements I_CyclistDatabase, I_TeamDatabase {

    private final static int DB_VERSION = 10;
    public static final int  CATALOG_NAME = R.string.app_generic_catalog;
    private DatabaseGenericCatalogUtils dbUtils;
	private SQLiteDatabase database;
	private CyclistDao categoryDao;
	private TeamDao productDao;

    @Override
    public void configDatabase() {
        String dbname=getPlatformMediator().getNormalizedResource(CATALOG_NAME);
        dbUtils = new DatabaseGenericCatalogUtils(getPlatformMediator().getContext(), dbname, null, DB_VERSION);
        setDatabase(dbUtils.getWritableDatabase());
        categoryDao = new CyclistDao(new CyclistTable(), database);
        productDao = new TeamDao(new TeamTable(), database);
    }

    private I_AndroidMediator getPlatformMediator() {
        return (I_AndroidMediator) getMediator();
    }

	private void openDatabase(){
		if(! getDatabase().isOpen()){
            setDatabase(dbUtils.getWritableDatabase());
		}
	}
	
	private void closeDatabase() {
		if (getDatabase().isOpen()) {
			getDatabase().close();
	    }
	}

	private void resetDatabase() {
		closeDatabase();
	    SystemClock.sleep(500);
	    openDatabase();
	}

    private SQLiteDatabase getDatabase() {
   		return database;
   	}

   	private void setDatabase(SQLiteDatabase db) {
   		database = db;
   	}

   	private CyclistDao getCyclistDao() {
   		return categoryDao;
   	}

    private void setCyclistDao(CyclistDao dao) {
   		categoryDao = dao;
   	}

   	private TeamDao getTeamDao() {
   		return productDao;
   	}

   	private void setTeamDao(TeamDao dao) {
   		productDao = dao;
   	}

    @Override
	public CyclistData getCyclist(Long dataId) {
		return getCyclistDao().get(dataId);
	}

    @Override
	public TeamData getTeam(Long dataId){
		return getTeamDao().get(dataId);
	}

    @Override
    public CyclistData getCyclistBy(DatabaseClauseArg[] args){

        String clause = " ";
        for (int index=0; index < args.length-1; index++) {
            DatabaseClauseArg arg = args[index];
            clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";
            clause += " AND ";
        }

        DatabaseClauseArg arg = args[args.length-1];
        clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";

        return getCyclistDao().getByClause(clause, null);
   	}

    @Override
    public TeamData getTeamBy(DatabaseClauseArg[] args){

        String clause = " ";
        for (int index=0; index < args.length-1; index++) {
            DatabaseClauseArg arg = args[index];
            clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";
            clause += " AND ";
        }

        DatabaseClauseArg arg = args[args.length-1];
        clause += arg.key + " "  + arg.cond + " '" + arg.val +"'";

        return getTeamDao().getByClause(clause, null);
   	}

    @Override
    public List<CyclistData> getCyclistListBy(DatabaseClauseArg[] args){

        String clause = " ";
        for (int index=0; index < args.length-1; index++) {
            DatabaseClauseArg arg = args[index];
            clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";
            clause += " AND ";
        }

        DatabaseClauseArg arg = args[args.length-1];
        clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";

        return getCyclistDao().getAllbyClause(clause, null, null, null, "id");
   	}

    @Override
    public List<TeamData> getTeamListBy(DatabaseClauseArg[] args){

        String clause = " ";
        for (int index=0; index < args.length-1; index++) {
            DatabaseClauseArg arg = args[index];
            clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";
            clause += " AND ";
        }

        DatabaseClauseArg arg = args[args.length-1];
        clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";

        return getTeamDao().getAllbyClause(clause,
                null, null, null, "id");
   	}

    @Override
	public List<CyclistData> getCyclistList(){
        return getCyclistDao().getAllbyClause(null, null, null, null, "id");
	}

    @Override
	public List<TeamData> getTeamList(){
        return getTeamDao().getAllbyClause(null, null, null, null, "id");
	}	

    @Override
	public boolean deleteCyclist(Long dataId){
        debug("deleteCyclist");

		getDatabase().beginTransaction();
        boolean result = getCyclistDao().delete(dataId);
		getDatabase().setTransactionSuccessful();
		getDatabase().endTransaction();
		return result;
	}

    @Override
    public boolean deleteCyclistList(){

        int size = getCyclistList().size();
   		getDatabase().beginTransaction();
        int result = getDatabase().delete(
                getCyclistDao().getTableName(), "1", null);
   		getDatabase().setTransactionSuccessful();
   		getDatabase().endTransaction();

        if(result == size) {
            return true;
        } else {
            return false;
        }
   	}

    @Override
    public boolean deleteTeamList(){
        int size = getTeamList().size();
   		getDatabase().beginTransaction();
        int result = getDatabase().delete(
                getTeamDao().getTableName(), "1", null);
   		getDatabase().setTransactionSuccessful();
   		getDatabase().endTransaction();

        if(result == size) {
            return true;
        } else {
            return false;
        }
   	}

    @Override
	public boolean deleteTeam(Long dataId){
		getDatabase().beginTransaction();
        boolean result = getTeamDao().delete(dataId);
		getDatabase().setTransactionSuccessful();
		getDatabase().endTransaction();
		return result;
	}

    @Override
	public Long saveCyclist(CyclistData data){

        debug("saveCyclist");

        long result = 0;
		try {

			getDatabase().beginTransaction();
			result = getCyclistDao().save(data);
			getDatabase().setTransactionSuccessful();

		} catch (Exception ex) {
            debug("saveCyclist", "error", ex.toString());
		}
		getDatabase().endTransaction();
		return result;
	}

    @Override
	public Long saveTeam(TeamData data){

        debug("saveTeam");

		long result = 0;
		try {

			getDatabase().beginTransaction();
			result = getTeamDao().save(data);
			getDatabase().setTransactionSuccessful();

		} catch (Exception ex) {
            debug("saveTeam", "error", ex.toString());
		}
		getDatabase().endTransaction();

		return result;
	}

    @Override
    public boolean updateCyclist(CyclistData data) {
        boolean result = false;
        try {

            getDatabase().beginTransaction();
            getCyclistDao().update(data, data.getId());
            getDatabase().setTransactionSuccessful();
            result = true;

        } catch (Exception e) {

        }
        getDatabase().endTransaction();
        return result;
    }

    @Override
    public boolean updateTeam(TeamData data) {
        boolean result = false;
        try {

            getDatabase().beginTransaction();
            getTeamDao().update(data, data.getId());
            getDatabase().setTransactionSuccessful();
            result = true;

        } catch (Exception e) {}
        getDatabase().endTransaction();
        return result;
    }
}
