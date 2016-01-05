package receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import service.AutoUpdateService;

public class AutoUpdateReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.d("1", "OK");
		Toast.makeText(context, "¸üÐÂÖÐ", Toast.LENGTH_SHORT).show();
		Intent i =new Intent (context, AutoUpdateService.class);
		context.startService(i);
	}

}
