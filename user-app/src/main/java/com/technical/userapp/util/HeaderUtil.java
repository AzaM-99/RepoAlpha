package com.technical.userapp.util;

import org.springframework.http.HttpHeaders;
import java.util.Arrays;

/**
 * This class is used to create a header that can be used to display a message to the user
 */
public final class HeaderUtil {

    public static HttpHeaders createAlert(String... args) {

        String alert;

        if (args.length == 1) {
            alert = args[0];
        } else {
            alert = args[0] + Arrays.toString(Arrays.copyOfRange(args, 1, args.length));
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-USER TECH-alert", alert);

        return headers;
    }
}
