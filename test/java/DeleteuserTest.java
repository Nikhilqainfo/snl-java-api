import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.testng.annotations.Test;

import com.qainfotech.tap.training.snl.api.GameInProgressException;
import com.qainfotech.tap.training.snl.api.MaxPlayersReachedExeption;
import com.qainfotech.tap.training.snl.api.NoUserWithSuchUUIDException;
import com.qainfotech.tap.training.snl.api.PlayerExistsException;

public class DeleteuserTest {

	@Test(expectedExceptions=NoUserWithSuchUUIDException.class)
	public void check_invalid_user_id_to_delete() throws FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException, NoUserWithSuchUUIDException
	{
		action obj=new action();
		obj.check_invalid_user_id_to_delete();
	}
	@Test
	public void check_valid_user_id_to_delete() throws FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException, NoUserWithSuchUUIDException
	{
		action obj=new action();
		obj.check_valid_user_id_to_delete();
	}
	
	
}
