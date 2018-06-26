import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import com.qainfotech.tap.training.snl.api.Board;
import com.qainfotech.tap.training.snl.api.GameInProgressException;
import com.qainfotech.tap.training.snl.api.InvalidTurnException;
import com.qainfotech.tap.training.snl.api.MaxPlayersReachedExeption;
import com.qainfotech.tap.training.snl.api.NoUserWithSuchUUIDException;
import com.qainfotech.tap.training.snl.api.PlayerExistsException;

public class action {
	
	Board reg;
	 public action() throws FileNotFoundException, UnsupportedEncodingException, IOException
	 {
		 reg=new Board();
	 }
	 
	 public void user_get_successfully_register(String username) throws FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException
	 	{
		JSONArray arr= reg.registerPlayer(username);
		int length=arr.length();
		Assert.assertEquals(arr.getJSONObject(length-1).get("name"),username);
		
	 	}
	 
	 public void check_max_user(int i) throws FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException
		{
		 for(int k=0;k<i;k++)
		 {
			reg.registerPlayer("Niks1"+"-"+k);
		 }
		 
		}
	 
	 public void check_dupliacte_username() throws FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException
	 	{
		 reg.registerPlayer("niks");
		 reg.registerPlayer("niks");
	 	}
	 
	 public void check_user_registration_while_game_in_progress() throws FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException, JSONException, InvalidTurnException
	 	{
		 reg.registerPlayer("niks1");
		 reg.registerPlayer("niks4");
		 JSONObject rec=reg.getData();
		 reg.rollDice((UUID)rec.getJSONArray("players").getJSONObject(rec.getInt("turn")).get("uuid"));
		 reg.registerPlayer("abc");
		 
	 	}
	 
	 
	 public void check_invalid_user_id_to_delete() throws FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException, NoUserWithSuchUUIDException
	 	{
		 reg.registerPlayer("niks1");
		 reg.registerPlayer("niks4");
		 UUID uid=UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
		 reg.deletePlayer(uid);
	 	}
	 
	 public void check_valid_user_id_to_delete() throws FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException, NoUserWithSuchUUIDException
	 	{
		 int index=0;
		 reg.registerPlayer("niks1");
		 reg.registerPlayer("niks4");
		 JSONObject rec=reg.getData();
		 UUID uid=UUID.fromString((String) rec.getJSONArray("players").getJSONObject(index).get("uuid"));
		 reg.deletePlayer(uid);
		 rec=reg.getData();
		 Assert.assertNotEquals(rec.getJSONArray("players").getJSONObject(rec.getInt("turn")).get("uuid"), uid);
	 	}
	 
	 public void check_dice_roll_for_valid_turn_player() throws FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException, JSONException, InvalidTurnException
		{
		 reg.registerPlayer("niks1");
		 reg.registerPlayer("niks4");
		 JSONObject rec=reg.getData();
		 reg.rollDice((UUID)rec.getJSONArray("players").getJSONObject(0).get("uuid"));
		 reg.rollDice((UUID)rec.getJSONArray("players").getJSONObject(0).get("uuid"));
		 
		}
	 
	 public void check_player_move_to_appropriate_place() throws FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException, JSONException, InvalidTurnException
		{
		 reg.registerPlayer("niks1");
		 reg.registerPlayer("niks4");
		 JSONObject rec=reg.getData();
		 int turn=rec.getInt("turn");
		 int old_position=(int) rec.getJSONArray("players").getJSONObject(rec.getInt("turn")).get("position");
		 JSONObject resp=reg.rollDice((UUID)rec.getJSONArray("players").getJSONObject(rec.getInt("turn")).get("uuid"));
		 int dice=(int)resp.get("dice");
		 int new_postion=old_position+dice;
		 rec=reg.getData();
		 Assert.assertEquals(rec.getJSONArray("players").getJSONObject(turn).get("position"), rec.getJSONArray("steps").getJSONObject(new_postion).get("target"));
		 
		}
	 
	 
}
