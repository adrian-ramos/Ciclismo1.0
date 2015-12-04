package com.example.ciclismo.team.master;

import com.example.ciclismo.team.data.TeamData;
import com.example.ciclismo.team.database.I_TeamDatabase;
import es.ulpgc.eite.da.catalog.android.core.master.MasterModel;

import java.util.List;

public class TeamMasterModel extends MasterModel implements I_TeamMasterModel {

    public TeamMasterModel() {
        super();
    }

    private I_TeamDatabase getDatabase() {
        return (I_TeamDatabase) getScreenDatabase();
    }

    @Override
    public void addData() {
        TeamData _data = new TeamData("Team " + (getSize() + 1));
        getDatabase().saveTeam(_data);
        super.addData();
    }

    @Override
    public void delData() {
        debug("delData");
        getDatabase().deleteTeam(
                getCollection().get(getPosition()).getId());
        super.delData();
    }

    @Override
    public List<TeamData> getCollection() {
        List<TeamData> collection = getDatabase().getTeamList();
        debug("getCollection", "collection", collection);
        return collection;
    }

    @Override
    public void setCollection() {
        if(getDatabase().getTeamList().size() == 0) {
            TeamData data1 = new TeamData("Team Sky","Is a British professional cycling team that competes in the UCI World Tour. " +
                    "The team is based at the National Cycling Centre in Manchester, England, with a logistics base in Deinze, Belgium" +
                    " and an operational base in Quarrata, Italy. The team is managed by British Cycling's former performance " +
                    "director Dave Brailsford.\n" +
                    "\n" +
                    "Team Sky's initial aim in 2010 was to \"create the first British winner of the Tour de France within five years\". " +
                    "Though later cut back to just aiming to \"win the Tour de France within five years\", Sky achieved their initial goal within" +
                    " just three years when Bradley Wiggins won the 2012 Tour de France, becoming the first British winner in its history, while" +
                    " teammate and fellow Briton Chris Froome finished as the runner up who then went onto win the 2013 Tour de France, thereby " +
                    "achieving Team Sky's primary aim twice over within the original five-year time period. Froome won Sky's third Tour de France" +
                    " title in 2015.","sky");
            getDatabase().saveTeam(data1);
            TeamData data2 = new TeamData("Movistar Team","Is a professional road bicycle racing team which participates in the UCI ProTour " +
                    "and has achieved thirteen general classification (GC) victories in Grand Tours. The title sponsor is the Spanish mobile " +
                    "telephone company Telefónica, with the team riding under the name of the company's brand Movistar.\n" +
                    "\n" +
                    "The team was formed as Reynolds, led by Ángel Arroyo and later by Pedro Delgado, who won a Tour de France and a Vuelta" +
                    " a España, and was subsequently sponsored by Banesto, under which title the team included 5-time Tour de France winner" +
                    " Miguel Indurain and Alex Zülle, twice winner of the Vuelta a España. The team offices are in Egüés, a municipality of " +
                    "Navarre, Spain, in the metropolitan area of Pamplona. A later sponsor was Caisse d'Epargne, a French semi-cooperative " +
                    "banking group.\n" +
                    "\n" +
                    "Having previously used Pinarello bikes, the team will ride Canyon frames for 2014 with Campagnolo parts. Since 2008 " +
                    "Eusebio Unzué has been the manager of the team after the long running manager, José Miguel Echavarri, retired from the" +
                    " sport. Directeurs sportifs of the team include Neil Stephens, Alfonso Galilea and José Luis Jaimerena.","movistar");
            getDatabase().saveTeam(data2);
            TeamData data3 = new TeamData("Team Europcar","Is a professional road bicycle racing team that competes as a UCI Professional Continental" +
                    " team in UCI Continental Circuits races, and UCI WorldTour races when invited as a wild card entry. Its title sponsor, Europcar, " +
                    "is a Paris-based car rental company. In previous years, the team was known as Brioches La Boulangère, Bonjour, Bouygues Télécom, " +
                    "and Bbox Bouygues Telecom. The 2015 season is the last under the sponsorship of Europcar; the team will be sponsored by" +
                    " Direct Energie in 2016.","europcar");
            getDatabase().saveTeam(data3);
            TeamData data4 = new TeamData("MTN Qhubeka","The team was founded in 2007, becoming a Continental Team in 2008. The team remained" +
                    " as a UCI Continental Team until the end of the 2012 season, with the team registering its interest for a Professional Continental " +
                    "licence for 2013. In November 2012, the team were registered as a Professional Continental team – Africa's first" +
                    " – by the Union Cycliste Internationale, for the 2013 season.\n" +
                    "\n" +
                    "The team achieved their first major win in 2013 when Gerald Ciolek won Milan-San Remo, one of the 5 Monuments of cycling. The team " +
                    "received their first Grand Tour wildcard for the 2014 Vuelta a España.\n" +
                    "\n" +
                    "In July 2014, the team announced that for the 2015 season they would be using Cervélo bikes with Brian Smith being appointed " +
                    "interim general manager. In August 2014, the team confirmed the signing of Edvald Boasson Hagen on a 2-year contract." +
                    " In September 2014 the team announced they had signed Tyler Farrar and Matthew Goss for the 2015 season.\n" +
                    "\n" +
                    "On January 14 the Amaury Sports Organisation (ASO) announced the 22 teams that would participate in the 2015 Tour de France, with " +
                    "MTN-Qhubeka making history as the first African registered team to take part. Steve Cummings brought the team their first stage" +
                    " win of the Tour, stage 14 on Mandela Day. The team's second Grand Tour stage victory came the following month at the 2015 " +
                    "Vuelta a España, where Kristian Sbaragli won a reduced bunch sprint on stage 10.\n" +
                    "\n" +
                    "In July 2015, MTN announced they would end their sponsorship of the team. Two months later, Dimension Data was announced as " +
                    "the team's new primary sponsor. The new team name would be \"Team Dimension Data riding for Quebeka\"; the change in name was " +
                    "intended to demonstrate that the team supported the Qhubeka charity rather than receiving sponsorship for them.The change came at " +
                    "the same time as rumours were circulating that Mark Cavendish and his lead-out man Mark Renshaw were about to sign with the team " +
                    "for the 2016 season. Days later the team announced Deloitte had agreed to become a major sponsor of the team; the very next" +
                    " day the signing of Cavendish and Renshaw – along with their former teammate Bernhard Eisel – was confirmed. In November 2015 " +
                    "the team announced that Rolf Aldag had been appointed as the team's Performance Manager with immediate effect, following Cavendish " +
                    "and Renshaw from Etixx-Quick Step. Later that month Roger Hammond announced that he would join the team as a sports director" +
                    " for 2016, combining the role with his current position as manager of the Madison-Genesis squad, and it was confirmed that the " +
                    "team had been granted a UCI World Tour licence for the 2016 season, becoming the first African team to enter cycling's top " +
                    "division.","mtn");
            getDatabase().saveTeam(data4);
        }
    }
}