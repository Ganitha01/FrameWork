package vtiger.Contacts.Tests;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Vtiger.GenericUtilities.BaseClass;
import vtiger_ObjectRepository.ContactInformationPage;
import vtiger_ObjectRepository.ContactsPage;
import vtiger_ObjectRepository.CreateNewContactPage;
import vtiger_ObjectRepository.CreateNewOrgPage;
import vtiger_ObjectRepository.HomePage;
import vtiger_ObjectRepository.OrgInformationPage;
import vtiger_ObjectRepository.OrganizationPage;
@Listeners(Vtiger.GenericUtilities.ListernersImplementation.class)
public class CreateContactWithOrganizationTest extends BaseClass{
	@Test(groups = "smokesuite",retryAnalyzer =Vtiger.GenericUtilities.RetryAnalyserImplementation.class)
	public void createContactWithOrgTest() throws Exception {
	
String ORGNAME=eutil.readDataFromExcel("Organization", 1, 2)+jutil.getRandomNumber();
String LASTNAME=eutil.readDataFromExcel("Contact", 1, 2);
//navigate to organization link
HomePage hp=new HomePage(driver);
hp.clickOnOrganizationLink();
//click on create organization lookup image
OrganizationPage op=new OrganizationPage(driver);
op.clickOnCreateOrgImg();
//create organization with mandatory fields
CreateNewOrgPage cnop=new CreateNewOrgPage(driver);
cnop.createNewOrganization(ORGNAME);
Thread.sleep(3000);
//validatation for Organization
/*String ORGHEADER=driver.findElement(By.className("dvHeaderText")).getText();*/
OrgInformationPage oip=new OrgInformationPage(driver);
String ORGHEADER=oip.getOrnHeader();
Assert.assertTrue(ORGHEADER.contains(ORGNAME));
Thread.sleep(3000);
//navigate to contacts link
hp.clickOnContactsLink();
//click on create contact lookup image
ContactsPage cp=new ContactsPage(driver);
cp.clickOnCreateNewContact();
//create new contact
CreateNewContactPage cncp=new CreateNewContactPage(driver);
cncp.createNewContact(driver, LASTNAME, ORGNAME);
Thread.sleep(4000);
//validation for contacts
ContactInformationPage cip=new ContactInformationPage(driver);
String CONHEADER=cip.getContactText();
Assert.assertTrue(CONHEADER.contains(LASTNAME));
System.out.println("create contact successfully");

}
}