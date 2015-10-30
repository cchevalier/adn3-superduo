package barqsoft.footballscores.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import java.util.Random;

import barqsoft.footballscores.R;

/**
 * Created by cch on 29/10/2015.
 */
public class SingleScoresAppWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
//        super.onUpdate(context, appWidgetManager, appWidgetIds);

        final int count = appWidgetIds.length;

        for (int i = 0; i < count; i++) {
            int widgetId = appWidgetIds[i];

            String randomNumber = String.format("%03d", (new Random().nextInt(900) + 100));

            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_single_scores);
            remoteViews.setTextViewText(R.id.widget_score, randomNumber);

            appWidgetManager.updateAppWidget(widgetId, remoteViews);
        }


    }
}
