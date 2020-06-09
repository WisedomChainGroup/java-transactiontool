package org.transactiontool.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.company.keystore.wallet.TxUtility;
import com.company.keystore.wallet.WalletUtility;
import org.transactiontool.ApiResult.APIResult;
import org.springframework.web.bind.annotation.*;


public class Keystore {

    public JSON fromPassword(String password) {
        JSON keystore = WalletUtility.fromPassword(password);
        APIResult result = new APIResult();
        if(keystore == null){
            result.setCode(5000);
            result.setMessage("Error");
        }else{
            result.setCode(2000);
            result.setMessage("SUCCESS");
            result.setData(keystore);
        }
        String jsonString = JSON.toJSONString(result);
        JSONObject json = JSON.parseObject(jsonString);
        return json;
    }

    public JSON verifyAddress(String address) {
        int code = WalletUtility.verifyAddress(address);
        System.out.println(address);
        System.out.println(code);
        APIResult result = new APIResult();
        if (code == 0){
            result.setCode(2000);
            result.setMessage("SUCCESS");
        }else if(code == -1){
            result.setCode(6000);
            result.setMessage("Error");
        }else if(code == -2){
            result.setCode(7000);
            result.setMessage("Error");
        }
        String jsonString = JSON.toJSONString(result);
        JSONObject json = JSON.parseObject(jsonString);
        return json;
    }


    /**
     * 调用此方法之前请先校验地址合法性！(调用verifyAddress方法)
     * @param address
     * @return
     */
    public JSON addressToPubkeyHash(@RequestParam(value = "address", required = true) String address) {
        String pubkeyHash = WalletUtility.addressToPubkeyHash(address);
        APIResult result = new APIResult();
        if(pubkeyHash == null || pubkeyHash == ""){
            result.setCode(5000);
            result.setMessage("Error");
        }else{
            result.setCode(2000);
            result.setMessage("SUCCESS");
            result.setData(pubkeyHash);
        }
        String jsonString = JSON.toJSONString(result);
        JSONObject json = JSON.parseObject(jsonString);
        return json;
    }

    public JSON keystoreToAddress(@RequestParam(value = "keystoreJson", required = true) String keystoreJson){
        String address = WalletUtility.keystoreToAddress(keystoreJson,null);
        APIResult result = new APIResult();
        if(address == null || address == ""){
            result.setCode(5000);
            result.setMessage("Error");
        }else{
            result.setCode(2000);
            result.setMessage("SUCCESS");
            result.setData(address);
        }
        String jsonString = JSON.toJSONString(result);
        JSONObject json = JSON.parseObject(jsonString);
        return json;
    }

    public JSON keystoreToPubkey(@RequestParam(value = "keystoreJson", required = true) String keystoreJson, @RequestParam(value = "password", required = true) String password) {
        String pubkey = WalletUtility.keystoreToPubkey(keystoreJson,password);
        APIResult result = new APIResult();
        if(pubkey == null || pubkey == ""){
            result.setCode(5000);
            result.setMessage("Error");
        }else{
            result.setCode(2000);
            result.setMessage("SUCCESS");
            result.setData(pubkey);
        }
        String jsonString = JSON.toJSONString(result);
        JSONObject json = JSON.parseObject(jsonString);
        return json;
    }

    public JSONObject keystoreToPubkeyHash(@RequestParam(value = "keystoreJson", required = true) String keystoreJson, @RequestParam(value = "password", required = true) String password) {
        String pubkeyHash = WalletUtility.keystoreToPubkeyHash(keystoreJson,password);
        APIResult result = new APIResult();
        if(pubkeyHash == null || pubkeyHash == ""){
            result.setCode(5000);
            result.setMessage("Error");
        }else{
            result.setCode(2000);
            result.setMessage("SUCCESS");
            result.setData(pubkeyHash);
        }
        String jsonString = JSON.toJSONString(result);
        JSONObject json = JSON.parseObject(jsonString);
        return json;
    }

    @RequestMapping(value="/obtainPrikey",method = RequestMethod.POST )
    public JSON obtainPrikey(@RequestParam(value = "keystoreJson", required = true) String keystoreJson,@RequestParam(value = "password", required = true) String password) {
        String privateKey = WalletUtility.obtainPrikey(keystoreJson,password);
        APIResult result = new APIResult();
        if(privateKey == null || privateKey == ""){
            result.setCode(5000);
            result.setMessage("Error");
        }else{
            result.setCode(2000);
            result.setMessage("SUCCESS");
            result.setData(privateKey);
        }
        String jsonString = JSON.toJSONString(result);
        JSONObject json = JSON.parseObject(jsonString);
        return json;

    }

    @RequestMapping(value="/prikeyToPubkey",method = RequestMethod.POST )
    public JSON prikeyToPubkey(@RequestParam(value = "prikey", required = true) String prikey) {
        String privateKey = WalletUtility.prikeyToPubkey(prikey);
        APIResult result = new APIResult();
        if(privateKey == null || privateKey == ""){
            result.setCode(5000);
            result.setMessage("Error");
        }else{
            result.setCode(2000);
            result.setMessage("SUCCESS");
            result.setData(privateKey);
        }
        String jsonString = JSON.toJSONString(result);
        JSONObject json = JSON.parseObject(jsonString);
        return json;
    }

    @RequestMapping(value="/pubkeyStrToPubkeyHashStr",method = RequestMethod.POST )
    public JSON pubkeyToPubkeyHash(@RequestParam(value = "pubkey", required = true) String pubkey) {
        String pubkeyHash = WalletUtility.pubkeyStrToPubkeyHashStr(pubkey);
        APIResult result = new APIResult();
        if(pubkeyHash == null || pubkeyHash == ""){
            result.setCode(5000);
            result.setMessage("Error");
        }else{
            result.setCode(2000);
            result.setMessage("SUCCESS");
            result.setData(pubkeyHash);
        }
        String jsonString = JSON.toJSONString(result);
        JSONObject json = JSON.parseObject(jsonString);
        return json;
    }
}
