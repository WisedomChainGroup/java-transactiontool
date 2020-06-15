package org.transactiontool.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.company.keystore.wallet.TxUtility;
import com.company.keystore.wallet.WalletUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.transactiontool.ApiResult.APIResult;
import org.transactiontool.controller.NodeController;
import org.transactiontool.model.Node;
import org.transactiontool.pool.NoncePool;
import org.transactiontool.pool.NonceState;
import org.transactiontool.service.TxService;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@Service
public class TxServiceImpl implements TxService {

    @Autowired
    NoncePool noncePool;

    @Autowired
    NodeController nodeController;

    @Override
    public Object ClientToTransferAccount(String fromPubkey, String toPubkeyHash, BigDecimal amount, String prikey, boolean isSend, Node node) {
        try {
            GetNownonce getNownonce = new GetNownonce(fromPubkey, node).invoke();
            if (getNownonce.is()) return getNownonce.getApiResult();
            long nownonce = getNownonce.getNownonce();
            String address = getNownonce.getAddress();
            JSONObject data = TxUtility.ClientToTransferAccount(fromPubkey, toPubkeyHash, amount, prikey, nownonce);
            UpdateNonce updateNonce = new UpdateNonce(nownonce, address, data).invoke();
            if (updateNonce.is()) return APIResult.newFailResult(5000, "Failed to construct transaction");
            if (isSend) {
                return transactionResult(data, node);
            }
            return data;
        } catch (Exception e) {
            APIResult result = new APIResult();
            result.setCode(5000);
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Object ClientToTransferVote(String fromPubkey, String toPubkeyHash, BigDecimal amount, String prikey, boolean isSend, Node node) {
        try {
            GetNownonce getNownonce = new GetNownonce(fromPubkey, node).invoke();
            if (getNownonce.is()) return getNownonce.getApiResult();
            long nownonce = getNownonce.getNownonce();
            String address = getNownonce.getAddress();
            JSONObject data = TxUtility.ClientToTransferVote(fromPubkey, toPubkeyHash, amount, nownonce, prikey);
            UpdateNonce updateNonce = new UpdateNonce(nownonce, address, data).invoke();
            if (updateNonce.is()) return APIResult.newFailResult(5000, "Failed to construct transaction");
            if (isSend) {
                return transactionResult(data, node);
            }
            return data;
        } catch (Exception e) {
            APIResult result = new APIResult();
            result.setCode(5000);
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Object ClientToTransferVoteWithdraw(String fromPubkey, String toPubkeyHash, BigDecimal amount, String prikey, String txid, boolean isSend, Node node) {
        try {
            GetNownonce getNownonce = new GetNownonce(fromPubkey, node).invoke();
            if (getNownonce.is()) return getNownonce.getApiResult();
            long nownonce = getNownonce.getNownonce();
            String address = getNownonce.getAddress();
            JSONObject data = TxUtility.ClientToTransferVoteWithdraw(fromPubkey, toPubkeyHash, amount, nownonce, prikey, txid);
            UpdateNonce updateNonce = new UpdateNonce(nownonce, address, data).invoke();
            if (updateNonce.is()) return APIResult.newFailResult(5000, "Failed to construct transaction");
            if (isSend) {
                return transactionResult(data, node);
            }
            return data;
        } catch (Exception e) {
            APIResult result = new APIResult();
            result.setCode(5000);
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Object ClientToTransferMortgage(String fromPubkey, String toPubkeyHash, BigDecimal amount, String prikey, boolean isSend, Node node) {
        try {
            GetNownonce getNownonce = new GetNownonce(fromPubkey, node).invoke();
            if (getNownonce.is()) return getNownonce.getApiResult();
            long nownonce = getNownonce.getNownonce();
            String address = getNownonce.getAddress();
            JSONObject data = TxUtility.ClientToTransferMortgage(fromPubkey, toPubkeyHash, amount, nownonce, prikey);
            UpdateNonce updateNonce = new UpdateNonce(nownonce, address, data).invoke();
            if (updateNonce.is()) return APIResult.newFailResult(5000, "Failed to construct transaction");
            if (isSend) {
                return transactionResult(data, node);
            }
            return data;
        } catch (Exception e) {
            APIResult result = new APIResult();
            result.setCode(5000);
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Object ClientToTransferMortgageWithdraw(String fromPubkey, String toPubkeyHash, BigDecimal amount, String prikey, String txid, boolean isSend, Node node) {
        try {
            GetNownonce getNownonce = new GetNownonce(fromPubkey, node).invoke();
            if (getNownonce.is()) return getNownonce.getApiResult();
            long nownonce = getNownonce.getNownonce();
            String address = getNownonce.getAddress();
            JSONObject data = TxUtility.ClientToTransferMortgageWithdraw(fromPubkey, toPubkeyHash, amount, nownonce, txid, prikey);
            UpdateNonce updateNonce = new UpdateNonce(nownonce, address, data).invoke();
            if (updateNonce.is()) return APIResult.newFailResult(5000, "Failed to construct transaction");
            if (isSend) {
                return transactionResult(data, node);
            }
            return data;
        } catch (Exception e) {
            APIResult result = new APIResult();
            result.setCode(5000);
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Object ClientToTransferProve(String fromPubkey, String prikey, String payloadStr, boolean isSend, Node node) {
        try {
            GetNownonce getNownonce = new GetNownonce(fromPubkey, node).invoke();
            if (getNownonce.is()) return getNownonce.getApiResult();
            long nownonce = getNownonce.getNownonce();
            String address = getNownonce.getAddress();
            JSONObject data = TxUtility.ClientToTransferProve(fromPubkey, nownonce, payloadStr.getBytes(StandardCharsets.UTF_8), prikey);
            UpdateNonce updateNonce = new UpdateNonce(nownonce, address, data).invoke();
            if (updateNonce.is()) return APIResult.newFailResult(5000, "Failed to construct transaction");
            if (isSend) {
                return transactionResult(data, node);
            }
            return data;
        } catch (Exception e) {
            APIResult result = new APIResult();
            result.setCode(5000);
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Object CreateSignToDeployforRuleAsset(String fromPubkey, String prikey, String code, BigDecimal offering, String createuser, String owner, int allowincrease, String info, boolean isSend, Node node) {
        try {
            GetNownonce getNownonce = new GetNownonce(fromPubkey, node).invoke();
            if (getNownonce.is()) return getNownonce.getApiResult();
            long nownonce = getNownonce.getNownonce();
            String address = getNownonce.getAddress();
            JSONObject data = TxUtility.CreateSignToDeployforRuleAsset(fromPubkey, prikey, nownonce, code, offering, createuser, owner, allowincrease, info);
            UpdateNonce updateNonce = new UpdateNonce(nownonce, address, data).invoke();
            if (updateNonce.is()) return APIResult.newFailResult(5000, "Failed to construct transaction");
            if (isSend) {
                return transactionResult(data, node);
            }
            return data;
        } catch (Exception e) {
            APIResult result = new APIResult();
            result.setCode(5000);
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Object CreateSignToDeployforAssetChangeowner(String fromPubkey, String txHash, String prikey, String newowner, boolean isSend, Node node) {
        try {
            GetNownonce getNownonce = new GetNownonce(fromPubkey, node).invoke();
            if (getNownonce.is()) return getNownonce.getApiResult();
            long nownonce = getNownonce.getNownonce();
            String address = getNownonce.getAddress();
            JSONObject data = TxUtility.CreateSignToDeployforAssetChangeowner(fromPubkey, txHash, prikey, nownonce, newowner);
            UpdateNonce updateNonce = new UpdateNonce(nownonce, address, data).invoke();
            if (updateNonce.is()) return APIResult.newFailResult(5000, "Failed to construct transaction");
            if (isSend) {
                return transactionResult(data, node);
            }
            return data;
        } catch (Exception e) {
            APIResult result = new APIResult();
            result.setCode(5000);
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Object CreateSignToDeployforRuleAssetIncreased(String fromPubkey, String txHash, String prikey, BigDecimal amount, boolean isSend, Node node) {
        try {
            GetNownonce getNownonce = new GetNownonce(fromPubkey, node).invoke();
            if (getNownonce.is()) return getNownonce.getApiResult();
            long nownonce = getNownonce.getNownonce();
            String address = getNownonce.getAddress();
            JSONObject data = TxUtility.CreateSignToDeployforRuleAssetIncreased(fromPubkey, txHash, prikey, nownonce, amount);
            UpdateNonce updateNonce = new UpdateNonce(nownonce, address, data).invoke();
            if (updateNonce.is()) return APIResult.newFailResult(5000, "Failed to construct transaction");
            if (isSend) {
                return transactionResult(data, node);
            }
            return data;
        } catch (Exception e) {
            APIResult result = new APIResult();
            result.setCode(5000);
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Object CreateSignToDeployforRuleTransfer(String fromPubkey, String txHash, String prikey, String from, String to, BigDecimal value, boolean isSend, Node node) {
        try {
            GetNownonce getNownonce = new GetNownonce(fromPubkey, node).invoke();
            if (getNownonce.is()) return getNownonce.getApiResult();
            long nownonce = getNownonce.getNownonce();
            String address = getNownonce.getAddress();
            JSONObject data = TxUtility.CreateSignToDeployforRuleTransfer(fromPubkey, txHash, prikey, nownonce, from, to, value);
            UpdateNonce updateNonce = new UpdateNonce(nownonce, address, data).invoke();
            if (updateNonce.is()) return APIResult.newFailResult(5000, "Failed to construct transaction");
            if (isSend) {
                return transactionResult(data, node);
            }
            return data;
        } catch (Exception e) {
            APIResult result = new APIResult();
            result.setCode(5000);
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Object CreateHashTimeBlockForDeploy(String fromPubkey, String prikey, String assetHash, String pubkeyHash, boolean isSend, Node node) {
        try {
            GetNownonce getNownonce = new GetNownonce(fromPubkey, node).invoke();
            if (getNownonce.is()) return getNownonce.getApiResult();
            long nownonce = getNownonce.getNownonce();
            String address = getNownonce.getAddress();
            JSONObject data = TxUtility.CreateHashTimeBlockForDeploy(fromPubkey, prikey, nownonce, assetHash, pubkeyHash);
            UpdateNonce updateNonce = new UpdateNonce(nownonce, address, data).invoke();
            if (updateNonce.is()) return APIResult.newFailResult(5000, "Failed to construct transaction");
            if (isSend) {
                return transactionResult(data, node);
            }
            return data;
        } catch (Exception e) {
            APIResult result = new APIResult();
            result.setCode(5000);
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Object CreateHashTimeBlockGetForDeploy(String fromPubkey, String prikey, String txGetHash, String transferhash, String origintext, boolean isSend, Node node) {
        try {
            GetNownonce getNownonce = new GetNownonce(fromPubkey, node).invoke();
            if (getNownonce.is()) return getNownonce.getApiResult();
            long nownonce = getNownonce.getNownonce();
            String address = getNownonce.getAddress();
            JSONObject data = TxUtility.CreateHashTimeBlockGetForDeploy(fromPubkey, prikey, txGetHash, nownonce, transferhash, origintext);
            UpdateNonce updateNonce = new UpdateNonce(nownonce, address, data).invoke();
            if (updateNonce.is()) return APIResult.newFailResult(5000, "Failed to construct transaction");
            if (isSend) {
                return transactionResult(data, node);
            }
            return data;
        } catch (Exception e) {
            APIResult result = new APIResult();
            result.setCode(5000);
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Object CreateHashTimeBlockTransferForDeploy(String fromPubkey, String prikey, String txGetHash, BigDecimal value, String hashresult, BigDecimal timestamp, boolean isSend, Node node) {
        try {
            GetNownonce getNownonce = new GetNownonce(fromPubkey, node).invoke();
            if (getNownonce.is()) return getNownonce.getApiResult();
            long nownonce = getNownonce.getNownonce();
            String address = getNownonce.getAddress();
            JSONObject data = TxUtility.CreateHashTimeBlockTransferForDeploy(fromPubkey, prikey, txGetHash, nownonce, value, hashresult, timestamp);
            UpdateNonce updateNonce = new UpdateNonce(nownonce, address, data).invoke();
            if (updateNonce.is()) return APIResult.newFailResult(5000, "Failed to construct transaction");
            if (isSend) {
                return transactionResult(data, node);
            }
            return data;
        } catch (Exception e) {
            APIResult result = new APIResult();
            result.setCode(5000);
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Object CreateHashHeightBlockForDeploy(String fromPubkey, String prikey, String assetHash, String pubkeyHash, boolean isSend, Node node) {
        try {
            GetNownonce getNownonce = new GetNownonce(fromPubkey, node).invoke();
            if (getNownonce.is()) return getNownonce.getApiResult();
            long nownonce = getNownonce.getNownonce();
            String address = getNownonce.getAddress();
            JSONObject data = TxUtility.CreateHashHeightBlockForDeploy(fromPubkey, prikey, nownonce, assetHash, pubkeyHash);
            UpdateNonce updateNonce = new UpdateNonce(nownonce, address, data).invoke();
            if (updateNonce.is()) return APIResult.newFailResult(5000, "Failed to construct transaction");
            if (isSend) {
                return transactionResult(data, node);
            }
            return data;
        } catch (Exception e) {
            APIResult result = new APIResult();
            result.setCode(5000);
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Object CreateHashHeightBlockGetForDeploy(String fromPubkey, String prikey, String txGetHash, String transferhash, String origintext, boolean isSend, Node node) {
        try {
            GetNownonce getNownonce = new GetNownonce(fromPubkey, node).invoke();
            if (getNownonce.is()) return getNownonce.getApiResult();
            long nownonce = getNownonce.getNownonce();
            String address = getNownonce.getAddress();
            JSONObject data = TxUtility.CreateHashHeightBlockGetForDeploy(fromPubkey, prikey, txGetHash, nownonce, transferhash, origintext);
            UpdateNonce updateNonce = new UpdateNonce(nownonce, address, data).invoke();
            if (updateNonce.is()) return APIResult.newFailResult(5000, "Failed to construct transaction");
            if (isSend) {
                return transactionResult(data, node);
            }
            return data;
        } catch (Exception e) {
            APIResult result = new APIResult();
            result.setCode(5000);
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Object CreateHashHeightBlockTransferForDeploy(String fromPubkey, String prikey, String txGetHash, BigDecimal value, String hashresult, BigDecimal blockheight, boolean isSend, Node node) {
        try {
            GetNownonce getNownonce = new GetNownonce(fromPubkey, node).invoke();
            if (getNownonce.is()) return getNownonce.getApiResult();
            long nownonce = getNownonce.getNownonce();
            String address = getNownonce.getAddress();
            JSONObject data = TxUtility.CreateHashHeightBlockTransferForDeploy(fromPubkey, prikey, txGetHash, nownonce, value, hashresult, blockheight);
            UpdateNonce updateNonce = new UpdateNonce(nownonce, address, data).invoke();
            if (updateNonce.is()) return APIResult.newFailResult(5000, "Failed to construct transaction");
            if (isSend) {
                return transactionResult(data, node);
            }
            return data;
        } catch (Exception e) {
            APIResult result = new APIResult();
            result.setCode(5000);
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Object CreateRateheightlockruleForDeploy(String fromPubkey, String prikey, String assetHash, BigDecimal onetimedepositmultiple, int withdrawperiodheight, String withdrawrate, String dest, boolean isSend, Node node) {
        try {
            GetNownonce getNownonce = new GetNownonce(fromPubkey, node).invoke();
            if (getNownonce.is()) return getNownonce.getApiResult();
            long nownonce = getNownonce.getNownonce();
            String address = getNownonce.getAddress();
            JSONObject data = TxUtility.CreateRateheightlockruleForDeploy(fromPubkey, prikey, nownonce, assetHash, onetimedepositmultiple, withdrawperiodheight, withdrawrate, dest);
            UpdateNonce updateNonce = new UpdateNonce(nownonce, address, data).invoke();
            if (updateNonce.is()) return APIResult.newFailResult(5000, "Failed to construct transaction");
            if (isSend) {
                return transactionResult(data, node);
            }
            return data;
        } catch (Exception e) {
            APIResult result = new APIResult();
            result.setCode(5000);
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Object CreateRateheightlockDepositRuleForDeploy(String fromPubkey, String prikey, String txHashCreate, BigDecimal value, boolean isSend, Node node) {
        try {
            GetNownonce getNownonce = new GetNownonce(fromPubkey, node).invoke();
            if (getNownonce.is()) return getNownonce.getApiResult();
            long nownonce = getNownonce.getNownonce();
            String address = getNownonce.getAddress();
            JSONObject data = TxUtility.CreateRateheightlockDepositRuleForDeploy(fromPubkey, prikey, txHashCreate, nownonce, value);
            UpdateNonce updateNonce = new UpdateNonce(nownonce, address, data).invoke();
            if (updateNonce.is()) return APIResult.newFailResult(5000, "Failed to construct transaction");
            if (isSend) {
                return transactionResult(data, node);
            }
            return data;
        } catch (Exception e) {
            APIResult result = new APIResult();
            result.setCode(5000);
            result.setMessage(e.getMessage());
            return result;
        }
    }

    @Override
    public Object CreateRateheightlockWithdrawRuleForDeploy(String fromPubkey, String txHashCreate, String prikey, String deposithash, String to, boolean isSend, Node node) {
        try {
            GetNownonce getNownonce = new GetNownonce(fromPubkey, node).invoke();
            if (getNownonce.is()) return getNownonce.getApiResult();
            long nownonce = getNownonce.getNownonce();
            String address = getNownonce.getAddress();
            JSONObject data = TxUtility.CreateRateheightlockWithdrawRuleForDeploy(fromPubkey,txHashCreate, prikey, nownonce,deposithash, to);
            UpdateNonce updateNonce = new UpdateNonce(nownonce, address, data).invoke();
            if (updateNonce.is()) return APIResult.newFailResult(5000, "Failed to construct transaction");
            if (isSend) {
                return transactionResult(data, node);
            }
            return data;
        } catch (Exception e) {
            APIResult result = new APIResult();
            result.setCode(5000);
            result.setMessage(e.getMessage());
            return result;
        }
    }

    private Object transactionResult(JSONObject data, Node node) throws IOException {
        if ((int) data.get("statusCode") == 5000) {
            APIResult result = new APIResult();
            result.setCode(5000);
            result.setMessage("Error:" + data.get("message"));
            return result;
        } else {
            String texhash = (String) (data).get("data");
            String transaction = (String) (data).get("message");
            JSONObject result = nodeController.sendTransaction(transaction, node);
            return result;
        }
    }

    private Object getNonce(String fromPubkey, Node node) throws InvocationTargetException, IntrospectionException, InstantiationException, IllegalAccessException, IOException {
        //address 放入Message返回
        long nownonce = 0;
        String frompubhash = WalletUtility.pubkeyStrToPubkeyHashStr(fromPubkey);
        String address = WalletUtility.pubkeyHashToAddress(frompubhash, 1);
        long maxnonce = noncePool.getMaxNonce(address);
        if (maxnonce == 0) {
            //rpc获取nonce
            APIResult apiResult = JSON.toJavaObject((JSONObject) nodeController.getNonce(frompubhash, node), APIResult.class);
            apiResult.setMessage(address);
            return apiResult;
        } else {
            APIResult apiResult = new APIResult();
            apiResult.setCode(2000);
            apiResult.setData(maxnonce);
            apiResult.setMessage(address);
            return apiResult;
        }
    }

    private class GetNownonce {
        private boolean myResult;
        private String fromPubkey;
        private long nownonce;
        private String address;
        private APIResult apiResult;
        private Node node;

        public GetNownonce(String fromPubkey, Node node) {
            this.fromPubkey = fromPubkey;
            this.node = node;
        }

        boolean is() {
            return myResult;
        }

        public long getNownonce() {
            return nownonce;
        }

        public String getAddress() {
            return address;
        }

        public APIResult getApiResult() {
            return apiResult;
        }

        public GetNownonce invoke() throws IOException, IntrospectionException, InstantiationException, IllegalAccessException, InvocationTargetException {
            nownonce = 0;
            address = "";
            apiResult = (APIResult) getNonce(fromPubkey, node);
            if (apiResult.getCode() == 5000) {
                myResult = true;
                return this;
            } else if (apiResult.getCode() == 2000) {
                nownonce = Long.valueOf(apiResult.getData().toString());
                address = apiResult.getMessage();
            }
            myResult = false;
            return this;
        }
    }

    private class UpdateNonce {
        private boolean myResult;
        private long nownonce;
        private String address;
        private JSONObject data;

        public UpdateNonce(long nownonce, String address, JSONObject data) {
            this.nownonce = nownonce;
            this.address = address;
            this.data = data;
        }

        boolean is() {
            return myResult;
        }

        public long getNownonce() {
            return nownonce;
        }

        public UpdateNonce invoke() throws IOException, IntrospectionException, InstantiationException, IllegalAccessException, InvocationTargetException {
            String txhash = (String) (data).get("data");
            if ((int) data.get("code") == 2000) {
                nownonce++;
                NonceState nonceState = new NonceState(txhash, nownonce, new Date().getTime());
                noncePool.add(address, nonceState);
            } else {
                myResult = true;
                return this;
            }
            myResult = false;
            return this;
        }
    }
}
