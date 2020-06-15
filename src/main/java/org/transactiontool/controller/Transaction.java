package org.transactiontool.controller;

import org.transactiontool.ApiResult.APIResult;
import org.transactiontool.Utils.TransactionUtils;
import org.transactiontool.model.Node;



import java.math.BigDecimal;
public class Transaction {
    private Node node;

    public Object ClientToTransferAccount(String fromPubkey, String toPubkeyHash, BigDecimal amount, String prikey, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return TransactionUtils.ClientToTransferAccount(fromPubkey, toPubkeyHash, amount, prikey, isSend, this.node);
    }

    public Object ClientToTransferVote(String fromPubkey, String toPubkeyHash, BigDecimal amount, String prikey, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return TransactionUtils.ClientToTransferVote(fromPubkey, toPubkeyHash, amount, prikey, isSend, this.node);
    }

    public Object ClientToTransferVoteWithdraw(String fromPubkey, String toPubkeyHash, BigDecimal amount, String prikey, String txid, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return TransactionUtils.ClientToTransferVoteWithdraw(fromPubkey, toPubkeyHash, amount, prikey, txid, isSend, this.node);
    }

    public Object ClientToTransferMortgage(String fromPubkey, String toPubkeyHash, BigDecimal amount, String prikey, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return TransactionUtils.ClientToTransferMortgage(fromPubkey, toPubkeyHash, amount, prikey, isSend, this.node);
    }

    public Object ClientToTransferMortgageWithdraw(String fromPubkey, String toPubkeyHash, BigDecimal amount, String prikey, String txid, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return TransactionUtils.ClientToTransferMortgageWithdraw(fromPubkey, toPubkeyHash, amount, prikey, txid, isSend, this.node);
    }

    public Object ClientToTransferProve(String fromPubkey, String prikey, String payloadStr, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return TransactionUtils.ClientToTransferProve(fromPubkey, prikey, payloadStr, isSend, this.node);
    }

    public Object CreateSignToDeployforRuleAsset(String fromPubkey, String prikey, String code, BigDecimal offering, String createuser, String owner, int allowincrease, String info, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return TransactionUtils.CreateSignToDeployforRuleAsset(fromPubkey, prikey, code, offering, createuser, owner, allowincrease, info, isSend, this.node);
    }

    public Object CreateSignToDeployforAssetChangeowner(String fromPubkey, String txHash, String prikey, String newowner, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return TransactionUtils.CreateSignToDeployforAssetChangeowner(fromPubkey, txHash, prikey, newowner, isSend, this.node);
    }

    public Object CreateSignToDeployforRuleAssetIncreased(String fromPubkey, String txHash, String prikey, BigDecimal amount, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return TransactionUtils.CreateSignToDeployforRuleAssetIncreased(fromPubkey, txHash, prikey, amount, isSend, this.node);
    }

    public Object CreateSignToDeployforRuleTransfer(String fromPubkey, String txHash, String prikey, String from, String to, BigDecimal amount, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return TransactionUtils.CreateSignToDeployforRuleTransfer(fromPubkey, txHash, prikey, from, to, amount, isSend, this.node);
    }

    public Object CreateHashTimeBlockForDeploy(String fromPubkey, String prikey, String assetHash, String pubkeyHash, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return TransactionUtils.CreateHashTimeBlockForDeploy(fromPubkey, prikey, assetHash, pubkeyHash, isSend, this.node);
    }

    public Object CreateHashTimeBlockTransferForDeploy(String fromPubkey, String prikey, String txGetHash, BigDecimal value, String hashresult, BigDecimal timestamp, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return TransactionUtils.CreateHashTimeBlockTransferForDeploy(fromPubkey, prikey, txGetHash, value, hashresult, timestamp, isSend, this.node);
    }

    public Object CreateHashTimeBlockGetForDeploy(String fromPubkey, String prikey, String txGetHash, String transferhash, String origintext, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return TransactionUtils.CreateHashTimeBlockGetForDeploy(fromPubkey, prikey, txGetHash, transferhash, origintext, isSend, this.node);
    }

    public Object CreateHashHeightBlockForDeploy(String fromPubkey, String prikey, String assetHash, String pubkeyHash, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return TransactionUtils.CreateHashHeightBlockForDeploy(fromPubkey, prikey, assetHash, pubkeyHash, isSend, this.node);
    }

    public Object CreateHashHeightBlockTransferForDeploy(String fromPubkey, String prikey, String txGetHash, BigDecimal value, String hashresult, BigDecimal blockheight, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return TransactionUtils.CreateHashHeightBlockTransferForDeploy(fromPubkey, prikey, txGetHash, value, hashresult, blockheight, isSend, this.node);
    }

    public Object CreateHashHeightBlockGetForDeploy(String fromPubkey, String prikey, String txGetHash, String transferhash, String origintext, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return TransactionUtils.CreateHashHeightBlockGetForDeploy(fromPubkey, prikey, txGetHash, transferhash, origintext, isSend, this.node);
    }

    public Object CreateRateheightlockruleForDeploy(String fromPubkey, String prikey, String assetHash, BigDecimal onetimedepositmultiple, int withdrawperiodheight, String withdrawrate, String dest, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return TransactionUtils.CreateRateheightlockruleForDeploy(fromPubkey, prikey, assetHash, onetimedepositmultiple, withdrawperiodheight, withdrawrate, dest, isSend, this.node);
    }

    public Object CreateRateheightlockDepositRuleForDeploy(String fromPubkey, String prikey, String txHashCreate, BigDecimal value, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return TransactionUtils.CreateRateheightlockDepositRuleForDeploy(fromPubkey, prikey, txHashCreate, value, isSend, this.node);
    }

    public Object CreateRateheightlockWithdrawRuleForDeploy(String fromPubkey, String txHashCreate, String prikey, String deposithash, String to, boolean isSend) {
        if (NodeCheck()) return APIResult.newFailResult(5000, "请选择节点");
        return TransactionUtils.CreateRateheightlockWithdrawRuleForDeploy(fromPubkey, txHashCreate, prikey, deposithash, to, isSend, this.node);
    }

    public Transaction(Node node){
        this.node = node;
    }

    private boolean NodeCheck() {
        if (this.node == null) {
            return true;
        }
        return false;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}
