package com.school.Redis.ServiceImpl;

import com.school.Redis.Domain.Book;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Date;

public class XmlConvertor {
        public static String file = "D:/Java DSA/SpringBootApplication/src/main/resources/book.xml";
        public static void marshalling() throws JAXBException {
                Book book = new Book();
                book.setId(1L);
                book.setName("Book1");
                book.setAuthor("Author1");
                book.setDate(new Date());;

                JAXBContext context = JAXBContext.newInstance(Book.class);
                Marshaller mar= context.createMarshaller();
                mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                mar.marshal(book, new File(file));
        }

        public static Book unMarshalling() throws JAXBException {
                JAXBContext context = JAXBContext.newInstance(Book.class);
                Unmarshaller unmar = context.createUnmarshaller();
                Book book = (Book) unmar.unmarshal(new File(file));
                return book;

        }

        public static void main(String[] args) throws JAXBException {
                   marshalling();

                   Book book = unMarshalling();
                System.out.println(book);
            }
}
