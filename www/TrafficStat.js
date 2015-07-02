var exec = require('cordova/exec');

/**
*TrafficStats模块提供流量统计功能 (Android) <br/>
*直接使用xFace.TrafficStats对象来获取流量的相关信息，获取的流量是从应用启动到调用接口其间的网络流量，
* @class TrafficStats
* @platform Android
*/
var TrafficStat = function() {};

/**
* 获取2G和3G网络的网络上行流量
@example
      xFace.getMobileTraffic( function(trafficData)
      {
          alert(trafficData);
      },null);
* @method getMobileTraffic
* @param {Function} successCallback 成功回调函数
* @param {String} successCallback.trafficData 网络流量,单位为KB
* @param {Function} [errorCallback]   失败回调函数
* @platform Android
* @since 3.0.0
*/
TrafficStat.prototype.getMobileTxTraffic = function(successCallback, errorCallback){
  exec(successCallback,errorCallback, "TrafficStat", "GSMtx", []);
};

/**
* 获取2G和3G网络的网络下行流量
@example
      xFace.getMobileTraffic( function(trafficData)
      {
          alert(trafficData);
      },null);
* @method getMobileTraffic
* @param {Function} successCallback 成功回调函数
* @param {String} successCallback.trafficData 网络流量,单位为KB
* @param {Function} [errorCallback]   失败回调函数
* @platform Android
* @since 3.0.0
*/
TrafficStat.prototype.getMobileRxTraffic = function(successCallback, errorCallback){
  exec(successCallback, errorCallback, "TrafficStat", "GSMrx", []);
};

/**
* 获取Wifi网络上行流量
@example
      xFace.getWifiTraffic(
      function(trafficData)
      {
          alert(trafficData);
      },null);
* @method getWifiTraffic
* @param {Function} successCallback 成功回调函数
* @param {String} successCallback.trafficData 网络流量,单位为KB
* @param {Function} [errorCallback]   失败回调函数
* @platform Android
* @since 3.0.0
*/
TrafficStat.prototype.getTotalTxTraffic = function(successCallback, errorCallback){
  exec(successCallback, errorCallback, "TrafficStat", "Totaltx", []);
};

/**
* 获取Wifi网络下行流量
@example
      xFace.getWifiTraffic(
      function(trafficData)
      {
          alert(trafficData);
      },null);
* @method getWifiTraffic
* @param {Function} successCallback 成功回调函数
* @param {String} successCallback.trafficData 网络流量,单位为KB
* @param {Function} [errorCallback]   失败回调函数
* @platform Android
* @since 3.0.0
*/
TrafficStat.prototype.getTotalRxTraffic = function(successCallback, errorCallback){
  exec(successCallback, errorCallback, "TrafficStat", "Totalrx", []);
};


/**
* 获取Uid
@example
      xFace.getWifiTraffic(
      function(trafficData)
      {
          alert(trafficData);
      },null);
* @method getWifiTraffic
* @param {Function} successCallback 成功回调函数
* @param {String} successCallback.trafficData 网络流量,单位为KB
* @param {Function} [errorCallback]   失败回调函数
* @platform Android
* @since 3.0.0
*/
TrafficStat.prototype.getUid = function(successCallback, errorCallback){
  exec(successCallback, errorCallback, "TrafficStat", "GetUids", []);
};

module.exports = new TrafficStat();