package ch.frankel.boot.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Collection;

@Configuration
public class XStreamAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(XStream.class)
    public XStream xStream() {
        return new XStream();
    }

    @Configuration
    public static class XStreamConverterAutoConfiguration {

        @Autowired
        private XStream xstream;

        @Autowired
        private Collection<Converter> converters;

        @PostConstruct
        public void registerConverters() {
            converters.forEach(xstream::registerConverter);
        }
    }
}
