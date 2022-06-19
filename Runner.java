public class Runner{
	public static void main(String[] args) {
		Address ad = new Address("sector", "street", "plotNumber");
		ResidentialPlot plotObj = new ResidentialPlot("owner", 10, ad, 132);
		plotObj.toString();
	}
}