package org.transactiontool.service;

import com.alibaba.fastjson.JSONObject;
import org.transactiontool.model.Node;

import java.math.BigDecimal;
import java.util.List;

public interface TxService {
    Object ClientToTransferAccount(String fromPubkey, String toPubkeyHash, BigDecimal amount, String prikey, boolean isSend, Node node);

    Object ClientToTransferVote(String fromPubkey, String toPubkeyHash, BigDecimal amount, String prikey, boolean isSend, Node node);

    Object ClientToTransferVoteWithdraw(String fromPubkey, String toPubkeyHash, BigDecimal amount, String prikey, String txid, boolean isSend, Node node);

    Object ClientToTransferMortgage(String fromPubkey, String toPubkeyHash, BigDecimal amount, String prikey, boolean isSend, Node node);

    Object ClientToTransferMortgageWithdraw(String fromPubkey, String toPubkeyHash, BigDecimal amount, String prikey, String txid, boolean isSend, Node node);

    Object ClientToTransferProve(String fromPubkey, String prikey, String payloadStr, boolean isSend, Node node);

    Object CreateSignToDeployforRuleAsset(String fromPubkey, String prikey, String code, BigDecimal offering, String createuser, String owner, int allowincrease, String info, boolean isSend, Node node);

    Object CreateSignToDeployforAssetChangeowner(String fromPubkey, String txHash, String prikey, String newowner, boolean isSend, Node node);

    Object CreateSignToDeployforRuleAssetIncreased(String fromPubkey, String txHash, String prikey, BigDecimal amount, boolean isSend, Node node);

    Object CreateSignToDeployforRuleTransfer(String fromPubkey, String txHash, String prikey, String from, String to, BigDecimal value, boolean isSend, Node node);

    Object CreateHashTimeBlockForDeploy(String fromPubkey, String prikey, String assetHash, String pubkeyHash, boolean isSend, Node node);

    Object CreateHashTimeBlockGetForDeploy(String fromPubkey, String prikey, String txGetHash, String transferhash, String origintext, boolean isSend, Node node);

    Object CreateHashTimeBlockTransferForDeploy(String fromPubkey, String prikey, String txGetHash, BigDecimal value, String hashresult, BigDecimal timestamp, boolean isSend, Node node);

    Object CreateHashHeightBlockForDeploy(String fromPubkey, String prikey, String assetHash, String pubkeyHash, boolean isSend, Node node);

    Object CreateHashHeightBlockGetForDeploy(String fromPubkey, String prikey, String txGetHash, String transferhash, String origintext, boolean isSend, Node node);

    Object CreateHashHeightBlockTransferForDeploy(String fromPubkey, String prikey, String txGetHash, BigDecimal value, String hashresult, BigDecimal blockheight, boolean isSend, Node node);

//    Object CreateMultipleToDeployforRuleFirst(String fromPubkey, String prikey, String assetHash, int max, int min, List<String> pubkeyHashList, boolean isSend, Node node);
//
//    Object CreateMultipleToDeployforRuleOther(String fromPubkey, String pubFirstSign, String prikey, boolean isPutSign, boolean isSend, Node node);
//
//    Object CreateMultipleToDeployforRuleSignSplice(String prikey, String pubFirstSign, String frompubkey, String signFirst, List<String> pubkeyOthers, List<String> signOthers, boolean isSend, Node node);
//
//    Object CreateMultisignatureToDeployforRuleFirst(String fromPubkey, String prikey, String txHashRule, int origin, int dest, String to, BigDecimal value, List<String> pubkeyHashList, boolean isSend, Node node);

//    Object CreateMultisignatureToDeployforRuleOther(String fromPubkey, String pubkeyFirstSign, String prikey, boolean isPutSign);
//
//    Object CreateMultisignatureToDeployforRuleSignSplice(String prikey, String pubkeyFirstSign, String frompubkey, String txHashRule, String signFirst, List<String> pubkeyOthers, List<String> signOthers, int type);

    Object CreateRateheightlockruleForDeploy(String fromPubkey, String prikey, String assetHash, BigDecimal onetimedepositmultiple, int withdrawperiodheight, String withdrawrate, String dest, boolean isSend, Node node);

    Object CreateRateheightlockDepositRuleForDeploy(String fromPubkey, String prikey, String txHashCreate, BigDecimal value, boolean isSend, Node node);

    Object CreateRateheightlockWithdrawRuleForDeploy(String fromPubkey, String txHashCreate, String prikey, String deposithash, String to, boolean isSend, Node node);
}
