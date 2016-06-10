package com.zhuxiaoxue.exception;

public class DataAccessException extends RuntimeException{
    public DataAccessException(){}
    public DataAccessException(String msg){
        super(msg);
    }
    public DataAccessException(String msg,Exception e){
        super(msg,e);
    }
}
