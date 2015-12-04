package com.example.ciclismo.cyclist.master;

import com.example.ciclismo.cyclist.data.CyclistData;
import com.example.ciclismo.cyclist.database.I_CyclistDatabase;
import es.ulpgc.eite.da.catalog.android.core.master.MasterModel;

import java.util.List;

public class CyclistMasterModel extends MasterModel implements I_CyclistMasterModel {

    public CyclistMasterModel() {
        super();
    }

    private I_CyclistDatabase getDatabase() {
        return (I_CyclistDatabase) getScreenDatabase();
    }
    @Override
    public void addData() {
        CyclistData _data = new CyclistData("Cyclist" + (getSize() + 1));
        getDatabase().saveCyclist(_data);
        super.addData();
    }

    @Override
    public void delData() {
        debug("delData");
        getDatabase().deleteCyclist(
                getCollection().get(getPosition()).getId());
        super.delData();
    }

    @Override
    public List<CyclistData> getCollection() {
        List<CyclistData> collection = getDatabase().getCyclistList();
        debug("getCollection", "collection", collection);
        return collection;
    }

    @Override
    public void setCollection() {
        if(getDatabase().getCyclistList().size() == 0) {
            CyclistData data1 = new CyclistData("Michał Kwiatkowski","Born in Dzilan the 2nd of June of 1992, is a Polish professional road bicycle racer for UCI ProTeam" +
                    " Sky Procycling. Kwiatkowski is seen as a strong all rounder, with good sprinting, time-trialling and " +
                    "climbing abilities allowing him to win both stage races and one day classics. His talent was shown in early " +
                    "career winning the World Junior Time Trial. In 2014, Kwiatkowski became the world champion of " +
                    "elite men's road race at the age of 24. He was also a member in the Omega Pharma-Quick-Step World Team Time Trial" +
                    " winning team in 2013.", "kwiato");
            getDatabase().saveCyclist(data1);
            CyclistData data2 = new CyclistData("Peter Sagan","Born in Žilina in the 26th of January of 1990 is a Slovak professional road bicycle racer" +
                    " for World Tour " +
                    "team Tinkoff-Saxo sagan had a successful junior cyclo-cross and team bike racing career, " +
                    "winning the Junior World Championship in 2008, before moving to road racing.\n" +           "\n" +
                    "sagan is considered one of cycling's most promising young talents, having earned many prestigious victories" +
                    " in his early twenties. Supporting this view are victories in: one World Championship, two Paris–Nice stages, " +
                    "three Tirreno–Adriatico stages, one in the Tour de Romandie, two and the overall classification in the Tour de Pologne, " +
                    "a record thirteen in the Tour of California, and eleven in the Tour de Suisse." +
                    " He has won eight stages in Grand Tours: four in the Vuelta a España and four in the Tour de France. " +
                    "He was also the winner of the points classification in the Tour de France, in 2012, 2013, 2014 and 2015; as a result, " +
                    "sagan became the first rider to win the classification in his first four attempts.","sagan");
            getDatabase().saveCyclist(data2);
            CyclistData data3= new CyclistData("Christopher Froome","Born in Nairobi the 20th of May of 1985 is a Kenyan-born British " +
                    "professional " +
                    "road racing cyclist" +
                    " riding for UCI ProTeam Team Sky. A two time winner of the Tour de France, he is seen as one of the most " +
                    "successful riders of the recent era.Brought up in Kenya and South Africa, he has ridden since 2008 under" +
                    " a British licence on the basis of his passport and his father's and grandparents' country of birth.\n" +
                    "\n" +
                    "In 2007 froome turned professional at the age of 22 with Team Konica Minolta. He moved to Europe to further his " +
                    "career, joining team Barloworld. In 2010 he moved to Team Sky and has become one of the team's key cyclists. " +
                    "froome made his breakthrough as a Grand Tour contender during the 2011 Vuelta a España where he finished second " +
                    "overall.\n" +
                    "\n" +
                    "At the 2012 Tour de France, riding as a super-domestique for Bradley Wiggins, froome won stage seven and finished" +
                    " second overall, behind only Wiggins in the same race as the best British performance in the race's history. " +
                    "In the same year he also won the bronze medal in the time trial event at the Olympic Games and finished fourth in" +
                    " the Vuelta a España. His first multi-stage race win came in 2013, in the Tour of Oman, followed by wins in the " +
                    "Critérium International, the Tour de Romandie, the Critérium du Dauphiné, and the Tour de France.\n" +
                    "\n" +
                    "As a defending champion, he began 2014 by again winning the Tour of Oman, followed by a repeat victory in the " +
                    "Tour de Romandie. After retiring from the 2014 Tour de France, he came back to place second in the Vuelta a " +
                    "España. In 2015, he won his second Critérium du Dauphiné and his second Tour de France.","froome");
            getDatabase().saveCyclist(data3);
            CyclistData data4 = new CyclistData("Mark Cavendish","Born in Douglas, Isle of Man, the 21st of May of 1985 is a British professional" +
                    " road racing cyclist who currently rides " +
                    "for UCI ProTeam Etixx-Quick Step. Originally a track cyclist specialising in the madison, points race, and scratch" +
                    " race disciplines, he has competed on the road since 2006, rising to prominence as a sprinter, widely considered" +
                    " one of the best of his era.\n" +
                    "\n" +
                    "On the track Cavendish won gold in the Madison at the 2005 and 2008 world championships riding for Great Britain," +
                    " with Rob Hayles and Bradley Wiggins respectively, and in the scratch race at the 2006 Commonwealth Games riding " +
                    "for Isle of Man.\n" +
                    "\n" +
                    "As a road cyclist, Cavendish achieved eleven wins in his first professional season, passing the record held by" +
                    " Alessandro Petacchi. Cavendish has won twenty-six Tour de France stages putting him third on the all-time list" +
                    " and fourth on the all-time list of Grand Tour stage winners with forty-four victories. He won the road race at " +
                    "the 2011 road world championships, becoming the second British rider to do so after Tom Simpson in 1965. " +
                    "Other notable wins include the 2009 Milan–San Remo classic and the points classification in all three of the " +
                    "grand tours: the 2010 Vuelta a España, the 2011 Tour de France, and the 2013 Giro d'Italia. In 2012 he became the" +
                    " first person to win the final Champs-Élysées stage in the Tour de France in four consecutive years.\n" +
                    "\n" +
                    "In the Queen's Birthday Honours 2011, Cavendish was appointed a Member of the Order of the British Empire for " +
                    "services to British Cycling. He won the 2011 BBC Sports Personality of the Year Award and in 2012 was named" +
                    " the Tour de France's best sprinter of all time by French newspaper L'Equipe. Since 2013 he has been ranked" +
                    " first on the Cycling Weekly all-time ranking of British professional riders.","cav");
            getDatabase().saveCyclist(data4);
        }
    }

}
