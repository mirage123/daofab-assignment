package com.daofab.assignment.serviceobjects;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class RestResponse<T> {
    private int statusCode;
    private String message;
    private long timeStamp;
    private T data;
    private PaginationInfo paginationInfo;

    public RestResponse() {
    }

    public RestResponse(int statusCode, String message, T data, PaginationInfo paginationInfo) {
        this.statusCode = statusCode;
        this.message = message;
        this.timeStamp = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
        this.data = data;
        this.paginationInfo = paginationInfo;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public PaginationInfo getPaginationInfo() {
        return paginationInfo;
    }

    public void setPaginationInfo(PaginationInfo paginationInfo) {
        this.paginationInfo = paginationInfo;
    }

    public static <T> RestResponse<T> ok(String message) {
        return new RestResponse<>(HttpStatus.OK.value(), message, null, null);
    }

    public static <T> RestResponse<T> okWithPayload(T data, String message) {
        return new RestResponse<>(HttpStatus.OK.value(), message, data, null);
    }

    public static <T> RestResponse<T> oKWithPaginatedPayload(T data, PaginationInfo paginationInfo, String message) {
        return new RestResponse<>(HttpStatus.OK.value(), message, data, paginationInfo);
    }

    public static <T> RestResponse<T> error(int statusCode, String message, T data) {
        return new RestResponse<>(statusCode, message, data, null);
    }


}