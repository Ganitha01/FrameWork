package vtiger.Organization.Tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Vtiger.GenericUtilities.BaseClass;
import vtiger_ObjectRepository.CreateNewOrgPage;
import vtiger_ObjectRepository.HomePage;
import vtiger_ObjectRepository.OrganizationPage;
@Listeners(Vtiger.GenericUtilities.ListernersImplementation.class)
public class CreateMultipleOrgTest extends BaseClass{
	@Test(dataProvider = "OrgWithIndustry",groups = {"smokesuite","regression"})
	public void createOrgTest(String ORG,String INDUSTRY) throws Exception
	{
		String ORGNAME=ORG+jutil.getRandomNumber();
		//navigate to organizaions link
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationLink();
	//click on create organization lookup
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrgImg();
		//create Organization with madatory fields
		CreateNewOrgPage cnop=new CreateNewOrgPage(driver);
		cnop.createNewOrganization(ORGNAME, INDUSTRY);
		
		//validation part
		String ORGHEADER=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(ORGHEADER.contains(ORGNAME));
		System.out.println("create organization successfully using data provider");
	}
	@DataProvider(name="OrgWithIndustry")
	public Object[][] getData() throws Exception
	{		Object[][] data=eutil.readDataFromExcelToDatoProvider("DataProviderOrg");
		return data;
	}

}
