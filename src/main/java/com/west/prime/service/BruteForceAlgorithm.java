package com.west.prime.service;

import com.west.prime.exception.InvalidInputException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class BruteForceAlgorithm implements PrimeAlgorithm {
    @Override
    public List<Integer> generatePrimeNumbers(int number) {
        if(number<2){
            throw new InvalidInputException("Number can not be less than 2");
        }

        log.info("Inside BruteForceAlgorithm");

        List<Integer> list = new ArrayList<>();
        for (int x = 2; x <= number; x++) {
            if (isPrimeNumber(x)) {
                list.add(x);
            }
        }
        return list;
    }

    private static boolean isPrimeNumber(int number) {
        int bound = (int) (Math.sqrt(number));
        for (int n = 2; n <= bound; n++) {
            if (number % n == 0) {
                return false;
            }
        }
        return true;
    }

}
