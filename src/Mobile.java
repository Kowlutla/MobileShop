
public class Mobile 
{
	String company_name;
	String model_name;
	float price;
	public Mobile(String company_name,String model_name,float price)
	{
		this.company_name=company_name;
		this.model_name=model_name;
		this.price=price;
	}
	public void setCompanyName(String company_name)
	{
		this.company_name=company_name;
	}
	public void setModelName(String model_name)
	{
		this.model_name=model_name;
	}
	public void setPrice(float price)
	{
		this.price=price;
	}
	public String getCompanyName()
	{
		return company_name;
	}
	public String getModelName()
	{
		return model_name;
	}
	public float getPrice()
	{
		return price;
	}
	public String toString()
	{
		return company_name+"\t\t\t"+model_name+"\t\t"+price;
	}
}
