package test.activitytest54best;

import android.Manifest;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.view.WindowManager;

/**
 * Created by sunyang on 2016/9/6.
 */
public class ForceOfflineReceiver extends BroadcastReceiver {

    @Override
    //okokokofdsfdsf
    public void onReceive(final Context context, final Intent intent) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setTitle("Waring");
        dialogBuilder.setMessage("You are offline, Please Login again!");
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ActivityCollector.finishAll();
                Intent intent1 = new Intent(context, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        AlertDialog alertDialog = dialogBuilder.create();

        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
    }
}
