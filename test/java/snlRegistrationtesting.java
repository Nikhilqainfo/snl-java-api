import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.testng.annotations.*;

import com.qainfotech.tap.training.snl.api.GameInProgressException;
import com.qainfotech.tap.training.snl.api.InvalidTurnException;
import com.qainfotech.tap.training.snl.api.MaxPlayersReachedExeption;
import com.qainfotech.tap.training.snl.api.PlayerExistsException;

public class snlRegistrationtesting {

	
	
	
	@Test(expectedExceptions=MaxPlayersReachedExeption.class)
	public void check_max_user() throws FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException
	{
		action obj=new action();
		
		obj.check_max_user(5);
	}
	
	@Test
	public void check_for_successfull_registration() throws FileNotFoundException, UnsupportedEncodingException, IOException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption
	{
		action obj=new action();
		
		obj.user_get_successfully_register("nikhil");
		obj.user_get_successfully_register("nikhil45");
		obj.user_get_successfully_register("nikhil55");
	}
	
	@Test(dependsOnMethods= {"check_max_user"},expectedExceptions=PlayerExistsException.class)
	
	public void check_duplicate_user() throws FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException
	{
		action obj=new action();
		
		obj.check_dupliacte_username();
	}
	
	@Test(dependsOnMethods= {"check_duplicate_user"},expectedExceptions=GameInProgressException.class)
	public void check_user_registration_while_game_in_progress() throws InvalidTurnException, FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException
	{
		action obj=new action();
		
		obj.check_user_registration_while_game_in_progress();
	}
	

}
