package fi.jamk.toastsdialogsnotificationexercise;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class ShareDialogFragment extends DialogFragment {
    int notification_id = 1;

    @Override
    public Dialog onCreateDialog(Bundle savedInstantState){
        final CharSequence[] items = {"Everywhere!!!", "Nowhere, because noone cares"};
        final String[] selection = new String[1];
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Where do you want to share it?")
                .setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                selection[0] = (String)items[which];
                                break;
                            case 1:
                                selection[0] = (String)items[which];
                                break;
                            default:
                                break;
                        }
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if( selection[0] == items[0] )
                            launchNotification("Cool! Now everyone knows what are you doing!");
                        else if ( selection[0] == items[1] )
                            launchNotification("Good choice..");
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        return builder.create();

    }

    public void launchNotification(String string) {

        //create a notification
        Notification notification = new Notification.Builder(getActivity())
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setContentTitle("AmazingApp notification")
                .setContentText(string)
                .setSmallIcon(R.drawable.ic_share_black_24dp)
                .setAutoCancel(true)
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                .build();

        NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(getActivity().NOTIFICATION_SERVICE);
        notificationManager.notify(notification_id, notification);
    }
}
