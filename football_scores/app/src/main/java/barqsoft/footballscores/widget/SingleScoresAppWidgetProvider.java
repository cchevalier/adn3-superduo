package barqsoft.footballscores.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Date;

import barqsoft.footballscores.R;
import barqsoft.footballscores.Utilies;
import barqsoft.footballscores.db.DatabaseContract;

/**
 * Created by cch on 29/10/2015.
 */
public class SingleScoresAppWidgetProvider extends AppWidgetProvider {

    public static final String TAG = "WIDGET";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
//        super.onUpdate(context, appWidgetManager, appWidgetIds);

        //
        // ContentResolver.query() arguments (5)
        //
        Uri uri;

        String[] projection = {
                DatabaseContract.scores_table.HOME_COL,
                DatabaseContract.scores_table.AWAY_COL,
                DatabaseContract.scores_table.HOME_GOALS_COL,
                DatabaseContract.scores_table.AWAY_GOALS_COL,
                DatabaseContract.scores_table.MATCH_ID,
                DatabaseContract.scores_table.DATE_COL,
                DatabaseContract.scores_table.TIME_COL
        };

        final int COL_HOME = 0;
        final int COL_AWAY = 1;
        final int COL_HOME_GOALS = 2;
        final int COL_AWAY_GOALS = 3;
        final int COL_MATCH_ID = 4;
        final int COL_DATE = 5;
        final int COL_TIME = 6;

        String selection = null;
        String[] selectionArgs = {""};
        String sortOrder = null;


        //
        //  query based on match_day
        //
        uri = DatabaseContract.scores_table.buildScoreWithDate();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date tenDaysAgo = new Date(System.currentTimeMillis() - 10 * 86400000);
        Date twoDaysAgo = new Date(System.currentTimeMillis() - 3 * 86400000);
        Date yesterday  = new Date(System.currentTimeMillis() - 86400000);
        Date today      = new Date(System.currentTimeMillis());

        selectionArgs[0] = dateFormat.format(twoDaysAgo);

        sortOrder = DatabaseContract.scores_table.MATCH_ID + " DESC";

/*
        //
        // query based on league
        //
        uri = DatabaseContract.scores_table.buildScoreWithLeague();
        selectionArgs[0] = "396";
*/

        //
        // Query()
        //
        Cursor cursor = context.getContentResolver().query(
                uri,                                        // Content URI
                projection,                                 // Columns to return for each row
                selection,                                  // selection
                selectionArgs,                              // selectionArgs
                sortOrder);                                 // sortOrder

        //
        // cursor DEBUG LOG
        //
        if (cursor == null) {
            Log.d(TAG, "cursor is null.");
        } else if (cursor.getCount() < 1) {
            Log.d(TAG, "cursor is empty.");
        } else {
            Log.d(TAG, "cursor length: " + cursor.getCount());
            cursor.moveToFirst();
            do {
                Log.d(TAG, cursor.getString(COL_MATCH_ID) + ": " +
                        cursor.getString(COL_HOME) + "  " + cursor.getInt(COL_HOME_GOALS) + " - " +
                        cursor.getInt(COL_AWAY_GOALS) + "  " + cursor.getString(COL_AWAY));
                cursor.moveToNext();
            } while (!cursor.isAfterLast());
            cursor.moveToFirst();
        }






        final int count = appWidgetIds.length;
        Log.d(TAG, "onUpdate: count = " + count);

        for (int i = 0; i < count; i++) {
            Log.d(TAG, "onUpdate: i = " + i);

            int widgetId = appWidgetIds[i];

            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_single_scores);

            remoteViews.setTextViewText(R.id.widget_header, "FootballScores: " + (Integer) i);

            if (cursor != null) {

                if (!cursor.isAfterLast()) {
                    Log.d(TAG, "onUpdate: " + i + " " + cursor.getString(COL_HOME));
                    remoteViews.setTextViewText(R.id.widget_home_team, cursor.getString(COL_HOME));
                    remoteViews.setTextViewText(R.id.widget_away_team, cursor.getString(COL_AWAY));

                    if (cursor.getInt(COL_HOME_GOALS) < 0) {
                        remoteViews.setTextViewText(R.id.widget_score, cursor.getString(COL_TIME));
                    } else {
                        remoteViews.setTextViewText(R.id.widget_score,
                                Utilies.getScores(cursor.getInt(COL_HOME_GOALS), cursor.getInt(COL_AWAY_GOALS)));
                    }

                    remoteViews.setViewVisibility(R.id.widget_query_info, View.GONE);
                    cursor.moveToNext();

                } else {
                    remoteViews.setViewVisibility(R.id.widget_home_team, View.GONE);
                    remoteViews.setViewVisibility(R.id.widget_score, View.GONE);
                    remoteViews.setViewVisibility(R.id.widget_away_team, View.GONE);
                    remoteViews.setViewVisibility(R.id.widget_query_info, View.VISIBLE);
                }

            } else {
                remoteViews.setViewVisibility(R.id.widget_home_team, View.GONE);
                remoteViews.setViewVisibility(R.id.widget_score, View.GONE);
                remoteViews.setViewVisibility(R.id.widget_away_team, View.GONE);
                remoteViews.setViewVisibility(R.id.widget_query_info, View.VISIBLE);

            }

            appWidgetManager.updateAppWidget(widgetId, remoteViews);


        }

        if (null != cursor) {
            cursor.close();
        }

    }



}
