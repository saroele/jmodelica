package org.jmodelica.ide.outline.cache;

import java.util.ArrayList;
import org.eclipse.core.resources.IFile;
import org.jastadd.ed.core.model.IASTChangeEvent;
import org.jastadd.ed.core.model.IASTChangeListener;
import org.jmodelica.ide.compiler.GlobalRootNode;
import org.jmodelica.ide.compiler.ModelicaASTRegistry;
import org.jmodelica.ide.helpers.ASTNodeCacheFactory;
import org.jmodelica.ide.helpers.CachedASTNode;
import org.jmodelica.ide.helpers.ICachedOutlineNode;
import org.jmodelica.ide.helpers.OutlineCacheJob;
import org.jmodelica.modelica.compiler.ASTNode;
import org.jmodelica.modelica.compiler.SourceRoot;

public class JobSourceOutlineCacheInitial extends OutlineCacheJob {

	public JobSourceOutlineCacheInitial(IASTChangeListener listener,
			IFile file, AbstractOutlineCache cache) {
		super(listener, file, cache);
	}

	@Override
	public void doJob() {
		long time = System.currentTimeMillis();
		GlobalRootNode root = (GlobalRootNode) ModelicaASTRegistry.getInstance().doLookup(file.getProject());
		SourceRoot sroot = root.getSourceRoot();
		ArrayList<ICachedOutlineNode> children = new ArrayList<ICachedOutlineNode>();
		CachedASTNode toReturn = null;
		synchronized (sroot.state()) {
			toReturn = ASTNodeCacheFactory.cacheNode(sroot, null, cache);
			for (Object obj : sroot.outlineChildren())
				if (obj instanceof ASTNode<?>)
					children.add(ASTNodeCacheFactory.cacheNode(
							(ASTNode<?>) obj, toReturn, cache));
		}
		toReturn.setOutlineChildren(children);
		System.out.println("CacheChildren from SourceOutline took: "
				+ (System.currentTimeMillis() - time) + "ms for nbrchild: "
				+ children.size());
		IASTChangeEvent event = new EventCachedInitial(toReturn);
		listener.astChanged(event);
	}
}