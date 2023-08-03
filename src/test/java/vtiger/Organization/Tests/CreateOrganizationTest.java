package vtiger.Organization.Tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Vtiger.GenericUtilities.BaseClass;
import vtiger_ObjectRepository.CreateNewOrgPage;
import vtiger_ObjectRepository.HomePage;
import vtiger_ObjectRepository.OrgInformationPage;
import vtiger_ObjectRepository.OrganizationPage;
@Listeners(Vtiger.GenericUtilities.ListernersImplementation.class)
public class CreateOrganizationTest extends BaseClass {
	@Test(groups = "regression")
public void createOrgTest() throws Exception
	{
	
	String ORGNAME=eutil.readDataFromExcel("Organization", 1, 2)+jutil.getRandomNumber();
	HomePage hp=new HomePage(driver);
	hp.clickOnOrganizationLink();
	OrganizationPage op=new OrganizationPage(driver);
	op.clickOnCreateOrgImg();
	CreateNewOrgPage cnop=new CreateNewOrgPage(driver);
	cnop.createNewOrganization(ORGNAME);
	//validation part
	OrgInformationPage oip=new OrgInformationPage(driver);
	
	String ORGHEADER=oip.getOrnHeader();
	Assert.assertTrue(ORGHEADER.contains(ORGNAME));
	System.out.println("Create organization successfuly");

	}
}
