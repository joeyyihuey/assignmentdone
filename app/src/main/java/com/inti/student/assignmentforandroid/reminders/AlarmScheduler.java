package com.inti.student.assignmentforandroid.reminders;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
/**
 * Created by Teh on 29/11/2018.
 */

public class AlarmScheduler {

    /**
     * Schedule a reminder alarm at the specified time for the given task.
     *
     * @param context Local application or activity context
     * @param alarmTime Alarm start time
     * @param reminderTask Uri referencing the task in the content provider
     */
    public void scheduleAlarm(Context context, long alarmTime, Uri reminderTask) {
        //Schedule the alarm. Will update an existing item for the same task.
        AlarmManager manager = AlarmManagerProvider.getAlarmManager(context);

        PendingIntent operation =
                ReminderAlarmService.getReminderPendingIntent(context, reminderTask);

        manager.setExact(AlarmManager.RTC, alarmTime, operation);
    }
}
