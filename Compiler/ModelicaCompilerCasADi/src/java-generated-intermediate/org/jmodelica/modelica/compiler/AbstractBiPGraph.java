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
 * @aspect StartValueDependency
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:3656
 */
public abstract class AbstractBiPGraph<E extends AbstractEq<E, V>, V extends AbstractVar<E, V>, C extends SCCBlock<E, V>> extends java.lang.Object {
    protected StepLogger stepLogger = null;

    public void setStepLogger(StepLogger stepLogger) {
        this.stepLogger = stepLogger;
    }

    public StepLogger getStepLogger() {
        return stepLogger;
    }

    public <T extends BLT> T computeBLT(StepUtil stepUtil, EquationBlockFactory.BlockProducer producer,
            T blt, boolean handleHomotopy, boolean mergePre, Collection<SCCContributor> extraContributors) {
        ASTNode.beginStep("computeBLT()");
        try {
            Collection<C> components = tarjan(stepUtil, extraContributors, true);
            stepUtil.getStepLogger().logDebug("BLT Components:");
            for (C component : components) {
                stepUtil.getStepLogger().logDebug(component);
            }
            return EquationBlockFactory.computeBLT(stepUtil, producer, blt, isInitialSystem(), handleHomotopy, mergePre, components);
        } finally {
            ASTNode.endStep("computeBLT()");
        }
    }

    public BLT computeDAEBLT(StepUtil stepUtil) {
        return computeBLT(stepUtil, EquationBlockFactory.DEFAULT_BLOCK_PRODUCER, new BLT(), true, true, Collections.<AbstractBiPGraph.SCCContributor>emptyList());
    }

    public BLT computeInitDAEBLT(StepUtil stepUtil) {
        return computeBLT(stepUtil, EquationBlockFactory.DEFAULT_BLOCK_PRODUCER, new BLT(), true, false, Collections.<AbstractBiPGraph.SCCContributor>emptyList());
    }

    public <T extends BLT> T computeBLT(StepUtil stepUtil, EquationBlockFactory.BlockProducer producer, T blt, boolean handleHomotopy) {
        return computeBLT(stepUtil, EquationBlockFactory.DEFAULT_BLOCK_PRODUCER, blt, handleHomotopy, false, Collections.<AbstractBiPGraph.SCCContributor>emptyList());
    }

    public Collection<SimpleEquationBlock> computeNonRealBlocks(EquationBlockFactory.BlockProducer producer, StepUtil stepUtil) {
        Collection<C> components = tarjan(stepUtil, false);
        Collection<SimpleEquationBlock> blocks = new ArrayList<SimpleEquationBlock>();
        for (C component : components) {
            SimpleEquationBlock block = EquationBlockFactory.createSimpleEquationBlock(component, producer, true);
            if (block == null) {
                StringBuffer sb = new StringBuffer();
                sb.append("Non-real equations contains an algebraic loop:");
                for (E e : component) {
                    sb.append("\n");
                    sb.append(e.getEquation());
                }
                throw new BLTException(sb.toString());
            } else if (!block.isSolvable()) {
                E e = component.iterator().next();
                StringBuffer sb = new StringBuffer();
                sb.append("Unable to solve variable '" + e.getMatching().getName() + "' from equation:\n");
                sb.append(e.getEquation());
                throw new BLTException(sb.toString());
            }
            blocks.add(block);
        }
        return blocks;
    }

    public void removeHomotopyActualIncidences() {
        for (E eqn : getEquations()) {
            if (eqn.getEquation().containsFHomotopyExp()) {
                eqn.removeIncidencesNotInSet(lookupVars(eqn.getEquation().homotopySimplifiedVarUseLookupVisitor()));
            }
        }
        
    }

    private boolean insideHomotopySimplified = false;

    public void setAsHomotopySimplified() {
        insideHomotopySimplified = true;
        removeHomotopyActualIncidences();
    }

    public boolean insideHomotopySimplified() {
        return insideHomotopySimplified;
    }

    
        private static final StartVarRefContributor START_VAR_REF_CONTRIBUTOR = addSCCContributor(new StartVarRefContributor());

    
        
        /**
         * Contributor that ensures that referenced variables in matched iteration
         * variables always is computed before this equation. This is necessary in
         * the initial system since start value of iteration variables may depend
         * on initial parameter which are calculated in the same BLT. These must be
         * computed before the block where the iteration variable is used!
         */
        private static class StartVarRefContributor extends SCCContributor {
            @Override
            public <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> Collection<E> members(E equation, AbstractBiPGraph<E, V, ?> graph) {
                Collection<E> res = Collections.emptyList();
                V var = equation.getMatching();
                if (!graph.isInitialSystem() || var == null) {
                    return res;
                }
                FExp startExp = var.getVariable().startAttributeExp();
                if (startExp == null) {
                    return res;
                }
                for (V depVar : graph.lookupVars(startExp.findFAccessExpsInTree())) {
                    // This is only some optimization so that we don't create a million of empty lists!
                    if (res.isEmpty()) {
                        res = new ArrayList<E>();
                    }
                    res.add(depVar.getMatching());
                }
                return res;
            }
    
            @Override
            public <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> Collection<E> sameBlockMembers(E equation, AbstractBiPGraph<E, V, ?> graph) {
                return Collections.emptyList();
            }
    
            @Override
            public <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> Map<E, Collection<? extends Object>> memberSets(E equation, AbstractBiPGraph<E, V, ?> graph) {
                return Collections.emptyMap();
            }
        }

    

    private static final String DEFAULT_EQ_PREFIX = "eq_";

    
    private static final String DEFAULT_EQ_SUBFIX = "";

    
    
    protected Map<String, V> variableMap = new LinkedHashMap<String, V>();

    
    protected Map<String, E> equationMap = new LinkedHashMap<String, E>();

    
    protected ListMap<FAbstractEquation, E> equationIndexMap = new LinkedHashListMap<FAbstractEquation, E>();

    
    private boolean initialSystem = false;

    
    private Enumerator enumerator = new Enumerator(1);

    

    public AbstractBiPGraph() {
    }

    

    public <E_OTHER extends AbstractEq<E_OTHER, V_OTHER>, V_OTHER extends AbstractVar<E_OTHER, V_OTHER>> AbstractBiPGraph(Collection<E_OTHER> eqs, Collection<V_OTHER> vars) {
        for (E_OTHER oldE : eqs)
            addEquation(oldE.getEquation(), oldE.groupNumber(), oldE.variability(), oldE.type(), oldE.isMeta(), oldE.getName());
        for (V_OTHER oldV : vars)
            addVariable(oldV.getName(), oldV.getVariable());
        for (E_OTHER oldE : eqs) {
            E e = getEquation(oldE.getName());
            for (V_OTHER oldV : oldE.getVariables()) {
                V v = getVariable(oldV.getName());
                if (v != null)
                    addInsidence(e, v);
            }
        }
    }

    

    public <E_OTHER extends AbstractEq<E_OTHER, V_OTHER>, V_OTHER extends AbstractVar<E_OTHER, V_OTHER>> AbstractBiPGraph(Collection<E_OTHER> block, boolean isInitial) {
        this(block, collectMatchingVariables(block));
        initialSystem = isInitial;
        for (E_OTHER e : block) {
            if (!e.isMeta()) {
                match(getEquation(e.getName()), getVariable(e.getMatching().getName()));
            }
        }
    }

    

    private static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> Collection<V> collectMatchingVariables(Collection<E> eqns) {
        Collection<V> vars = new ArrayList<V>();
        for (E e : eqns) {
            if (!e.isMeta()) {
                vars.add(e.getMatching());
            }
        }
        return vars;
    }

    

    public boolean isComplete() {
        return getUnmatchedVariables().size() == 0 && getUnmatchedEquations().size() == 0;
    }

    

    public Collection<E> getEquations() {
        return equationMap.values();
    }

    

    public Collection<V> getVariables() {
        return variableMap.values();
    }

    

    public E getEquation(String name) {
        return equationMap.get(name);
    }

    

    public void setAsInitialSystem() {
        initialSystem = true;
        for (E eqn : getEquations()) {
            if (eqn.groupNumber() != 0) {
                continue;
            }
            for (V var : lookupVars(eqn.getEquation().findInitUniqueDAEVarUsesInTree())) {
                for (E groupEqn : eqn.getGroupMembers()) {
                    addEdge(groupEqn, var);
                }
            }
        }
    }

    

    public boolean isInitialSystem() {
        return initialSystem;
    }

    
    
    public java.util.List<E> getEquations(FAbstractEquation eqn) {
        return equationIndexMap.getList(eqn);
    }

    

    private E addEquation(FAbstractEquation eqn, int groupNumber, TypePrefixVariability variability, FType type, boolean isMeta, String prefix, String subfix, Enumerator enumerator) {
        String name;
        do {
            name = prefix + enumerator.next() + subfix;
        } while (getEquation(name) != null);
        return addEquation(eqn, groupNumber, variability, type, isMeta, name);
    }

    

    protected E addEquation(FAbstractEquation eqn, int groupNumber, Collection<E> groupMemberList, TypePrefixVariability variability, FType type, String name) {
        return addEquation(eqn, groupNumber, groupMemberList, variability, type, false, name);
    }

    

    protected E addEquation(FAbstractEquation eqn, int groupNumber, TypePrefixVariability variability, FType type, boolean isMeta, String name) {
        return addEquation(eqn, groupNumber, equationIndexMap.getList(eqn, true), variability, type, isMeta, name);
    }

    

    protected E addEquation(FAbstractEquation eqn, int groupNumber, Collection<E> groupMemberList, TypePrefixVariability variability, FType type, boolean isMeta, String name) {
        E e = equationMap.get(name);
        if (e != null)
            throw new IllegalArgumentException("Equation with the name '" + name + "' already exists:\n" + e.getEquation() + "\nNew equation:\n" + eqn);
        e = createEq(name, eqn, groupNumber, groupMemberList, variability, type, isMeta);
        equationMap.put(name,e);
        insertIntoEquationIndexMap(eqn,e);
        return e;
    }

    

    protected abstract E createEq(String name, FAbstractEquation eqn, int groupNumber, Collection<E> groupMembers, TypePrefixVariability variability, FType type, boolean isMeta);

    

    public V addVariable(FVariable var) {
        return addVariable(var.name(), var);
    }

    

    public V addVariable(String name, FVariable var) {
        V v = variableMap.get(name);
        if (v==null) {
            v = createVar(name, var);
            variableMap.put(name,v);
        }	
        return v;
    }

    

    protected abstract V createVar(String name, FVariable var);

    

    public void removeEquation(E e) {
        for (V v : e.getVariables()) {
            if (v.getMatching() == e) {
                v.setMatching(null);
            }
        }
        e.setMatching(null);
        e.getVariables().clear();
        equationMap.remove(e.getName());
        removeFromEquationIndexMap(e.getEquation(),e);
    }

    

    public void removeVariable(V v) {
        for (E e : getEquations()) {
            if (e.getMatching() == v) {
                e.setMatching(null);
            }
            e.getVariables().remove(v);
        }
        v.setMatching(null);
        variableMap.remove(v.getName());
    }

    

    public void removeVariables(Collection<? extends FVariable> fVars) {
        for (FVariable fVar : fVars) {
            V var = getVariable(fVar.name());
            if (var != null)
                removeVariable(var);
        }
    }

    
    
    public V getVariable(String name) {
        return variableMap.get(name);
    }

    

    public final boolean addEdge(String equationName, String variableName) {
        return addEdge(getEquation(equationName), getVariable(variableName));
    }

    

    public boolean addEdge(E e, V v) {
        if (v==null || e==null)
            return false;
        if (e.getVariables().contains(v))
            return false;
        e.addVariable(v);
        return true;
    }

    

    public enum VarType {
        DERIVATIVE_VARIABLES { 
            public Collection<? extends FVariable> variables(FClass c)            { return c.derivativeVariables(); }
            public Collection<? extends FVariable> variables(FAbstractEquation e) { return e.derivativeVariables(); }
            public boolean isOk(TypePrefixVariability variability)               { return variability.continuousVariability(); }
        },
        DIFFERENTIATED_VARIABLES { 
            public Collection<? extends FVariable> variables(FClass c)            { return c.allDifferentiatedRealVariables(); }
            public Collection<? extends FVariable> variables(FAbstractEquation e) { return e.differentiatedRealVariables(); }
            public boolean isOk(TypePrefixVariability variability)               { return variability.continuousVariability(); }
        }, 
        ALGEBRAIC_VARIABLES { 
            public Collection<? extends FVariable> variables(FClass c)            { return c.normalAlgebraicVariables(); }
            public Collection<? extends FVariable> variables(FAbstractEquation e) { return e.algebraicVariables(); }
        }, 
        CONTINUOUS_ALGEBRAIC_VARIABLES { 
            public Collection<? extends FVariable> variables(FClass c)            { return c.normalAlgebraicContinousRealVariables(); }
            public Collection<? extends FVariable> variables(FAbstractEquation e) { return e.algebraicContinousRealVariables(); }
            public boolean isOk(TypePrefixVariability variability)               { return variability.continuousVariability(); }
        }, 
        DISCRETE_ALGEBRAIC_VARIABLES { 
            public Collection<? extends FVariable> variables(FClass c)            { return c.discreteVariables(); }
            public Collection<? extends FVariable> variables(FAbstractEquation e) { return e.discreteVariables(); }
            public boolean isOk(TypePrefixVariability variability)               { return variability.discreteVariability(); }
        }, 
        DISCRETE_PRE_VARIABLES { 
            public Collection<? extends FVariable> variables(FClass c)            { return c.discretePreVariables(); }
            public Collection<? extends FVariable> variables(FAbstractEquation e) { return e.discretePreVariables(); }
            public boolean isOk(TypePrefixVariability variability)               { return variability.discreteVariability(); }
        },
        NON_FIXED_PARAMETERS {
            public Collection<? extends FVariable> variables(FClass c)            { return c.initialParameters(); }
            public Collection<? extends FVariable> variables(FAbstractEquation e) { return e.initialParameters(); }
            public boolean isOk(TypePrefixVariability variability)               { return variability.parameterVariability(); }
        };

        public abstract Collection<? extends FVariable> variables(FClass c);
        public abstract Collection<? extends FVariable> variables(FAbstractEquation e);
        public boolean isOk(TypePrefixVariability e) { return true; }
    }

    

    public void addVariables(FClass fclass, EnumSet<VarType> variableTypes) {
        for (VarType t : variableTypes)
            for (FVariable fv : t.variables(fclass))
                addVariable(fv.name(), fv);
    }

    

    public void addEquations(java.util.List<FAbstractEquation> eqns, EnumSet<VarType> variableTypes) {
        do_addEquations(eqns, variableTypes, DEFAULT_EQ_PREFIX, enumerator);
    }

    

    public void addEquations(java.util.List<FAbstractEquation> eqns, EnumSet<VarType> variableTypes, String eqNamePrefix, Enumerator enumerator) {
        if (eqNamePrefix.equals(DEFAULT_EQ_PREFIX))
            throw new IllegalArgumentException("The equation name prefix '" + eqNamePrefix + "' is reserved!");
        do_addEquations(eqns, variableTypes, eqNamePrefix, enumerator);
    }

    

    private void do_addEquations(java.util.List<FAbstractEquation> eqns, EnumSet<VarType> variableTypes, String eqNamePrefix, Enumerator enumerator) {
        Set<FVariable> emptySet = Collections.emptySet();
        for (FAbstractEquation e : eqns) {
            
            IncidenceMap incMap = e.createIncidenceMap(this, variableTypes);
            int n_eq = incMap.numEqs();
            
            Collection<E> groupMembers = getEquations(e);
            int n_existing = 0;
            int n_existing_meta = 0;
            for (E eqn : groupMembers) {
                n_existing += 1;
                if (eqn.isMeta()) {
                    n_existing_meta++;
                }
            }
            if (n_existing != 0 && (n_existing - n_existing_meta) != n_eq) {
                throw new IllegalArgumentException("Equation already exist in BiPGraph but with different number of scalars, previously " + n_existing + ", now " + n_eq + ", equation:\n" + e);
            }
            if (n_existing == 0) {
                groupMembers = new ArrayList<E>();
                Enumerator subEnumerator = enumerator;
                String prefix = eqNamePrefix;
                String subfix = "";
                if (n_eq > 1) {
                    subEnumerator = new Enumerator(1);
                    prefix += enumerator.next() + "[";
                    subfix = "]";
                }
                if (n_eq == 0) {
                    E eqn = addEquation(e, 0, incMap.variability(0), incMap.type(0), true, prefix, subfix, subEnumerator);
                    groupMembers.add(eqn);
                } else {
                    for (int i = n_eq - 1; 0 <= i; i--) { // During tarjan the order will be reversed,
                        // need to reverse here to preserve the initial order.
                        E eqn = addEquation(e, i, incMap.variability(i), incMap.type(i), false, prefix, subfix, subEnumerator);
                        groupMembers.add(eqn);
                    }
                }
            }
            for (E eqn : groupMembers) {
                incMap.addEdges(eqn, false);
            }
        }
    }

    
    
    protected CommonAccessExpLookupVisitor<FAccessExp> getCommonAccessExpLookupVisitor() {
        if (isInitialSystem()) {
            return InitDAEVarUseLookupVisitor.instance;
        } else {
            return DAEVarUseLookupVisitor.instance;
        }
    }

    
    
    /**
     * Handles incidences between variables in an FAbstractEquation.
     * The base case is a scalar equation where all variables are 
     * dependent on each other.
     */
    protected class IncidenceMap {
        private Set<V> vars = null;
        protected final FAbstractEquation equation;
        protected final VariableResolver<E, V> resolver;
        
        public IncidenceMap(FAbstractEquation e, VariableResolver<E, V> resolver) {
            equation = e;
            this.resolver = resolver;
        }
        
        protected Set<V> vars() {
            if (vars == null) {
                vars = resolver.lookupVars(equation.findCommonAccessExpsInTree(getCommonAccessExpLookupVisitor()));
            }
            return vars;
        }
        
        public TypePrefixVariability variability(int i) {
            return equation.variability();
        }
        
        public FType type(int i) {
            return equation.type();
        }
        
        public void addEdges(E eqn, boolean log) {
            for (V var : vars()) {
                if (log) {
                    getStepLogger().logVerbose("*** %s", var);
                }
                addEdge(eqn, var);
            }
        }
        
        public int numEqs() {
            return equation.numScalarEquations();
        }
    }

    
    
    /**
     * An interface that should be implemented by all IncidenceMap classes that
     * represent an equation which only has one or more variables on the left hand
     * side (one variable on the left hand side per scalar equation)
     */
    protected interface AssignmentIncidenceMap {
        public Iterable<FAccessExp> rhs(String assignedLHS);
        public Collection<FAccessExp> assigned();
    }

    
    
    /**
     * Handles normal equations which are on the form "x = ...".
     */
    protected class SingleAssignmentIncidenceMap extends IncidenceMap implements AssignmentIncidenceMap {
        private final FAccessExp assigned;
        private Collection<FAccessExp> rhsUses;
        
        public SingleAssignmentIncidenceMap(FEquation eqn, VariableResolver<E, V> resolver) {
            super(eqn, resolver);
            assigned = eqn.getLeft().asFAccessExp();
           
        }
        
        private Collection<FAccessExp> rhsUses() {
            if (rhsUses == null) {
                rhsUses = equation.FAccessExpsInRHS(getCommonAccessExpLookupVisitor());
            }
            return rhsUses;
        }
        
        @Override
        public Iterable<FAccessExp> rhs(String assignedLHS) {
            if (assignedLHS.equals(assigned.name())) {
                return rhsUses();
            } else {
                return Collections.emptyList();
            }
        }
        
        @Override
        public Collection<FAccessExp> assigned() {
            return Collections.singletonList(assigned);
        }
    }

    
    
    /**
     * Handles incidences between variables in a non-scalar FAbstractEquation.
     * Isolates LHS variables from each other.
     */
    protected abstract class MultiIncidenceMap extends IncidenceMap {
        private Map<Integer, V> lhs = null;
        private Set<FAccessExp> lhsUses = null;
        protected final EnumSet<VarType> variableTypes;
        
        public MultiIncidenceMap(FAbstractEquation e, VariableResolver<E, V> resolver, EnumSet<VarType> variableTypes) {
            super(e, resolver);
            this.variableTypes = variableTypes;
        }
        
        protected Set<FAccessExp> lhsUses() {
            if (lhsUses == null) {
                lhsUses = equation.FAccessExpsInLHS(getCommonAccessExpLookupVisitor());
            }
            return lhsUses;
        }
        
        protected abstract void computeLHS(Map<Integer, V> lhs);
        
        protected Map<Integer, V> lhs() {
            if (lhs == null) {
                Map<Integer, V> lhsTmp = new HashMap<Integer, V>();
                computeLHS(lhsTmp);
                lhs = lhsTmp;
            }
            return lhs;
        }
        
        protected void buildLhsFunction(Map<Integer, V> lhs, EnumSet<VarType> variableTypes) {
            int i = 0;
            for (FAccessExp use : lhsUses()) {
                if (variableTypes != null) {
                    FAbstractVariable fv = use.myFV();
                    if (fv != null && !addLhs(fv, variableTypes)) {
                        continue;
                    }
                }
                buildLhsFunction(lhs, use, i++);
            }
        }
        
        protected void buildLhsFunction(Map<Integer, V> lhs, FAccessExp use, int i) {
            V var = getVariable(use.name());
            lhs.put(i, var);
        }
        
        protected boolean addLhs(FAbstractVariable fv, EnumSet<VarType> variableTypes) {
            for (VarType t : variableTypes) {
                if (t.isOk(variability(fv))) {
                    return true;
                }
            }
            return false;
        }
        
        @Override
        public TypePrefixVariability variability(int i) {
            V var = lhs().get(i);
            if (var == null) {
                return super.variability(i);
            }
            return variability(var.getVariable());
        }
        
        private TypePrefixVariability variability(FAbstractVariable fv) {
            TypePrefixVariability v = fv.variability();
            if (v.parameterOrLess()) {
                v = fv.type().funcOutputVariability();
            }
            return v;
        }
        
        @Override
        public FType type(int i) {
            V var = lhs().get(i);
            if (var == null) {
                return super.type(i);
            }
            return var.type();
        }
        
        @Override
        public void addEdges(E eqn, boolean log) {
            int i = eqn.groupNumber();
            V lhsVar = lhs().get(i);
            for (V var : vars()) {
                if (var == lhsVar || rhs(i).contains(var)) {
                    addEdge(eqn, var);
                }
            }
        }

        protected abstract Set<V> rhs(int i);

        @Override
        public int numEqs() {
            return lhs().size();
        }
    }

    
    
    /**
     * Handles incidences between variables in a non-scalar FAbstractEquation.
     * Isolates LHS variables from each other.
     * Assumes all LHS variables are dependent on all RHS variables.
     */
    protected class ManyIncidenceMap extends MultiIncidenceMap {
        
        private Set<V> rhs = null;
        
        public ManyIncidenceMap(FAbstractEquation e, VariableResolver<E, V> resolver, EnumSet<VarType> variableTypes) {
            super(e, resolver, variableTypes);
        }
        
        protected Set<V> rhs() {
            if (rhs == null) {
                rhs = resolver.lookupVars(equation.FAccessExpsInRHS());
                if (equation instanceof FAlgorithm) {
                    rhs.removeAll(resolver.lookupVars(lhsUses()));
                }
            }
            return rhs;
        }
        
        protected void computeLHS(Map<Integer, V> lhs) {
            if (equation instanceof FFunctionCallEquation) {
                buildLhsFunction(lhs, variableTypes);
            } else {
                buildLhsOther(lhs, variableTypes);
            }
        }
        
        private void buildLhsOther(Map<Integer, V> lhs, EnumSet<VarType> variableTypes) {
            int i = 0;
            for (FAbstractVariable fv : ASTNode.lookupFVariablesInSet(lhsUses())) {
                if (variableTypes != null) {
                    if (!addLhs(fv, variableTypes)) {
                        continue;
                    }
                }
                
                V var = getVariable(fv.name());
                lhs.put(i++, var);
            }
        }
        
        @Override
        protected Set<V> rhs(int i) {
            return rhs();
        }
    }

    
    
    /**
     * Handles incidences between variables in a non-scalar FAbstractEquation.
     * Isolates LHS variables from each other.
     * Computes RHS dependencies for LHS.
     */
    protected class SplitIncidenceMap extends MultiIncidenceMap implements AssignmentIncidenceMap {
        protected ArrayList<Set<V>> splitMap;
        protected Map<FAccessExp, Collection<FAccessExp>> resolvedDependencies;
        private Map<String, FAccessExp> nameToAssignedMap;
        
        public SplitIncidenceMap(FFunctionCallEquation e, VariableResolver<E, V> resolver, EnumSet<VarType> variableTypes) {
            super(e, resolver, variableTypes);
        }
        
        private Map<FAccessExp, Collection<FAccessExp>> sortDependencies(Map<FAccessExp, Set<FAccessExp>> unsortedDependencies) {
            final Map<String, Integer> varToPosMap = new HashMap<String, Integer>();
            int counter = 0;
            for (FAccessExp use : equation.FAccessExpsInRHS()) {
                if (!varToPosMap.containsKey(use.name())) {
                    varToPosMap.put(use.name(), counter++);
                }
            }
            Map<FAccessExp, Collection<FAccessExp>> resolvedDependencies = new HashMap<>();
            for (Map.Entry<FAccessExp, Set<FAccessExp>> entry : unsortedDependencies.entrySet()) {
                ArrayList<FAccessExp> uses = new ArrayList<>(entry.getValue());
                Collections.sort(uses, new Comparator<FAccessExp>() {
                    public int compare(FAccessExp a, FAccessExp b) {
                        return varToPosMap.get(a.name()) - varToPosMap.get(b.name());
                    }
                });
                resolvedDependencies.put(entry.getKey(), uses);
            }
            return resolvedDependencies;
        }
        
        protected Map<FAccessExp, Collection<FAccessExp>> resolvedDependencies() {
            if (resolvedDependencies == null) {
                DependencyVariableEvaluator pve = new DependencyVariableEvaluator();
                FFunctionCallEquation equation = (FFunctionCallEquation) this.equation;
                try {
                    equation.getCall().evaluate(pve);
                    Map<FAccessExp, Set<FAccessExp>> unsortedDependencies = pve.resolveDependencies(equation);
                    resolvedDependencies = sortDependencies(unsortedDependencies);
                } catch (ConstantEvaluationException e) {
                    ASTNode.log.debug("SplitIncidenceMap failed to compute dependency information, falling back to normal heuristics!");
                    resolvedDependencies = new HashMap<FAccessExp, Collection<FAccessExp>>();
                    Collection<FAccessExp> rhs = equation.FAccessExpsInRHS();
                    for (FAccessExp lhs : lhsUses()) {
                        resolvedDependencies.put(lhs, rhs);
                    }
                }
            }
            return resolvedDependencies;
        }
        
        protected Map<String, FAccessExp> nameToAssignedMap() {
            if (nameToAssignedMap == null) {
                nameToAssignedMap = new HashMap<>();
                for (FAccessExp use : lhsUses()) {
                    FAccessExp old = nameToAssignedMap.put(use.name(), use);
                    if (old != null) {
                        throw new UnsupportedOperationException("The following equation assignes the same variable twice, " + old + ", this class doesn't handle that:\n" + equation);
                    }
                }
            }
            return nameToAssignedMap;
        }
        
    
        @Override
        protected void computeLHS(Map<Integer, V> lhs) {
            splitMap = new ArrayList<Set<V>>();
            buildLhsFunction(lhs, variableTypes);
        }
        
        @Override
        protected void buildLhsFunction(Map<Integer, V> lhs, FAccessExp use, int i) {
            super.buildLhsFunction(lhs, use, i);
            Set<V> s = resolver.lookupVars(resolvedDependencies().get(use));
            splitMap.add(s);
        }

        @Override
        protected Set<V> rhs(int i) {
            lhs(); // Just ensure that splitMap is computed.
           return splitMap.get(i);
        }

        @Override
        public Collection<FAccessExp> assigned() {
            return lhsUses();
        }

        @Override
        public final Iterable<FAccessExp> rhs(String assignedLHS) {
            FAccessExp use = nameToAssignedMap().get(assignedLHS);
            if (use == null) {
                return Collections.emptyList();
            } else {
                return resolvedDependencies().get(use);
            }
        }
        
    }

    
    
    
    public boolean match(E e, V v) {
        if (!canMatch(e, v))
            return false;
        if (e.getMatching() != null)
            e.getMatching().setMatching(null);
        if (v.getMatching() != null)
            v.getMatching().setMatching(null);
        v.setMatching(e);
        e.setMatching(v);
        return true;
    }

    

    public boolean canMatch(E e, V v) {
        if (e.isMeta())
            return false;
        
        FAbstractEquation equation = e.getEquation();
        FVariable variable = v.getVariable();
        
        if (!variable.isReal() && !equation.isSolved(variable).isAnalyticallySolvable()) {
            return false;
        }
        
        if (initialSystem)
            return true;
        
        if (equation instanceof FAlgorithm)
            return true;
        
        // Discrete variables can only be matched to discrete equations.
        // Except discrete reals in initial system.
        return variable.isContinuous() || e.variability().discreteVariability() || equation.isInitial();
    }

    

    public void addInsidence(E e, V v) {
        e.addVariable(v);
    }

    

    public Collection<E> greedyMatching() {
        Collection<E> unmatched = new ArrayList<E>();
        for (E e : getEquations()) {
            if (e.getMatching() != null)
                continue;
            for (V v : e.getVariables()) {
                if (v.getMatching()==null) {
                    match(e, v);
                    break;
                }
            }
            if (e.getMatching() == null)
                unmatched.add(e);
        }
        return unmatched;
    }

    

    /**
     * Comparator that is used during matching of variables to equations. We 
     * need to use a comparator during this since we wan't to prioritize
     * matching of certain variables. For example, when matching the initial
     * system, there is usually more variables than equations. In that case it
     * is better to leave a variable with start value unmatched since we then
     * can use the start value as an extra initial condition (equation).
     */
    private static class VarMatchingComparator implements Comparator<AbstractVar<?,?>> {
        private Set<FAbstractVariable> hasExtraStartConditions;
        private VarMatchingComparator(Set<FAbstractVariable> hasExtraStartConditions) {
            if (hasExtraStartConditions == null)
                hasExtraStartConditions = Collections.emptySet();
            this.hasExtraStartConditions = hasExtraStartConditions;
        }
        
        /**
         * Variable o1 will be prefered over o2 by returning a negative number.
         * This means that o1 will be matched (if possible) before o2, which
         * means that we wan't to return a positive number for the variables
         * that we wan't to be unmatched (and used as initial conditions).
         */
        @Override
        public int compare(AbstractVar<?,?> o1, AbstractVar<?,?> o2) {
            FVariable v1 = o1.getVariable();
            FVariable v2 = o2.getVariable();
            
            // Variables that has an extra start condition (equation already in
            // the system) should be matched last
            boolean b1 = (v1.isPreVariable() && hasExtraStartConditions.contains(v1.myNonPreVariable())) || hasExtraStartConditions.contains(v1);
            boolean b2 = (v2.isPreVariable() && hasExtraStartConditions.contains(v2.myNonPreVariable())) || hasExtraStartConditions.contains(v2);
            int diff = (b1 ? 1 : 0) - (b2 ? 1 : 0);
            if (diff != 0)
                return diff;
            
            // Discrete pre() and continuous variables with start value should
            // be matched last
            b1 = (v1.isDiscrete() && v1.isPreVariable() || v1.isContinuous()) && v1.startAttributeSet();
            b2 = (v2.isDiscrete() && v2.isPreVariable() || v2.isContinuous()) && v2.startAttributeSet();
            diff = (b1 ? 1 : 0) - (b2 ? 1 : 0);
            if (diff != 0)
                return diff;
            
            // pre() variables should be matched last (why?)
            diff = (v1.isPreVariable() ? 1 : 0) - (v2.isPreVariable() ? 1 : 0);
            if (diff != 0)
                return diff;
            
            // Make the sorting deterministic by comparing the names
            return o1.getName().compareTo(o2.getName());
        }
    }

    

    public java.util.List<Map<V, Set<E>>> bfs(Collection<E> startingNodes, Comparator<? super V> varComparator) {
        java.util.List<Map<V, Set<E>>> Lv = new ArrayList<Map<V, Set<E>>>();
        Set<E> Le_current = new LinkedHashSet<E>();
        Set<E> Le_next = new LinkedHashSet<E>();
        
        Le_current.addAll(startingNodes);
        // Reset nodes
        lightReset();
        
        int layer = 0;
        boolean freeVarNodeFound = false;
        //System.out.println("************** BFS ************* starting nodes: " + startingNodes);
        
        while (Le_current.size() > 0 && !freeVarNodeFound) {
            //System.out.println("*** layer: " + layer);
            //System.out.println(Lv);
            //System.out.println(Le_current);
            Lv.add(new TreeMap<V, Set<E>>(varComparator));
            
            for (E s : Le_current) {
                //System.out.println(" eq: " + s);
                for (V t : s.getVariables()) {
                    if (!canMatch(s, t))
                        continue;
                    //System.out.println("  " + t + " layer: " + t.getLayer());
                    if (t.getLayer() >= layer) {
                        //System.out.println("    adding " + t);
                        t.setLayer(layer);
                        Set<E> h = Lv.get(layer).get(t);
                        if (h == null) {
                            h = new LinkedHashSet<E>();
                            Lv.get(layer).put(t, h);
                        }
                        h.add(s);
                        E u = t.getMatching();
                        if (u != null) {
                            //System.out.println("     " + t + "'s matching is " + u);
                            u.setLayer(layer);
                            Le_next.add(u);
                        } else {
                            //System.out.println("     " + t + "has no matching");
                            freeVarNodeFound = true;
                        }
                    }
                }
            }
            layer++;
            Le_current = Le_next;
            Le_next = new LinkedHashSet<E>();
        }
        
        java.util.List<V> delQueue = new ArrayList<V>();
        for (V v : Lv.get(Lv.size() - 1).keySet()) {
            if (v.getMatching() != null) {
                delQueue.add(v);
            }
        }
        for (V v : delQueue) {
            Lv.get(Lv.size() - 1).remove(v);
        }
        //System.out.println(Lv);
        //System.out.println("************** BFS ends *************");
        return Lv;
    }

    

    public java.util.List<java.util.List<Edge>> dfs(java.util.List<Map<V, Set<E>>> Lv) {
        lightReset();
        java.util.List<java.util.List<Edge>> P = new ArrayList<java.util.List<Edge>>();
        
        boolean found_path = true;
        for (V v : Lv.get(Lv.size() - 1).keySet()) {
            ArrayList<Edge> P_tmp = new ArrayList<Edge>();
            
            ListIterator<Map<V, Set<E>>> iter = Lv.listIterator(Lv.size());
            while (iter.hasPrevious()) {
                Map<V, Set<E>> l = iter.previous();
                v.setVisited(true);
                if (!found_path) {
                    break;
                }
                found_path = false;
                for (E e : l.get(v)) {
                    if (!e.isVisited() && canMatch(e, v)) {
                        e.setVisited(true);
                        P_tmp.add(new Edge(e, v));
                        v = e.getMatching();
                        found_path = true;
                        break;
                    }
                }
            }
            if (P_tmp.size() == Lv.size()) {
                P.add(P_tmp);
            }
        }
        //System.out.println(P);
        return P;
    }

    

    public void reassign(java.util.List<java.util.List<Edge>> P) {
        for (java.util.List<Edge> l : P) {
            for (Edge ed : l) {
                match(ed.getEquation(), ed.getVariable());
            }
        }
    }

    

    public void maximumMatching(boolean resetMatching) {
        maximumMatching(resetMatching, null);
    }

    

    public void maximumMatching(boolean resetMatching, Set<FAbstractVariable> hasExtraStartConditions) {
        if (resetMatching) {
            reset();
            greedyMatching();
        }
        
        // Initialize set of free equations
        Set<E> startingNodes = new LinkedHashSet<E>();
        for (E e : getEquations()) {
            if (e.getMatching()==null) {
                startingNodes.add(e);
            }
        }
        
        Set<E> unmatchedEquations = new LinkedHashSet<E>(getUnmatchedEquations());
        
        java.util.List<Map<V, Set<E>>> Lv = null;
        java.util.List<java.util.List<Edge>> P = null;
        Comparator<? super V> varComparator = new VarMatchingComparator(hasExtraStartConditions);
        
        while (unmatchedEquations.size()>0) {
            
            Lv = bfs(unmatchedEquations, varComparator);
            P = dfs(Lv);
            
            if (Lv.get(Lv.size()-1).size()==0) {
                break;
            }
            
            reassign(P);
            
            for (java.util.List<Edge> l : P) {
                unmatchedEquations.remove(l.get(l.size()-1).getEquation());
            }
        }
    }

    

    protected class UnmatchedEquationsCriteria implements Criteria<E> {
        @Override
        public boolean test(E elem) {
            return elem.getMatching() == null && !elem.isMeta();
        }
    }

    

    public Iterator<E> unmatchedEquationsIterator() {
        return new FilteredIterator<E>(getEquations().iterator(), new UnmatchedEquationsCriteria());
    }

    

    public Iterable<E> unmatchedEquationsIterable() {
        return new Iterable<E>() {
            @Override
            public Iterator<E> iterator() {
                return unmatchedEquationsIterator();
            }
        };
    }

    

    public Collection<E> getUnmatchedEquations() {
        java.util.List<E> l = new ArrayList<E>();
        for (E e : unmatchedEquationsIterable())
            l.add(e);
        return l;
    }

    

    protected class UnmatchedVariablesCriteria implements Criteria<AbstractVar<?,?>> {
        @Override
        public boolean test(AbstractVar<?,?> elem) {
            return elem.getMatching() == null;
        }
    }

    

    public Iterator<V> unmatchedVariablesIterator() {
        return new FilteredIterator<V>(getVariables().iterator(), new UnmatchedVariablesCriteria());
    }

    

    public Iterable<V> unmatchedVariablesIterable() {
        return new Iterable<V>() {
            @Override
            public Iterator<V> iterator() {
                return unmatchedVariablesIterator();
            }
        };
    }

    

    public Collection<V> getUnmatchedVariables() {
        java.util.List<V> l = new ArrayList<V>();
        for (V v : unmatchedVariablesIterable())
            l.add(v);
        return l;
    }

    

    public java.util.List<E> getMatchedEquations() {
        java.util.List<E> l = new ArrayList<E>();
        for (E e : getEquations()) {
            if (e.getMatching()!=null) {
                l.add(e);
            }
        }
        return l;
    }

    

    public java.util.List<V> getMatchedVariables() {
        java.util.List<V> l = new ArrayList<V>();
        for (V v : getVariables()) {
            if (v.getMatching()!=null) {
                l.add(v);
            }
        }
        return l;
    }

    

    public Collection<E> getVisitedEquations() {
        Collection<E> l = new ArrayList<E>();
        for (E e: getEquations()) {
            if (e.isVisited())
                l.add(e);
        }
        return l;
    }

    

    public Collection<V> getVisitedVariables() {
        Collection<V> l = new ArrayList<V>();
        for (V v: getVariables()) {
            if (v.isVisited())
                l.add(v);
        }
        return l;
    }

    

    private static Collection<SCCContributor> SCCContributors;

    

    /**
     * Adds a new strongly connected component contributor to the list of
     * contributors.
     */
    private static <T extends SCCContributor> T addSCCContributor(T contributor) {
        if (SCCContributors == null)
            SCCContributors = new ArrayList<SCCContributor>();
        SCCContributors.add(contributor);
        return contributor;
    }

    

    /**
     * Retrevies the list of strongly connected component contributors.
     * This method should always be used since it ensures that the list is
     * initialized propperly.
     */
    public static Collection<SCCContributor> getSCCContributors() {
        if (SCCContributors == null)
            SCCContributors = new ArrayList<SCCContributor>();
        return SCCContributors;
    }

    
    
    /**
     * Abstract class for describing arc contributors to Tarjan's strongly
     * connected components algorithm.
     */
    public static abstract class SCCContributor {
        private final String option;
        
        private SCCContributor() {
            option = null;
        }

        private SCCContributor(String option) {
            this.option = option;
        }

        public boolean isActive(StepUtil stepUtil) {
            return option == null || stepUtil != null && stepUtil.getOptionRegistry().getBooleanOption(option);
        }

        /**
         * This method returns a list of equations that the supplied equation
         * depend on. This method is implemented by the overriding class.
         * 
         * Surounding BiPGraph is provided for convenience
         */
        public abstract <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> Collection<E> members(E equation, AbstractBiPGraph<E, V, ?> graph);

        /**
         * This method returns a list of equations that the supplied equation
         * should be in the same group as. It is important that there is a
         * symmetry in the lists returned. If A return a list containing B and
         * C. Then the list for B should contain A and C, finally the list for
         * C should contain A and B. Unexepected behaviour otherwise! The list
         * for A may contain A itself. This method is implemented by the
         * overriding class.
         * 
         * Use this method instead of members() when it is known from the start
         * that the lists are symetric. The implementation that backs this
         * method is way more efficient for large lists.
         * 
         * Surounding BiPGraph is provided for convenience
         */
        public abstract <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> Collection<E> sameBlockMembers(E equation, AbstractBiPGraph<E, V, ?> graph);

        /**
         * This method returns a map that map an equation to a list of object
         * identifiers. All equations that are associated with the same object
         * identifier are kept in the same block.
         * 
         * Surounding BiPGraph is provided for convenience
         */
        public abstract <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> Map<E, Collection<? extends Object>> memberSets(E equation, AbstractBiPGraph<E, V, ?> graph);
        
        public <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>, C extends SCCBlock<E, V>> Collection<C> mergeComponents(Collection<C> components, AbstractBiPGraph<E, V, ?> graph) {
            return components;
        }
    }

    
    
    private static final GroupMemberContributor GROUP_MEMBER_CONTRIBUTOR = new GroupMemberContributor();

    
    
    /**
     * Contributor that describes the relationship between BiPGrah equations
     * that link to the same AST equation, for example FFunctionCallEquations.
     */
    private static class GroupMemberContributor extends SCCContributor {
        
        @Override
        public <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> Collection<E> members(E equation, AbstractBiPGraph<E, V, ?> graph) {
            return Collections.emptyList();
        }
        
        @Override
        public <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> Collection<E> sameBlockMembers(E equation, AbstractBiPGraph<E, V, ?> graph) {
            return equation.getGroupMembers();
        }

        
        @Override
        public <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> Map<E, Collection<? extends Object>> memberSets(E equation, AbstractBiPGraph<E, V, ?> graph) {
            return Collections.emptyMap();
        }
    }

    
    
    
    private static final HomotopyContributor HOMOTOPY_CONTRIBUTOR = addSCCContributor(new HomotopyContributor());

    
    
    /**
     * Contributor that ensures that all equations with homotopy are computed in the same block.
     */
    private static class HomotopyContributor extends SCCContributor {
        
        private static final Collection<? extends Object> memberSets = Arrays.asList("homotopy");
        
        @Override
        public <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> Collection<E> members(E equation, AbstractBiPGraph<E, V, ?> graph) {
            return Collections.emptyList();
        }

        @Override
        public <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> Collection<E> sameBlockMembers(E equation, AbstractBiPGraph<E, V, ?> graph) {
            return Collections.emptyList();
        }

        @Override
        public <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> Map<E, Collection<? extends Object>> memberSets(E equation, AbstractBiPGraph<E, V, ?> graph) {
            if (!graph.isInitialSystem() || graph.insideHomotopySimplified() || !equation.getEquation().containsFHomotopyExp()) {
                return Collections.emptyMap();
            }
            Map<E, Collection<? extends Object>> eqsIdentMap = new HashMap<E, Collection<? extends Object>>();
            eqsIdentMap.put(equation, memberSets);
            return eqsIdentMap;
        }
    }

    
    
    protected abstract C createComponentBlock();

    

    public Collection<C> tarjan(boolean forceGroupMembersIntoSameBlock) {
        return tarjan(null, forceGroupMembersIntoSameBlock);
    }

    
    

    public Collection<C> tarjan(StepUtil stepUtil, boolean forceGroupMembersIntoSameBlock) {
        return tarjan(stepUtil, Collections.<SCCContributor>emptyList(), forceGroupMembersIntoSameBlock);
    }

    

    public Collection<C> tarjan(StepUtil stepUtil, Collection<SCCContributor> extraContributors,
            boolean forceGroupMembersIntoSameBlock) {
        tarjanReset();
        
        Collection<SCCContributor> groupMemberContributers;
        if (forceGroupMembersIntoSameBlock) {
            groupMemberContributers = Collections.<SCCContributor>singletonList(GROUP_MEMBER_CONTRIBUTOR);
        } else {
            groupMemberContributers = Collections.<SCCContributor>emptyList();
        }
        
        Collection<SCCContributor> contributors = new ArrayList<SCCContributor>();
        for (SCCContributor contributor : new ChainedIterable<SCCContributor>(getSCCContributors(), groupMemberContributers, extraContributors)) {
            if (!contributor.isActive(stepUtil))
                continue;
            contributors.add(contributor);
        }
        
        
        BiPTarjan tarjan = new BiPTarjan(contributors);
        Collection<C> components = tarjan.tarjan(getEquations());
//        for (SCCContributor contributor : contributors) {
//            components = contributor.mergeComponents(components, this);
//        }
        return components;
    }

    

    private class BiPTarjan extends Tarjan<E, C> {
        
        private final Collection<SCCContributor> contributors;
        Map<E, Collection<Collection<E>>> keepTogetherMap = new LinkedHashMap<E, Collection<Collection<E>>>();
        
        public BiPTarjan(Collection<SCCContributor> contributors) {
            this.contributors = contributors;
            Map<Object, Collection<E>> memberSetsMap = new HashMap<Object, Collection<E>>();
            for (SCCContributor contributor : contributors) {
                for (E equation : getEquations()) {
                    for (Map.Entry<E, Collection<? extends Object>> eqIdent : contributor.memberSets(equation, AbstractBiPGraph.this).entrySet()) {
                        for (Object identifier : eqIdent.getValue()) {
                            Collection<E> memberSet = memberSetsMap.get(identifier);
                            if (memberSet == null) {
                                memberSet = new ArrayList<E>();
                                memberSetsMap.put(identifier, memberSet);
                            }
                            Collection<Collection<E>> keepTogetherLists = keepTogetherMap.get(eqIdent.getKey());
                            if (keepTogetherLists == null) {
                                keepTogetherLists = new ArrayList<Collection<E>>();
                                keepTogetherMap.put(eqIdent.getKey(), keepTogetherLists);
                            }
                            memberSet.add(eqIdent.getKey());
                            keepTogetherLists.add(memberSet);
                        }
                    }
                }
            }
        }

        @Override
        protected boolean visited(E e) {
            return e.isVisited();
        }

        @Override
        protected void setVisited(E e, boolean val) {
            e.setVisited(val);
        }

        @Override
        protected boolean shouldVisit(E e) {
            return e.tarjanVisit();
        }

        @Override
        protected void addPredecessors(E e, Collection<E> predecessors) {
            for (V v : e.getVariables()) {
                E ee = v.getMatching();
                if (ee != null && e != ee && v.tarjanVisit())
                    predecessors.add(ee);
            }
            for (SCCContributor contributor : contributors)
                for (E ee : contributor.members(e, AbstractBiPGraph.this))
                    if (e != ee && ee.tarjanVisit())
                        predecessors.add(ee);
        }

        @Override
        protected int getIndex(E e) {
            return e.getTarjanNbr();
        }

        @Override
        protected void setIndex(E e, int val) {
            e.setTarjanNbr(val);
        }

        @Override
        protected int getLowLink(E e) {
            return e.getTarjanLowLink();
        }

        @Override
        protected void setLowLink(E e, int val) {
            e.setTarjanLowLink(val);
        }

        @Override
        protected void forceIntoSame(E e, Set<E> members) {
            members.remove(e); // Added later
            forceIntoSameInternal(e, members);
        }

        private void forceIntoSameInternal(E e, Set<E> members) {
            if (members.contains(e)) {
                return;
            }
            members.add(e);
            Collection<Collection<E>> keepTogetherLists = keepTogetherMap.get(e);
            if (keepTogetherLists != null) {
                for (Collection<E> keepTogether : keepTogetherLists) {
                    for (E ee : keepTogether) {
                        forceIntoSameInternal(ee, members);
                    }
                }
            }
            for (SCCContributor contributor : contributors) {
                for (E member : contributor.sameBlockMembers(e, AbstractBiPGraph.this)) {
                    forceIntoSameInternal(member, members);
                }
            }
        }

        @Override
        protected C createComponent() {
            return createComponentBlock();
        }
        
    }

    

    public void reset() {
        for (E e : getEquations()) {
            e.reset();
        }
        for (V v : getVariables()) {
            v.reset();
        }
    }

    

    public void lightReset() {
        for (E e : getEquations()) {
            e.lightReset();
        }
        for (V v : getVariables()) {
            v.lightReset();
        }
    }

    

    public void tarjanReset() {
        for (E e : getEquations()) {
            e.tarjanReset();
        }
    }

    

    public void insertIntoEquationIndexMap(FAbstractEquation eqn, E e) {
        equationIndexMap.add(eqn, e);
    }

    

    public void removeFromEquationIndexMap(FAbstractEquation eqn, E e) {
        equationIndexMap.removeFirst(eqn, e);
    }

    

    public String printMatching() {
        StringBuffer str = new StringBuffer();
        str.append("----------------------------------------\n");
        str.append("BiPGraph matching:\n");
        for (E e : getEquations()) {
            if (e.getMatching()!=null) {
                str.append(e);
                str.append(" : ");
                str.append(e.getMatching());
                str.append("\n");
            }
        }       
        str.append("Unmatched equations: {");
        for (E e : unmatchedEquationsIterable()) {
            str.append(e + " ");
        }
        str.append("}\n");
        
        str.append("Unmatched variables: {");
        for (V v : unmatchedVariablesIterable()) {
            str.append(v + " ");
        }
        str.append("}\n");
        
        str.append("----------------------------------------\n");
        return str.toString();
    }

    

    public Object printMatchingObj() {
        return new Object() {
            @Override
            public String toString() {
                return printMatching();
            }
        };
    }

    

    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("BiPGraph (" + getEquations().size() + " equations, " + variableMap.size() + " variables)\n");
        str.append("Variables: {");
        for (String vName : variableMap.keySet()) {
            V v = variableMap.get(vName);
            str.append(v);
            str.append(" ");
        }
        str.append("}\n");
        Map<FAbstractEquation, E> printedMap = new HashMap<FAbstractEquation, E>();
        for (E e : getEquations()) {
            str.append(e);
            str.append(" : ");
            for (V v : e.getVariables()) {
                str.append(v);
                str.append(canMatch(e, v) ? '@' : '#');
                if (v.getMatching() == e || e.getMatching() == v) {
                    str.append('M');
                }
                str.append(' ');
            }
            String previousPrintLabel = null;
            if (e.getGroupMembers().size() > 1) {
                E previous = printedMap.get(e.getEquation());
                
                if (previous == null) {
                    printedMap.put(e.getEquation(), e);
                } else {
                    previousPrintLabel = previous.getName();
                }
            }
            if (previousPrintLabel == null) {
                str.append("// " + e.printEquation() + "\n");
            } else {
                str.append("// Already printed, see " + previousPrintLabel + "\n");
            }
        }
        return str.toString();
    }

    

    public class Edge {
        private V variable;
        private E equation;

        public Edge(E e, V v) {
            this.equation = e;
            this.variable = v;
        }

        public V getVariable() {
            return variable;
        }

        public void setVariable(V variable) {
            this.variable = variable;
        }

        public E getEquation() {
            return equation;
        }

        public void setEquation(E equation) {
            this.equation = equation;
        }

        public String toString() {
            return "(" + equation + "," + variable + ")";
        }

    }

    
    
    public Map<V, Collection<E>> computeVariableToEquationMap() {
        Map<V, Collection<E>> map = new HashMap<V, Collection<E>>();
        for (E eqn : getEquations()) {
            for (V var : eqn.getVariables()) {
                Collection<E> eqns = map.get(var);
                if (eqns == null) {
                    eqns = new ArrayList<E>();
                    map.put(var, eqns);
                }
                eqns.add(eqn);
            }
        }
        return map;
    }

    

    public int countNumberOfIncidences() {
        int count = 0;
        for (E e : getEquations()) {
            count += e.getVariables().size();
        }
        return count;
    }

    
    protected static interface VariableResolver<E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> {
        public Set<V> lookupVars(Iterable<FAccessExp> set);
    }

    public VariableResolver<E, V> defaultVariableResolver() {
    return new VariableResolver<E,V>() {
        public Set<V> lookupVars(Iterable<FAccessExp> set) {
            return AbstractBiPGraph.this.lookupVars(set);
        }
    };
}

    public Set<V> lookupVars(Iterable<FAccessExp> set) {
    Set<V> res = new LinkedHashSet<V>();
    for (FAccessExp use : set) {
        V var = getVariable(use.name());
        if (var != null)
            res.add(var);
    }
    return res;
}

    
        private final static Enumerator visitEnumerator = new Enumerator(1);

    
        public abstract class AugmentingPathAlgorithm<R> {
            private final R TRUE_VALUE;

            protected AugmentingPathAlgorithm(R TRUE_VALUE) {
                this.TRUE_VALUE = TRUE_VALUE;
            }

            public R augmentingPath(E e) {
                return augmentingPath(e, Collections.<V>emptyList());
            }

            public R augmentingPath(E e, Collection<V> preVisit) {
                int visitNum = visitEnumerator.next();
                for (V var : preVisit)
                    var.augmentingPathVisit(visitNum);
                return visitEqn(e, visitNum);
            }
            
            private final R visitEqn(E eqn, int num) {
                R res = startValue(eqn);
                if (!eqn.augmentingPathVisit(num))
                    return res;
                for (V var : visitVariables(eqn)) {
                    if (!shouldVisit(eqn, var))
                        continue;
                    if (var.getMatching() == null) {
                        match(eqn, var);
                        return TRUE_VALUE;
                    } else if (var.augmentingPathVisit(num)) {
                        R subRes = visitEqn(var.getMatching(), num);
                        if (subRes == TRUE_VALUE) {
                            match(eqn, var);
                            return TRUE_VALUE;
                        }
                        res = mergeSubRes(res, subRes, eqn);
                    }
                }
                return res;
            }

            protected void match(E eqn, V var) {
                AbstractBiPGraph.this.match(eqn, var);
            }

            protected abstract R startValue(E eqn);

            protected abstract R mergeSubRes(R res, R subRes, E eqn);

            protected boolean shouldVisit(E eqn, V var) {
                return canMatch(eqn, var);
            }

            protected Iterable<V> visitVariables(E eqn) {
                return eqn.getVariables();
            }

            public R trueValue() {
                return TRUE_VALUE;
            }
        }

    

        private final StandardAugmentingPath STANDARD_AUGMENTING_PATH = new StandardAugmentingPath();

    

        public class StandardAugmentingPath extends AugmentingPathAlgorithm<Boolean> {
            public StandardAugmentingPath() {
                super(true);
            }

            @Override
            protected Boolean startValue(E eqn) {
                return false;
            }

            @Override
            protected Boolean mergeSubRes(Boolean res, Boolean subRes, E eqn) {
                return false;
            }
        }

    public boolean augmentPath(E e) {
        e.setVisited(true);
        for (V v : e.getVariables()) {
            if (!canMatch(e, v))
                continue;
            if (v.getMatching()==null) {
                match(e, v);
                return true;
            } else if (!v.isVisited()) {
                v.setVisited(true);
                if (augmentPath(v.getMatching())) {
                    match(e, v);
                    return true;
                }
            }
        }
        return false;
    }

    
        /**
         * Goes through the list of unmatched equations and tries to determine
         * if it is redundant. Al list of equations that should be removed is
         * returned if all unmatched equations are found to be redundent.
         */
        public OISResult overdeterminedInitialSystem() {
            getStepLogger().logVerbose("Analysing initial system for redundant equations to remove.");
            OISVariableEvaluator evaluator = new OISVariableEvaluator(getStepLogger());
            boolean allIsGood = true;
            for (E eqn : unmatchedEquationsIterable()) {
                getStepLogger().logVerbose("Checking unmatched equation %s", eqn);
                FAbstractEquation equation = eqn.getEquation();
                if (!equation.isInitial()) {
                    getStepLogger().logVerbose("  Not an initial equation");
                    allIsGood = false;
                } else if (equation.OIS_consistencyCheck(evaluator,stepLogger)) {
                    getStepLogger().logVerbose("  Consistent");
                } else {
                    allIsGood = false;
                    getStepLogger().logVerbose("  Unable to verify or different values were calculated");
                }
            }
            if (!allIsGood) {
                getStepLogger().logVerbose("Unable to verify all unmatched initial equations");
                return null;
            }
            Collection<E> results = new ArrayList<E>();
            getStepLogger().logVerbose("All seems to be ok!");
            return new OISResult(getUnmatchedEquations(), evaluator.visitedParameters);
        }

    
        
        public class OISResult{
            public final Collection<E> redundentEquations;
            public final Collection<FVariable> visitedParameters;
            
            private OISResult(Collection<E> redundentEquations, Collection<FVariable> visitedParameters) {
                this.redundentEquations = redundentEquations;
                this.visitedParameters = visitedParameters;
            }
        }

    
        
        /**
         * Variable evaluator that is used during analyse of overdetermined
         * initial system.
         */
        public class OISVariableEvaluator extends VariableEvaluator {
            
            private Set<CommonVariableDecl> evaluationStack = new HashSet<CommonVariableDecl>();
            private Map<CommonVariableDecl, CValue> evaluationCache = new LinkedHashMap<CommonVariableDecl, CValue>();
            private Set<FVariable> visitedParameters = new LinkedHashSet<FVariable>();
            
            private StepLogger stepLogger;
            
            public OISVariableEvaluator(StepLogger stepLogger) {
                super(true);
                this.stepLogger = stepLogger;
            }
            
            public StepLogger getStepLogger() {
                return stepLogger;
            }
            
            @Override
            public CValue ceval(CommonVariableDecl variable) {
                getStepLogger().logVerbose("    %s", variable.name());
                CValue val = evaluationCache.get(variable);
                if (val != null)
                    return val;
                if (evaluationStack.contains(variable)) {
                    val = CValue.UNKNOWN;
                } else {
                    try {
                        evaluationStack.add(variable);
                        V var = getVariable(variable.name());
                        if (var == null) { // Parameter or constant
                            visitedParameters.add(variable.asFAbstractVariable().asFVariable());
                            val = variable.ceval(this);
                        } else {
                            val = var.OIS_ceval(this);
                        }
                    } catch (ConstantEvaluationException e) {
                        val = CValue.UNKNOWN;
                    } finally {
                        evaluationStack.remove(variable);
                    }
                }
                evaluationCache.put(variable, val);
                return val;
            }
            
            @Override
            public CValue ceval(CommonVariableDecl variable, Index i) {
                return ceval(variable).array().getCell(i);
            }
        }


}
