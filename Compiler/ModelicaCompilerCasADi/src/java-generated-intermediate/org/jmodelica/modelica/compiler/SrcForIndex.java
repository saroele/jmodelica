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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\Modelica.ast:251
 * @astdecl SrcForIndex : SrcComponentClause ::= [SrcExp];
 * @production SrcForIndex : {@link SrcComponentClause} ::= <span class="component">[{@link SrcExp}]</span>;

 */
public class SrcForIndex extends SrcComponentClause implements Cloneable {
    /**
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:528
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
		str.print(getSrcForIndexDecl().name());
		if (hasSrcExp()) {
			str.print(" in ");
			p.print(getSrcExp(), str, indent);
		}
	}
    /**
     * @aspect InstantiatedExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:3332
     */
    public InstForIndex instantiate() {
        InstForIndexPrimitive ip = new InstForIndexPrimitive(getSrcForIndexDecl().name(), 
                new InstParseAccess("Integer"), new Opt<FArraySubscripts>(), getSrcForIndexDecl(), 
                new Opt<InstModification>(), new Opt<InstConstrainingComponent>(), new Opt<FExp>());
        InstForIndex res;
        if (hasSrcExp()) {
            res = new InstForIndexWithExp(ip, getSrcExp().instantiate());
        } else {
            res = new InstForIndexNoExp(ip);
        }
        return copyLocationTo(res);
    }
    /**
     * @declaredat ASTNode:1
     */
    public SrcForIndex() {
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
        children = new ASTNode[9];
        setChild(Opt.EMPTY, 0);
        setChild(Opt.EMPTY, 1);
        setChild(Opt.EMPTY, 2);
        setChild(Opt.EMPTY, 4);
        setChild(List.EMPTY, 5);
        setChild(Opt.EMPTY, 6);
        setChild(Opt.EMPTY, 8);
    }
    /**
     * @declaredat ASTNode:20
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Redeclare", "Final", "Inner", "Outer", "Replaceable", "SrcTypePrefixFlow", "SrcTypePrefixVariability", "SrcTypePrefixInputOutput", "ClassName", "TypeArraySubscripts", "SrcComponentDecl", "SrcConstrainingClause", "SrcComment", "SrcExp"},
        type = {"boolean", "boolean", "boolean", "boolean", "boolean", "Opt<SrcTypePrefixFlow>", "Opt<SrcTypePrefixVariability>", "Opt<SrcTypePrefixInputOutput>", "SrcAccess", "Opt<SrcArraySubscripts>", "List<SrcComponentDecl>", "Opt<SrcConstrainingClause>", "SrcComment", "Opt<SrcExp>"},
        kind = {"Token", "Token", "Token", "Token", "Token", "Opt", "Opt", "Opt", "Child", "Opt", "List", "Opt", "Child", "Opt"}
    )
    public SrcForIndex(boolean p0, boolean p1, boolean p2, boolean p3, boolean p4, Opt<SrcTypePrefixFlow> p5, Opt<SrcTypePrefixVariability> p6, Opt<SrcTypePrefixInputOutput> p7, SrcAccess p8, Opt<SrcArraySubscripts> p9, List<SrcComponentDecl> p10, Opt<SrcConstrainingClause> p11, SrcComment p12, Opt<SrcExp> p13) {
        setRedeclare(p0);
        setFinal(p1);
        setInner(p2);
        setOuter(p3);
        setReplaceable(p4);
        setChild(p5, 0);
        setChild(p6, 1);
        setChild(p7, 2);
        setChild(p8, 3);
        setChild(p9, 4);
        setChild(p10, 5);
        setChild(p11, 6);
        setChild(p12, 7);
        setChild(p13, 8);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:42
     */
    protected int numChildren() {
        return 9;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:48
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:52
     */
    public void flushAttrCache() {
        super.flushAttrCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:56
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:60
     */
    public SrcForIndex clone() throws CloneNotSupportedException {
        SrcForIndex node = (SrcForIndex) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:65
     */
    public SrcForIndex copy() {
        try {
            SrcForIndex node = (SrcForIndex) clone();
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
     * @declaredat ASTNode:84
     */
    @Deprecated
    public SrcForIndex fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:94
     */
    public SrcForIndex treeCopyNoTransform() {
        SrcForIndex tree = (SrcForIndex) copy();
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
     * @declaredat ASTNode:114
     */
    public SrcForIndex treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:119
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenboolean_Redeclare == ((SrcForIndex) node).tokenboolean_Redeclare) && (tokenboolean_Final == ((SrcForIndex) node).tokenboolean_Final) && (tokenboolean_Inner == ((SrcForIndex) node).tokenboolean_Inner) && (tokenboolean_Outer == ((SrcForIndex) node).tokenboolean_Outer) && (tokenboolean_Replaceable == ((SrcForIndex) node).tokenboolean_Replaceable);    
    }
    /**
     * Replaces the lexeme Redeclare.
     * @param value The new value for the lexeme Redeclare.
     * @apilevel high-level
     */
    public void setRedeclare(boolean value) {
        tokenboolean_Redeclare = value;
    }
    /**
     * Retrieves the value for the lexeme Redeclare.
     * @return The value for the lexeme Redeclare.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Redeclare")
    public boolean getRedeclare() {
        return tokenboolean_Redeclare;
    }
    /**
     * Replaces the lexeme Final.
     * @param value The new value for the lexeme Final.
     * @apilevel high-level
     */
    public void setFinal(boolean value) {
        tokenboolean_Final = value;
    }
    /**
     * Retrieves the value for the lexeme Final.
     * @return The value for the lexeme Final.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Final")
    public boolean getFinal() {
        return tokenboolean_Final;
    }
    /**
     * Replaces the lexeme Inner.
     * @param value The new value for the lexeme Inner.
     * @apilevel high-level
     */
    public void setInner(boolean value) {
        tokenboolean_Inner = value;
    }
    /**
     * Retrieves the value for the lexeme Inner.
     * @return The value for the lexeme Inner.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Inner")
    public boolean getInner() {
        return tokenboolean_Inner;
    }
    /**
     * Replaces the lexeme Outer.
     * @param value The new value for the lexeme Outer.
     * @apilevel high-level
     */
    public void setOuter(boolean value) {
        tokenboolean_Outer = value;
    }
    /**
     * Retrieves the value for the lexeme Outer.
     * @return The value for the lexeme Outer.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Outer")
    public boolean getOuter() {
        return tokenboolean_Outer;
    }
    /**
     * Replaces the lexeme Replaceable.
     * @param value The new value for the lexeme Replaceable.
     * @apilevel high-level
     */
    public void setReplaceable(boolean value) {
        tokenboolean_Replaceable = value;
    }
    /**
     * Retrieves the value for the lexeme Replaceable.
     * @return The value for the lexeme Replaceable.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Replaceable")
    public boolean getReplaceable() {
        return tokenboolean_Replaceable;
    }
    /**
     * Replaces the optional node for the SrcTypePrefixFlow child. This is the <code>Opt</code>
     * node containing the child SrcTypePrefixFlow, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcTypePrefixFlow child.
     * @apilevel low-level
     */
    public void setSrcTypePrefixFlowOpt(Opt<SrcTypePrefixFlow> opt) {
        setChild(opt, 0);
    }
    /**
     * Replaces the (optional) SrcTypePrefixFlow child.
     * @param node The new node to be used as the SrcTypePrefixFlow child.
     * @apilevel high-level
     */
    public void setSrcTypePrefixFlow(SrcTypePrefixFlow node) {
        if (node != null) {
            setChild(new Opt(node), 0);
        } else {
            setChild(Opt.EMPTY, 0);
        }
    }
    /**
     * Check whether the optional SrcTypePrefixFlow child exists.
     * @return {@code true} if the optional SrcTypePrefixFlow child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcTypePrefixFlow() {
        return getSrcTypePrefixFlowOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcTypePrefixFlow child.
     * @return The SrcTypePrefixFlow child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcTypePrefixFlow getSrcTypePrefixFlow() {
        return (SrcTypePrefixFlow) getSrcTypePrefixFlowOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcTypePrefixFlow child. This is the <code>Opt</code> node containing the child SrcTypePrefixFlow, not the actual child!
     * @return The optional node for child the SrcTypePrefixFlow child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcTypePrefixFlow")
    public Opt<SrcTypePrefixFlow> getSrcTypePrefixFlowOpt() {
        return (Opt<SrcTypePrefixFlow>) getChild(0);
    }
    /**
     * Retrieves the optional node for child SrcTypePrefixFlow. This is the <code>Opt</code> node containing the child SrcTypePrefixFlow, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcTypePrefixFlow.
     * @apilevel low-level
     */
    public Opt<SrcTypePrefixFlow> getSrcTypePrefixFlowOptNoTransform() {
        return (Opt<SrcTypePrefixFlow>) getChildNoTransform(0);
    }
    /**
     * Replaces the optional node for the SrcTypePrefixVariability child. This is the <code>Opt</code>
     * node containing the child SrcTypePrefixVariability, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcTypePrefixVariability child.
     * @apilevel low-level
     */
    public void setSrcTypePrefixVariabilityOpt(Opt<SrcTypePrefixVariability> opt) {
        setChild(opt, 1);
    }
    /**
     * Replaces the (optional) SrcTypePrefixVariability child.
     * @param node The new node to be used as the SrcTypePrefixVariability child.
     * @apilevel high-level
     */
    public void setSrcTypePrefixVariability(SrcTypePrefixVariability node) {
        if (node != null) {
            setChild(new Opt(node), 1);
        } else {
            setChild(Opt.EMPTY, 1);
        }
    }
    /**
     * Check whether the optional SrcTypePrefixVariability child exists.
     * @return {@code true} if the optional SrcTypePrefixVariability child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcTypePrefixVariability() {
        return getSrcTypePrefixVariabilityOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcTypePrefixVariability child.
     * @return The SrcTypePrefixVariability child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcTypePrefixVariability getSrcTypePrefixVariability() {
        return (SrcTypePrefixVariability) getSrcTypePrefixVariabilityOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcTypePrefixVariability child. This is the <code>Opt</code> node containing the child SrcTypePrefixVariability, not the actual child!
     * @return The optional node for child the SrcTypePrefixVariability child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcTypePrefixVariability")
    public Opt<SrcTypePrefixVariability> getSrcTypePrefixVariabilityOpt() {
        return (Opt<SrcTypePrefixVariability>) getChild(1);
    }
    /**
     * Retrieves the optional node for child SrcTypePrefixVariability. This is the <code>Opt</code> node containing the child SrcTypePrefixVariability, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcTypePrefixVariability.
     * @apilevel low-level
     */
    public Opt<SrcTypePrefixVariability> getSrcTypePrefixVariabilityOptNoTransform() {
        return (Opt<SrcTypePrefixVariability>) getChildNoTransform(1);
    }
    /**
     * Replaces the optional node for the SrcTypePrefixInputOutput child. This is the <code>Opt</code>
     * node containing the child SrcTypePrefixInputOutput, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcTypePrefixInputOutput child.
     * @apilevel low-level
     */
    public void setSrcTypePrefixInputOutputOpt(Opt<SrcTypePrefixInputOutput> opt) {
        setChild(opt, 2);
    }
    /**
     * Replaces the (optional) SrcTypePrefixInputOutput child.
     * @param node The new node to be used as the SrcTypePrefixInputOutput child.
     * @apilevel high-level
     */
    public void setSrcTypePrefixInputOutput(SrcTypePrefixInputOutput node) {
        if (node != null) {
            setChild(new Opt(node), 2);
        } else {
            setChild(Opt.EMPTY, 2);
        }
    }
    /**
     * Check whether the optional SrcTypePrefixInputOutput child exists.
     * @return {@code true} if the optional SrcTypePrefixInputOutput child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcTypePrefixInputOutput() {
        return getSrcTypePrefixInputOutputOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcTypePrefixInputOutput child.
     * @return The SrcTypePrefixInputOutput child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcTypePrefixInputOutput getSrcTypePrefixInputOutput() {
        return (SrcTypePrefixInputOutput) getSrcTypePrefixInputOutputOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcTypePrefixInputOutput child. This is the <code>Opt</code> node containing the child SrcTypePrefixInputOutput, not the actual child!
     * @return The optional node for child the SrcTypePrefixInputOutput child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcTypePrefixInputOutput")
    public Opt<SrcTypePrefixInputOutput> getSrcTypePrefixInputOutputOpt() {
        return (Opt<SrcTypePrefixInputOutput>) getChild(2);
    }
    /**
     * Retrieves the optional node for child SrcTypePrefixInputOutput. This is the <code>Opt</code> node containing the child SrcTypePrefixInputOutput, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcTypePrefixInputOutput.
     * @apilevel low-level
     */
    public Opt<SrcTypePrefixInputOutput> getSrcTypePrefixInputOutputOptNoTransform() {
        return (Opt<SrcTypePrefixInputOutput>) getChildNoTransform(2);
    }
    /**
     * Replaces the ClassName child.
     * @param node The new node to replace the ClassName child.
     * @apilevel high-level
     */
    public void setClassName(SrcAccess node) {
        setChild(node, 3);
    }
    /**
     * Retrieves the ClassName child.
     * @return The current node used as the ClassName child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="ClassName")
    public SrcAccess getClassName() {
        return (SrcAccess) getChild(3);
    }
    /**
     * Retrieves the ClassName child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the ClassName child.
     * @apilevel low-level
     */
    public SrcAccess getClassNameNoTransform() {
        return (SrcAccess) getChildNoTransform(3);
    }
    /**
     * Replaces the optional node for the TypeArraySubscripts child. This is the <code>Opt</code>
     * node containing the child TypeArraySubscripts, not the actual child!
     * @param opt The new node to be used as the optional node for the TypeArraySubscripts child.
     * @apilevel low-level
     */
    public void setTypeArraySubscriptsOpt(Opt<SrcArraySubscripts> opt) {
        setChild(opt, 4);
    }
    /**
     * Replaces the (optional) TypeArraySubscripts child.
     * @param node The new node to be used as the TypeArraySubscripts child.
     * @apilevel high-level
     */
    public void setTypeArraySubscripts(SrcArraySubscripts node) {
        if (node != null) {
            setChild(new Opt(node), 4);
        } else {
            setChild(Opt.EMPTY, 4);
        }
    }
    /**
     * Check whether the optional TypeArraySubscripts child exists.
     * @return {@code true} if the optional TypeArraySubscripts child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasTypeArraySubscripts() {
        return getTypeArraySubscriptsOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) TypeArraySubscripts child.
     * @return The TypeArraySubscripts child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcArraySubscripts getTypeArraySubscripts() {
        return (SrcArraySubscripts) getTypeArraySubscriptsOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the TypeArraySubscripts child. This is the <code>Opt</code> node containing the child TypeArraySubscripts, not the actual child!
     * @return The optional node for child the TypeArraySubscripts child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="TypeArraySubscripts")
    public Opt<SrcArraySubscripts> getTypeArraySubscriptsOpt() {
        return (Opt<SrcArraySubscripts>) getChild(4);
    }
    /**
     * Retrieves the optional node for child TypeArraySubscripts. This is the <code>Opt</code> node containing the child TypeArraySubscripts, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child TypeArraySubscripts.
     * @apilevel low-level
     */
    public Opt<SrcArraySubscripts> getTypeArraySubscriptsOptNoTransform() {
        return (Opt<SrcArraySubscripts>) getChildNoTransform(4);
    }
    /**
     * Replaces the SrcComponentDecl list.
     * @param list The new list node to be used as the SrcComponentDecl list.
     * @apilevel high-level
     */
    public void setSrcComponentDeclList(List<SrcComponentDecl> list) {
        setChild(list, 5);
    }
    /**
     * Retrieves the number of children in the SrcComponentDecl list.
     * @return Number of children in the SrcComponentDecl list.
     * @apilevel high-level
     */
    public int getNumSrcComponentDecl() {
        return getSrcComponentDeclList().getNumChild();
    }
    /**
     * Retrieves the number of children in the SrcComponentDecl list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the SrcComponentDecl list.
     * @apilevel low-level
     */
    public int getNumSrcComponentDeclNoTransform() {
        return getSrcComponentDeclListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the SrcComponentDecl list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the SrcComponentDecl list.
     * @apilevel high-level
     */
    public SrcComponentDecl getSrcComponentDecl(int i) {
        return (SrcComponentDecl) getSrcComponentDeclList().getChild(i);
    }
    /**
     * Check whether the SrcComponentDecl list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasSrcComponentDecl() {
        return getSrcComponentDeclList().getNumChild() != 0;
    }
    /**
     * Append an element to the SrcComponentDecl list.
     * @param node The element to append to the SrcComponentDecl list.
     * @apilevel high-level
     */
    public void addSrcComponentDecl(SrcComponentDecl node) {
        List<SrcComponentDecl> list = (parent == null) ? getSrcComponentDeclListNoTransform() : getSrcComponentDeclList();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addSrcComponentDeclNoTransform(SrcComponentDecl node) {
        List<SrcComponentDecl> list = getSrcComponentDeclListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the SrcComponentDecl list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setSrcComponentDecl(SrcComponentDecl node, int i) {
        List<SrcComponentDecl> list = getSrcComponentDeclList();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the SrcComponentDecl list.
     * @return The node representing the SrcComponentDecl list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="SrcComponentDecl")
    public List<SrcComponentDecl> getSrcComponentDeclList() {
        List<SrcComponentDecl> list = (List<SrcComponentDecl>) getChild(5);
        return list;
    }
    /**
     * Retrieves the SrcComponentDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the SrcComponentDecl list.
     * @apilevel low-level
     */
    public List<SrcComponentDecl> getSrcComponentDeclListNoTransform() {
        return (List<SrcComponentDecl>) getChildNoTransform(5);
    }
    /**
     * @return the element at index {@code i} in the SrcComponentDecl list without
     * triggering rewrites.
     */
    public SrcComponentDecl getSrcComponentDeclNoTransform(int i) {
        return (SrcComponentDecl) getSrcComponentDeclListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the SrcComponentDecl list.
     * @return The node representing the SrcComponentDecl list.
     * @apilevel high-level
     */
    public List<SrcComponentDecl> getSrcComponentDecls() {
        return getSrcComponentDeclList();
    }
    /**
     * Retrieves the SrcComponentDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the SrcComponentDecl list.
     * @apilevel low-level
     */
    public List<SrcComponentDecl> getSrcComponentDeclsNoTransform() {
        return getSrcComponentDeclListNoTransform();
    }
    /**
     * Replaces the optional node for the SrcConstrainingClause child. This is the <code>Opt</code>
     * node containing the child SrcConstrainingClause, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcConstrainingClause child.
     * @apilevel low-level
     */
    public void setSrcConstrainingClauseOpt(Opt<SrcConstrainingClause> opt) {
        setChild(opt, 6);
    }
    /**
     * Replaces the (optional) SrcConstrainingClause child.
     * @param node The new node to be used as the SrcConstrainingClause child.
     * @apilevel high-level
     */
    public void setSrcConstrainingClause(SrcConstrainingClause node) {
        if (node != null) {
            setChild(new Opt(node), 6);
        } else {
            setChild(Opt.EMPTY, 6);
        }
    }
    /**
     * Check whether the optional SrcConstrainingClause child exists.
     * @return {@code true} if the optional SrcConstrainingClause child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcConstrainingClause() {
        return getSrcConstrainingClauseOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcConstrainingClause child.
     * @return The SrcConstrainingClause child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcConstrainingClause getSrcConstrainingClause() {
        return (SrcConstrainingClause) getSrcConstrainingClauseOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcConstrainingClause child. This is the <code>Opt</code> node containing the child SrcConstrainingClause, not the actual child!
     * @return The optional node for child the SrcConstrainingClause child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcConstrainingClause")
    public Opt<SrcConstrainingClause> getSrcConstrainingClauseOpt() {
        return (Opt<SrcConstrainingClause>) getChild(6);
    }
    /**
     * Retrieves the optional node for child SrcConstrainingClause. This is the <code>Opt</code> node containing the child SrcConstrainingClause, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcConstrainingClause.
     * @apilevel low-level
     */
    public Opt<SrcConstrainingClause> getSrcConstrainingClauseOptNoTransform() {
        return (Opt<SrcConstrainingClause>) getChildNoTransform(6);
    }
    /**
     * Replaces the SrcComment child.
     * @param node The new node to replace the SrcComment child.
     * @apilevel high-level
     */
    public void setSrcComment(SrcComment node) {
        setChild(node, 7);
    }
    /**
     * Retrieves the SrcComment child.
     * @return The current node used as the SrcComment child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="SrcComment")
    public SrcComment getSrcComment() {
        return (SrcComment) getChild(7);
    }
    /**
     * Retrieves the SrcComment child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the SrcComment child.
     * @apilevel low-level
     */
    public SrcComment getSrcCommentNoTransform() {
        return (SrcComment) getChildNoTransform(7);
    }
    /**
     * Replaces the optional node for the SrcExp child. This is the <code>Opt</code>
     * node containing the child SrcExp, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcExp child.
     * @apilevel low-level
     */
    public void setSrcExpOpt(Opt<SrcExp> opt) {
        setChild(opt, 8);
    }
    /**
     * Replaces the (optional) SrcExp child.
     * @param node The new node to be used as the SrcExp child.
     * @apilevel high-level
     */
    public void setSrcExp(SrcExp node) {
        if (node != null) {
            setChild(new Opt(node), 8);
        } else {
            setChild(Opt.EMPTY, 8);
        }
    }
    /**
     * Check whether the optional SrcExp child exists.
     * @return {@code true} if the optional SrcExp child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcExp() {
        return getSrcExpOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcExp child.
     * @return The SrcExp child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcExp getSrcExp() {
        return (SrcExp) getSrcExpOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcExp child. This is the <code>Opt</code> node containing the child SrcExp, not the actual child!
     * @return The optional node for child the SrcExp child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcExp")
    public Opt<SrcExp> getSrcExpOpt() {
        return (Opt<SrcExp>) getChild(8);
    }
    /**
     * Retrieves the optional node for child SrcExp. This is the <code>Opt</code> node containing the child SrcExp, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcExp.
     * @apilevel low-level
     */
    public Opt<SrcExp> getSrcExpOptNoTransform() {
        return (Opt<SrcExp>) getChildNoTransform(8);
    }
    /**
     * @attribute syn
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:204
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceTraversal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:204")
    public SrcForIndexDecl getSrcForIndexDecl() {
        SrcForIndexDecl getSrcForIndexDecl_value = (SrcForIndexDecl) getSrcComponentDecl(0);
        return getSrcForIndexDecl_value;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
