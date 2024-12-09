package th.ac.ku.kps.eng.cpe.soa.lab1.model;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookStore b = new BookStore() ;
		b.setIsbn("0123456001");
		b.setTitle("Java For Dummies");
		b.setAuthor("Tan Ah Teck");
		b.setCatagory("Programming");
		b.setYear(2009);
		b.setEdition((byte)7);
		b.setPrice(19.99);
	}


}
