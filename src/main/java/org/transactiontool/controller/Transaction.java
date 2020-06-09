package org.transactiontool.controller;


import com.company.keystore.wallet.WalletUtility;
import org.springframework.stereotype.Component;
import org.transactiontool.ApiResult.APIResult;
import org.transactiontool.model.Node;
import org.transactiontool.pool.NoncePool;
import org.transactiontool.pool.NonceState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.transactiontool.service.TxService;

import java.math.BigDecimal;
import java.util.*;

@Component
public class Transaction {

    @Autowired
    NoncePool noncePool;

    @Autowired
    private TxService txService;

    private Node node;

    @Autowired
    public void setNode(Node node) {
        this.node = node;
    }


    public Object ClientToTransferAccount(String fromPubkey, String toPubkeyHash, BigDecimal amount, String prikey, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return txService.ClientToTransferAccount(fromPubkey, toPubkeyHash, amount, prikey, isSend, node);
    }

    public Object ClientToTransferVote(String fromPubkey, String toPubkeyHash, BigDecimal amount, String prikey, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return txService.ClientToTransferVote(fromPubkey, toPubkeyHash, amount, prikey, isSend, node);
    }

    public Object ClientToTransferVoteWithdraw(String fromPubkey, String toPubkeyHash, BigDecimal amount, String prikey, String txid, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return txService.ClientToTransferVoteWithdraw(fromPubkey, toPubkeyHash, amount, prikey, txid, isSend, node);
    }

    public Object ClientToTransferMortgage(String fromPubkey, String toPubkeyHash, BigDecimal amount, String prikey, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return txService.ClientToTransferMortgage(fromPubkey, toPubkeyHash, amount, prikey, isSend, node);
    }

    public Object ClientToTransferMortgageWithdraw(String fromPubkey, String toPubkeyHash, BigDecimal amount, String prikey, String txid, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return txService.ClientToTransferMortgageWithdraw(fromPubkey, toPubkeyHash, amount, prikey, txid, isSend, node);
    }

    public Object ClientToTransferProve(String fromPubkey, String prikey, String payloadStr, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return txService.ClientToTransferProve(fromPubkey, prikey, payloadStr, isSend, node);
    }

    public Object CreateSignToDeployforRuleAsset(String fromPubkey, String prikey, String code, BigDecimal offering, String createuser, String owner, int allowincrease, String info, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return txService.CreateSignToDeployforRuleAsset(fromPubkey, prikey, code, offering, createuser, owner, allowincrease, info, isSend, node);
    }

    public Object CreateSignToDeployforAssetChangeowner(String fromPubkey, String txHash, String prikey, String newowner, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return txService.CreateSignToDeployforAssetChangeowner(fromPubkey, txHash, prikey, newowner, isSend, node);
    }

    public Object CreateSignToDeployforRuleAssetIncreased(String fromPubkey, String txHash, String prikey, BigDecimal amount, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return txService.CreateSignToDeployforRuleAssetIncreased(fromPubkey, txHash, prikey, amount, isSend, node);
    }

    public Object CreateSignToDeployforRuleTransfer(String fromPubkey, String txHash, String prikey, String from, String to, BigDecimal amount, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return txService.CreateSignToDeployforRuleTransfer(fromPubkey, txHash, prikey, from, to, amount, isSend, node);
    }

    public Object CreateHashTimeBlockForDeploy(String fromPubkey, String prikey, String assetHash, String pubkeyHash, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return txService.CreateHashTimeBlockForDeploy(fromPubkey, prikey, assetHash, pubkeyHash, isSend, node);
    }

    public Object CreateHashTimeBlockTransferForDeploy(String fromPubkey, String prikey, String txGetHash, BigDecimal value, String hashresult, BigDecimal timestamp, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return txService.CreateHashTimeBlockTransferForDeploy(fromPubkey, prikey, txGetHash, value, hashresult, timestamp, isSend, node);
    }

    public Object CreateHashTimeBlockGetForDeploy(String fromPubkey, String prikey, String txGetHash, String transferhash, String origintext, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return txService.CreateHashTimeBlockGetForDeploy(fromPubkey, prikey, txGetHash, transferhash, origintext, isSend, node);
    }

    public Object CreateHashHeightBlockForDeploy(String fromPubkey, String prikey, String assetHash, String pubkeyHash, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return txService.CreateHashHeightBlockForDeploy(fromPubkey, prikey, assetHash, pubkeyHash, isSend, node);
    }

    public Object CreateHashHeightBlockTransferForDeploy(String fromPubkey, String prikey, String txGetHash, BigDecimal value, String hashresult, BigDecimal blockheight, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return txService.CreateHashHeightBlockTransferForDeploy(fromPubkey, prikey, txGetHash, value, hashresult, blockheight, isSend, node);
    }

    public Object CreateHashHeightBlockGetForDeploy(String fromPubkey, String prikey, String txGetHash, String transferhash, String origintext, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return txService.CreateHashHeightBlockGetForDeploy(fromPubkey, prikey, txGetHash, transferhash, origintext, isSend, node);
    }

    public Object CreateRateheightlockruleForDeploy(String fromPubkey, String prikey, String assetHash, BigDecimal onetimedepositmultiple, int withdrawperiodheight, String withdrawrate, String dest, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return txService.CreateRateheightlockruleForDeploy(fromPubkey, prikey, assetHash, onetimedepositmultiple, withdrawperiodheight, withdrawrate, dest, isSend, node);
    }

    public Object CreateRateheightlockDepositRuleForDeploy(String fromPubkey, String prikey, String txHashCreate, BigDecimal value, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return txService.CreateRateheightlockDepositRuleForDeploy(fromPubkey, prikey, txHashCreate, value, isSend, node);
    }

    public Object CreateRateheightlockWithdrawRuleForDeploy(String fromPubkey, String txHashCreate, String prikey, String deposithash, String to, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return txService.CreateRateheightlockWithdrawRuleForDeploy(fromPubkey, txHashCreate, prikey, deposithash, to, isSend, node);
    }


    private boolean NodeCheck() {
        if (node == null) {
            return true;
        }
        return false;
    }
}
