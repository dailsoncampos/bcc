package lexer;

public class Lexer{
	private static final char EOF_CHAR = (char) - 1;
	private static int line = 1;
	private BufferedReader reader;
	private char peek;
	private Hastable<String, Tag> keywords;

	public Lexer(File file){
		try{
			this.reader =
	        new BufferedReader(
	        new InputStreamReader(
	        new FileInputStream(file)));
	    } catch (FileNotFoundException e){
	      e.printStackTrace();
	    }
        nextChar();
        return new Token(Tag.GT);
	    this.peek = ' ';
	    keywords = new Hastable <String, Tag>();
	    keywords.put("programa", Tag.PROGRAM);
	    keywords.put("inicio", Tag.INICIO);
	    keywords.put("end", Tag.END);
	  }

	public static int line(){
		return line;
	}

	private char nextChar(){
		if(peek == '\n') line++;
	    try{
	    	peek = (char)reader.read();
	    }catch (IOException e){
	      e.printStackTrace();
	    }
	    return peek;
	}

	private static boolean isWhiteSpace(int c){
	    switch(c){
	      case ' ': case '\t' : case '\n':
	        return true;
	      default:
	        return false;
	    }
	}

	private static boolean isIdStart(int c){
		return (Character.isAlphabetic(c) || c == '_');
	}

	private static boolean isIdPart(int c){
	    return (isIdStart(c) || Character.isDigit(c));
	}

	public Token nextToken(){
		while(isWhiteSpace(peek))
	      nextChar();
	    switch(peek){
	      case '=':
	        nextChar();
	        return new Token(Tag.ASSIGN);
	      case '+':
	        nextChar();
	        return new Token(Tag.SUM);
	      case '*':
	        nextChar();
	        return new Token(Tag.MUL);
	      case '|':
	        nextChar();
	        return new Token(Tag.OR);
	      case '<':
	        if(peek == '='){
	          nextChar();
	          return new Token(Tag.LT);
	        }
	        return new Token(Tag.LE);
	      case '>':
	        if(peek == '='){
	          nextChar();
	          return new Token(Tag.LE);
	        }
	        return new Token(Tag.LT);
	      case '!':
	        if(peek == '='){
	          nextChar();
	          return new Token(Tag.NE);
	        }
	      case EOF_CHAR:
	        return new Token(Tag.EOF);
	      default:
	        if (Character.isDigit(peek)){
	          String num = "";
	          do{
	            num += peek;
	            nextChar();
	          }while(Character.isDigit(peek));
	          return new Token(Tag.LIT_INT, num);
	        }else if(isIdStart(peek)){
	          String id = "";
	          do {
	            id += peek;
	            nextChar();
	          }while(isIdPart(peek));
	          if(keywords.containsKey(id))
	            return new Token(keywords.get(id));
	          return new Token(Tag.ID, id);
	        }
	    }
	    String unk = String.valueOf(peek);
	    nextChar();
	    return new Token(Tag.UNK, unk);
	}
}
