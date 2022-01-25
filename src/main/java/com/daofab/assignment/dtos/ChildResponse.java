package com.daofab.assignment.dtos;

import lombok.Getter;

/**
 * @author prabesh on 25/Jan/2022
 */

@Getter
public class ChildResponse {

    private final Integer id;
    private final String sender;
    private final String receiver;
    private final Integer totalAmount;
    private final Integer paidAmount;

    public ChildResponse(Integer id, String sender, String receiver, Integer totalAmount, Integer paidAmount) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
    }
}
