package CarUse;

import java.util.Scanner;

public class CarUse {
	public long rto = 113990;
	public long insur = 47300;
	public long tcscharges = 11000;
	public long additional = 15000;
	public long totalcost;
	public long discount;
	public long price = 0;
	public String models;
	public String insurance;
	public String additionalAccessories;
	
	public void printDetails() {
		String[] carmodels = {"Polo Trendline","Polo Highline","Virtus Trendline","Virtus Highline","Taigun Trendline","Taigun Highline", "Taigun Topline"};
		long[] CarPrices = {870000,1009000,1105000,1308000,1489000,1542000,1771000};
		for(int i=0;i<carmodels.length;i++)
			System.out.println((i+1)+"  "+carmodels[i]+"  "+CarPrices[i]);

	}

	public long getdetails(String models) {
		String[] carmodels = {"Polo Trendline","Polo Highline","Virtus Trendline","Virtus Highline","Taigun Trendline","Taigun Highline", "Taigun Topline"};
		long[] CarPrices = {870000,1009000,1105000,1308000,1489000,1542000,1771000};
		
		for(int i = 0;i< carmodels.length;i++) {
			if(carmodels[i].equals(models)) {
				price = CarPrices[i];
				break;
			}
		}
		return price;
	}
	public void getCarDetails() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Do You need Insurance: ");
		String insurance = scan.nextLine();
		System.out.println("Do you need Additional Accessories: ");
		String additionalAccessories = scan.nextLine();
		System.out.println("Dealer discount: ");
		long discount = scan.nextLong();
		if(discount >= 30000) {
			discount =0;
		}
		if(insurance.equals("yes") && additionalAccessories.equals("no")) {
			totalcost = price +  rto + insur + tcscharges - discount;
		System.out.println("Total Cost " + totalcost);
		}
		else if(insurance.equals("yes") && additionalAccessories.equals("yes")) {
			totalcost =  price + rto + insur + tcscharges + additional - discount;
			System.out.println("Total Cost "+ totalcost);
		}	
		else if(insurance.equals("no") && additionalAccessories.equals("yes")) {
			totalcost =  price + rto + tcscharges + additional - discount;
			System.out.println("Total Cost "+ totalcost);
		}
		else if(insurance.equals("no") && additionalAccessories.equals("no")) {
			discount = 0;
			insur = 0;
			additional = 0;
			totalcost =  price + rto + insur + tcscharges + additional - discount;
			System.out.println("Total Cost "+ totalcost);
		}
}
	public static void main(String[] args) {
		CarUse car = new CarUse();
		Scanner sc = new Scanner(System.in);
		System.out.println("Select car model: ");
		car.printDetails();
		String models = sc.nextLine();
		car.getdetails(models);
		car.getCarDetails();
	}
}
