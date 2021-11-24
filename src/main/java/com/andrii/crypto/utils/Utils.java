package com.andrii.crypto.utils;

import com.andrii.crypto.model.Cryptocurrency;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    public String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public int getRandomInt() {
        return ThreadLocalRandom.current().nextInt(0, 100000);
    }
}
