package cmds;

import main.Conn;
import main.ErrCode;
import view.Displayer;

/**
 * chat-update S->C packet.
 */
public class ChatUpdate implements CmdFunc {
	private Displayer d;

	@Override
	public void exec(String line, Conn conn) {
		String message = line.substring(12);
		d.show(message);
		conn.sendOK();
	}

	@Override
	public void error(ErrCode err, String line, Conn conn) {}
	
	public void addDisplayer(Displayer d) {
		this.d = d;
	}
}
