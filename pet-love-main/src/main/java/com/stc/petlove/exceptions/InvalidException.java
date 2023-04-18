package com.stc.petlove.exceptions;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 3/15/23
 * Time      : 8:57 AM
 * Filename  : InvalidException
 */
public class InvalidException extends RuntimeException{
    public InvalidException(String message) {
        super(message);
    }
}
