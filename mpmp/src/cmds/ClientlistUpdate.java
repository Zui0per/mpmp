package cmds;

import main.Conn;
import main.ErrCode;
import model.Player;

/**
 * clientlist-update S->C packet.
 */
public class ClientlistUpdate implements CmdFunc {
	@Override
	public void exec(String line, Conn conn) {
		int nclients;
		String args[];

		args = line.split(" ");
		if(args.length < 2) {
			conn.sendErr(ErrCode.ClientlistUpdateUsage);
			return;
		}

		try {
			nclients = Integer.parseInt(args[1]);
		} catch(NumberFormatException nfe) {
			conn.sendErr("'" + args[1] + "': not a number"); //XXX -.-  -lele
			return;
		}

		lister.resetPlayerList();
		while(nclients --> 0) {
			String s;
			String fields[];
			Player.Mode mode;

			s = conn.readLine();
			if(s == null) {
				conn.sendErr(ErrCode.EOF);
				return;
			}

			fields = s.split(": ");
			if(fields.length < 3) {
				conn.sendErr(ErrCode.ClientlistUpdateMissingFields);
				return;
			}

			switch(fields[1].toLowerCase()) {
			case "spectator":
				mode = Player.Mode.Spectator;
				break;
			case "player":
				mode = Player.Mode.Player;
				break;
			default:
				conn.sendErr("bad gamemode '" + fields[1] + "'"); //XXX -.-  -lele
				return;
			}

			lister.addPlayer(new Player(Player.parseColor(fields[0]), mode, fields[2]));
		}

		conn.sendOK();
	}

	@Override
	public void error(ErrCode err, String line, Conn conn) {
		System.err.println("Can't happen: " + err.getMessage());
	}
	
	public interface ClientLister {
		public void addPlayer(Player p);
		public void resetPlayerList();
	}
	private ClientLister lister;
	
	public void addClientLister(ClientLister lister) {
		this.lister = lister;
	}
}