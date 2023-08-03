package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
@Test
public void practice()
{
	System.out.println("step1");
	Assert.assertEquals("a", "b");
	System.out.println("step2");
	Assert.assertEquals(true, false);
	System.out.println("step3");
	Assert.assertTrue(true);
	System.out.println("step4");
}
@Test
public void practice1()
{   SoftAssert sa=new SoftAssert();
	System.out.println("step-1-practice");
	sa.assertTrue(false);
	System.out.println("step-1-practice");
	sa.assertEquals(true, true);
	System.out.println("step-1-practice");
	System.out.println("step-1-practice");
	System.out.println("step-1-practice");
	sa.assertAll();
}
}
