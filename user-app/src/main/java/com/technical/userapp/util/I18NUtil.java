package com.technical.userapp.util;


import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * It's a utility class that allows you to get a message from a properties file based on the current
 * locale which is used to translte messages
 */
@Component
public class I18NUtil {

    private static MessageSource messageSource;

    public I18NUtil(MessageSource messageSource) {
        I18NUtil.messageSource = messageSource;
    }

    public static String get(String key) {
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }
}
