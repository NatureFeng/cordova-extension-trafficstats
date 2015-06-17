package com.naturefeng.cordova.plugin;

import android.net.TrafficStats;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;


/**
 * This class gets data usage from mobile.
 */
public class TrafficStat extends CordovaPlugin {
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.i("test","1");
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
        return false;
    }

    /*
     * GSM total transmit bytes 
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
     * Total Rx total bytes
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
     * Total tx total bytes
     */
    private void Totalrx(CallbackContext callbackContext) {
        Log.i("test","2");
        JSONObject mStartRX = new JSONObject();
        Log.i("test","3");
        long RX = 0;
        try{
            Log.i("test","4");
            RX = TrafficStats.getTotalRxBytes();
            Log.i("test","5");
            if(RX != TrafficStats.UNSUPPORTED){
                Log.i("test","6");
                mStartRX.put("TRXBytes", RX);
                Log.i("test","7");
                callbackContext.success(mStartRX);
            } else {
                Log.i("test","8");
                callbackContext.error("Stats Not Possible");
            }
        }
        catch(JSONException ex)
        {
            callbackContext.error("Exception");
        }
    }
}