package com.alex.demopractice.config;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OperationResult {
    public int status;
    public String message;
    public Object data;
}
