package com.example.demo.Domain;

import com.example.demo.generator.DatePrefixedSequenceIdGenerator;
import com.example.demo.generator.StringPrefixedSequenceIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;


@Entity
public class Document {
       private static final long serialVersionUID = -4803404484359869286L;
       @Id
       @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
       @GenericGenerator(name = "book_seq", strategy = "com.example.demo.generator.StringPrefixedSequenceIdGenerator", parameters = {
                @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
                @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "GE_"),
                @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%06d")})
       @Column(name = "id", updatable = false, nullable = false)
       private String id;

       @Version
       @Column(name = "version")
       private int version;

       @Column
       private String title;

       @Column
       private LocalDate publishingDate;

       @ManyToOne
       @JoinColumn(name = "publisherid")
       private Publisher publisher;



       public Publisher getPublisher() {
              return publisher;
       }

       public void setPublisher(Publisher publisher) {
              this.publisher = publisher;
       }

       public String getId() {
              return id;
       }

       public void setId(String id) {
              this.id = id;
       }

       public int getVersion() {
              return version;
       }
       public void setVersion(int version) {
              this.version = version;
       }

       public String getTitle() {
              return title;
       }
       public void setTitle(String title) {
              this.title = title;
       }

       public LocalDate getPublishingDate() {
              return publishingDate;
       }

       public void setPublishingDate(LocalDate publishingDate) {
              this.publishingDate = publishingDate;
       }
       public Document(){}

       public Document(int version, String title, LocalDate publishingDate) {
             this.version = version;
              this.title = title;
              this.publishingDate = publishingDate;
       }

       @Override
       public boolean equals(Object o) {
              if (this == o) return true;
              if (o == null || getClass() != o.getClass()) return false;

              Document document = (Document) o;

              return id != null ? id.equals(document.id) : document.id == null;
       }

       @Override
       public int hashCode() {
              return id != null ? id.hashCode() : 0;
       }

       @Override
       public String toString() {
              return "Book{" +
                      "id='" + id + '\'' +
                   ", version=" + version +
                      ", title='" + title + '\'' +
                      ", publishingDate=" + publishingDate +
                      ", publisher=" + publisher +
                      '}';
       }
}
