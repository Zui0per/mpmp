package cmds;

import java.util.Arrays;

import main.Conn;
import main.ErrCode;
import view.Displayer;

/**
 * add-money S->C packet
 * @author oki
 */
public class AddMoney implements CmdFunc {
	private Displayer d;

	@Override
	public void exec(String line, Conn conn) {
		String reason;
		String args[];
		int amount;

		args = line.split(" ");
		if(args.length < 3) {
			// XXX one syntax/usage error code should suffice -oki
			conn.sendErr(ErrCode.Usage, "add-money <amount> <reason>");
			return;
		}

		try {
			amount = Integer.parseInt(args[1]);
		} catch(NumberFormatException nfe) {
			conn.sendErr(ErrCode.Unexpected, "'" + args[1] + "' is not a number");
			return;
		}

		reason = String.join(" ", Arrays.copyOfRange(args, 2, args.length));
		d.show("add-money: " + amount + " " + reason);
	}

	@Override
	public void error(ErrCode err, String line, Conn conn) {}

	public void addDisplayer(Displayer d) {
		this.d = d;
	}
}
