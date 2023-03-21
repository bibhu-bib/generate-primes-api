package com.west.prime.service;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class SieveOfEratosthenes implements PrimeAlgorithm {

    @Override
    public List<Integer> generatePrimeNumbers(int number) {
        log.info("Inside SieveOfEratosthenes");

        boolean[] prime = new boolean[number + 1];
        Arrays.fill(prime, true);

        for (int p = 2; p * p <= number; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= number; i += p) {
                    prime[i] = false;
                }
            }
        }

        List<Integer> primeNumbers = new LinkedList<>();
        for (int i = 2; i <= number; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
}
