package com.west.prime.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Prime {
    private int initial;
    private List<Integer> primes;

}
