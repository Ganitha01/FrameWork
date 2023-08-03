package training;

import org.testng.annotations.Test;

public class TestNgPractice {
	@Test(priority = -1)
	public void dpdate()
	{
		System.out.println("update successfully");
	}
	@Test(enabled = false)
	public void create()
	{
		System.out.println("create successfully");
	}
	@Test(dependsOnMethods = "zreate")
	public void elete()
	{
		System.out.println("delete successfully");
	}
}
