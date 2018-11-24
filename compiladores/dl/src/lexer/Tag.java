package lexer;

public enum Tag {
	PROGRAM("PROGRAM"),
	BEGIN("BEGIN"), END("END"),
	ASSIGN("ASSIGN"),
	SUM("SUM"), MUL("MUL"),
	OR("OR"),
	NE("NT"),	LT("LT"), LE("LE"), GT("GT"), GE("GE"),
	LIT_INT("LIT_INT"),
	ID("ID"),
	EOF("EOF"), UNK("UNK");

	private String name;

	private Tag(String name) {
		this.name = name;
	}

	@Override
	public String toString(){
		return name;
	}
}