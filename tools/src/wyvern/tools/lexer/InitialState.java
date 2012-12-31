package wyvern.tools.lexer;

public class InitialState implements LexerState {
	
	private InitialState() {}
	private static InitialState instance = new InitialState();
	public static InitialState getInstance() {
		return instance;
	}
	
	private StringBuffer startOfLine = new StringBuffer();
	
	int depth = 0;

	@Override
	public Token getToken(Lexer lexer) {
		
		// if end of file, return EOF token
		if (!lexer.hasNext()) {
			resetBuffer();	// for testing -- this object might be reused
			return Token.getEOF();
		}
		
		char ch = lexer.peek();
		
		// on newline, reset the buffer and continue
		if (ch == '\n' || ch == '\r') {
			lexer.read();
			resetBuffer();
			return getToken(lexer);
		}
		
		// skip non-newline whitespace
		if (Character.isWhitespace(ch)) {
			startOfLine.append(ch);
			lexer.read();
			return getToken(lexer);
		}
		
		// read identifiers
		if (Character.isAlphabetic(ch)) {
			lexer.currentState = IdentifierState.getInstance();
			return getNextToken(lexer);
		}
		
		// read numbers
		if (Character.isDigit(ch)) {
			lexer.currentState = NumberState.getInstance();
			return getNextToken(lexer);
		}
		//Read strings
		if (ch == '"') {
			lexer.read();
			lexer.currentState = StringState.getInstance();
			return getNextToken(lexer);
		}
		
		// read symbols
		if (lexer.isSymbol(ch)) {
			lexer.currentState = SymbolState.getInstance();
			return getNextToken(lexer);			
		}
		
		// else error
		throw new LexerException();
	}
	
	private Token getNextToken(Lexer lexer) {
		Token token = null;
		String start = startOfLine.toString();
					
		//Doesen't work hugely well with changing amounts of spacing.
		if (start.equals(lexer.getCurrentPrefix())) {
			token = Token.getNEWLINE();
		} else if (start.startsWith(lexer.getCurrentPrefix())) {
			token = Token.getINDENT();
			lexer.pushPrefix(start);
		} else if (lexer.getCurrentPrefix().startsWith(start)) {
			lexer.popPrefix();
			//lexer.pushPrefix(lexer.getCurrentPrefix().substring(0, lexer.getCurrentPrefix().length() - 1));
			if (!lexer.getCurrentPrefix().equals(start))
				lexer.currentState = InitialState.getInstance();
			token = Token.getDEDENT();
		} else {
			throw new LexerException();				
		}
		
		resetBuffer();
		return token;
	}

	private void resetBuffer() {
		startOfLine.delete(0, startOfLine.length());
	}
}
