package sync;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.people.v1.PeopleService;
import com.google.api.services.people.v1.model.ListConnectionsResponse;
import com.google.api.services.people.v1.model.Name;
import com.google.api.services.people.v1.model.Person;

import java.util.List;

public class HelloWorld {
	private static final String APPLICATION_NAME = "Google People API Java Quickstart";
	private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

	public static void main(String[] args) {
		try {
			final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			Credential credential = Config.getCredential(HTTP_TRANSPORT);
			PeopleService service = new PeopleService.Builder(
					HTTP_TRANSPORT,
					JSON_FACTORY,
					credential).setApplicationName(APPLICATION_NAME)
					.build();

			ListConnectionsResponse response = service.people().connections()
					.list("people/me")
					.setPageSize(10)
					.setPersonFields("names,emailAddresses")
					.execute();

			// Print display name of connections if available.
			List<Person> connections = response.getConnections();
			if (connections != null && connections.size() > 0) {
				for (Person person : connections) {
					List<Name> names = person.getNames();
					if (names != null && names.size() > 0) {
						System.out.println("Name: " + person.getNames().get(0)
								.getDisplayName());
						System.out.println("Email: " + person.getEmailAddresses().getFirst().getValue());
					} else {
						System.out.println("No names available for connection.");
					}
				}
			} else {
				System.out.println("No connections found.");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
