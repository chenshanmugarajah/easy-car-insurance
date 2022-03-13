package chen.shanmugarajah;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraper extends Thread {
	
	private String url;
	private String name;
	private String numberOfProducts;
	private String productsPerPage;
	private String productListClass;
	private String productObjectClass;
	private String productNameClass;
	private String productPriceClass;
	private String productUrlClass;
	
	public Scraper () {	
	}
	
	public void getData () throws IOException {
		
		try {
			Connection connection = Jsoup.connect(url);
			connection.userAgent("Mozilla/5.0");
			Document document = connection.get();
			Elements products = document.select(productObjectClass);
			
			for (Element product : products) {
				String toyName = product.select(productNameClass).text();
				String toyPrice = product.select(productPriceClass).text();
				String amazonPrice = searchAmazon(toyName);
				System.out.println("Toy name: " + toyName + " Argos price:" + toyPrice + " Amazon price: " + amazonPrice);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	
	public String searchAmazon(String amazonProductTitle) throws IOException {
		
		String amazonTitle = amazonProductTitle.replaceAll(" ", "+");
		String amazonUrl = "https://www.amazon.co.uk/s?k=";
		String amazonPrice = "->";
		
		try {
			Connection connection = Jsoup.connect(amazonUrl+amazonTitle);
			connection.userAgent("Mozilla/5.0");
			Document document = connection.get();
			Elements products = document.select(".s-result-item");
			for(int i=0; i<3; i++) {
				amazonPrice += " " + products.get(i).select(".a-offscreen").text();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return amazonPrice;
	} 
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNameString() {
		return name;
	}
	public void setNameString(String name) {
		this.name = name;
	}
	public String getNumberOfProducts() {
		return numberOfProducts;
	}
	public void setNumberOfProducts(String numberOfProducts) {
		this.numberOfProducts = numberOfProducts;
	}
	public String getProductsPerPage() {
		return productsPerPage;
	}
	public void setProductsPerPage(String productsPerPage) {
		this.productsPerPage = productsPerPage;
	}
	public String getProductListClass() {
		return productListClass;
	}
	public void setProductListClass(String productListClass) {
		this.productListClass = productListClass;
	}
	public String getProductObjectClass() {
		return productObjectClass;
	}
	public void setProductObjectClass(String productObjectClass) {
		this.productObjectClass = productObjectClass;
	}
	public String getProductNameClass() {
		return productNameClass;
	}
	public void setProductNameClass(String productNameClass) {
		this.productNameClass = productNameClass;
	}
	public String getProductPriceClass() {
		return productPriceClass;
	}
	public void setProductPriceClass(String productPriceClass) {
		this.productPriceClass = productPriceClass;
	}
	public String getProductUrlClass() {
		return productUrlClass;
	}
	public void setProductUrlClass(String productUrlClass) {
		this.productUrlClass = productUrlClass;
	}
	
	

}
