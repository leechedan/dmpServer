package com.chinagreentown.dmp.api;


/**
 * HBase Data Access exception.
 */


/**
 * @desc copy from spring data hadoop hbase
 */
public class HbaseSystemException extends RuntimeException {

    public HbaseSystemException(Exception cause) {
        super(cause.getMessage(), cause);
    }

    public HbaseSystemException(Throwable throwable) {
        super(throwable.getMessage(), throwable);
    }
}
