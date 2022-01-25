package com.daofab.assignment.dtos;

import lombok.Data;
import lombok.Getter;

/**
 * @author prabesh on 25/Jan/2022
 */

@Getter
public class ParentResponse {

    private final Integer id;
    private final String sender;
    private final String receiver;
    private final Integer totalAmount;
    private final Long paidAmount;

    public ParentResponse(Integer id, String sender, String receiver, Integer totalAmount, Long paidAmount) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount == null ? 0: paidAmount;
    }
}
