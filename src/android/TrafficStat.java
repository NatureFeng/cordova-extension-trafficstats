package com.naturefeng.cordova.plugin;

import android.net.TrafficStats;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;


/**
 * This class gets data usage from mobile.
 */
public class TrafficStat extends CordovaPlugin {
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("GSMtx")) { 
            this.GSMtx(callbackContext);
            return true;
        }
        else if(action.equals("GSMrx")) {
            this.GSMrx(callbackContext);
            return true;
        }
        else if(action.equals("Totaltx")){
            this.Totaltx(callbackContext);
            return true;
        }
        else if(action.equals("Totalrx")) {
            this.Totalrx(callbackContext);
            return true;
        }
        else if(action.equals("GetUids")) {
            this.GetUids(callbackContext);
            return true;
        }
        return false;
    }

    /*
     * GSM Tx total bytes 
     */
    private void GSMtx(CallbackContext callbackContext) {
        JSONObject mStartTX = new JSONObject();
        long TX = 0;
        try{
            TX = TrafficStats.getMobileTxBytes();
            if(TX != TrafficStats.UNSUPPORTED){
                mStartTX.put("TXBytes", TX);
                callbackContext.success(mStartTX);
            } else {
                callbackContext.error("Stats Not Possible");
            }
        }
        catch(JSONException ex)
        {
            
            callbackContext.error("Exception");
        }
    }
    
    /*
     * GSM Rx total bytes
     */
    private void GSMrx(CallbackContext callbackContext) {
        JSONObject mStartRX = new JSONObject();
        long RX = 0;
        try{
            RX = TrafficStats.getMobileRxBytes();
            if(RX != TrafficStats.UNSUPPORTED){
                mStartRX.put("RXBytes", RX);
                callbackContext.success(mStartRX);
            } else {
                callbackContext.error("Stats Not Possible");
            }
        }
        catch(JSONException ex)
        {
            callbackContext.error("Exception");
        }
    }

    
    /*
     * Total Tx total bytes
     */
    private void Totaltx(CallbackContext callbackContext) {
        JSONObject mStartTX = new JSONObject();
        long TX = 0;
        try{
            TX = TrafficStats.getTotalTxBytes();
            if(TX != TrafficStats.UNSUPPORTED){
                mStartTX.put("TTXBytes", TX);
                callbackContext.success(mStartTX);
            } else {
                callbackContext.error("Stats Not Possible");
            }
        }
        catch(JSONException ex)
        {
            callbackContext.error("Exception");
        }
    }
    
    /*
     * Total Rx total bytes
     */
    private void Totalrx(CallbackContext callbackContext) {
        JSONObject mStartRX = new JSONObject();
        long RX = 0;
        try{
            RX = TrafficStats.getTotalRxBytes();
            if(RX != TrafficStats.UNSUPPORTED){
                mStartRX.put("TRXBytes", RX);
                callbackContext.success(mStartRX);
            } else {
                callbackContext.error("Stats Not Possible");
            }
        }
        catch(JSONException ex)
        {
            callbackContext.error("Exception");
        }
    }

    private void GetUids(CallbackContext callbackContext) {
        String uidList = "";
        PackageManager pm = this.cordova.getActivity().getPackageManager();
        List<PackageInfo> packinfos = pm
                .getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES
                        | PackageManager.GET_PERMISSIONS);
        for (PackageInfo info : packinfos) {
            String[] premissions = info.requestedPermissions;
            if (premissions != null && premissions.length > 0) {
                for (String premission : premissions) {
                    if ("android.permission.INTERNET".equals(premission)) {
                        int uid = info.applicationInfo.uid;
                        long RX = 0;
                        RX = TrafficStats.getUidRxBytes(uid);
                        uidList = uidList + info.applicationInfo.loadLabel(pm).toString() + "." + uid + "." + RX + ";";
                    }
                }
            }
        }
        callbackContext.success(uidList);
    }

}