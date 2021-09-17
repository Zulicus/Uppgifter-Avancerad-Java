package main;

public class Row {

	private String OrderDate = " ";
	private String Region = " ";
	private String Rep1 = " ";
	private String Rep2 = " ";
	private String Item = " ";
	private String Units = " ";
	private String UnitCost = " ";
	private String Total = " ";

	public Row(String line) {
		super();
		if (line.split(",").length < 8) {
			if (line.charAt(0) == ',') {
				this.Region = line.split(",")[1];
				this.Rep1 = line.split(",")[2];
				this.Rep2 = line.split(",")[3];
				this.Item = line.split(",")[4];
				this.Units = line.split(",")[5];
				this.UnitCost = line.split(",")[6];
				this.Total = line.split(",")[7];
			} else if (line.charAt(line.length() - 1) == ',') {
				this.OrderDate = line.split(",")[0];
				this.Region = line.split(",")[1];
				this.Rep1 = line.split(",")[2];
				this.Rep2 = line.split(",")[3];
				this.Item = line.split(",")[4];
				this.Units = line.split(",")[5];
				this.UnitCost = line.split(",")[6];
			} else {
				boolean checker = false;
				int counter = 0;
				for (int i = 0; i < line.length(); i++) {
					System.out.println(counter);
					if (line.charAt(i) == ',') {
						if (checker) {
							break;
						} else {
							checker = true;
							counter++;
						}
					} else {
						checker = false;
					}
				}
				switch (counter) {
				case 0:
					System.out.println("Error!");
					break;
				case 1:
					this.OrderDate = line.split(",")[0];
					this.Rep1 = line.split(",")[1];
					this.Rep2 = line.split(",")[2];
					this.Item = line.split(",")[3];
					this.Units = line.split(",")[4];
					this.UnitCost = line.split(",")[5];
					this.Total = line.split(",")[6];
				case 2:
					this.OrderDate = line.split(",")[0];
					this.Region = line.split(",")[1];
					this.Rep2 = line.split(",")[2];
					this.Item = line.split(",")[3];
					this.Units = line.split(",")[4];
					this.UnitCost = line.split(",")[5];
					this.Total = line.split(",")[6];
				case 3:
					this.OrderDate = line.split(",")[0];
					this.Region = line.split(",")[1];
					this.Rep1 = line.split(",")[2];
					this.Item = line.split(",")[3];
					this.Units = line.split(",")[4];
					this.UnitCost = line.split(",")[5];
					this.Total = line.split(",")[6];
				case 4:
					this.OrderDate = line.split(",")[0];
					this.Region = line.split(",")[1];
					this.Rep1 = line.split(",")[2];
					this.Rep2 = line.split(",")[3];
					this.Units = line.split(",")[4];
					this.UnitCost = line.split(",")[6];
					this.Total = line.split(",")[6];
				case 5:
					this.OrderDate = line.split(",")[0];
					this.Region = line.split(",")[1];
					this.Rep1 = line.split(",")[2];
					this.Rep2 = line.split(",")[3];
					this.Item = line.split(",")[4];
					this.UnitCost = line.split(",")[5];
					this.Total = line.split(",")[6];
				case 6:
					this.OrderDate = line.split(",")[0];
					this.Region = line.split(",")[1];
					this.Rep1 = line.split(",")[2];
					this.Rep2 = line.split(",")[3];
					this.Item = line.split(",")[4];
					this.Units = line.split(",")[5];
					this.Total = line.split(",")[6];
				case 7:
					this.OrderDate = line.split(",")[0];
					this.Region = line.split(",")[1];
					this.Rep1 = line.split(",")[2];
					this.Rep2 = line.split(",")[3];
					this.Item = line.split(",")[4];
					this.Units = line.split(",")[5];
					this.UnitCost = line.split(",")[6];
				case 8:
					System.out.println("Error!");
					break;
				default:
					break;
				}
			}
		} else if (line.split(",").length > 8) {
			this.OrderDate = line.split(",")[0];
			this.Region = line.split(",")[1];
			this.Rep1 = line.split(",")[2];
			this.Rep2 = line.split(",")[3];
			this.Item = line.split(",")[4];
			this.Units = line.split(",")[5];
			this.UnitCost = line.split(",")[6];
			this.Total = line.split(",")[7] + "," + line.split(",")[8];
		} else {
			this.OrderDate = line.split(",")[0];
			this.Region = line.split(",")[1];
			this.Rep1 = line.split(",")[2];
			this.Rep2 = line.split(",")[3];
			this.Item = line.split(",")[4];
			this.Units = line.split(",")[5];
			this.UnitCost = line.split(",")[6];
			this.Total = line.split(",")[7];
		}
	}

	public String get() {
		return OrderDate + ", " + Region + ", " + Rep1 + ", " + Rep2 + ", " + Item + ", " + Units + ", " + UnitCost
				+ ", " + Total;
	}

	public String getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}

	public String getRegion() {
		return Region;
	}

	public void setRegion(String region) {
		Region = region;
	}

	public String getRep1() {
		return Rep1;
	}

	public void setRep1(String rep1) {
		Rep1 = rep1;
	}

	public String getRep2() {
		return Rep2;
	}

	public void setRep2(String rep2) {
		Rep2 = rep2;
	}

	public String getItem() {
		return Item;
	}

	public void setItem(String item) {
		Item = item;
	}

	public String getUnits() {
		return Units;
	}

	public void setUnits(String units) {
		Units = units;
	}

	public String getUnitCost() {
		return UnitCost;
	}

	public void setUnitCost(String unitCost) {
		UnitCost = unitCost;
	}

	public String getTotal() {
		return Total;
	}

	public void setTotal(String total) {
		Total = total;
	}
}
