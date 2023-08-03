package vtiger.Practice;

import org.testng.annotations.Test;

public class TestNGPracticeTest {
	@Test(invocationCount = 1	, priority = 1)
	public void createUserTest()
	{
		System.out.println("user created");
	}
	@Test(priority = 2)
	public void modifyUserTest()
	{
		System.out.println("user modifyed");
	}
	@Test ()
	public void deleteUserTest()
	{
		System.out.println("user deleted");
	}


}
