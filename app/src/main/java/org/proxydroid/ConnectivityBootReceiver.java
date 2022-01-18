package org.proxydroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;

import org.proxydroid.utils.Utils;

public class ConnectivityBootReceiver extends BroadcastReceiver {
    private Handler mHandler = new Handler();

    public String basePath = "/data/data/org.proxydroid/";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("ConnectivityBroadcast", "onReceive: ConnectivityBootReceiver");

        //SharedPreferences settings = PreferenceManager
        //        .getDefaultSharedPreferences(context);
        //Profile mProfile = new Profile();
        //mProfile.getProfile(settings);
        //
        ////on boot run test...
        //ProxyDroidReceiver pdr = new ProxyDroidReceiver();
        //SharedPreferences.Editor ed = settings.edit();
        //ed = settings.edit();
        //ed.putString("lastSSID", "curSSID");
        //ed.commit();
        //Utils.setConnecting(true);
        //pdr.onReceive(context, intent);

        if (Utils.isConnecting()) return;

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (Utils.isWorking()) return;

                //SharedPreferences settings = PreferenceManager
                //        .getDefaultSharedPreferences(context);
                //SharedPreferences.Editor ed = settings.edit();

                ProxyDroidReceiver pdr = new ProxyDroidReceiver();
                //ed = settings.edit();
                //ed.putString("lastSSID", curSSID);
                //ed.commit();

                Utils.setConnecting(true);
                pdr.onReceive(context, intent);

                //SharedPreferences settings = PreferenceManager
                //        .getDefaultSharedPreferences(context);
                //Profile mProfile = new Profile();
                //mProfile.getProfile(settings);
                //
                //Intent it = new Intent(context, ProxyDroidService.class);
                //Bundle bundle = new Bundle();
                //bundle.putString("host", mProfile.getHost());
                //bundle.putString("user", mProfile.getUser());
                //bundle.putString("bypassAddrs", mProfile.getBypassAddrs());
                //bundle.putString("password", mProfile.getPassword());
                //bundle.putString("domain", mProfile.getDomain());
                //
                //bundle.putString("proxyType", mProfile.getProxyType());
                //bundle.putBoolean("isAutoSetProxy", mProfile.isAutoSetProxy());
                //bundle.putBoolean("isBypassApps", mProfile.isBypassApps());
                //bundle.putBoolean("isAuth", mProfile.isAuth());
                //bundle.putBoolean("isNTLM", mProfile.isNTLM());
                //bundle.putBoolean("isDNSProxy", mProfile.isDNSProxy());
                //bundle.putBoolean("isPAC", mProfile.isPAC());
                //bundle.putInt("port", mProfile.getPort());
                //
                //it.putExtras(bundle);
                //Log.d("ConnectivityBroadcast", bundle.toString());
                //
                //Utils.setConnecting(true);
                //context.startService(it);
            }
        });
    }
}
