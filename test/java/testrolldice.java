import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.json.JSONException;
import org.testng.annotations.Test;

import com.qainfotech.tap.training.snl.api.GameInProgressException;
import com.qainfotech.tap.training.snl.api.InvalidTurnException;
import com.qainfotech.tap.training.snl.api.MaxPlayersReachedExeption;
import com.qainfotech.tap.training.snl.api.PlayerExistsException;

public class testrolldice {

	@Test(expectedExceptions=InvalidTurnException.class)
	public void check_dice_roll_for_valid_turn_player() throws FileNotFoundException, UnsupportedEncodingException, IOException, JSONException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, InvalidTurnException
	{
		action obj=new action();
		obj.check_dice_roll_for_valid_turn_player();
	}
	
	@Test
	public void check_player_move_to_appropriate_place() throws FileNotFoundException, UnsupportedEncodingException, IOException, JSONException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, InvalidTurnException
	{
		action obj=new action();
		obj.check_player_move_to_appropriate_place();
	}
	@Test
	public void check_invalid_user()
	{
		
	}
}
