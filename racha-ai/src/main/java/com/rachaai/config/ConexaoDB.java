package com.rachaai.config;
import java.util.Properties;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
        switch (os) {
            case "windows":
                return System.getenv("APPDATA") + "\\RachaAi\\";
            case "linux":
                String path = System.getenv("XDG_CONFIG_HOME");
                if (path != null && !path.isEmpty()) {
                    return path + "/RachaAi/";
                } else {
                    return System.getProperty("user.home") + "/.config/RachaAi/";
                }
            default:
                throw new IllegalStateException("Erro ao identificar o sistema operacional. Caminho de configuração não definido.");
        }
    }
    private static final String CONFIG_FILE_NAME = "config.properties";
    private static Properties configFile() {
        String onlyPath = configPath();
        String filenPath = onlyPath + CONFIG_FILE_NAME;
        Properties props = new Properties();
            props.setProperty("host", "");
            props.setProperty("porta", "5432");
            props.setProperty("banco", "");
            props.setProperty("usuario", "");
            props.setProperty("senha", "");
        File configFile = new File(filenPath);
        File configDir = new File(onlyPath);
        if (!configDir.exists()) {
            configDir.mkdirs();
        } 
        if (!configFile.exists()) {
            try (FileOutputStream output = new FileOutputStream(configFile);) {
                props.store(output, "Configurações do Banco de Dados");
            } catch (IOException e) {
                throw new RuntimeException("Erro ao criar o arquivo de configuração: " + e.getMessage(), e);
            }
        }
        try (FileInputStream input = new FileInputStream(configFile);) {
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo de configuração: " + e.getMessage(), e);
        }
        return props;
    }
    public static Connection getConnection() throws SQLException, ConfiguracaoIncompletaException {
        Properties props = configFile();
        String host = props.getProperty("host");
        String porta = props.getProperty("porta");
        String banco = props.getProperty("banco");
        String usuario = props.getProperty("usuario");
        String senha = props.getProperty("senha");

        if (host == null || host.isBlank() || banco == null || banco.isBlank() || usuario == null || usuario.isBlank() || porta == null || porta.isBlank()) {
            throw new ConfiguracaoIncompletaException("Configuração do banco de dados incompleta. Por favor, preencha todas as informações no arquivo de configuração.");
        }

        String url = "jdbc:postgresql://" + host + ":" + porta + "/" + banco;
        return DriverManager.getConnection(url, usuario, senha);
    }
}

