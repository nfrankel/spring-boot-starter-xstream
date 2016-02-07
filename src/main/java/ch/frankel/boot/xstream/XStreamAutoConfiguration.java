package ch.frankel.boot.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

@Configuration
public class XStreamAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(XStream.class)
    public XStream xStream() {
        return new XStream();
    }

    @Bean
    public Collection<Converter> converters(XStream xstream, Collection<Converter> converters) {
        converters.forEach(xstream::registerConverter);
        return converters;
    }
}
