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
 * @ast class
 * @aspect TestAnnotationizer
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\TestFramework\\src\\jastadd\\TestAnnotationizer.jrag:51
 */
abstract public class TestAnnotationizerHelper extends java.lang.Object {
    

    /*
     *  TODO:   <ul>
     *              <li>Use more code directly from the test case classes.</li>
     *              <li>Add support for MethodTestCase to use arguments=[...].</li>
     *          </ul>
     *  
     */
    
    /**
     * This is the main method for creating the annotation.
     * 
     * @param filePath     the path to the Modelica file containing the test model
     * @param testType     the type of test case (case sensitive)
     * @param modelName    the name of the test model
     * @param description  the text to put in the "description" field of the test annotation
     * @param data         any extra data to send to the delegate object
     * @param opts         comma-separated list of compiler options to override defaults for
     * @param checkType    check type to use when checking
     * @param libs         list of libraries needed
     * @param write        if <code>true</code>, write the annotation directly in the Modelica file
     */
    public static void doAnnotation(String filePath, String testType, String modelName, String description,
            String platform, String[] opts, String data, String checkType, String[] libs, boolean write) throws Exception {

        try {
            Class cl = getTestCase(testType);
            Constructor constructor =
                    cl.getConstructor(String.class, String.class, String.class, String.class, String[].class, Object[].class);

            TestAnnotationizerHelper ta =
                    (TestAnnotationizerHelper) constructor.newInstance(filePath, modelName, description, platform, opts, new Object[] { data });

            ta.setCheckType(checkType);
            ta.setModelicaLibraries(libs);
            ta.createAnnotation(write);
        } catch (Exception e) {
            handleException(e);
        }
    }

    

    /**
     * This is the main method for regenerating an existing annotation.
     * 
     * @param filePath     the path to the Modelica file containing the test model
     * @param modelName    the name of the test model
     * @param write        if <code>true</code>, write the annotation directly in the Modelica file
     */
    public static void doRegenerate(String filePath, String modelName, boolean write) throws Exception {
        try {
            SourceRoot root = parse(filePath, modelName, createTestOptions());
            SrcClassDecl cd = root.getProgram().simpleLookupClass(modelName);
            if (cd.isUnknown()) {
                System.err.println("Class " + modelName + " not found");
                return;
            }
            AnnotationNode tests = cd.annotation("__JModelica/UnitTesting/tests");
            AnnotationNode test = AnnotationNode.NO_ANNOTATION;
            for (AnnotationNode n : tests) {
                if (test.exists()) {
                    System.err.println("Multiple test annotations found in class " + modelName + ".");
                    System.err.println("TestAnnotationizer is currently unable to regenerate models with multiple tests!");
                    return;
                }
                test = n;
            }
            if (!test.exists()) {
                System.err.println("No test annotation found in class " + modelName);
                return;
            }
            Class cl = getTestCase(test.name());
            Constructor constructor = cl.getConstructor(SrcClassDecl.class, String.class, String.class);
            TestAnnotationizerHelper ta = (TestAnnotationizerHelper) constructor.newInstance(cd, filePath, modelName);
            ta.createAnnotation(write);
        } catch (Exception e) {
            handleException(e);
        }
    }

    

    /**
     * Set type of error checking to be performed.
     * 
     * Available for all test types, but only logical to change for error/warning/compliance tests.
     */
    public void setCheckType(String val) {
        if (val != null)
            checkType = ErrorCheckType.valueOf(ErrorCheckType.class, val.toUpperCase());
    }

    
    
    /**
     * Get type of error checking being performed.
     */
    public ErrorCheckType getCheckType() {
        return (checkType == null) ? ErrorCheckType.COMPILE : checkType;
    }

    

    /**
     * Set list of libraries needed by test.
     */
    public void setModelicaLibraries(String[] val) {
        libs = val;
    }

    

    /**
     * Get list of libraries needed by test as comma-separated string.
     */
    public String getModelicaLibrariesString() {
        StringBuilder buf = new StringBuilder();
        for (String lib : libs) {
            if (buf.length() > 0)
                buf.append(',');
            buf.append(lib);
        }
        return buf.toString();
    }

    

    /**
     * Are there any extra libraries needed by test?
     */
    public boolean hasModelicaLibraries() {
        return libs.length > 0;
    }

    

    /**
     * Get the test case generator class for the specified test case name (or prefix thereof).
     */
    private static Class getTestCase(String testType) {
        String ttl = testType.toLowerCase();
        for (Class cl : TestAnnotationizerHelper.class.getClasses()) {
            if (cl.getSimpleName().toLowerCase().startsWith(ttl) && !Modifier.isAbstract(cl.getModifiers())) {
                System.out.println("Creating " + TestAnnotationizerHelper.testClassName(cl.getSimpleName()) + "...");
                return cl;
            }
        }
        
        throw new IllegalArgumentException("Test type " + testType + " not found.");
    }

    

    /**
     * Print error message for exception.
     */
    private static void handleException(Exception e) {
        System.out.println("Creating annotation failed:");
        Throwable cause = (e instanceof InvocationTargetException) ? e.getCause() : e;
        String message = cause.getMessage();
        if (message == null || !(cause instanceof ModelicaException))
            cause.printStackTrace(System.out);
        else
            System.out.println(message);
    }

    

    /**
     * Prints a help message and exits.
     * 
     * Iterates over all available test case types and prints a usage message for each.
     */
    public static void usageError() throws Exception {
        System.out.println("Usage: java TestAnnotationizer <.mo file path> [options...] [<description>]");
        System.out.println("  Options:");
        System.out.println("    -w           write result to file instead of stdout");
        System.out.println("    -m/-o        create annotation for Modelica/Optimica (default is infer from file path)");
        System.out.println("    -r           regenerate an already present annotation");
        System.out.println("    -a           regenerate annotations for all models in test file (implies -r)");
        System.out.println("    -l=<libs>    comma-separated list of libraries needed by test (except for MSL)");
        System.out.println("                 paths should be relative to test file");
        System.out.println("    -t=<type>    set type of test, a unique prefix is enough, e.g. Err for ErrorTestCase");
        System.out.println("    -c=<class>   set name of class to generate annotation for, if name ");
        System.out.println("                 does not contain a dot, base name of .mo file is prepended");
        System.out.println("    -d=<data>    set extra data to send to the specific generator, \\n is interpreted");
        System.out.println("    -p=<opts>    comma-separated list of compiler options to override defaults for, ");
        System.out.println("                 example: -p=eliminate_alias_variables=false,default_msl_version=\"2.2\"");
        System.out.println("    -k=<type>    set the check type to use when error checking");
        System.out.println("    -h           print this help");
        System.out.println("  User will be prompted for type and/or class if not set with options.");
        System.out.println("  Available test types:");
        for (Class cl : TestAnnotationizerHelper.class.getClasses()) 
            if (!Modifier.isAbstract(cl.getModifiers()))
                cl.getMethod("usage", String.class, String.class).invoke(null, cl.getSimpleName(), null);
    }

    

	/**
	 * Prints a usage message for this test case type.
	 * 
	 * Prints the class name and, if given in <code>extra</code>, a description of 
	 * what extra data passed to the test case type is used for.
	 * 
	 * Subclasses should override and call this implementation if they use the 
	 * <code>data</code> argument of their constructor.
	 */
	public static void usage(String cl, String extra) {
		System.out.print("    " + cl);
		if (extra != null && !extra.equals(""))
			System.out.print(",  data = " + extra);
		System.out.println();
	}

    


    protected String filePath;

    
    protected String className;

    
    protected String testName;

    
    protected String description;

    
    protected int beginLine;

    
    protected int endLine;

    
    protected SourceRoot root;

    
    protected Object[] data;

    
    protected String platform;

    
    protected String[] opts;

    
    protected String[] libs;

    
    protected OptionRegistry or = null;

    
    protected ErrorCheckType checkType = null;

    

    /**
     * Standard constructor for test case creators.
     * 
     * Parses the Modelica file containing the test model and saves the source root.
     * 
     * All subclasses should have a constructor with the same arguments that calls this constructor.
     * 
     * @param filePath     the path to the Modelica file containing the test model
     * @param className    the name of the test model
     * @param description  the text to put in the "description" field of the test annotation
     * @param platform     see {@link #doAnnotation(String, String, String, String, String[], String, String, String[], boolean)}
     * @param opts         comma-separated list of compiler options to override defaults for
     * @param data         any extra data to send to the delegate object
     */
    public TestAnnotationizerHelper(String filePath, String className, String description,
            String platform, String[] opts, Object[] data) throws Exception {

        this.filePath = filePath;
        this.className = className;
        this.description = prepare(description);
        this.platform = platform;
        this.opts = opts;
        this.data = data;
    }

    

    /**
     * Test regeneration constructor for test case creators.
     * 
     * Parses the Modelica file containing the test model and saves the source root.
     * 
     * All subclasses should have a constructor with the same arguments that calls this constructor.
     * 
     * @param filePath     the path to the Modelica file containing the test model
     * @param className    the name of the test model
     */
    public TestAnnotationizerHelper(SrcClassDecl cd, String filePath, String className) throws Exception {
        this.filePath = filePath;
        this.className = className;
        beginLine = cd.beginLine();
        endLine = cd.endLine();
        System.out.println("Test class " + className + " begins at line " + beginLine);
        AnnotationNode a = cd.annotation("__JModelica/UnitTesting/tests").iterator().next();
        this.description = annotationString(a.forPath("description"), false);
        this.platform = annotationString(a.forPath("platform"), false);
        this.data = getData(a, dataNames(), false);
        setCheckType(annotationString(a.forPath("checkType"), false));
        String libs = annotationString(a.forPath("modelicaLibraries"), false);
        setModelicaLibraries((libs == null) ? new String[0] : libs.split(","));
        ArrayList<String> optStrings = new ArrayList<String>();
        for (AnnotationNode a2 : a) 
            if (a2.name().indexOf('_') >= 0) 
                optStrings.add(a2.name() + '=' + annotationString(a2, true));
        opts = optStrings.toArray(new String[optStrings.size()]);
    }

    

    /*
     * Note that a special case is needed to handle null values among arguments else constant evaluation fails.
     */
    private Object[] getData(AnnotationNode node, String[] annotationNames, boolean option) {
        int length = annotationNames.length;
        Object[] data = new Object[length];

        for (int i = 0; i < length; ++i) {
            try {
                data[i] = node.forPath(annotationNames[i]).ceval().objectValue();
                if (data[i] instanceof String) {
                    data[i] = ((String) data[i]).trim();
                }
            } catch (ConstantEvaluationException e) {}
        }
        return data;
    }

    

	protected static String annotationString(AnnotationNode a, boolean option) {
		if (a.isStringValue()) {
			String str = prepare(a.string().trim());
			return option ? '"' + str + '"' : str;
		} else {
			SrcExp exp = a.exp();
			if (exp != null)
				return exp.toString();
		}
		return null;
	}

    

    /**
     * Get the name of the extra data parameters in the annotation, if any.
     */
    protected String[] dataNames() {
        return new String[] {};
    }

    

    /**
     * Process input and prepare all data needed for creating annotation.
     * 
     * Base implementation calculates test name and parses file.
     */
    protected void process() throws Exception {
        testName = className.substring(className.indexOf('.') + 1).replace('.', '_');
        root = parse(filesToParse(filePath, libs), className, optionRegistry());
        SrcClassDecl cd = root.getProgram().simpleLookupClass(className);
        beginLine = cd.beginLine();
        endLine = cd.endLine();
    }

    

    /**
     * Create list of files and libraries to parse.
     */
    private static String[] filesToParse(String filePath, String[] libs) {
        String[] names = new String[libs.length + 1];
        names[0] = filePath;
        File parent = new File(filePath).getParentFile();
        for (int i = 0; i < libs.length; i++) {
            names[i + 1] = new File(parent, libs[i]).getAbsolutePath();
        }
        return names;
    }

    

    /**
     * Parse a single file.
     */
    private static SourceRoot parse(String filePath, String className, OptionRegistry opts) throws Exception {
        return parse(new String[] { filePath }, className, opts);
    }

    

    /**
     * Parse a set of files.
     */
    private static SourceRoot parse(String[] files, String className, OptionRegistry opts) throws Exception {
        File modelicapath = EnvironmentUtils.getThirdPartyMSL();
        opts.setStringOption("MODELICAPATH", modelicapath.getPath());
        SourceRoot root;
        
        try {
            root = TestCase.PARSER_HANDLER.parseModel(UtilInterface.create(opts), files);
        } catch (ParserException e) {
            CompilerException ce = new CompilerException();
            ce.addProblem(e.getProblem());
            throw ce;
        }
        for (SrcStoredDefinition sd : root.getProgram().getUnstructuredEntitys()) 
            sd.setFileName(files[0]);
        return root;
    }

    

	/**
	 * Create an annotation from this helper object.
	 * 
	 * @param write  if <code>true</code>, write the annotation directly in the Modelica file
	 */
	protected void createAnnotation(boolean write) throws Exception {
        process();
		if (write)
			writeAnnotation();
		else
			printAnnotation();
	}

    

    /**
     * Get the options registry to use.
     * 
     * Creates one if not already created.
     */
    protected OptionRegistry optionRegistry() {
        if (or == null) {
            or = createTestOptions();
            for (String opt : opts) {
                String parts[] = opt.split("=");
                if (parts.length != 2)
                    throw new ModelicaException("Bad compiler option string: " + opt);
                String key = parts[0];
                String val = parts[1];
                if (val.startsWith("\"") && val.endsWith("\"")) {
                    or.setStringOption(key, val.substring(1, val.length() - 1));
                } else if (val.equals("true") || val.equals("false")) {
                    or.setBooleanOption(key, val.equals("true"));
                } else if (isInteger(val)) {
                    or.setIntegerOption(key, Integer.parseInt(val));
                } else if (isReal(val)) {
                    or.setRealOption(key, Double.parseDouble(val));
                } else {
                    throw new ModelicaException("Bad compiler option value: " + opt);
                }
            }
        }
        return or;
    }

    

    /**
     * Ensures that option additions are loaded, then create a new TestOptions instance.
     */
    protected static OptionRegistry createTestOptions() {
        OptionRegistry tmp = ModelicaCompiler.createOptions();
        OptionRegistry options = new TestOptions();
        OptionsAggregated.addTo(options);
        return options;
    }

    

	/**
	 * Check if a string can be parsed as an int.
	 */
	protected static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

    
	
	/**
	 * Check if a string can be parsed as a double.
	 */
	protected static boolean isReal(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

    
	
	protected void printSpecificLine(
			PrintStream out, String indent, String name, String value, boolean last) {
        int nl = Math.max(value.lastIndexOf('\n'), value.lastIndexOf('\r'));
        boolean multi = nl >= 0;
        if (multi) 
            value = "\n" + value + (nl < value.length() - 1 ? "\n" : "");
		doPrintSpecificLine(out, indent, name, '"' + value + '"', last, multi);
	}

    
	
	protected void printSpecificLine(
			PrintStream out, String indent, String name, double value, boolean last) {
		doPrintSpecificLine(out, indent, name, Double.toString(value), last, false);
	}

    
	
	protected void printSpecificLine(
			PrintStream out, String indent, String name, int value, boolean last) {
		doPrintSpecificLine(out, indent, name, Integer.toString(value), last, false);
	}

    
	
	protected void printSpecificLine(
			PrintStream out, String indent, String name, boolean value, boolean last) {
		doPrintSpecificLine(out, indent, name, Boolean.toString(value), last, false);
	}

    

    protected void printSpecificLine(PrintStream out, String indent, String name, Object[] value, boolean last) {
        doPrintSpecificLine(out, indent, name, arrayString(value), last, false);
    }

    

    private <T> String arrayString(T[] array) {
        String arrayString = Arrays.toString(array);
        return "{ " + arrayString.substring(1, arrayString.length() - 2) + " }";
    }

    

	protected void doPrintSpecificLine(
			PrintStream out, String indent, String name, String value, boolean last, boolean multi) {
		out.print(indent + name + "=" + value);
		if (!last)
			out.print(",\n");
		else if (!multi) 
			out.print("\n ");
	}

    

    private static final String DEFAULT_INDENT = "    ";

    

    /**
     * Prints the resulting test annotation to stdout.
     */
    public void printAnnotation() throws Exception {
        System.out.println("Annotation:\n=====================");
        outputAnnotation(System.out, false, DEFAULT_INDENT);
        System.out.println("\n=====================");
    }

    

    /**
     * Writes the resulting test annotation directly in the Modelica file.
     */
    public void writeAnnotation() throws Exception {
        File old = new File(filePath);
        BufferedReader in = new BufferedReader(TestCase.PARSER_HANDLER.fileReader(null, old));
        File altered = File.createTempFile(className, ".mo");
        PrintStream out = new PrintStream(altered, "UTF-8");
        boolean foundOld = false;
        boolean lastBlank = false;
        String indent = DEFAULT_INDENT;
        for (int i = 1; i < endLine; i++) {
            String line = in.readLine();
            if (!foundOld) {
                int j = -1;
                if (i > beginLine && (j = line.indexOf(HEADER)) >= 0) {
                    foundOld = true;
                    if (line.trim().equals(ANNOTATION + HEADER)) {
                        out.print(indent + ANNOTATION);
                    } else {
                        out.print(line.substring(0, j));
                        indent = copyIndent(line);
                    }
                } else {
                    if (i == beginLine) {
                        indent = copyIndent(line);
                    }
                    out.println(line);
                    lastBlank = line.trim().isEmpty();
                }
            }
        }
        if (!lastBlank && !foundOld) {
            out.println();
        }
        try {
            outputAnnotation(out, foundOld, indent);
        } catch (Exception e) {
            out.close();
            altered.delete();
            throw e;
       }
        for (String line = in.readLine(); line != null; line = in.readLine())
            out.println(line);
        out.close();
        if (!altered.renameTo(old)) {
            in = new BufferedReader(TestCase.PARSER_HANDLER.fileReader(null, altered));
            out = new PrintStream(old, "UTF-8");
            for (String line = in.readLine(); line != null; line = in.readLine())
                out.println(line);
            altered.delete();
        }
        System.out.println("File " + old.getName() + " updated.");
    }

    

    public static String copyIndent(String line) {
        return line.split("\\S", 2)[0].replace("\t", "    ");
    }

    

    private final static String ANNOTATION = "annotation(";

    
    private final static String HEADER = "__JModelica(UnitTesting(tests={";

    

    /**
     * Generates the test annotation and ouputs it on the given stream.
     */
    public void outputAnnotation(PrintStream out, boolean replace, String indent) throws Exception {
        if (!replace) {
            out.print(indent + ANNOTATION);
        }
        out.println(HEADER);
        out.println(indent + "    " + testClassName() + "(");
        out.println(indent + "        name=\"" + testName + "\",");
        out.println(indent + "        description=\"" + description + "\",");
        if (platform != null)             
            out.println(indent + "        platform=\"" + platform + "\",");
        if (hasModelicaLibraries())
            out.println(indent + "        modelicaLibraries=\"" + getModelicaLibrariesString() + "\",");
        for (String opt : opts) 
            out.println(indent + "        " + opt + ",");
        if (checkType != null)
            out.println(indent + "        checkType=" + checkType.toString().toLowerCase() + ",");
        printSpecific(out, indent + "        ");
        out.println(")})));");
    }

    

    /**
     * Returns {@link #testClassName(String)} where the parameter {@code String} is
     * set to the {@link Class#getSimpleName()} of this class.
     */
    protected String testClassName() {
        return testClassName(getClass().getSimpleName());
    }

    

    /**
     * Maps the class name of a subclass of {@link TestAnnotationizerHelper} named
     * by the parameter {@code name} to the class name of the associated subclass of
     * {@link TestCase}.
     * 
     * @param name
     *            the class name of a subclass of TestAnnotationizerHelper.
     */
    protected static String testClassName(String name) {
        return name.replace("Helper", "");
    }

    

    /**
     * Escapes unallowed characters in the fields of the test annotation.
     */
    protected static String prepare(String str) {
        return str.replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\"");
    }

    

    /**
     * Performs the instantiation, flattening and transform canonical steps of the compilation.
     */
    protected FClass compile() throws Exception {
        InstClassDecl icl = instantiate();
        FClass fc = flatten(icl);
        transformCanonical(fc);
        return fc;
    }

    

	/**
	 * Performs the instantiation step of the compilation.
	 */
	protected InstClassDecl instantiate() throws Exception {
		InstProgramRoot ipr = root.getProgram().getInstProgramRoot();
		Collection<Problem> problems = null;
		try {
			ipr.checkErrorsInInstClass(className, getCheckType());
			problems = root.collectWarnings();
		} catch (CompilerException e) {
			problems = e.getProblems();
		}
		handleCompilerProblems(problems);
		return ipr.lookupInstClassQualified(className).target();
	}

    

    /**
     * Performs the flattening step of the compilation.
     */
    protected FClass flatten(InstClassDecl icd) {
        FClass fc = FClass.create(icd, null);
        Collection<Problem> problems = null;
        try {
            icd.flattenInstClassDecl(fc);
            problems = root.collectWarnings();
        } catch (CompilerException e) {
            problems = e.getProblems();
        }
        handleCompilerProblems(problems);
        return fc;
    }

    

	/**
	 * Performs the transform canonical step of the compilation.
	 */
	protected void transformCanonical(FClass fc) throws Exception {
		fc.transformCanonical();
		Collection<Problem> problems = null;
		try {
			fc.errorCheck(getCheckType());
			problems = root.collectWarnings();
		} catch (CompilerException e) {
			problems = e.getProblems();
		}
		handleCompilerProblems(problems);
	}

    
	
	/**
	 * Filters away the Problems that is ignored by test cases and throws an 
	 *        exception if any remain.
	 * 
	 * Called by instantiate() and transformCanonical() after error checking.
	 */
	protected void handleCompilerProblems(Collection<Problem> problems) throws CompilerException {
		CompilerException ce = new CompilerException();
		for (Problem p : problems) 
			if (keepProblem(p)) 
				ce.addProblem(p);
		if (!ce.getProblems().isEmpty())
			throw ce;
	}

    
	
	/**
	 * Decides what Problems to keep when filtering.
	 * 
	 * This implementation filters out warnings and compliance errors.
	 */
	protected boolean keepProblem(Problem p) {
		return p.isTestError(false);
	}

    

    /**
     * Ensure that user has passed extra data for test case.
     */
    protected void checkData(Object[] data) throws Exception {
        if (data == null || data.length == 0) {
            throw new ModelicaException(getClass().getSimpleName() + " needs extra data.");
        }
    }

    

	/**
	 * Generate and print the part of the annotation that is specific to 
	 *        the test case type.
	 */
	abstract protected void printSpecific(PrintStream out, String indent) throws Exception;

    

	/**
	 * Base class for code generation tests.
	 * 
	 * Extra data is used as the code template.
	 */
	public static abstract class CodeGenTestCase extends TestAnnotationizerHelper {

		protected String template;
		protected String code;

        /**
         * Constructor for base code generation test.
         * 
         * Compiles the model and generates code using the code template passed in 
         * <code>data</code> and a code generator created by subclass.
         */
        public CodeGenTestCase(String filePath, String className, String description,
                String platform, String[] opts, Object[] data) throws Exception {

            super(filePath, className, description, platform, opts, data);
        }

		/**
		 * Test regeneration constructor for base code generation test.
		 * 
		 * Delegates to superclass implementation.
		 * 
		 * @param filePath     the path to the Modelica file containing the test model
		 * @param className    the name of the test model
		 */
		public CodeGenTestCase(SrcClassDecl cd, String filePath, String className) throws Exception {
			super(cd, filePath, className);
		}

        protected String[] dataNames() {
            return new String[] { "template" };
        }

        protected void process() throws Exception {
            super.process();
            checkData(data);
            template = prepare(data[0].toString().replaceAll("\\\\n", "\n"));
            FClass fc = compile();
            AbstractGenerator generator = createGenerator(fc);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            generator.generate(new StringReader(template), createCodeStream(os));
            code = prepare(os.toString());
        }

        private NotNullCodeStream createCodeStream(OutputStream os) {
            PrintStream ps = CodeStream.createPrintStream(os, or.getBooleanOption("debug_duplicate_generated"));
            return new UnitTestCodeStream(ps);
        }

		/**
		 * Create the code generator to use.
		 */
		public abstract AbstractGenerator createGenerator(FClass fc);

		/**
		 * Generate and print the part of the annotation that is specific to 
	     *        this test case type.
		 */
		@Override
		protected void printSpecific(PrintStream out, String indent) throws Exception {
			printSpecificLine(out, indent, "template", template, false);
			printSpecificLine(out, indent, "generatedCode", code, true);
		}
		
	}

    

	/**
	 * A generic code generation test.
	 */
	public static class GenericCodeGenTestCase extends CodeGenTestCase {

        /**
         * Constructor for generic code generation test.
         * 
         * Delegates to super class.
         */
        public GenericCodeGenTestCase(String filePath, String className, String description,
                String platform, String[] opts, Object[] data) throws Exception {

            super(filePath, className, description, platform, opts, data);
        }

		/**
		 * Test regeneration constructor for generic code generation test.
		 * 
		 * Delegates to superclass implementation.
		 * 
		 * @param filePath     the path to the Modelica file containing the test model
		 * @param className    the name of the test model
		 */
		public GenericCodeGenTestCase(SrcClassDecl cd, String filePath, String className) throws Exception {
			super(cd, filePath, className);
		}
		
		/**
		 * Prints a usage message for this test case type.
		 */
		public static void usage(String cl, String extra) {
			TestAnnotationizerHelper.usage(cl, "generic code template");
		}

        /**
         * Create the code generator to use.
         * 
         * Creates a GenericGenerator.
         */
        @Override
        public AbstractGenerator createGenerator(FClass fc) {
            return new GenericGenerator(ASTNode.prettyPrinter, '$', fc);
        }
        
    }

    

	/**
	 * A flattening test.
	 */
	public static class FlatteningTestCase extends TestAnnotationizerHelper {
		
		protected FClass fc;

        /**
         * Constructor for flattening test.
         * 
         * Performs the flattening and instantiation steps of compilation.
         */
        public FlatteningTestCase(String filePath, String className, String description,
                String platform, String[] opts, Object[] data) throws Exception {

            super(filePath, className, description, platform, opts, data);
        }

		/**
		 * Test regeneration constructor for flattening test.
		 * 
		 * Delegates to superclass implementation.
		 * 
		 * @param filePath     the path to the Modelica file containing the test model
		 * @param className    the name of the test model
		 */
		public FlatteningTestCase(SrcClassDecl cd, String filePath, String className) throws Exception {
			super(cd, filePath, className);
		}
		
		protected void process() throws Exception {
			super.process();
			fc = flatten(instantiate());
		}

		/**
		 * Generate and print the part of the annotation that is specific to 
	     *        this test case type.
		 */
		@Override
		protected void printSpecific(PrintStream out, String indent) throws Exception {
			out.println(indent + "flatModel=\"");
			out.print(prepare(fc.prettyPrint("")));
			out.print("\"");
		}
		
	}

    

	/**
	 * A transform canonical test.
	 */
	public static class TransformCanonicalTestCase extends FlatteningTestCase {

        /**
         * Constructor for transform canonical test.
         * 
         * Performs the transform canonical step of compilation.
         * (Superclass performs the flattening and instantiation steps.)
         */
        public TransformCanonicalTestCase(String filePath, String className, String description,
                String platform, String[] opts, Object[] data) throws Exception {

            super(filePath, className, description, platform, opts, data);
        }

		/**
		 * Test regeneration constructor for transform canonical test.
		 * 
		 * Delegates to superclass implementation.
		 * 
		 * @param filePath     the path to the Modelica file containing the test model
		 * @param className    the name of the test model
		 */
		public TransformCanonicalTestCase(SrcClassDecl cd, String filePath, String className) throws Exception {
			super(cd, filePath, className);
		}
		
		protected void process() throws Exception {
			super.process();
			transformCanonical(fc);
		}
		
	}

    

	/**
	 * An error test case.
	 */
	public static class ErrorTestCaseHelper extends TestAnnotationizerHelper {

		private String message;

        /**
         * Constructor for error test case.
         * 
         * Compiles the model and catches any compiler exceptions thrown. If an 
         * exception is caught, an error message is composed, to be included in 
         * the annotation.
         */
        public ErrorTestCaseHelper(String filePath, String className, String description,
                String platform, String[] opts, Object[] data) throws Exception {

            super(filePath, className, description, platform, opts, data);
        }

		/**
		 * Test regeneration constructor for error test.
		 * 
		 * Delegates to superclass implementation.
		 * 
		 * @param filePath     the path to the Modelica file containing the test model
		 * @param className    the name of the test model
		 */
		public ErrorTestCaseHelper(SrcClassDecl cd, String filePath, String className) throws Exception {
			super(cd, filePath, className);
		}

        protected void process() throws Exception {
            super.process();
            try {
                compile();
                throw new ModelicaException(noExceptionMessage());
            } catch (CompilerException e) {
                message = prepareErrorMsg(e.getMessage(true));
            }
        }

        /**
         * Remove location information from error message, since it is unreliable anyway, 
         * in addition to escaping characters that aren't allowed in the annotation.
         */
        protected String prepareErrorMsg(String str) {
            ErrorTestCase ec = new ErrorTestCase();
            ec.setSourceFileName(filePath);
            ec.setBeginLine(beginLine);
            str = ec.filterTestResult(str, true);
            return prepare(str);
        }

		/**
		 * Returns an error message for when no errors were detected in test model.
		 */
		protected String noExceptionMessage() {
			return "No errors reported in "+getClass().getSimpleName()+".";
		}

		/**
		 * Generate and print the part of the annotation that is specific to 
	     *        this test case type.
		 */
		@Override
		protected void printSpecific(PrintStream out, String indent) throws Exception {
			printSpecificLine(out, indent, "errorMessage", message, true);
		}

	}

    
	
	/**
	 * A warning test.
	 */
	public static class WarningTestCase extends ErrorTestCaseHelper {

        /**
         * Constructor for warning test.
         * 
         * Delegates to super class.
         */
        public WarningTestCase(String filePath, String className, String description,
                String platform, String[] opts, Object[] data) throws Exception {

            super(filePath, className, description, platform, opts, data);
        }

		/**
		 * Test regeneration constructor for warning test.
		 * 
		 * Delegates to superclass implementation.
		 * 
		 * @param filePath     the path to the Modelica file containing the test model
		 * @param className    the name of the test model
		 */
		public WarningTestCase(SrcClassDecl cd, String filePath, String className) throws Exception {
			super(cd, filePath, className);
		}
		
		/**
		 * Returns an error message for when no errors were detected in test model.
		 */
		protected String noExceptionMessage() {
			return "No warnings or errors reported in WarningTestCase.";
		}
		
		/**
		 * Decides what Problems to keep when filtering.
		 * 
		 * This implementation keeps all problems.
		 */
		protected boolean keepProblem(Problem p) {
			return true;
		}

	}

    
	
	/**
	 * A compliance error test.
	 */
	public static class ComplianceErrorTestCase extends ErrorTestCaseHelper {

        /**
         * Constructor for compliance error test.
         * 
         * Delegates to super class.
         */
        public ComplianceErrorTestCase(String filePath, String className, String description,
                String platform, String[] opts, Object[] data) throws Exception {

            super(filePath, className, description, platform, opts, data);
        }

		/**
		 * Test regeneration constructor for compliance test.
		 * 
		 * Delegates to superclass implementation.
		 * 
		 * @param filePath     the path to the Modelica file containing the test model
		 * @param className    the name of the test model
		 */
		public ComplianceErrorTestCase(SrcClassDecl cd, String filePath, String className) throws Exception {
			super(cd, filePath, className);
		}
		
		/**
		 * Decides what Problems to keep when filtering.
		 * 
		 * This implementation filters out compliance errors.
		 */
		protected boolean keepProblem(Problem p) {
			return p.severity() == ProblemSeverity.ERROR;
		}

	}

    

    /**
     * A generic method test case.
     */
    public static abstract class MethodTestCase extends TestAnnotationizerHelper {

        private Object[] arguments;
        private String methodName;
        private String methodResult;

        /**
         * Constructor for generic method test case.
         * 
         * Performs any specified processing.
         */
        public MethodTestCase(String filePath, String className, String description,
                String platform, String[] opts, Object[] data) throws Exception {

            super(filePath, className, description, platform, opts, data);
        }

        /**
         * Test regeneration constructor for generic method test case.
         * 
         * Delegates to superclass implementation.
         * 
         * @param filePath     the path to the Modelica file containing the test model
         * @param className    the name of the test model
         */
        public MethodTestCase(SrcClassDecl cd, String filePath, String className) throws Exception {
            super(cd, filePath, className);
        }
        
        protected String[] dataNames() {
            return new String[] { "arguments", "methodName" };
        }
        
        protected void callMethod(Object o) throws Exception {
            checkData(data);
            arguments = (data[0] == null) ? new Object[0] : (Object[]) data[0];
            methodName = data[1].toString();
            Method method = o.getClass().getMethod(methodName, TestCase.unwrapClasses(arguments));
            methodResult = method.invoke(o, arguments).toString();
        }
        
        /**
         * Generate and print the part of the annotation that is specific to 
         *        this test case type.
         */
        @Override
        protected void printSpecific(PrintStream out, String indent) throws Exception {
            printSpecificLine(out, indent, "methodName", methodName, false);
            if (arguments.length > 0) {
                printSpecificLine(out, indent, "arguments", arguments, false);
            }
            printSpecificLine(out, indent, "methodResult", prepare(methodResult), true);
        }
        
        /**
         * Prints a usage message for this test case type.
         */
        public static void usage(String cl, String extra) {
            TestAnnotationizerHelper.usage(cl, "method name");
        }

    }

    

    /**
     * An FClass method test case.
     */
    public static class FClassMethodTestCase extends MethodTestCase {

        
        /**
         * Constructor for FClass method test case.
         * 
         * Compiles the model.
         */
        public FClassMethodTestCase(String filePath, String className, String description,
                String platform, String[] opts, Object[] data) throws Exception {

            super(filePath, className, description, platform, opts, data);
        }

        /**
         * Test regeneration constructor for FClass method test case.
         * 
         * Delegates to superclass implementation.
         * 
         * @param filePath     the path to the Modelica file containing the test model
         * @param className    the name of the test model
         */
        public FClassMethodTestCase(SrcClassDecl cd, String filePath, String className) throws Exception {
            super(cd, filePath, className);
        }
        
        protected void process() throws Exception {
            super.process();
            callMethod(compile());
        }

    }

    

    /**
     * An FClass method test case.
     */
    public static class InstClassMethodTestCase extends MethodTestCase {

        
        /**
         * Constructor for InstClassDecl method test case.
         * 
         * Compiles the model.
         */
        public InstClassMethodTestCase(String filePath, String className, String description, String platform, String[] opts,
                Object[] data) throws Exception {

            super(filePath, className, description, platform, opts, data);
        }

        /**
         * Test regeneration constructor for InstClassDecl method test case.
         * 
         * Delegates to superclass implementation.
         * 
         * @param filePath     the path to the Modelica file containing the test model
         * @param className    the name of the test model
         */
        public InstClassMethodTestCase(SrcClassDecl cd, String filePath, String className) throws Exception {
            super(cd, filePath, className);
        }
        
        protected void process() throws Exception {
            super.process();
            callMethod(instantiate());
        }

    }

    

	/**
	 * An SourceRoot method test case.
	 */
	public static class SourceMethodTestCase extends MethodTestCase {

        /**
         * Constructor for SourceRoot method test case.
         *
         * Compiles the model.
         */
        public SourceMethodTestCase(String filePath, String className, String description,
                String platform, String[] opts, Object[] data) throws Exception {

            super(filePath, className, description, platform, opts, data);
        }

		/**
		 * Test regeneration constructor for SourceRoot method test case.
		 *
		 * Delegates to superclass implementation.
		 *
		 * @param filePath     the path to the Modelica file containing the test model
		 * @param className    the name of the test model
		 */
		public SourceMethodTestCase(SrcClassDecl cd, String filePath, String className) throws Exception {
			super(cd, filePath, className);
		}

		protected void process() throws Exception {
			super.process();
			callMethod(root);
		}

	}

    

	/**
	 * A constant evaluation test case.
	 */
	public static class EvalTestCase extends TestAnnotationizerHelper {

		private String values;
		private String variables;
		protected FClass fc;

        /**
         * Constructor for parameter value evaluation test case.
         * 
         * Compiles the model.
         */
        public EvalTestCase(String filePath, String className, String description,
                String platform, String[] opts, Object[] data) throws Exception {

            super(filePath, className, description, platform, opts, data);
        }

		/**
		 * Test regeneration constructor for parameter value evaluation test case.
		 * 
		 * Delegates to superclass implementation.
		 * 
		 * @param filePath     the path to the Modelica file containing the test model
		 * @param className    the name of the test model
		 */
		public EvalTestCase(SrcClassDecl cd, String filePath, String className) throws Exception {
			super(cd, filePath, className);
		}

        protected String[] dataNames() {
            return new String[]{ "variables" };
        }

        protected void process() throws Exception {
            super.process();
            fc = compile();
            checkData(data);
            variables = makeVariableList(data[0].toString());
            values = prepare(evaluateVars(variables.split("[\\n\\r]+")));
        }

		/**
		 * Create newline-separated list of scalarized variables from comma-separated list of 
		 * possibly non-scalarized variables.
		 */
		public String makeVariableList(String vars) {
			String[] list = vars.replace(',', '\n').split("[\\n\\r]+");
			Set<String> available = fc.variablesMap().flatNameSet();
			ArrayList<String> names = new ArrayList<String>();
			for (String name : list) {
				name = name.trim();
				int l = names.size();
				if (available.contains(name)) {
					names.add(name + "\n");
				} else {
					Pattern p = Pattern.compile(name + "[\\[.].*");
					for (String var : available) 
						if (p.matcher(var).matches()) 
							names.add(var + "\n");
				}
				if (names.size() == l)
					throw new IllegalArgumentException("Could not find variable " + name);
			}
			Collections.sort(names);
			StringBuilder res = new StringBuilder();
			for (String name : names)
				res.append(name);
			return res.toString().trim();
		}
		
		/**
		 * Evaluate variables in an FClass.
		 * 
		 * @return the resulting values, as a string, one value per line.
		 */
		public String evaluateVars(String[] variables) {
			StringBuilder res = new StringBuilder();
			for (int i = 0; i < variables.length; i++) {
				if (i != 0)
					res.append('\n');
				res.append(fc.lookupFV(variables[i]).ceval().toString());
			}
			return res.toString();
		}
		
		/**
		 * Generate and print the part of the annotation that is specific to 
	     *        this test case type.
		 */
		@Override
		protected void printSpecific(PrintStream out, String indent) throws Exception {
			printSpecificLine(out, indent, "variables", variables, false);
			printSpecificLine(out, indent, "values", values, true);
		}
		
		/**
		 * Prints a usage message for this test case type.
		 */
		public static void usage(String cl, String extra) {
			TestAnnotationizerHelper.usage(cl, "variable list");
		}

	}

    

	/**
	 * A constant evaluation test case.
	 */
	public static class TimeTestCase extends TestAnnotationizerHelper {
		
		private double time;

        public TimeTestCase(String filePath, String className, String description,
                String platform, String[] opts, Object[] data) throws Exception {

            super(filePath, className, description, platform, opts, data);
        }

		/**
		 * Test regeneration constructor for compilation time test case.
		 * 
		 * Delegates to superclass implementation.
		 * 
		 * @param filePath     the path to the Modelica file containing the test model
		 * @param className    the name of the test model
		 */
		public TimeTestCase(SrcClassDecl cd, String filePath, String className) throws Exception {
			super(cd, filePath, className);
		}

        protected String[] dataNames() {
            return new String[] { "maxTime" };
        }

		protected void process() throws Exception {
			super.process();
			time = Double.parseDouble(data[0].toString());
		}
		
		/**
		 * Generate and print the part of the annotation that is specific to 
	     *        this test case type.
		 */
		@Override
		protected void printSpecific(PrintStream out, String indent) throws Exception {
			printSpecificLine(out, indent, "maxTime", time, true);
		}
		
		/**
		 * Prints a usage message for this test case type.
		 */
		public static void usage(String cl, String extra) {
			TestAnnotationizerHelper.usage(cl, "maximum execution time");
		}
		
	}

    

    /**
     * A class for testing options.
     */
    public static class OptionTestCase extends TestAnnotationizerHelper {
        private Object[] defaults;
        private String[] names;

        /**
         * Creates a test case for options.
         * <p>
         * Note that this test case accepts a single default value argument for several options. I.e., for N names,
         * default values can be set to either "defaults=value" or "defaults={ value1, value2, ..., valueN}".
         * Using "defaults={ value }" also works.
         * 
         * @param filePath     the path to the Modelica file containing the test model.
         * @param className    the name of the test model.
         * @param description  the text to put in the "description" field of the test annotation.
         * @param opts         comma-separated list of compiler options to override defaults for.
         * @param data         any extra data to send to the delegate object.
         */
        public OptionTestCase(String filePath, String className,
                String description, String platform, String[] opts, Object[] data) throws Exception {

            super(filePath, className, description, platform, opts, data);
        }

        /**
         * Constructor for test regeneration.
         * 
         * @param filePath     the path to the Modelica file containing the test model
         * @param className    the name of the test model
         */
        public OptionTestCase(SrcClassDecl cd, String filePath, String className) throws Exception {
            super(cd, filePath, className);
        }

        @Override
        public String[] dataNames() {
            return new String[] { "names", "defaults" };
        }

        @Override
        protected void printSpecific(PrintStream out, String indent) throws Exception {
            printSpecificLine(out, indent, "names",  names, false);
            printSpecificLine(out, indent, "defaults", defaults, true);
        }

        @Override
        protected void process() throws Exception {
            super.process();
            defaults = (Object[]) data[0];
            Object[] opts = (Object[]) data;

            int length = opts.length;
            names = new String[length];
            for (int i = 0; i < length; ++i) {
                names[i] = opts[i].toString();
            }
        }

        /**
         * Prints a usage message for this test case type.
         */
        public static void usage(String cl, String extra) {
            TestAnnotationizerHelper.usage(cl, "names");
        }
    }

    

    /**
     * An FMI XML code generation test.
     */
    public static class FmiXMLCodeGenTestCase extends CodeGenTestCase {

        public FmiXMLCodeGenTestCase(String filePath, String className, String description,
                String platform, String[] opts, Object[] data) throws Exception {

            super(filePath, className, description, platform, opts, data);
        }

        public FmiXMLCodeGenTestCase(SrcClassDecl cd, String filePath, String className) throws Exception {
            super(cd, filePath, className);
        }

        public static void usage(String cl, String extra) {
            TestAnnotationizerHelper.usage(cl, "XML code template");
        }

        @Override
        public AbstractGenerator createGenerator(FClass fc) {
            String ver = optionRegistry().getStringOption("fmi_version");
            if (ver == OptionRegistry.FMIVersion.FMI20) {
                return new Fmi2XMLGenerator(ASTNode.prettyPrinter, '$', fc);
            } else {
                return new Fmi1XMLGenerator(ASTNode.prettyPrinter, '$', fc);
            }
        }

    }

    

	/**
	 * An XML code generation test.
	 */
	public static class XMLCodeGenTestCase extends CodeGenTestCase {

        /**
         * Constructor for XML code generation test.
         * 
         * Delegates to super class.
         */
        public XMLCodeGenTestCase(String filePath, String className, String description,
                String platform, String[] opts, Object[] data) throws Exception {

            super(filePath, className, description, platform, opts, data);
        }

		/**
		 * Test regeneration constructor for XML code generation test.
		 * 
		 * Delegates to superclass implementation.
		 * 
		 * @param filePath     the path to the Modelica file containing the test model
		 * @param className    the name of the test model
		 */
		public XMLCodeGenTestCase(SrcClassDecl cd, String filePath, String className) throws Exception {
			super(cd, filePath, className);
		}
		
		/**
		 * Prints a usage message for this test case type.
		 */
		public static void usage(String cl, String extra) {
			TestAnnotationizerHelper.usage(cl, "XML code template");
		}

        /**
         * Create the code generator to use.
         * 
         * Creates an XMLGenerator.
         */
        @Override
        public AbstractGenerator createGenerator(FClass fc) {
            return new XMLGenerator(ASTNode.prettyPrinter, '$', fc);
        }
        
    }

    

	/**
	 * A C code generation test.
	 */
	public static class CCodeGenTestCase extends CodeGenTestCase {

        /**
         * Constructor for C code generation test.
         * 
         * Delegates to super class.
         */
        public CCodeGenTestCase(String filePath, String className, String description,
                String platform, String[] opts, Object[] data) throws Exception {

            super(filePath, className, description, platform, opts, data);
        }

		/**
		 * Test regeneration constructor for C code generation test.
		 * 
		 * Delegates to superclass implementation.
		 * 
		 * @param filePath     the path to the Modelica file containing the test model
		 * @param className    the name of the test model
		 */
		public CCodeGenTestCase(SrcClassDecl cd, String filePath, String className) throws Exception {
			super(cd, filePath, className);
		}
		
		/**
		 * Prints a usage message for this test case type.
		 */
		public static void usage(String cl, String extra) {
			TestAnnotationizerHelper.usage(cl, "C code template");
		}

		/**
		 * Create the code generator to use.
		 * 
		 * Creates a CGenerator.
		 */
		@Override
		public AbstractGenerator createGenerator(FClass fc) {
			return new CGenerator(ASTNode.prettyPrinter, '$', fc);
		}
		
	}


}
