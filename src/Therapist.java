import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Therapist {
	
	private Set<String> hedgeSet = new HashSet<String>();
	private Set<String> qualifierSet = new HashSet<String>();
	private Map<String,String> replacementMap = new HashMap<String,String>();
	
	private Random rand;
	
	public Therapist() {
		hedgeSet.add("Please tell me more");
		hedgeSet.add("Many of my patients tell me the same thing");
		hedgeSet.add("It is getting late, maybe we had better quit");
		qualifierSet.add("Why do you say that");
		qualifierSet.add("You seem to think that");
		qualifierSet.add("So, you are concerned that");
		replacementMap.put("I", "you");
		replacementMap.put("me", "you");
		replacementMap.put("my", "your");
		replacementMap.put("am", "are");
		
		rand = new Random();
	}
	
	public String hedge() {
		int index = rand.nextInt(hedgeSet.size());
		Iterator<String> iter = hedgeSet.iterator();
		for (int i = 0; i < index; i++) {
			iter.next();
		}
		return iter.next();
	}
	
	public String qualify(String statement) {
		int index = rand.nextInt(qualifierSet.size());
		Iterator<String> iter = qualifierSet.iterator();
		for (int i = 0; i < index; i++) {
			iter.next();
		}
		String qualifier = iter.next();
		return qualifier + " " + this.replaceQualifiers(statement);
	}
	
	private String replaceQualifiers(String text) {
		Set<String> keys = replacementMap.keySet();
		Iterator<String> iter = keys.iterator();
		for (int i = 0; i < keys.size(); i++) {
			String key = iter.next();
			text = text.replaceAll("\\b" + key + "\\b", replacementMap.get(key));
		}
		return text;
	}
}
