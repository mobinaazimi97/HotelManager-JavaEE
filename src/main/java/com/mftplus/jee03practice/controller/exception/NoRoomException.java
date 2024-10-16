package com.mftplus.jee03practice.controller.exception;

public class NoRoomException extends Exception{
    public NoRoomException() {
        super("No Room Found!");
    }
}
