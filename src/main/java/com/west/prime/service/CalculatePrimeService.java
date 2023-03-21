package com.west.prime.service;

import com.west.prime.config.CacheConfig;
import com.west.prime.dto.AlgorithmType;
import com.west.prime.dto.Prime;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatePrimeService {
    private PrimeAlgorithm algorithm;

    @Cacheable(CacheConfig.CACHE_NAME)
    public Prime getPrimes(int number, AlgorithmType type) {
        if (type == AlgorithmType.BRUTE_FORCE) {
            algorithm = new BruteForceAlgorithm();
        } else if (type == AlgorithmType.SIEVE) {
            algorithm = new SieveOfEratosthenes();
        }

        List<Integer> response = algorithm.generatePrimeNumbers(number);
        return new Prime(number, response);
    }
}
