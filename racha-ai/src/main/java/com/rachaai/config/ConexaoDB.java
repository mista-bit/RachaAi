package com.rachaai.config;

public class ConexaoDB {
    private static String detectOS() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            return "windows";
        }
        else if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
            return "linux";
        }
        else{
            return "desconhecido";
        }
    }
    private static String configPath() {
        String os = detectOS();
    }
}

