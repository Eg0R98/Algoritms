package com.stulikov.different;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
public class DifferentApplication {


    public static void main(String[] args) throws IOException {
//		SpringApplication.run(EntytyManagerApplication.class, args);
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();

        URL urlTimeUpdate = new URL("https://tosamara.ru/api/v2/classifiers");


        Source source = new StreamSource(urlTimeUpdate.openStream());

      Object object =  jaxb2Marshaller.unmarshal(source);


    }
}
