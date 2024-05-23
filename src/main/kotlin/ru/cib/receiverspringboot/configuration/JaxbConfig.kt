package ru.cib.receiverspringboot.configuration

import DepartmentXml
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.xml.bind.JAXBContext
import javax.xml.bind.Marshaller
import javax.xml.bind.Unmarshaller

@Configuration
class JaxbConfig {

    @Bean
    fun createUnmarshaller(): Unmarshaller {
        val jaxbContext = JAXBContext.newInstance(DepartmentXml::class.java)
        return jaxbContext.createUnmarshaller()
    }

    @Bean
    fun createMarshaller(): Marshaller {
        val jaxbContext = JAXBContext.newInstance(DepartmentXml::class.java)
        return jaxbContext.createMarshaller()
    }
}