package cmds;

import main.Conn;
import main.ErrCode;

/**
 * Interface CmdFunc is implemented by all protocol command handlers.
 * The method exec gets the whole line it was invoked from and the Client
 * that sent the packet.
 *
 * @author oki, Leander
 */
public interface CmdFunc {
	public void exec(String line, Conn conn);
	public void error(ErrCode err, String line, Conn conn);
}
