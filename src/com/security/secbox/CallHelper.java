package com.security.secbox;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Gravity;
import android.widget.Toast;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * 
 * @author Giovanny Andres Gongora - SecBox
 *
 */

public class CallHelper {
	//Here we add all the phone numbers. Yes, this is incredible stupid but it is just a first version.
	private String number_libardo = "3015516541";
	private String numero_ivan = "3164088309";
	private String tester1 = "3187261504";
	private String tester2 = "3108899429";
	private String tester3 = "3182457875";
	private String tester4 = "3214066065";
	private String tester5 = "3133101011";
	private String casa = "0382663073";

	private class CallStateListener extends PhoneStateListener {
		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			switch (state) {
			case TelephonyManager.CALL_STATE_RINGING:
				// called when someone is ringing to this phone
				if (number_libardo.equals(incomingNumber)) {					
					final Toast toast = Toast.makeText(ctx,"\n\n¡Numero Verificado!"+ "\nEste llamada proviene de una entidad confiable.", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					LinearLayout toastView = (LinearLayout) toast.getView();
					ImageView imageCodeProject = new ImageView(ctx);
					imageCodeProject.setImageResource(R.drawable.verificado);
					toastView.addView(imageCodeProject, 0);
					new CountDownTimer(9000, 1000) {
					    public void onTick(long millisUntilFinished) {toast.show();}
					    public void onFinish() {toast.show();}
					}.start();
				} else if (numero_ivan.equals(incomingNumber)){
					final Toast toast = Toast.makeText(ctx,"\n\n¡Numero Verificado!"+ "\nEste llamada proviene de una entidad confiable.", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					LinearLayout toastView = (LinearLayout) toast.getView();
					ImageView imageCodeProject = new ImageView(ctx);
					imageCodeProject.setImageResource(R.drawable.verificado);
					toastView.addView(imageCodeProject, 0);
					new CountDownTimer(9000, 1000) {
					    public void onTick(long millisUntilFinished) {toast.show();}
					    public void onFinish() {toast.show();}
					}.start();
				} else if (tester1.equals(incomingNumber)) {
					final Toast toast = Toast.makeText(ctx,"\n\n¡Ten cuidado!"+ "\nEl numero de esta llamada esta reportado como fraudulento.", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					LinearLayout toastView = (LinearLayout) toast.getView();
					ImageView imageCodeProject = new ImageView(ctx);
					imageCodeProject.setImageResource(R.drawable.error);
					toastView.addView(imageCodeProject, 0);
					new CountDownTimer(9000, 1000) {
					    public void onTick(long millisUntilFinished) {toast.show();}
					    public void onFinish() {toast.show();}
					}.start();
				} else if (tester2.equals(incomingNumber)) {
					final Toast toast = Toast.makeText(ctx,"\n\n¡Imposible verificar!"+ "\nEsta llamada puede ser motivo de una estafa.", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					LinearLayout toastView = (LinearLayout) toast.getView();
					ImageView imageCodeProject = new ImageView(ctx);
					imageCodeProject.setImageResource(R.drawable.warning);
					toastView.addView(imageCodeProject, 0);
					new CountDownTimer(9000, 1000) {
					    public void onTick(long millisUntilFinished) {toast.show();}
					    public void onFinish() {toast.show();}
					}.start();
				} else if (tester3.equals(incomingNumber)) {
					final Toast toast = Toast.makeText(ctx,"\n\n¡Imposible verificar!"+ "\nEsta llamada puede ser motivo de una estafa.", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					LinearLayout toastView = (LinearLayout) toast.getView();
					ImageView imageCodeProject = new ImageView(ctx);
					imageCodeProject.setImageResource(R.drawable.warning);
					toastView.addView(imageCodeProject, 0);
					new CountDownTimer(9000, 1000) {
					    public void onTick(long millisUntilFinished) {toast.show();}
					    public void onFinish() {toast.show();}
					}.start();
				} else if (tester4.equals(incomingNumber)) {
					final Toast toast = Toast.makeText(ctx,"\n\n¡Imposible verificar!"+ "\nEsta llamada puede ser motivo de una estafa.", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					LinearLayout toastView = (LinearLayout) toast.getView();
					ImageView imageCodeProject = new ImageView(ctx);
					imageCodeProject.setImageResource(R.drawable.verificado);
					toastView.addView(imageCodeProject, 0);
					new CountDownTimer(9000, 1000) {
					    public void onTick(long millisUntilFinished) {toast.show();}
					    public void onFinish() {toast.show();}
					}.start();
				} else if (tester5.equals(incomingNumber)) {
					final Toast toast = Toast.makeText(ctx,"\n\n¡Numero Verificado!"+ "\nEste llamada proviene de una entidad confiable.", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					LinearLayout toastView = (LinearLayout) toast.getView();
					ImageView imageCodeProject = new ImageView(ctx);
					imageCodeProject.setImageResource(R.drawable.verificado);
					toastView.addView(imageCodeProject, 0);
					new CountDownTimer(9000, 1000) {
					    public void onTick(long millisUntilFinished) {toast.show();}
					    public void onFinish() {toast.show();}
					}.start();
				}
				break;
			}
		}
	}
	
	public class OutgoingReceiver extends BroadcastReceiver {
	    public OutgoingReceiver() {
	    }

	    @Override
	    public void onReceive(Context context, Intent intent) {
	        String number = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
	        //TODO: We need to do this in a better way. We can manage every number on a if and else.
	        if (casa.equals(number)) {
	        	Toast.makeText(ctx, 
		        		"Llamada segura - Outgoing: "+number, 
		        		Toast.LENGTH_LONG).show();
	        }
	        
	    }
  
	}

	private Context ctx;
	private TelephonyManager tm;
	private CallStateListener callStateListener;
	private OutgoingReceiver outgoingReceiver;

	public CallHelper(Context ctx) {
		this.ctx = ctx;
		
		callStateListener = new CallStateListener();
		outgoingReceiver = new OutgoingReceiver();
	}
	
	/**
	 * Start calls detection.
	 */
	public void start() {
		tm = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);
		tm.listen(callStateListener, PhoneStateListener.LISTEN_CALL_STATE);
		
		IntentFilter intentFilter = new IntentFilter(Intent.ACTION_NEW_OUTGOING_CALL);
		ctx.registerReceiver(outgoingReceiver, intentFilter);
	}
	
	/**
	 * Stop calls detection.
	 */
	public void stop() {
		tm.listen(callStateListener, PhoneStateListener.LISTEN_NONE);
		ctx.unregisterReceiver(outgoingReceiver);
	}

}
