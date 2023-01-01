package com.example.book_store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private String image;
    @Column(name = "supplier")
    private String supplier;
    @Column(name = "author")
    private String author;
    @Column(name = "translator")
    private String translator;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "publish_year")
    private Integer publishYear;
    @Column(name = "weight")
    private Integer weight;
    private String demension;
    private Integer pages;
    private String cover;
    private Double price;
    private Integer stock;
    @Column(columnDefinition = "TEXT")
    private String details;
    @Column(name = "is_delete")
    private boolean isDelete;

    @ManyToOne
    @JoinColumn(name = "book_type", referencedColumnName = "id")
    private BookType bookType;

    public Book() {
    }

    public Book(Integer id, String name, String image, String supplier, String author, String translator, String publisher, Integer publishYear, Integer weight, String demension, Integer pages, String cover, Double price, Integer stock, String details, boolean isDelete, BookType bookType) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.supplier = supplier;
        this.author = author;
        this.translator = translator;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.weight = weight;
        this.demension = demension;
        this.pages = pages;
        this.cover = cover;
        this.price = price;
        this.stock = stock;
        this.details = details;
        this.isDelete = isDelete;
        this.bookType = bookType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getDemension() {
        return demension;
    }

    public void setDemension(String demension) {
        this.demension = demension;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }
}
