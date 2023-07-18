package day1;

import java.util.ArrayList;
import java.util.List;
//Constructor class
class Goods {
	int S_No;
	String Product;
	int Price, GST, Qnt;

	public Goods(int S_No, String Product, int Price, int GST, int Qnt) {
		this.S_No = S_No;
		this.Product = Product;
		this.Price = Price;
		this.GST = GST;
		this.Qnt = Qnt;
	}
}

public class GoodsAndTax {
	public static void main(String[] args) {
		List<Goods> list = new ArrayList<Goods>();
		int sum = 0, max = 0;
		String name = null; //declaring values for constructor
		Goods g1 = new Goods(1, "Leather_Wallet", 1100, 18, 1);
		Goods g2 = new Goods(2, "Umbrella", 900, 12, 4);
		Goods g3 = new Goods(3, "Cigarette", 200, 28, 3);
		Goods g4 = new Goods(4, "Honey", 100, 0, 2);
       //adding all the good in single list
		list.add(g1);
		list.add(g2);
		list.add(g3);
		list.add(g4);
		for (Goods g : list) {
			//calculating gst for each product and assigning value to max
			int val = (g.Price * g.GST) / 100;
			assert val > max : "Need to print the name of the product for highest gst value";
			if (val > max) {
				max = val;
				name = g.Product;
			}
			assert g.Price >= 500 : "Calculating total price by deducting 5% for particular product";
			assert g.Price < 500 : "Calculating total price without deducting 5% for particular product";
			if (g.Price >= 500) {
				sum += ((g.Price * g.Qnt) - (((g.Price * g.Qnt) * 5) / 100)) + val;
			}
			
			else {
				sum += (g.Price * g.Qnt) + val;
			}
		}

		System.out.println("Product for which we paid maximum GST amount: " + name);
		System.out.println("Total amount to be paid to the shop keeper: " + sum);

	}

}
