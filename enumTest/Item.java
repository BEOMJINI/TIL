package enumTest;


public class Item {

	private int number;
	private String categorayName;
	private String itemName;
	private int price;
	
	public Item(int number, String categorayName, String itemName, int price) {
		super();
		this.number = number;
		this.categorayName = categorayName;
		this.itemName = itemName;
		this.price = price;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getCategorayName() {
		return categorayName;
	}
	public void setCategorayName(String categorayName) {
		this.categorayName = categorayName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return  "["+number + "\t" + categorayName + "\t" + itemName + "\t"
				+ price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (number != other.number)
			return false;
		return true;
	}
	
	
	
}