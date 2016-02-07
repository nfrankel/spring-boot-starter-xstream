package ch.frankel.boot.xstream;

import com.thoughtworks.xstream.XStream;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XStreamAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(XStream.class)
    public XStream xStream() {
        return new XStream();
    }
}
