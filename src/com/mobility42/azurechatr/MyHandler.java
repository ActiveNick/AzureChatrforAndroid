package com.mobility42.azurechatr;

import com.microsoft.windowsazure.notifications.NotificationsHandler;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

public class MyHandler extends NotificationsHandler {

	public static final String DISPLAY_MESSAGE_ACTION = "displaymessage";
	public static final String EXTRA_MESSAGE = "message";
	public static final String EXTRA_USERNAME = "username";
	public static final int NOTIFICATION_ID = 1;
	private NotificationManager mNotificationManager;
	NotificationCompat.Builder builder;
	Context ctx;

	@Override
	public void onReceive(Context context, Bundle bundle) {
	    ctx = context;
	    String nhMessage = bundle.getString("message");
	    String nhUsername = bundle.getString("username");

	    sendNotification(nhUsername + " - " + nhMessage);
	    displayMessage(context, nhMessage, nhUsername);
	}

	private void sendNotification(String msg) {
	    mNotificationManager = (NotificationManager)
	              ctx.getSystemService(Context.NOTIFICATION_SERVICE);

	    PendingIntent contentIntent = PendingIntent.getActivity(ctx, 0,
	          new Intent(ctx, ChatActivity.class), 0);

	    NotificationCompat.Builder mBuilder =
	          new NotificationCompat.Builder(ctx)
	          .setSmallIcon(R.drawable.ic_launcher)
	          .setContentTitle("AzureChatr for Android")
	          .setStyle(new NotificationCompat.BigTextStyle()
	                     .bigText(msg))
	          .setContentText(msg);

	     mBuilder.setContentIntent(contentIntent);
	     mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
	}
	
	static void displayMessage(Context context, String message, String username) {
	    Intent intent = new Intent(DISPLAY_MESSAGE_ACTION);
	    intent.putExtra(EXTRA_MESSAGE, message);
	    intent.putExtra(EXTRA_USERNAME, username);
	    context.sendBroadcast(intent);
	}
}
