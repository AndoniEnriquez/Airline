package notification;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.PGConnection;
import org.postgresql.PGNotification;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

public class SocketIO implements Runnable {
	
	private static final String LOCALHOST = "localhost";
	private static final String SPLITTER = ">";
	private static final int LOOP_TIME = 500;
	private static final int PORT_NMBER = 9092;
	private PGConnection pgConn;
	private static Configuration conf;
	private static SocketIOServer server;

	public static void start() {
		conf = new Configuration();
		conf.setHostname(LOCALHOST);
		conf.setPort(PORT_NMBER);
		server = new SocketIOServer(conf);
		server.start();
	}

	public static void stop() {
		server.stop();
	}

	public SocketIO(Connection conn, String[] listenToArray) throws SQLException, InterruptedException {

		this.pgConn = (PGConnection) conn;
		Statement listenStatement = conn.createStatement();
		for (String listenTo : listenToArray) {
			listenStatement.execute("LISTEN " + listenTo);
		}
		listenStatement.close();
	}

	@Override
	public void run() {

		while (true) {
			try {

				PGNotification notifications[] = pgConn.getNotifications();

				if (notifications != null) {
					for (PGNotification pgNotification : notifications) {
						String[] tableInfo = pgNotification.getParameter().split(SPLITTER);
						System.out.println("Send to JS : "+tableInfo[1]);
						server.getBroadcastOperations().sendEvent("eventFromJava", tableInfo[1]);
					}
				}
				Thread.sleep(LOOP_TIME);
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

	public static void sendNotification(String receivingGroup, String message) {
		server.getBroadcastOperations().sendEvent(receivingGroup, message);
	}
}