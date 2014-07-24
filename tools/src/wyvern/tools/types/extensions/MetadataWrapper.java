package wyvern.tools.types.extensions;

import wyvern.tools.typedAST.core.expressions.Application;
import wyvern.tools.typedAST.core.expressions.Invocation;
import wyvern.tools.typedAST.interfaces.TypedAST;
import wyvern.tools.typedAST.interfaces.Value;
import wyvern.tools.types.*;
import wyvern.tools.util.Reference;
import wyvern.tools.util.TreeWriter;

import java.util.HashSet;
import java.util.Map;

public class MetadataWrapper implements Type, ApplyableType, OperatableType, RecordType, MetaType {
	private final Type inner;
	private final Reference<TypedAST> metadata;

	public MetadataWrapper(Type inner, Reference<TypedAST> metadata) {
		this.inner = inner;
		this.metadata = metadata;
	}

	@Override
	public void writeArgsToTree(TreeWriter writer) {

	}

	@Override
	public boolean subtype(Type other, HashSet<SubtypeRelation> subtypes) {
		return inner.subtype(other);
	}

	@Override
	public boolean subtype(Type other) {
		return inner.subtype(other);
	}

	@Override
	public boolean isSimple() {
		return inner.isSimple();
	}

	@Override
	public Map<String, Type> getChildren() {
		return inner.getChildren();
	}

	@Override
	public Type cloneWithChildren(Map<String, Type> newChildren) {
		return new MetadataWrapper(inner.cloneWithChildren(newChildren), metadata);
	}

	//TODO
	@Override
	public Type checkApplication(Application application, Environment env) {
		if (inner instanceof ApplyableType)
			return ((ApplyableType) inner).checkApplication(application, env);
		else
			throw new RuntimeException();
	}

	@Override
	public Type checkOperator(Invocation opExp, Environment env) {
		if (inner instanceof OperatableType)
			return ((OperatableType) inner).checkOperator(opExp, env);
		else
			throw new RuntimeException();
	}

	@Override
	public Type getInnerType(String name) {
		if (inner instanceof RecordType)
			return ((RecordType) inner).getInnerType(name);
		else
			throw new RuntimeException();
	}

	@Override
	public Value getMetaObj() {
		return this.metadata.get();
	}
}
