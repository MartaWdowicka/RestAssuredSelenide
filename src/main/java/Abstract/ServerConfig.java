package Abstract;

import java.io.InputStream;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServerConfig {
    public String tMobileUrl;
    public String currencyExchangeEndpoint;

    public static ServerConfig getServerConfig() {
        ServerConfig config = null;
        LoaderOptions options = new LoaderOptions();
        Yaml yaml = new Yaml(new Constructor(ServerConfig.class, options));
        try (InputStream inputStream = ServerConfig.class.getClassLoader().getResourceAsStream("config.yaml")) {
            if (inputStream == null) {
                throw new IllegalArgumentException("file not found! " + "config.yaml");
            }
            config = yaml.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return config;
     }
}