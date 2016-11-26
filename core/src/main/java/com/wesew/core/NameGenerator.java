package com.wesew.core;

import java.util.UUID;

/**
 * @author vladyslav.yemelianov
 */
public class NameGenerator {
    public static String id() {
        return UUID.randomUUID().toString();
    }
}
