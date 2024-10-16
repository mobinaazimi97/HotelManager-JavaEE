package com.mftplus.jee03practice.controller.exception;

public class NoTransactionException extends Exception {
    public NoTransactionException() {
        super("No transaction found!");
    }
}
