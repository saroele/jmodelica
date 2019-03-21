/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.0 */
package org.jmodelica.modelica.compiler;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;
import org.jmodelica.util.BinaryOperation;
import org.jmodelica.util.StringUtil;
import org.jmodelica.util.collections.ConstArrayIterator;
import org.jmodelica.util.collections.SingleIterator;
import org.jmodelica.util.values.ConstValue;
import org.jmodelica.util.values.Evaluable;
import org.jmodelica.util.values.ConstantEvaluationException;
import org.jmodelica.util.values.ConstantEvaluationNotReadyException;
import org.jmodelica.util.values.FunctionEvaluationException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Timer;
import java.util.TimerTask;
import org.jmodelica.common.evaluation.ExternalFunction;
import org.jmodelica.common.evaluation.ExternalProcessCache;
import org.jmodelica.common.evaluation.ExternalProcessCacheImpl;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache;
import org.jmodelica.common.evaluation.ProcessCommunicator;
import org.jmodelica.common.ast.prefixes.EquationType;
import org.jmodelica.common.ast.prefixes.TypePrefixInputOutput;
import org.jmodelica.common.ast.prefixes.VisibilityType;
import org.jmodelica.util.Precedence;
import java.util.LinkedHashSet;
import java.util.EnumMap;
import java.io.File;
import java.math.BigInteger;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.DigestOutputStream;
import java.security.NoSuchAlgorithmException;
import org.jmodelica.common.GUIDManager;
import org.jmodelica.util.streams.StreamGobbler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.jmodelica.util.logging.StreamingLogger;
import org.jmodelica.util.logging.Level;
import org.jmodelica.util.AbstractModelicaScanner;
import beaver.Symbol;
import java.io.ByteArrayOutputStream;
import org.jmodelica.util.streams.CodeStream;
import org.jmodelica.util.streams.NotNullCodeStream;
import java.util.TreeSet;
import org.jmodelica.util.collections.ParallelIterable;
import org.jmodelica.util.ErrorCheckType;
import org.jmodelica.util.problemHandling.SimpleProblemProducer;
import org.jmodelica.util.problemHandling.SimpleWarningProducer;
import org.jmodelica.util.problemHandling.SimpleErrorProducer;
import org.jmodelica.util.problemHandling.ComplianceFMUOnlyProducer;
import org.jmodelica.common.URIResolver;
import org.jmodelica.common.URIResolver.URIException;
import java.util.LinkedList;
import org.jmodelica.util.collections.ListMap;
import org.jmodelica.util.collections.LinkedHashListMap;
import org.jmodelica.api.problemHandling.Problem;
import org.jmodelica.api.problemHandling.ProblemSeverity;
import org.jmodelica.api.problemHandling.ProblemKind;
import org.jmodelica.util.problemHandling.ReporterNode;
import org.jmodelica.util.problemHandling.ProblemOptionsProvider;
import org.jmodelica.util.Criteria;
import org.jmodelica.util.problemHandling.ErrorProducerUnlessDisabled;
import org.jmodelica.util.problemHandling.AbstractErrorProducerUnlessDisabled;
import org.jmodelica.util.collections.ReverseListIterable;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import org.jmodelica.util.Enumerator;
import org.jmodelica.util.collections.GrowableSetIterable;
import java.util.Stack;
import org.jmodelica.util.collections.FilteredIterator;
import org.jmodelica.util.collections.FilteredIterable;
import java.util.SortedSet;
import java.util.Comparator;
import org.jmodelica.common.options.OptionRegistry;
import org.jmodelica.util.problemHandling.ProblemProducer;
import org.jmodelica.util.AdjustableSymbol;
import org.jmodelica.util.QualifiedName;
import org.jmodelica.util.collections.SubClassIterator;
import org.jmodelica.util.collections.SingleIterable;
import org.jmodelica.util.collections.ChainedIterable;
import org.jmodelica.util.collections.NestledIterator;
import org.jmodelica.util.collections.NestledIterable;
import org.jmodelica.util.collections.SubClassIterable;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import org.jmodelica.util.collections.ChainedIterator;
import org.jmodelica.util.annotations.AnnotationProvider;
import org.jmodelica.util.annotations.AnnotationProvider.SubNodePair;
import org.jmodelica.util.annotations.FailedToSetAnnotationValueException;
import org.jmodelica.util.annotations.GenericAnnotationNode;
import org.jmodelica.util.annotations.IterableAnnotationProvider;
import org.jmodelica.util.collections.TransformerIterable;
import org.jmodelica.util.values.Evaluator;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.net.URI;
import java.net.URISyntaxException;
import org.jmodelica.util.formatting.FormattingRecorder;
import org.jmodelica.util.formatting.DefaultFormattingRecorder;
import org.jmodelica.common.ResourceLoader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;
import java.util.IdentityHashMap;
import org.jmodelica.util.streams.NullStream;
import org.jmodelica.util.problemHandling.SanityProblemProducer;
import java.util.EnumSet;
import org.jmodelica.util.munkres.DenseMunkresProblem;
import org.jmodelica.util.munkres.IntegerCost;
import java.util.BitSet;
import org.jmodelica.util.exceptions.BLTException;
import java.util.ListIterator;
import java.util.TreeMap;
import java.util.Random;
import org.jmodelica.util.collections.HashStack;
import org.jmodelica.util.tarjan.Tarjan;
import org.jmodelica.util.tarjan.SimpleTarjan;
import org.jmodelica.util.tarjan.TarjanComponent;
import org.jmodelica.util.exceptions.MunkresException;
import org.jmodelica.util.exceptions.IndexReductionException;
import org.jmodelica.util.munkres.SparseMunkresProblem;
import org.jmodelica.util.munkres.MunkresProblem;
import org.jmodelica.util.munkres.MunkresCost;
import org.jmodelica.util.Solvability;
import java.io.*;
import java.lang.reflect.Constructor;
import org.jmodelica.util.XMLUtil;
import java.io.OutputStream;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import org.jmodelica.util.collections.ListUtil;
import java.io.FileReader;
import org.jmodelica.util.test.GenericTestCase;
import org.jmodelica.util.test.Assert;
import org.jmodelica.util.CompiledUnit;
import org.jmodelica.util.logging.units.LoggingUnit;
import org.jmodelica.util.test.GenericTestSuite;
import org.jmodelica.util.test.TestTree;
import org.jmodelica.common.options.TestOptions;
import org.jmodelica.util.AbstractFlatModelicaScanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jmodelica.util.streams.CStringCodeStream;
import org.jmodelica.common.ccodegen.CFuncParamDirection;
import org.jmodelica.util.exceptions.CompilerException;
import java.util.Deque;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.InterruptedException;
import java.lang.StringBuilder;
import java.nio.channels.FileChannel;
import java.util.Hashtable;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipEntry;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.jmodelica.util.logging.ModelicaLogger;
import org.jmodelica.util.logging.MemoryLogger;
import org.jmodelica.common.options.OptionRegistry.UnknownOptionException;
import org.jmodelica.util.Arguments;
import org.jmodelica.util.SymbolValueFixer;
import org.jmodelica.util.EnvironmentUtils;
import org.jmodelica.util.exceptions.ModelicaException;
import org.jmodelica.util.exceptions.InternalCompilerError;
import org.jmodelica.util.MemorySpider;
import org.jmodelica.util.exceptions.IllegalCompilerArgumentException;
import org.jmodelica.util.exceptions.ModelicaClassNotFoundException;
import org.jmodelica.util.exceptions.JModelicaHomeNotFoundException;
import org.jmodelica.util.exceptions.PackingFailedException;
import org.jmodelica.util.exceptions.CcodeCompilationException;
import org.jmodelica.util.PassAndForget;
import org.jmodelica.util.logging.IllegalLogStringException;
import org.jmodelica.util.streams.*;
import org.jmodelica.util.files.*;
import org.jmodelica.util.ccompiler.CCompilerArguments;
import org.jmodelica.util.ccompiler.CCompilerDelegator;
import org.jmodelica.util.ccompiler.CCompilerDelegator.Creator;
import org.jmodelica.util.ccompiler.CCompilerTarget;
import org.jmodelica.util.ccompiler.GccCompilerDelegator;
import org.jmodelica.common.LogContainer;
import org.jmodelica.modelica.compiler.generated.OptionsAggregated;
import org.xml.sax.SAXException;
import ifcasadi.ifcasadi;
import ifcasadi.GenericType;
import ifcasadi.MX;
import ifcasadi.MXFunction;
import ifcasadi.MXVector;
/**
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\Modelica.ast:247
 * @astdecl SrcForClauseE : SrcAbstractEquation ::= SrcForIndex* SrcAbstractEquation*;
 * @production SrcForClauseE : {@link SrcAbstractEquation} ::= <span class="component">{@link SrcForIndex}*</span> <span class="component">{@link SrcAbstractEquation}*</span>;

 */
public class SrcForClauseE extends SrcAbstractEquation implements Cloneable {
    /**
     * @aspect InstantiatedExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:3345
     */
    public InstForClauseE instantiate() {
        List<InstForIndex> forIndex = new List();
        List<FAbstractEquation> eqns = new List();
        for (SrcForIndex fi : getSrcForIndexs()) {
            forIndex.add(fi.instantiate());     
        }
        for (SrcAbstractEquation ae : getSrcAbstractEquations()) {
            eqns.add(ae.instantiate());
        }
        return copyStringComment(new InstForClauseE(equationType(), forIndex, eqns));
    }
    /**
     * @declaredat ASTNode:1
     */
    public SrcForClauseE() {
        super();
    }
    /**
     * Initializes the child array to the correct size.
     * Initializes List and Opt nta children.
     * @apilevel internal
     * @ast method
     * @declaredat ASTNode:10
     */
    public void init$Children() {
        children = new ASTNode[3];
        setChild(List.EMPTY, 1);
        setChild(List.EMPTY, 2);
    }
    /**
     * @declaredat ASTNode:15
     */
    @ASTNodeAnnotation.Constructor(
        name = {"SrcComment", "SrcForIndex", "SrcAbstractEquation"},
        type = {"SrcComment", "List<SrcForIndex>", "List<SrcAbstractEquation>"},
        kind = {"Child", "List", "List"}
    )
    public SrcForClauseE(SrcComment p0, List<SrcForIndex> p1, List<SrcAbstractEquation> p2) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:26
     */
    protected int numChildren() {
        return 3;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:32
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:36
     */
    public void flushAttrCache() {
        super.flushAttrCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:40
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:44
     */
    public SrcForClauseE clone() throws CloneNotSupportedException {
        SrcForClauseE node = (SrcForClauseE) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:49
     */
    public SrcForClauseE copy() {
        try {
            SrcForClauseE node = (SrcForClauseE) clone();
            node.parent = null;
            if (children != null) {
                node.children = (ASTNode[]) children.clone();
            }
            return node;
        } catch (CloneNotSupportedException e) {
            throw new Error("Error: clone not supported for " + getClass().getName());
        }
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @deprecated Please use treeCopy or treeCopyNoTransform instead
     * @declaredat ASTNode:68
     */
    @Deprecated
    public SrcForClauseE fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:78
     */
    public SrcForClauseE treeCopyNoTransform() {
        SrcForClauseE tree = (SrcForClauseE) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                ASTNode child = (ASTNode) children[i];
                if (child != null) {
                    child = child.treeCopyNoTransform();
                    tree.setChild(child, i);
                }
            }
        }
        return tree;
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The subtree of this node is traversed to trigger rewrites before copy.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:98
     */
    public SrcForClauseE treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:103
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the SrcComment child.
     * @param node The new node to replace the SrcComment child.
     * @apilevel high-level
     */
    public void setSrcComment(SrcComment node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the SrcComment child.
     * @return The current node used as the SrcComment child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="SrcComment")
    public SrcComment getSrcComment() {
        return (SrcComment) getChild(0);
    }
    /**
     * Retrieves the SrcComment child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the SrcComment child.
     * @apilevel low-level
     */
    public SrcComment getSrcCommentNoTransform() {
        return (SrcComment) getChildNoTransform(0);
    }
    /**
     * Replaces the SrcForIndex list.
     * @param list The new list node to be used as the SrcForIndex list.
     * @apilevel high-level
     */
    public void setSrcForIndexList(List<SrcForIndex> list) {
        setChild(list, 1);
    }
    /**
     * Retrieves the number of children in the SrcForIndex list.
     * @return Number of children in the SrcForIndex list.
     * @apilevel high-level
     */
    public int getNumSrcForIndex() {
        return getSrcForIndexList().getNumChild();
    }
    /**
     * Retrieves the number of children in the SrcForIndex list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the SrcForIndex list.
     * @apilevel low-level
     */
    public int getNumSrcForIndexNoTransform() {
        return getSrcForIndexListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the SrcForIndex list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the SrcForIndex list.
     * @apilevel high-level
     */
    public SrcForIndex getSrcForIndex(int i) {
        return (SrcForIndex) getSrcForIndexList().getChild(i);
    }
    /**
     * Check whether the SrcForIndex list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasSrcForIndex() {
        return getSrcForIndexList().getNumChild() != 0;
    }
    /**
     * Append an element to the SrcForIndex list.
     * @param node The element to append to the SrcForIndex list.
     * @apilevel high-level
     */
    public void addSrcForIndex(SrcForIndex node) {
        List<SrcForIndex> list = (parent == null) ? getSrcForIndexListNoTransform() : getSrcForIndexList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addSrcForIndexNoTransform(SrcForIndex node) {
        List<SrcForIndex> list = getSrcForIndexListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the SrcForIndex list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setSrcForIndex(SrcForIndex node, int i) {
        List<SrcForIndex> list = getSrcForIndexList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the SrcForIndex list.
     * @return The node representing the SrcForIndex list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="SrcForIndex")
    public List<SrcForIndex> getSrcForIndexList() {
        List<SrcForIndex> list = (List<SrcForIndex>) getChild(1);
        return list;
    }
    /**
     * Retrieves the SrcForIndex list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the SrcForIndex list.
     * @apilevel low-level
     */
    public List<SrcForIndex> getSrcForIndexListNoTransform() {
        return (List<SrcForIndex>) getChildNoTransform(1);
    }
    /**
     * @return the element at index {@code i} in the SrcForIndex list without
     * triggering rewrites.
     */
    public SrcForIndex getSrcForIndexNoTransform(int i) {
        return (SrcForIndex) getSrcForIndexListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the SrcForIndex list.
     * @return The node representing the SrcForIndex list.
     * @apilevel high-level
     */
    public List<SrcForIndex> getSrcForIndexs() {
        return getSrcForIndexList();
    }
    /**
     * Retrieves the SrcForIndex list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the SrcForIndex list.
     * @apilevel low-level
     */
    public List<SrcForIndex> getSrcForIndexsNoTransform() {
        return getSrcForIndexListNoTransform();
    }
    /**
     * Replaces the SrcAbstractEquation list.
     * @param list The new list node to be used as the SrcAbstractEquation list.
     * @apilevel high-level
     */
    public void setSrcAbstractEquationList(List<SrcAbstractEquation> list) {
        setChild(list, 2);
    }
    /**
     * Retrieves the number of children in the SrcAbstractEquation list.
     * @return Number of children in the SrcAbstractEquation list.
     * @apilevel high-level
     */
    public int getNumSrcAbstractEquation() {
        return getSrcAbstractEquationList().getNumChild();
    }
    /**
     * Retrieves the number of children in the SrcAbstractEquation list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the SrcAbstractEquation list.
     * @apilevel low-level
     */
    public int getNumSrcAbstractEquationNoTransform() {
        return getSrcAbstractEquationListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the SrcAbstractEquation list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the SrcAbstractEquation list.
     * @apilevel high-level
     */
    public SrcAbstractEquation getSrcAbstractEquation(int i) {
        return (SrcAbstractEquation) getSrcAbstractEquationList().getChild(i);
    }
    /**
     * Check whether the SrcAbstractEquation list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasSrcAbstractEquation() {
        return getSrcAbstractEquationList().getNumChild() != 0;
    }
    /**
     * Append an element to the SrcAbstractEquation list.
     * @param node The element to append to the SrcAbstractEquation list.
     * @apilevel high-level
     */
    public void addSrcAbstractEquation(SrcAbstractEquation node) {
        List<SrcAbstractEquation> list = (parent == null) ? getSrcAbstractEquationListNoTransform() : getSrcAbstractEquationList();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addSrcAbstractEquationNoTransform(SrcAbstractEquation node) {
        List<SrcAbstractEquation> list = getSrcAbstractEquationListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the SrcAbstractEquation list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setSrcAbstractEquation(SrcAbstractEquation node, int i) {
        List<SrcAbstractEquation> list = getSrcAbstractEquationList();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the SrcAbstractEquation list.
     * @return The node representing the SrcAbstractEquation list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="SrcAbstractEquation")
    public List<SrcAbstractEquation> getSrcAbstractEquationList() {
        List<SrcAbstractEquation> list = (List<SrcAbstractEquation>) getChild(2);
        return list;
    }
    /**
     * Retrieves the SrcAbstractEquation list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the SrcAbstractEquation list.
     * @apilevel low-level
     */
    public List<SrcAbstractEquation> getSrcAbstractEquationListNoTransform() {
        return (List<SrcAbstractEquation>) getChildNoTransform(2);
    }
    /**
     * @return the element at index {@code i} in the SrcAbstractEquation list without
     * triggering rewrites.
     */
    public SrcAbstractEquation getSrcAbstractEquationNoTransform(int i) {
        return (SrcAbstractEquation) getSrcAbstractEquationListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the SrcAbstractEquation list.
     * @return The node representing the SrcAbstractEquation list.
     * @apilevel high-level
     */
    public List<SrcAbstractEquation> getSrcAbstractEquations() {
        return getSrcAbstractEquationList();
    }
    /**
     * Retrieves the SrcAbstractEquation list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the SrcAbstractEquation list.
     * @apilevel low-level
     */
    public List<SrcAbstractEquation> getSrcAbstractEquationsNoTransform() {
        return getSrcAbstractEquationListNoTransform();
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
