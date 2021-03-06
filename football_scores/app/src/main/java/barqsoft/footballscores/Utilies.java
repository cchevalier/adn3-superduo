package barqsoft.footballscores;

import android.content.res.Resources;

/**
 * Created by yehya khaled on 3/3/2015.
 */
public class Utilies
{
    public static final int BUNDESLIGA1       = 394;
    public static final int BUNDESLIGA2       = 395;
    public static final int LIGUE1            = 396;
    public static final int LIGUE2            = 397;
    public static final int PREMIER_LEAGUE    = 398;
    public static final int PRIMERA_DIVISION  = 399;
    public static final int SEGUNDA_DIVISION  = 400;
    public static final int SERIE_A           = 401;
    public static final int PRIMERA_LIGA      = 402;
    public static final int BUNDESLIGA3       = 403;
    public static final int EREDIVISIE        = 404;
    public static final int CHAMPIONS_LEAGUE  = 405;

    //public static final int SERIE_A = 357;
    //public static final int PREMIER_LEAGUE = 354;
    //public static final int CHAMPIONS_LEAGUE = 362;
    //public static final int PRIMERA_DIVISION = 358;
    //public static final int BUNDESLIGA = 351;

    public static String getLeague(Resources res, int league_num)
    {
        switch (league_num)
        {
            case BUNDESLIGA1:
                return res.getString(R.string.bundesliga_1);
            case BUNDESLIGA2:
                return res.getString(R.string.bundesliga_2);
            case BUNDESLIGA3:
                return res.getString(R.string.bundesliga_3);
            case LIGUE1:
                return res.getString(R.string.ligue_1);
            case LIGUE2:
                return res.getString(R.string.ligue_2);
            case PREMIER_LEAGUE:
                return res.getString(R.string.premier_league);
            case PRIMERA_DIVISION:
                return res.getString(R.string.primera_division);
            case SEGUNDA_DIVISION:
                return res.getString(R.string.segunda_division);
            case SERIE_A:
                return res.getString(R.string.serie_a);
            case PRIMERA_LIGA:
                return res.getString(R.string.primera_liga);
            case EREDIVISIE:
                return res.getString(R.string.eredivisie);
            case CHAMPIONS_LEAGUE:
                return res.getString(R.string.uefa_champions_league);
            default:
                return res.getString(R.string.unknown_league);
        }
    }
    public static String getMatchDay(Resources res, int match_day,int league_num)
    {
        if(league_num == CHAMPIONS_LEAGUE)
        {
            if (match_day <= 6)
            {
                return res.getString(R.string.matchday_cl_group_stage) + String.valueOf(match_day);
            }
            else if(match_day == 7 || match_day == 8)
            {
                return res.getString(R.string.matchday_cl_round_of_16);
            }
            else if(match_day == 9 || match_day == 10)
            {
                return res.getString(R.string.matchday_cl_quarter_final);
            }
            else if(match_day == 11 || match_day == 12)
            {
                return res.getString(R.string.matchday_cl_semi_final);
            }
            else
            {
                return res.getString(R.string.matchday_cl_final);
            }
        }
        else
        {
            return res.getString(R.string.matchday) + String.valueOf(match_day);
        }
    }

    public static String getScores(int home_goals,int awaygoals)
    {
        if(home_goals < 0 || awaygoals < 0)
        {
            return " - ";
        }
        else
        {
            return String.valueOf(home_goals) + " - " + String.valueOf(awaygoals);
        }
    }

    public static int getTeamCrestByTeamName (String teamname)
    {
        if (teamname==null){return R.drawable.no_icon;}
        switch (teamname)
        { //This is the set of icons that are currently in the app. Feel free to find and add more
            //as you go.
            case "Arsenal FC":
                return R.drawable.arsenal;
            case "Manchester United FC":
                return R.drawable.manchester_united;
            case "Swansea City":
                return R.drawable.swansea_city_afc;
            case "Leicester City":
                return R.drawable.leicester_city_fc_hd_logo;
            case "Everton FC":
                return R.drawable.everton_fc_logo1;
            case "West Ham United FC":
                return R.drawable.west_ham;
            case "Tottenham Hotspur FC":
                return R.drawable.tottenham_hotspur;
            case "West Bromwich Albion":
                return R.drawable.west_bromwich_albion_hd_logo;
            case "Sunderland AFC":
                return R.drawable.sunderland;
            case "Stoke City FC":
                return R.drawable.stoke_city;
            default:
                return R.drawable.no_icon;
        }
    }
}
