package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import entity.User;
import stepDefs.common.Hooks;
import utils.BrowserEvents;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AllUsersListPage extends Hooks {

    public By allUserTable = By.xpath("//table[@id='users']");
    public By allRows = By.xpath("//table[@id='users']/tbody//tr");
    public By tableCell = By.tagName("td");


    public void manageUserdata(String name, String email, String password){

    		List<User> actualUserList = new ArrayList<User>();
    		List<WebElement> rows = BrowserEvents.getElements(allRows);
    		
    		rows.forEach(
    				(row) ->{
    					List<WebElement> cells = BrowserEvents.getSubElements(row, tableCell);
    	    				User user = new User(cells.get(0).getText(), cells.get(1).getText(), cells.get(2).getText());
    	    				actualUserList.add(user);
    				}
    			);
    		
        	//verify count
    		assertEquals(1, actualUserList.stream().filter(u -> u.getName().equals(name)).count());

    		//verify all details
    		Stream<User> filterUserData = actualUserList.stream().filter(u -> u.getName().equals(name));  
        	filterUserData.forEach(
        			(actualUser) ->{
        		        assertEquals("Invalid Name", name, actualUser.getName());
        		        assertEquals("Invalid Email", email, actualUser.getEmail());
        		        assertEquals("Invalid Password", password, actualUser.getPassword());
        			}
        		);
        
       
    }

}