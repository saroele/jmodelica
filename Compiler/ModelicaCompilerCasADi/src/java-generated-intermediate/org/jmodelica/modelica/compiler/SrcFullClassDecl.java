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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\Modelica.ast:97
 * @astdecl SrcFullClassDecl : SrcBaseClassDecl ::= [SrcStringComment] SrcClause* [SrcExternalClause] [SrcAnnotation] SrcEndDecl;
 * @production SrcFullClassDecl : {@link SrcBaseClassDecl} ::= <span class="component">[{@link SrcStringComment}]</span> <span class="component">{@link SrcClause}*</span> <span class="component">[{@link SrcExternalClause}]</span> <span class="component">[{@link SrcAnnotation}]</span> <span class="component">{@link SrcEndDecl}</span>;

 */
public class SrcFullClassDecl extends SrcBaseClassDecl implements Cloneable, StringCommentSource, ASTNodeWithAnnotation {
    /**
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:321
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
        str.print(indent);
        if (getEncapsulated()) {
            str.print("encapsulated ");
        }
        if (getPartial()) {
            str.print("partial ");
        }
        if (getRedeclare()) {
            str.print("redeclare ");
        }
        if (getFinal()) {
            str.print("final ");
        }
        if (getInner()) {
            str.print("inner ");
        }
        if (getOuter()) {
            str.print("outer ");
        }
        if (getReplaceable()) {
            str.print("replaceable ");
        }
        
        str.print(getSrcRestriction(), " ");
        if (isClassExtends()) {
            str.print("extends ");
        }
        prettyPrintClassName(p, str, indent);
        str.println();

        for (SrcClause cl : getSrcClauses()) {
            p.print(cl, str, indent);
        }
        p.print(getSrcEndDecl(), str, indent);
    }
    /**
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:358
     */
    public void prettyPrintClassName(Printer p, CodeStream str, String indent) {
        p.print(getName(), str, indent);
    }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1388
     */
    public Opt<InstExternal> newInstExternalOpt() {
    	return hasSrcExternalClause() ? new Opt(getSrcExternalClause().instantiate()) : new Opt();
    }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1392
     */
    public InstFullClassDecl newInstClassDecl() {
        InstFullClassDecl fcd = new InstFullClassDecl(this, new Opt(), newInstRestriction(), newInstExternalOpt());
        fcd.setInstConstrainingClassOpt(newInstConstrainingClassOpt(null));
        fcd.setLocation(this);
        return fcd;
    }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1458
     */
    public InstClassDecl createInstReplacingClass(
            SrcClassDecl replacedClass, InstRedeclareClassNode icr, InstRedeclareClassNode cicr) {
        InstRestriction ir = newInstRestriction();
        Opt<InstExternal> exto = newInstExternalOpt();
        SrcClassDecl constrainingDecl = (cicr == null) ? replacedClass : cicr.redeclaringClassDecl();
        InstReplacingFullClassDecl fcd = new InstReplacingFullClassDecl(this, new Opt(), ir, exto, replacedClass, icr);
        fcd.setInstConstrainingClassOpt(constrainingDecl.newInstConstrainingClassOpt(cicr));
        //TODO: Should be constr clause of original or redeclared? 
        // - Should be from redeclared if it has one.
        fcd.setLocation(this);
        return fcd;
    }
    /**
     * Create from a SrcFullClassDecl - will destroy that node!
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:264
     */
    public SrcFullClassDecl(SrcFullClassDecl fcd) {
        this(fcd.getName(),
             fcd.getEncapsulated(),
             fcd.getPartial(),
             fcd.getSrcRestriction(),
             fcd.getRedeclare(),
             fcd.getFinal(),
             fcd.getInner(),
             fcd.getOuter(),
             fcd.getReplaceable(),
             fcd.getSrcConstrainingClauseOpt(),
             fcd.getConstrainingClauseCommentOpt(),
             fcd.getSrcStringCommentOpt(),
             fcd.getSrcClauseList(),
             fcd.getSrcExternalClauseOpt(),
             fcd.getSrcAnnotationOpt(),
             fcd.getSrcEndDecl());
        setLocation(fcd);
    }
    /**
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:691
     */
    public void addBuiltinFunctions(List<? super SrcBaseClassDecl> list, SrcExternalClause builtin) {
        if (isPackage()) {
            List<SrcElement> subList = new List<SrcElement>();
            for (SrcClause cd : getSrcClauses()) {
                cd.addBuiltinFunctions(subList, builtin);
            }
            setSrcClauseList(new List<SrcClause>().add(new SrcDefaultElementList(subList)));
        } else {
            String name = getName().getID();
            if (name.equals("Integer") || name.equals("String")) {
                // Add character that isn't allowed in identifiers to prevent collision with user class or the primitive class
                name = "!" + name;
                getName().setID(name);
                getSrcEndDecl().setEndID(name);
            }
            if (!algorithms().iterator().hasNext()) {
                setSrcExternalClause(builtin.fullCopy());
            }
        }
        list.add(this);
    }
    /**
     * Helper method which looks for the class with the given name among this class's imported classes.
     * Has to be an unqualified classname.
     * This method returns the unknown class when the class isn't found.
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:496
     */
    protected ResolvedAccess simpleLookupInImports(String name) {
        ResolvedAccess res;
        for (SrcImportClause imp : imports()) {
            res = imp.simpleLookupInImport(name);
            if (!res.isUnknown()) {
                return res;
            }
        }
        
        return unknownAccess();
    }
    /**
     * Helper method which looks for the class with the given name among this class's super classes.
     * Has to be an unqualified classname.
     * This method returns the unknown class when the class isn't found.
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:513
     */
    protected ResolvedAccess simpleLookupInExtends(String name) {
        ResolvedAccess res;
        for (SrcExtendsClause superClass : superClasses()) {
            res = superClass.findClassDecl().simpleLookupMemberScope(name);
            if (!res.isUnknown()) {
                return res.fromContext(qualifiedName(), superClass.isProtected());
            }
        }
        
        return unknownAccess();
    }
    /**
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:160
     */
    

        protected abstract class ClauseElementIterator<T> extends NestledIterator<T,SrcClause> {
            public ClauseElementIterator() {
                super(getSrcClauses().iterator());
            }
        }
    /**
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:280
     */
    @Override
    public <T extends SrcClause> Iterable<T> clauses(Class<T> type) {
        return new SubClassIterable<SrcClause, T>(type, getSrcClauses());
    }
    /**
     * @aspect TestFramework
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\TestFramework\\src\\jastadd\\TestFramework.jrag:34
     */
    public boolean collectTestCases(TestSuite ts, String className) {
        if (super.collectTestCases(ts, className)) 
            return true;
        return getSrcClauseList().collectTestCases(ts, className);
    }
    /**
     * @aspect TestFramework
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\TestFramework\\src\\jastadd\\TestFramework.jrag:67
     */
    public void collectTestCases(TestSuite ts) {
        ts.enterClass(name());
        AnnotationNode a1 = annotation("__JModelica/UnitTesting/tests");
        if (a1.exists()) {
            for (AnnotationNode a2 : a1) 
                generateTestCase(ts, a2);
        } else {
            getSrcClauseList().collectTestCases(ts);
        }
        ts.exitClass();
    }
    /**
     * @declaredat ASTNode:1
     */
    public SrcFullClassDecl() {
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
        setChild(Opt.EMPTY, 2);
        setChild(Opt.EMPTY, 3);
        setChild(Opt.EMPTY, 4);
        setChild(List.EMPTY, 5);
        setChild(Opt.EMPTY, 6);
        setChild(Opt.EMPTY, 7);
    }
    /**
     * @declaredat ASTNode:19
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Name", "Encapsulated", "Partial", "SrcRestriction", "Redeclare", "Final", "Inner", "Outer", "Replaceable", "SrcConstrainingClause", "ConstrainingClauseComment", "SrcStringComment", "SrcClause", "SrcExternalClause", "SrcAnnotation", "SrcEndDecl"},
        type = {"SrcIdDecl", "boolean", "boolean", "SrcRestriction", "boolean", "boolean", "boolean", "boolean", "boolean", "Opt<SrcConstrainingClause>", "Opt<SrcComment>", "Opt<SrcStringComment>", "List<SrcClause>", "Opt<SrcExternalClause>", "Opt<SrcAnnotation>", "SrcEndDecl"},
        kind = {"Child", "Token", "Token", "Child", "Token", "Token", "Token", "Token", "Token", "Opt", "Opt", "Opt", "List", "Opt", "Opt", "Child"}
    )
    public SrcFullClassDecl(SrcIdDecl p0, boolean p1, boolean p2, SrcRestriction p3, boolean p4, boolean p5, boolean p6, boolean p7, boolean p8, Opt<SrcConstrainingClause> p9, Opt<SrcComment> p10, Opt<SrcStringComment> p11, List<SrcClause> p12, Opt<SrcExternalClause> p13, Opt<SrcAnnotation> p14, SrcEndDecl p15) {
        setChild(p0, 0);
        setEncapsulated(p1);
        setPartial(p2);
        setChild(p3, 1);
        setRedeclare(p4);
        setFinal(p5);
        setInner(p6);
        setOuter(p7);
        setReplaceable(p8);
        setChild(p9, 2);
        setChild(p10, 3);
        setChild(p11, 4);
        setChild(p12, 5);
        setChild(p13, 6);
        setChild(p14, 7);
        setChild(p15, 8);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:43
     */
    protected int numChildren() {
        return 9;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:49
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:53
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        simpleLookupDefaultScope_String_reset();
        simpleLookupLocalScope_String_reset();
        simpleLookupMemberScope_String_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:60
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:64
     */
    public SrcFullClassDecl clone() throws CloneNotSupportedException {
        SrcFullClassDecl node = (SrcFullClassDecl) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:69
     */
    public SrcFullClassDecl copy() {
        try {
            SrcFullClassDecl node = (SrcFullClassDecl) clone();
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
     * @declaredat ASTNode:88
     */
    @Deprecated
    public SrcFullClassDecl fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:98
     */
    public SrcFullClassDecl treeCopyNoTransform() {
        SrcFullClassDecl tree = (SrcFullClassDecl) copy();
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
     * @declaredat ASTNode:118
     */
    public SrcFullClassDecl treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:123
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenboolean_Encapsulated == ((SrcFullClassDecl) node).tokenboolean_Encapsulated) && (tokenboolean_Partial == ((SrcFullClassDecl) node).tokenboolean_Partial) && (tokenboolean_Redeclare == ((SrcFullClassDecl) node).tokenboolean_Redeclare) && (tokenboolean_Final == ((SrcFullClassDecl) node).tokenboolean_Final) && (tokenboolean_Inner == ((SrcFullClassDecl) node).tokenboolean_Inner) && (tokenboolean_Outer == ((SrcFullClassDecl) node).tokenboolean_Outer) && (tokenboolean_Replaceable == ((SrcFullClassDecl) node).tokenboolean_Replaceable);    
    }
    /**
     * Replaces the Name child.
     * @param node The new node to replace the Name child.
     * @apilevel high-level
     */
    public void setName(SrcIdDecl node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the Name child.
     * @return The current node used as the Name child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Name")
    public SrcIdDecl getName() {
        return (SrcIdDecl) getChild(0);
    }
    /**
     * Retrieves the Name child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Name child.
     * @apilevel low-level
     */
    public SrcIdDecl getNameNoTransform() {
        return (SrcIdDecl) getChildNoTransform(0);
    }
    /**
     * Replaces the lexeme Encapsulated.
     * @param value The new value for the lexeme Encapsulated.
     * @apilevel high-level
     */
    public void setEncapsulated(boolean value) {
        tokenboolean_Encapsulated = value;
    }
    /**
     * Retrieves the value for the lexeme Encapsulated.
     * @return The value for the lexeme Encapsulated.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Encapsulated")
    public boolean getEncapsulated() {
        return tokenboolean_Encapsulated;
    }
    /**
     * Replaces the lexeme Partial.
     * @param value The new value for the lexeme Partial.
     * @apilevel high-level
     */
    public void setPartial(boolean value) {
        tokenboolean_Partial = value;
    }
    /**
     * Retrieves the value for the lexeme Partial.
     * @return The value for the lexeme Partial.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Partial")
    public boolean getPartial() {
        return tokenboolean_Partial;
    }
    /**
     * Replaces the SrcRestriction child.
     * @param node The new node to replace the SrcRestriction child.
     * @apilevel high-level
     */
    public void setSrcRestriction(SrcRestriction node) {
        setChild(node, 1);
    }
    /**
     * Retrieves the SrcRestriction child.
     * @return The current node used as the SrcRestriction child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="SrcRestriction")
    public SrcRestriction getSrcRestriction() {
        return (SrcRestriction) getChild(1);
    }
    /**
     * Retrieves the SrcRestriction child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the SrcRestriction child.
     * @apilevel low-level
     */
    public SrcRestriction getSrcRestrictionNoTransform() {
        return (SrcRestriction) getChildNoTransform(1);
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
     * Replaces the optional node for the SrcConstrainingClause child. This is the <code>Opt</code>
     * node containing the child SrcConstrainingClause, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcConstrainingClause child.
     * @apilevel low-level
     */
    public void setSrcConstrainingClauseOpt(Opt<SrcConstrainingClause> opt) {
        setChild(opt, 2);
    }
    /**
     * Replaces the (optional) SrcConstrainingClause child.
     * @param node The new node to be used as the SrcConstrainingClause child.
     * @apilevel high-level
     */
    public void setSrcConstrainingClause(SrcConstrainingClause node) {
        if (node != null) {
            setChild(new Opt(node), 2);
        } else {
            setChild(Opt.EMPTY, 2);
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
        return (Opt<SrcConstrainingClause>) getChild(2);
    }
    /**
     * Retrieves the optional node for child SrcConstrainingClause. This is the <code>Opt</code> node containing the child SrcConstrainingClause, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcConstrainingClause.
     * @apilevel low-level
     */
    public Opt<SrcConstrainingClause> getSrcConstrainingClauseOptNoTransform() {
        return (Opt<SrcConstrainingClause>) getChildNoTransform(2);
    }
    /**
     * Replaces the optional node for the ConstrainingClauseComment child. This is the <code>Opt</code>
     * node containing the child ConstrainingClauseComment, not the actual child!
     * @param opt The new node to be used as the optional node for the ConstrainingClauseComment child.
     * @apilevel low-level
     */
    public void setConstrainingClauseCommentOpt(Opt<SrcComment> opt) {
        setChild(opt, 3);
    }
    /**
     * Replaces the (optional) ConstrainingClauseComment child.
     * @param node The new node to be used as the ConstrainingClauseComment child.
     * @apilevel high-level
     */
    public void setConstrainingClauseComment(SrcComment node) {
        if (node != null) {
            setChild(new Opt(node), 3);
        } else {
            setChild(Opt.EMPTY, 3);
        }
    }
    /**
     * Check whether the optional ConstrainingClauseComment child exists.
     * @return {@code true} if the optional ConstrainingClauseComment child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasConstrainingClauseComment() {
        return getConstrainingClauseCommentOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) ConstrainingClauseComment child.
     * @return The ConstrainingClauseComment child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcComment getConstrainingClauseComment() {
        return (SrcComment) getConstrainingClauseCommentOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the ConstrainingClauseComment child. This is the <code>Opt</code> node containing the child ConstrainingClauseComment, not the actual child!
     * @return The optional node for child the ConstrainingClauseComment child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="ConstrainingClauseComment")
    public Opt<SrcComment> getConstrainingClauseCommentOpt() {
        return (Opt<SrcComment>) getChild(3);
    }
    /**
     * Retrieves the optional node for child ConstrainingClauseComment. This is the <code>Opt</code> node containing the child ConstrainingClauseComment, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child ConstrainingClauseComment.
     * @apilevel low-level
     */
    public Opt<SrcComment> getConstrainingClauseCommentOptNoTransform() {
        return (Opt<SrcComment>) getChildNoTransform(3);
    }
    /**
     * Replaces the optional node for the SrcStringComment child. This is the <code>Opt</code>
     * node containing the child SrcStringComment, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcStringComment child.
     * @apilevel low-level
     */
    public void setSrcStringCommentOpt(Opt<SrcStringComment> opt) {
        setChild(opt, 4);
    }
    /**
     * Replaces the (optional) SrcStringComment child.
     * @param node The new node to be used as the SrcStringComment child.
     * @apilevel high-level
     */
    public void setSrcStringComment(SrcStringComment node) {
        if (node != null) {
            setChild(new Opt(node), 4);
        } else {
            setChild(Opt.EMPTY, 4);
        }
    }
    /**
     * Check whether the optional SrcStringComment child exists.
     * @return {@code true} if the optional SrcStringComment child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcStringComment() {
        return getSrcStringCommentOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcStringComment child.
     * @return The SrcStringComment child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcStringComment getSrcStringComment() {
        return (SrcStringComment) getSrcStringCommentOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcStringComment child. This is the <code>Opt</code> node containing the child SrcStringComment, not the actual child!
     * @return The optional node for child the SrcStringComment child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcStringComment")
    public Opt<SrcStringComment> getSrcStringCommentOpt() {
        return (Opt<SrcStringComment>) getChild(4);
    }
    /**
     * Retrieves the optional node for child SrcStringComment. This is the <code>Opt</code> node containing the child SrcStringComment, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcStringComment.
     * @apilevel low-level
     */
    public Opt<SrcStringComment> getSrcStringCommentOptNoTransform() {
        return (Opt<SrcStringComment>) getChildNoTransform(4);
    }
    /**
     * Replaces the SrcClause list.
     * @param list The new list node to be used as the SrcClause list.
     * @apilevel high-level
     */
    public void setSrcClauseList(List<SrcClause> list) {
        setChild(list, 5);
    }
    /**
     * Retrieves the number of children in the SrcClause list.
     * @return Number of children in the SrcClause list.
     * @apilevel high-level
     */
    public int getNumSrcClause() {
        return getSrcClauseList().getNumChild();
    }
    /**
     * Retrieves the number of children in the SrcClause list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the SrcClause list.
     * @apilevel low-level
     */
    public int getNumSrcClauseNoTransform() {
        return getSrcClauseListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the SrcClause list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the SrcClause list.
     * @apilevel high-level
     */
    public SrcClause getSrcClause(int i) {
        return (SrcClause) getSrcClauseList().getChild(i);
    }
    /**
     * Check whether the SrcClause list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasSrcClause() {
        return getSrcClauseList().getNumChild() != 0;
    }
    /**
     * Append an element to the SrcClause list.
     * @param node The element to append to the SrcClause list.
     * @apilevel high-level
     */
    public void addSrcClause(SrcClause node) {
        List<SrcClause> list = (parent == null) ? getSrcClauseListNoTransform() : getSrcClauseList();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addSrcClauseNoTransform(SrcClause node) {
        List<SrcClause> list = getSrcClauseListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the SrcClause list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setSrcClause(SrcClause node, int i) {
        List<SrcClause> list = getSrcClauseList();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the SrcClause list.
     * @return The node representing the SrcClause list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="SrcClause")
    public List<SrcClause> getSrcClauseList() {
        List<SrcClause> list = (List<SrcClause>) getChild(5);
        return list;
    }
    /**
     * Retrieves the SrcClause list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the SrcClause list.
     * @apilevel low-level
     */
    public List<SrcClause> getSrcClauseListNoTransform() {
        return (List<SrcClause>) getChildNoTransform(5);
    }
    /**
     * @return the element at index {@code i} in the SrcClause list without
     * triggering rewrites.
     */
    public SrcClause getSrcClauseNoTransform(int i) {
        return (SrcClause) getSrcClauseListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the SrcClause list.
     * @return The node representing the SrcClause list.
     * @apilevel high-level
     */
    public List<SrcClause> getSrcClauses() {
        return getSrcClauseList();
    }
    /**
     * Retrieves the SrcClause list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the SrcClause list.
     * @apilevel low-level
     */
    public List<SrcClause> getSrcClausesNoTransform() {
        return getSrcClauseListNoTransform();
    }
    /**
     * Replaces the optional node for the SrcExternalClause child. This is the <code>Opt</code>
     * node containing the child SrcExternalClause, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcExternalClause child.
     * @apilevel low-level
     */
    public void setSrcExternalClauseOpt(Opt<SrcExternalClause> opt) {
        setChild(opt, 6);
    }
    /**
     * Replaces the (optional) SrcExternalClause child.
     * @param node The new node to be used as the SrcExternalClause child.
     * @apilevel high-level
     */
    public void setSrcExternalClause(SrcExternalClause node) {
        if (node != null) {
            setChild(new Opt(node), 6);
        } else {
            setChild(Opt.EMPTY, 6);
        }
    }
    /**
     * Check whether the optional SrcExternalClause child exists.
     * @return {@code true} if the optional SrcExternalClause child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcExternalClause() {
        return getSrcExternalClauseOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcExternalClause child.
     * @return The SrcExternalClause child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcExternalClause getSrcExternalClause() {
        return (SrcExternalClause) getSrcExternalClauseOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcExternalClause child. This is the <code>Opt</code> node containing the child SrcExternalClause, not the actual child!
     * @return The optional node for child the SrcExternalClause child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcExternalClause")
    public Opt<SrcExternalClause> getSrcExternalClauseOpt() {
        return (Opt<SrcExternalClause>) getChild(6);
    }
    /**
     * Retrieves the optional node for child SrcExternalClause. This is the <code>Opt</code> node containing the child SrcExternalClause, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcExternalClause.
     * @apilevel low-level
     */
    public Opt<SrcExternalClause> getSrcExternalClauseOptNoTransform() {
        return (Opt<SrcExternalClause>) getChildNoTransform(6);
    }
    /**
     * Replaces the optional node for the SrcAnnotation child. This is the <code>Opt</code>
     * node containing the child SrcAnnotation, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcAnnotation child.
     * @apilevel low-level
     */
    public void setSrcAnnotationOpt(Opt<SrcAnnotation> opt) {
        setChild(opt, 7);
    }
    /**
     * Replaces the (optional) SrcAnnotation child.
     * @param node The new node to be used as the SrcAnnotation child.
     * @apilevel high-level
     */
    public void setSrcAnnotation(SrcAnnotation node) {
        if (node != null) {
            setChild(new Opt(node), 7);
        } else {
            setChild(Opt.EMPTY, 7);
        }
    }
    /**
     * Check whether the optional SrcAnnotation child exists.
     * @return {@code true} if the optional SrcAnnotation child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcAnnotation() {
        return getSrcAnnotationOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcAnnotation child.
     * @return The SrcAnnotation child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcAnnotation getSrcAnnotation() {
        return (SrcAnnotation) getSrcAnnotationOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcAnnotation child. This is the <code>Opt</code> node containing the child SrcAnnotation, not the actual child!
     * @return The optional node for child the SrcAnnotation child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcAnnotation")
    public Opt<SrcAnnotation> getSrcAnnotationOpt() {
        return (Opt<SrcAnnotation>) getChild(7);
    }
    /**
     * Retrieves the optional node for child SrcAnnotation. This is the <code>Opt</code> node containing the child SrcAnnotation, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcAnnotation.
     * @apilevel low-level
     */
    public Opt<SrcAnnotation> getSrcAnnotationOptNoTransform() {
        return (Opt<SrcAnnotation>) getChildNoTransform(7);
    }
    /**
     * Replaces the SrcEndDecl child.
     * @param node The new node to replace the SrcEndDecl child.
     * @apilevel high-level
     */
    public void setSrcEndDecl(SrcEndDecl node) {
        setChild(node, 8);
    }
    /**
     * Retrieves the SrcEndDecl child.
     * @return The current node used as the SrcEndDecl child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="SrcEndDecl")
    public SrcEndDecl getSrcEndDecl() {
        return (SrcEndDecl) getChild(8);
    }
    /**
     * Retrieves the SrcEndDecl child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the SrcEndDecl child.
     * @apilevel low-level
     */
    public SrcEndDecl getSrcEndDeclNoTransform() {
        return (SrcEndDecl) getChildNoTransform(8);
    }
    /**
     * Is this element a full class decl?
     * @attribute syn
     * @aspect NodeTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:463
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="NodeTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:463")
    public boolean isFullClassDecl() {
        boolean isFullClassDecl_value = true;
        return isFullClassDecl_value;
    }
    /**
     * @attribute syn
     * @aspect NodeTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:466
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="NodeTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:466")
    public SrcFullClassDecl asFullClassDecl() {
        SrcFullClassDecl asFullClassDecl_value = this;
        return asFullClassDecl_value;
    }
    /** @apilevel internal */
    private void simpleLookupDefaultScope_String_reset() {
        simpleLookupDefaultScope_String_values = null;
    }
    /** @apilevel internal */
    protected java.util.Map simpleLookupDefaultScope_String_values;

    /**
     * Lookup in contained elements, extended classes, imports and surrounding classes.
     * Has to be an unqualified classname.
     * @attribute syn
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:338
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SimpleClassLookup", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:338")
    public ResolvedAccess simpleLookupDefaultScope(String name) {
        Object _parameters = name;
        if (simpleLookupDefaultScope_String_values == null) simpleLookupDefaultScope_String_values = new java.util.HashMap(4);
        ASTState state = state();
        if (simpleLookupDefaultScope_String_values.containsKey(_parameters)) {
            return (ResolvedAccess) simpleLookupDefaultScope_String_values.get(_parameters);
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        ResolvedAccess simpleLookupDefaultScope_String_value = simpleLookupDefaultScope_compute(name);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        simpleLookupDefaultScope_String_values.put(_parameters, simpleLookupDefaultScope_String_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return simpleLookupDefaultScope_String_value;
    }
    /** @apilevel internal */
    private ResolvedAccess simpleLookupDefaultScope_compute(String name) {
            ResolvedAccess res = simpleLookupIncludeImports(name);
            if (res.isUnknown()) {
                return isEncapsulated() ? simpleLookupPredefined(name) : simpleLookupHelper(name);
            }
            return res;
        }
    /**
     * Lookup simple name in contained classes, extends and imports but not in surrounding classes.
     * Has to be an unqualified classname.
     * @attribute syn
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:373
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SimpleClassLookup", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:373")
    public ResolvedAccess simpleLookupIncludeImports(String name) {
        {
                ResolvedAccess res = simpleLookupMemberScope(name);
                if (res.isUnknown()) {
                    res = simpleLookupInImports(name);
                }
                return res;
            }
    }
    /** @apilevel internal */
    private void simpleLookupLocalScope_String_reset() {
        simpleLookupLocalScope_String_values = null;
    }
    /** @apilevel internal */
    protected java.util.Map simpleLookupLocalScope_String_values;

    /**
     * Lookup in contained classes, imports and surrounding classes. Has to be an unqualified classname.
     * @attribute syn
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:385
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SimpleClassLookup", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:385")
    public ResolvedAccess simpleLookupLocalScope(String name) {
        Object _parameters = name;
        if (simpleLookupLocalScope_String_values == null) simpleLookupLocalScope_String_values = new java.util.HashMap(4);
        ASTState state = state();
        if (simpleLookupLocalScope_String_values.containsKey(_parameters)) {
            return (ResolvedAccess) simpleLookupLocalScope_String_values.get(_parameters);
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        ResolvedAccess simpleLookupLocalScope_String_value = simpleLookupLocalScope_compute(name);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        simpleLookupLocalScope_String_values.put(_parameters, simpleLookupLocalScope_String_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return simpleLookupLocalScope_String_value;
    }
    /** @apilevel internal */
    private ResolvedAccess simpleLookupLocalScope_compute(String name) {
            if (duringFindClassDeclRevisits > MAX_FIND_CLASS_DECL_REVISITS) {
                return unknownAccess();
            }
            duringFindClassDeclRevisits++;
    
            ResolvedAccess res = simpleLookupInClassList(classes(), name, qualifiedName());
            if (res.isUnknown()) {
                res = simpleLookupInComponentList(components(), name, qualifiedName());
                if (res.isUnknown()) {
                    res = simpleLookupInImports(name);
                }
            }
            duringFindClassDeclRevisits--;
            if (res.isUnknown()) {
                return isEncapsulated() ? simpleLookupPredefined(name) : simpleLookupHelper(name);
            }
            return res;
        }
    /** @apilevel internal */
    private void simpleLookupMemberScope_String_reset() {
        simpleLookupMemberScope_String_values = null;
    }
    /** @apilevel internal */
    protected java.util.Map simpleLookupMemberScope_String_values;

    /**
     * Lookup in contained classes and extended classes.
     * Has to be an unqualified classname.
     * This method returns the unknown class when the class isn't found.
     * @attribute syn
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:419
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SimpleClassLookup", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:419")
    public ResolvedAccess simpleLookupMemberScope(String name) {
        Object _parameters = name;
        if (simpleLookupMemberScope_String_values == null) simpleLookupMemberScope_String_values = new java.util.HashMap(4);
        ASTState state = state();
        if (simpleLookupMemberScope_String_values.containsKey(_parameters)) {
            return (ResolvedAccess) simpleLookupMemberScope_String_values.get(_parameters);
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        ResolvedAccess simpleLookupMemberScope_String_value = simpleLookupMemberScope_compute(name);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        simpleLookupMemberScope_String_values.put(_parameters, simpleLookupMemberScope_String_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return simpleLookupMemberScope_String_value;
    }
    /** @apilevel internal */
    private ResolvedAccess simpleLookupMemberScope_compute(String name) {
            if (duringFindClassDeclRevisits > MAX_FIND_CLASS_DECL_REVISITS) { 
                return unknownAccess();
            }
            duringFindClassDeclRevisits++;
    
            ResolvedAccess res = simpleLookupInClassList(classes(), name, qualifiedName());
            if (res.isUnknown()) {
                res = simpleLookupInComponentList(components(), name, qualifiedName());
                if (res.isUnknown()) {
                    res = simpleLookupInExtends(name);
                }
            }
            duringFindClassDeclRevisits--;
            return res;
    	}
    /**
     * @attribute syn
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:30
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceTraversal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:30")
    public Iterable<SrcAbstractEquation> equations() {
        Iterable<SrcAbstractEquation> equations_value = new Iterable<SrcAbstractEquation>() {
                public Iterator<SrcAbstractEquation> iterator() {
                    return new ClauseElementIterator<SrcAbstractEquation>() {
                        protected Iterator<SrcAbstractEquation> subIterator(SrcClause c) {
                            return c.equationIterator();
                        }
                    };
                }
            };
        return equations_value;
    }
    /**
     * @attribute syn
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:43
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceTraversal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:43")
    public Iterable<SrcExtendsClause> superClasses() {
        Iterable<SrcExtendsClause> superClasses_value = new Iterable<SrcExtendsClause>() {
                public Iterator<SrcExtendsClause> iterator() {
                    return new ClauseElementIterator<SrcExtendsClause>() {
                        protected Iterator<SrcExtendsClause> subIterator(SrcClause c) {
                            return c.extendsIterator();
                        }
                    };
                }
            };
        return superClasses_value;
    }
    /**
     * @attribute syn
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:60
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceTraversal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:60")
    public Iterable<SrcComponentClause> componentClauses() {
        Iterable<SrcComponentClause> componentClauses_value = new Iterable<SrcComponentClause>() {
                public Iterator<SrcComponentClause> iterator() {
                    return new ClauseElementIterator<SrcComponentClause>() {
                        protected Iterator<SrcComponentClause> subIterator(SrcClause c) {
                            return c.componentClauseIterator();
                        }
                    };
                }
            };
        return componentClauses_value;
    }
    /**
     * @attribute syn
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:86
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceTraversal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:86")
    public Iterable<SrcModificationOrRedeclareElement> elementModifications() {
        Iterable<SrcModificationOrRedeclareElement> elementModifications_value = new FilteredIterable(
                    components(),
                    new Criteria<SrcModificationOrRedeclareElement>() {
                        public boolean test(SrcModificationOrRedeclareElement elem) {
                            return elem.hasRedeclare();
                        }
                    });
        return elementModifications_value;
    }
    /**
     * @attribute syn
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:99
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceTraversal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:99")
    public Iterable<SrcImportClause> imports() {
        Iterable<SrcImportClause> imports_value = new Iterable<SrcImportClause>() {
                public Iterator<SrcImportClause> iterator() {
                    return new ClauseElementIterator<SrcImportClause>() {
                        protected Iterator<SrcImportClause> subIterator(SrcClause c) {
                            return c.importIterator();
                        }
                    };
                }
            };
        return imports_value;
    }
    /**
     * @attribute syn
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:111
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceTraversal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:111")
    public Iterable<SrcClassDecl> classes() {
        Iterable<SrcClassDecl> classes_value = new Iterable<SrcClassDecl>() {
                public Iterator<SrcClassDecl> iterator() {
                    return new ClauseElementIterator<SrcClassDecl>() {
                        protected Iterator<SrcClassDecl> subIterator(SrcClause c) {
                            return c.classIterator();
                        }
                    };
                }
            };
        return classes_value;
    }
    /**
     * Get the string comment a.k.a. description string that applies to this element, 
     * or null if there is none.
     * @attribute syn
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:222
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceTraversal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:222")
    public SrcStringComment myStringComment() {
        SrcStringComment myStringComment_value = selectStringComment(getConstrainingClauseComment(), this);
        return myStringComment_value;
    }
    /**
     * Get the annotation node for this AST node's annotation, if any.
     * 
     * This should be overridden for all nodes that can have annotations.
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:44
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:44")
    public AnnotationNode annotation(InstContext instContext) {
        AnnotationNode annotation_InstContext_value = annotationOfChild(getSrcAnnotationOpt(), instContext);
        return annotation_InstContext_value;
    }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:417
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:417")
    public AnnotationNode createNullAnnotationNode(InstContext instContext) {
        AnnotationNode createNullAnnotationNode_InstContext_value = new FullClassDeclAnnotationNode(this, instContext);
        return createNullAnnotationNode_InstContext_value;
    }
    /*******************
     * Class Decls    
     * ****************
     * @attribute syn
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:367
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SrcAnnotations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:367")
    public SrcAnnotationProvider srcAnnotationProvider() {
        SrcAnnotationProvider srcAnnotationProvider_value = SrcAnnotationNode.createProviderFor(this);
        return srcAnnotationProvider_value;
    }
    /**
     * @attribute inh
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:29
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:29")
    public List getPredefinedType() {
        List getPredefinedType_value = getParent().Define_getPredefinedType(this, null);
        return getPredefinedType_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:278
     * @apilevel internal
     */
    public ResolvedAccess Define_simpleLookupHelper(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return simpleLookupDefaultScope(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:278
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute simpleLookupHelper
     */
    protected boolean canDefine_simpleLookupHelper(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:292
     * @apilevel internal
     */
    public ResolvedAccess Define_simpleLookupFromValue(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return simpleLookupDefaultScope(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:292
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute simpleLookupFromValue
     */
    protected boolean canDefine_simpleLookupFromValue(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:302
     * @apilevel internal
     */
    public ResolvedAccess Define_simpleLookupFromExtends(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return simpleLookupLocalScope(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:302
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute simpleLookupFromExtends
     */
    protected boolean canDefine_simpleLookupFromExtends(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:784
     * @apilevel internal
     */
    public String Define_classNamePrefix(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return combineName(classNamePrefix(), name());
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:784
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute classNamePrefix
     */
    protected boolean canDefine_classNamePrefix(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:857
     * @apilevel internal
     */
    public String Define_packagePath(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        {
                SrcClassDecl cd = simpleLookupClass(new QualifiedName(name, true));
                return (cd == null || cd.isUnknown()) ? null : cd.dirName();
            }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:857
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute packagePath
     */
    protected boolean canDefine_packagePath(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:868
     * @apilevel internal
     */
    public String Define_topPackagePath(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        {
        	  String path = topPackagePath();
        	  return (path == null) ? dirName() : path;
          }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:868
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute topPackagePath
     */
    protected boolean canDefine_topPackagePath(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:912
     * @apilevel internal
     */
    public SrcBaseClassDecl Define_enclosingClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getSrcExternalClauseOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:917
            return this;
        }
        else if (_callerNode == getSrcAnnotationOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:916
            return this;
        }
        else if (_callerNode == getSrcClauseListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:915
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return this;
        }
        else {
            return getParent().Define_enclosingClassDecl(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:912
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute enclosingClassDecl
     */
    protected boolean canDefine_enclosingClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
