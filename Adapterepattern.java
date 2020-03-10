public interface ITarget
{
 public String translateAndTellToOtherPerson(String words,String convertToWhichLanguage);
}
import java.util.HashMap;
public class John implements ITarget
{

 static HashMap<String, String> englishFrenchMap = new HashMap<String, String>();
 static HashMap<String, String> frenchEnglishMap = new HashMap<String, String>();
 David david = new David();
 Rohit rohit =new Rohit();

 static
 {
 englishFrenchMap.put("how are you?", "comment allez-vous?");
 englishFrenchMap.put("I am in USA", "Je suis aux Etats-Unis");
 frenchEnglishMap.put("Je suis très bien", "I am fine");
 frenchEnglishMap.put("où êtes-vous?", "where are you?");

 }

 @Override
 public String translateAndTellToOtherPerson( String words, String convertToWhichLanguage )
 {
 if( convertToWhichLanguage.equalsIgnoreCase("English") )
 {

 String englishWords = convertToEnglish(words);
 System.out.println("\nJohn Converted \"" + words + " \" to \"" + englishWords
                 + " and send the question to David");
 String englishWordsReply = david.answerFortheQuestion(englishWords);
 System.out.println("John Got reply from David in English like : " + "\"" + englishWordsReply
                 + "\"");
 String frenchConverted = convertToFrench(englishWordsReply);
 System.out.println("John Converted " + "\"" + englishWordsReply + "\"" + " to " + "\""
                 + frenchConverted + "\"" + " and send back to Rohit\n");
 return frenchConverted;

 }
 else if( convertToWhichLanguage.equalsIgnoreCase("French") )

 {
 String frenchWords = convertToFrench(words);
 System.out.println("\nJohn Converted \"" + words + " \" to \"" + frenchWords
                 + " and send the question to Rohit");
 String frenchWordsReply =rohit.answerFortheQuestion(frenchWords);
 System.out.println("John Got reply from Rohit in French like : " + "\"" + frenchWordsReply
                 + "\"");
 String englishConverted = convertToEnglish(frenchWordsReply);
 System.out.println("John Converted " + "\"" + frenchWordsReply + "\"" + " to " + "\""
                 + englishConverted + "\"" + " and send back to David\n");
 return englishConverted;

 }

 return "Sorry Cannot Covert";
 }

 public String convertToFrench( String words )
 {
 return englishFrenchMap.get(words);
 }

 public String convertToEnglish( String words )
 {
 return frenchEnglishMap.get(words);
 }

}
public interface EnglishSpeaker
{
 public String askQuestion( String words );
 public String answerFortheQuestion( String words );
 
}
public class David implements EnglishSpeaker
{

 public static void main( String args[] )
 {
 String replyFromRohit = new David().askQuestion("how are you?");
 System.out.println("Reply From Rohit [French Speaker can Speak and Understand only French] :  " + replyFromRohit);
 }

 @Override
 public String askQuestion( String words )
 {
 System.out.println("Question Asked by David [English Speaker and Can understand only English] : " +words);
 ITarget target = new John();
 String replyFromRohit = target.translateAndTellToOtherPerson(words, "French");
 return replyFromRohit;
 }

 @Override
 public String answerFortheQuestion( String words )
 {
 String reply = null;
 if( words.equalsIgnoreCase("where are you?") )
 {
 reply = "I am in USA";
 }
 return reply;
 }

}
public interface FrenchSpeaker
{
 public String askQuestion( String words );
 public String answerFortheQuestion( String words );

}
public class Rohit implements FrenchSpeaker
{

 public static void main( String args[] )
 {
 String replyFromDavid = new Rohit().askQuestion("où êtes-vous?");
 System.out.println("Reply From David [English Speaker can Speak and Understand only English] :  " + replyFromDavid);
 }

 @Override
 public String askQuestion( String words )
 {
 System.out.println("Question Asked by Rohit [French Speaker and Can understand only French] : " +words);
 ITarget target = new John();
 String replyFromDavid = target.translateAndTellToOtherPerson(words, "English");
 return replyFromDavid;
 }

 @Override
 public String answerFortheQuestion( String words )
 {
 String reply = null;
 if( words.equalsIgnoreCase("comment allez-vous?") )
 {
 reply = "Je suis très bien";
 }
 return reply;
 }

}