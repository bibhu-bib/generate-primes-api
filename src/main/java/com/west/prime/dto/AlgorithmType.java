package com.west.prime.dto;

public enum AlgorithmType {

    BRUTE_FORCE("BRUTE_FORCE"),
    SIEVE("SIEVE");

    private final String type;

    AlgorithmType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
