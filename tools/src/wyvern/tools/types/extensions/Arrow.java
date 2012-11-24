package wyvern.tools.types.extensions;

import static wyvern.tools.errors.ErrorMessage.ACTUAL_FORMAL_TYPE_MISMATCH;
import static wyvern.tools.errors.ToolError.reportError;
import wyvern.tools.typedAST.Application;
import wyvern.tools.types.AbstractTypeImpl;
import wyvern.tools.types.ApplyableType;
import wyvern.tools.types.Type;
import wyvern.tools.util.TreeWriter;

public class Arrow extends AbstractTypeImpl implements ApplyableType {
	private Type result;
	private Type argument;
	
	public Arrow(Type argument, Type result) {
		this.argument = argument;
		this.result = result;
	}

	Type getResult() {
		return result;
	}
	
	Type getArgument() {
		return argument;
	}
	
	@Override
	public Type checkApplication(Application application) {
		Type actualType = application.getArgument().typecheck();
		if (!actualType.equals(argument))
			reportError(ACTUAL_FORMAL_TYPE_MISMATCH, application);
		return result;
	}
	
	@Override
	public void writeArgsToTree(TreeWriter writer) {
		writer.writeArgs(argument, result);		
	}
	
	@Override
	public String toString() {
		String argString = argument.toString();
		if (argument instanceof Arrow)
			argString = "(" + argString + ")";
		return argString + " -> " + result;
	}
	
	@Override
	public boolean equals(Object otherT) {
		if (!(otherT instanceof Arrow))
			return false;
		Arrow otherAT = (Arrow) otherT; 
		return argument.equals(otherAT.argument) && result.equals(otherAT.result);
	}
	
	@Override
	public int hashCode() {
		return 37*argument.hashCode()+result.hashCode();
	}	
}