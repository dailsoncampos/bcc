package lexer;

public class Token{
	  private Tag tag;
	  private String lexeme;

	  public Token(Tag t, String l){
		  tag = t;
		  lexeme = l;
	  }

	  public Token(Tag t){
		  this(t, null);
	  }

	  public Tag tag(){
		  return tag;
	  }
		
	  public String lexeme(){
		  return lexeme;
	  }

	  @Override
	  public String toString(){
		  String s = "<" + tag;
		  if(lexeme != null){
			  s += ", '" + lexeme + "'";
		  }
		  s += ">";
		  return s;
	  }
}