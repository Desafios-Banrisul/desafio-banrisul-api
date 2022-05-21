package utilitarios;

import java.io.*;
import java.util.Properties;

public class FileOperations {
    private static final String CAMINHO_PROPERTIES =
            System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
                    File.separator + "resources" + File.separator + "Properties" + File.separator;

    public static Properties getPropriedade(String nomeArquivo) {
        InputStream inputStream = null;
        Properties properties = new Properties();

        try {
            File file = new File(CAMINHO_PROPERTIES + File.separator +nomeArquivo + ".Properties");
            inputStream = new FileInputStream(file);
            properties.load(inputStream);
            return properties;
        }catch (Exception e){
            e.printStackTrace();
        }
        return properties;
    }

    public static void setPropriedade(String fileName, String propKey, String propValue) throws IOException {
        Properties prop = getPropriedade(fileName);
        try {
            OutputStream outputStream = new FileOutputStream(CAMINHO_PROPERTIES + fileName + ".properties");
            prop.setProperty(propKey, propValue);
            prop.store(outputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
