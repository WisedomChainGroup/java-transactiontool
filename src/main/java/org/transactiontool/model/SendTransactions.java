package org.transactiontool.model;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.transactiontool.ApiResult.APIResult;
import org.transactiontool.controller.NodeController;

import java.util.ArrayList;
import java.util.List;

public class SendTransactions {

    @Autowired
    NodeController nodeController;

    public List<String> transactions;

    public Node node;

    public List<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

    public SendTransactions(List<String> transactions, Node node) {
        this.transactions = transactions;
        this.node = node;
    }

    public Object Send() {
        int i = 0;
        for (String str : this.getTransactions()) {
            JSONObject result = nodeController.sendTransaction(str, this.node);
            if ((int) result.get("code") == 2000) {
                i++;
            }
        }
        return APIResult.newSuccessResult("Send successfully ,number of successes:" + i + "number of failures:" + (this.getTransactions().size() - i));
    }

}
