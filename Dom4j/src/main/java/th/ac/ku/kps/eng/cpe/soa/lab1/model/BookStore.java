package th.ac.ku.kps.eng.cpe.soa.lab1.model;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class BookStore {
    private String isbn;
    private String title;
    private String author;
    private String category;
    private int year;
    private String language;
    private byte edition;
    private double price;

    // Getters and Setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCatagory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public byte getEdition() {
        return edition;
    }

    public void setEdition(byte edition) {
        this.edition = edition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Method to generate XML
    public static void toXml(List<BookStore> books) throws Exception {
        Document doc = DocumentFactory.getInstance().createDocument();
        Element bookstore = doc.addElement("bookstore");

        for (BookStore book : books) {
            Element bookElement = bookstore.addElement("book")
                                           .addAttribute("ISBN", book.getIsbn());
            bookElement.addElement("title").addText(book.getTitle());
            bookElement.addElement("author").addText(book.getAuthor());
            bookElement.addElement("category").addText(book.getCategory());
            if (book.getLanguage() != null) {
                bookElement.addElement("language").addText(book.getLanguage());
            }
            bookElement.addElement("year").addText(String.valueOf(book.getYear()));
            bookElement.addElement("edition").addText(String.valueOf(book.getEdition()));
            bookElement.addElement("price").addText(String.valueOf(book.getPrice()));
        }

        // Write to XML file
        FileOutputStream fos = new FileOutputStream("bookstore.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(fos, format);
        writer.write(doc);
        writer.flush();
        writer.close();
        fos.close();
    }

    public static void main(String[] args) throws Exception {
        // Create BookStore objects
        BookStore b1 = new BookStore();
        b1.setIsbn("0123456001");
        b1.setTitle("Java For Dummies");
        b1.setAuthor("Tan Ah Teck");
        b1.setCatagory("Programming");
        b1.setYear(2009);
        b1.setEdition((byte) 7);
        b1.setPrice(19.99);

        BookStore b2 = new BookStore();
        b2.setIsbn("0123456002");
        b2.setTitle("Java Advanced");
        b2.setAuthor("Jane Doe");
        b2.setCatagory("Programming");
        b2.setYear(2015);
        b2.setEdition((byte) 3);
        b2.setPrice(25.99);

        BookStore b3 = new BookStore();
        b3.setIsbn("0123456003");
        b3.setTitle("The Complete Guide to Fishing");
        b3.setAuthor("Bill Jones");
        b3.setCatagory("Leisure");
        b3.setLanguage("French");
        b3.setYear(2000);
        b3.setEdition((byte) 2);
        b3.setPrice(49.99);

        // Add to list and generate XML
        List<BookStore> books = new ArrayList<BookStore>();
        books.add(b1);
        books.add(b2);
        books.add(b3);

        BookStore.toXml(books);
        System.out.println("XML file 'bookstore.xml' created successfully.");
    }
}
