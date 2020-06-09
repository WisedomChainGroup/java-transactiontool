package org.transactiontool.controller;

import com.alibaba.fastjson.JSONObject;
import org.transactiontool.ApiResult.APIResult;
import org.transactiontool.Utils.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.transactiontool.model.Node;


@Component
public class NodeController {

    @Value("${nodeNet}")
    private String ip;


    /**
     * 获取nonce
     * @param pubkeyhash
     * @return
     */
    public Object getNonce(String pubkeyhash, Node node){
        if (node == null)
            return JSONObject.parseObject(APIResult.newFailResult(5000,"Please select Node").toString());
        String url = "http://"+node.getIp()+":"+node.getPort()+"/sendNonce";
        String param = "pubkeyhash="+pubkeyhash;
        String result = HttpRequestUtil.sendPost(url,param);
        JSONObject jo = JSONObject.parseObject(result);
        return  jo;
    }

    /**
     * 通过事务哈希获取区块确认状态
     * @param txHash
     * @return
     */
    public JSONObject getTransactionConfirmed(String txHash){
        String url = "http://"+ip+"/transactionConfirmed";
        String param = "txHash="+txHash;
        String result = HttpRequestUtil.sendGet(url,param);
        JSONObject jo = JSONObject.parseObject(result);
        return jo;
    }

    /**
     * 广播事务
     * @param traninfo
     * @return
     */
    public JSONObject sendTransaction(String traninfo, Node node){
        if (node == null)
            return JSONObject.parseObject(APIResult.newFailResult(5000,"Please select Node").toString());
        String url = "http://"+node.getIp()+":"+node.getPort()+"/sendTransaction";
        String param = "traninfo="+traninfo;
        String result = HttpRequestUtil.sendPost(url,param);
        JSONObject jo = JSONObject.parseObject(result);
        return  jo;
    }
}
