package org.transactiontool.controller;

import com.alibaba.fastjson.JSONObject;
import org.transactiontool.ApiResult.APIResult;
import org.transactiontool.Utils.HttpRequestUtil;
import org.transactiontool.model.Node;


public class NodeController {


    /**
     * 获取nonce
     *
     * @param pubkeyhash
     * @return
     */
    public static Object getNonce(String pubkeyhash, Node node) {
        if (node == null)
            return JSONObject.parseObject(APIResult.newFailResult(5000, "Please select Node").toString());
        String url = "http://" + node.getIp() + ":" + node.getPort() + "/sendNonce";
        String param = "pubkeyhash=" + pubkeyhash;
        String result = HttpRequestUtil.sendPost(url, param);
        JSONObject jo = JSONObject.parseObject(result);
        return jo;
    }

    /**
     * 广播事务
     *
     * @param traninfo
     * @return
     */
    public static JSONObject sendTransaction(String traninfo, Node node) {
        if (node == null)
            return JSONObject.parseObject(APIResult.newFailResult(5000, "Please select Node").toString());
        String url = "http://" + node.getIp() + ":" + node.getPort() + "/sendTransaction";
        String param = "traninfo=" + traninfo;
        String result = HttpRequestUtil.sendPost(url, param);
        JSONObject jo = JSONObject.parseObject(result);
        return jo;
    }
}
