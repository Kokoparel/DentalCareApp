package com.example.dentalcareapp.app.utils;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.example.dentalcareapp.app.R;
import com.example.dentalcareapp.app.activities.MainActivity;
import java.util.Calendar;

public class NotificationHelper {

    private static final String CHANNEL_ID = "dental_care_channel";
    private static final String CHANNEL_NAME = "Dental Care Reminders";
    private static final int MORNING_NOTIFICATION_ID = 1001;
    private static final int NIGHT_NOTIFICATION_ID = 1002;
    private static final int APPOINTMENT_NOTIFICATION_ID = 1003;

    private Context context;
    private NotificationManager notificationManager;

    public NotificationHelper(Context context) {
        this.context = context;
        notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
        createNotificationChannel();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel.setDescription("Pengingat untuk kesehatan gigi Anda");
            channel.enableVibration(true);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void showNotification(String title, String message, int notificationId) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setVibrate(new long[]{0, 500, 200, 500});

        notificationManager.notify(notificationId, builder.build());
    }

    public void scheduleMorningReminder() {
        scheduleNotification(7, 0, MORNING_NOTIFICATION_ID,
                "Sikat Gigi Pagi", "Waktunya sikat gigi pagi! 🌅🦷");
    }

    public void scheduleNightReminder() {
        scheduleNotification(21, 0, NIGHT_NOTIFICATION_ID,
                "Sikat Gigi Malam", "Jangan lupa sikat gigi sebelum tidur! 🌙🦷");
    }

    private void scheduleNotification(int hour, int minute, int requestCode,
                                      String title, String message) {
        AlarmManager alarmManager = (AlarmManager)
                context.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(context, NotificationReceiver.class);
        intent.putExtra("title", title);
        intent.putExtra("message", message);
        intent.putExtra("notificationId", requestCode);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context,
                requestCode,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);

        // If the time has passed today, schedule for tomorrow
        if (calendar.getTimeInMillis() < System.currentTimeMillis()) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        if (alarmManager != null) {
            alarmManager.setRepeating(
                    AlarmManager.RTC_WAKEUP,
                    calendar.getTimeInMillis(),
                    AlarmManager.INTERVAL_DAY,
                    pendingIntent
            );
        }
    }

    public void scheduleAppointmentReminder(String dentistName, String date, String time) {
        String message = "Appointment dengan " + dentistName + " pada " + time;
        showNotification("Pengingat Appointment", message, APPOINTMENT_NOTIFICATION_ID);
    }

    public void cancelAllNotifications() {
        notificationManager.cancelAll();
    }
}