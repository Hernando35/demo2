package com.example.demo.BootstratData;

import com.example.demo.Domain.Document;
import com.example.demo.Domain.Publisher;
import com.example.demo.Repository.DocumentRepository;
import com.example.demo.Repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Bootstrap implements CommandLineRunner {
    private final DocumentRepository documentRepository;
    private final PublisherRepository publisherRepository;

    public Bootstrap(DocumentRepository documentRepository ,PublisherRepository publisherRepository) {
        this.documentRepository = documentRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        LocalDate localDate = LocalDate.of(2019,12,12);
        LocalDate localDate1 = LocalDate.of(2201,05,12);
        Publisher publisher = new Publisher("Amazon", "787988GH");
        publisher.setId("00006");
        Document document = new Document(23, "submission", localDate);
        Document document1 = new Document(2, "New version", localDate1);

        documentRepository.save(document);
        documentRepository.save(document1);


        System.out.println("bootstrap");
        System.out.println("number of documents: "+ documentRepository.count());
    }

}
