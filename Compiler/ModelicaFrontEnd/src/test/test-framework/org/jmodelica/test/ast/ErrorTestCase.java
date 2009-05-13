/*
    Copyright (C) 2009 Modelon AB

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3 of the License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package org.jmodelica.test.ast;

import org.jmodelica.parser.ModelicaParser;
import org.jmodelica.parser.FlatModelicaParser;
import org.jmodelica.ast.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Collection;

/**
 * @author jakesson
 *
 */
public class ErrorTestCase extends TestCase {

	String errorMessage="";
	
	private ModelicaParser parser = new ModelicaParser();
	private FlatModelicaParser flatParser = new FlatModelicaParser();
	
	public ErrorTestCase() {}
	
	public ErrorTestCase(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	/* (non-Javadoc)
	 * @see org.jmodelica.test.ast.TestCase#dump(java.lang.StringBuffer, java.lang.String)
	 */
	@Override
	public void dump(StringBuffer str, String indent) {
		str.append(indent+"ErrorTestCase: \n");
		if (testMe())
			str.append("PASS\n");
		else
			str.append("FAIL\n");
		str.append(indent+" Name:                     "+getName()+"\n");
		str.append(indent+" Description:              "+getDescription()+"\n");
		str.append(indent+" Source file:              "+getSourceFileName()+"\n");
		str.append(indent+" Class name:               "+getClassName()+"\n");

	}

	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("ErrorTestCase: \n");
		str.append(" Name:                     "+getName()+"\n");
		str.append(" Description:              "+getDescription()+"\n");
		str.append(" Source file:              "+getSourceFileName()+"\n");
		str.append(" Class name:               "+getClassName()+"\n");
		return str.toString();
		
	}

	
	
	/* (non-Javadoc)
	 * @see org.jmodelica.test.ast.TestCase#dumpJunit(java.lang.StringBuffer, int)
	 */
	@Override
	public void dumpJunit(StringBuffer str, int index) {
		testMe();
		str.append("  @Test public void " + getName() + "() {\n");
		str.append("    assertTrue(ts.get("+index+").testMe());\n");
	    str.append("  }\n\n");
	}

	/* (non-Javadoc)
	 * @see org.jmodelica.test.ast.TestCase#printTest(java.lang.StringBuffer)
	 */
	@Override
	public boolean printTest(StringBuffer str) {
		str.append("TestCase: " + getName() +": ");
		if (testMe()) {
			str.append("PASS\n");
			return true;
		}else {
			str.append("FAIL\n");
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see org.jmodelica.test.ast.TestCase#testMe()
	 */
	@Override
	public boolean testMe() {
        System.out.println("Running test: " + getClassName());
		SourceRoot sr = parser.parseFile(getSourceFileName());
		sr.setFileName(getSourceFileName());	    
		InstProgramRoot ipr = sr.getProgram().getInstProgramRoot();
	    StringBuffer str = new StringBuffer();
	    Collection<Problem> problems;
	    try {
	    	problems = ipr.checkErrorsInInstClass(getClassName());
	    } catch (ModelicaClassNotFoundException e) {
	    	return false;
	    }
	    if (problems.size()>0) {
	    	str.append("Errors found!\n");
	    	for (Problem p : problems) {
	    		str.append(p.toString()+"\n");
	    	}
	    	String testErrorMsg = filterErrorMessages(str.toString());
	    	String correctErrorMsg = filterErrorMessages(getErrorMessage());
//	    	System.out.println("**** " +getClassName());
//	    	System.out.println(correctErrorMsg);
//	    	System.out.println("*");
//	    	System.out.println(testErrorMsg);
//	    	System.out.println("*");
			if (testErrorMsg.equals(correctErrorMsg))
	    		return true;
	    }

	    // No errors in first pass, check for errors after transform canonical
	    FlatRoot flatRoot = new FlatRoot();
	    flatRoot.setFileName(getSourceFileName());
	    FClass fc = new FClass();
	    flatRoot.setFClass(fc);
	    try {
	    	ipr.findFlattenInst(getClassName(),fc);
	    	fc.transformCanonical();
	    	StringBuffer str_flat = new StringBuffer();
	    	problems = fc.errorCheck();
	    	if (problems.size()>0) {
//	    		str.append("Errors found!\n");
	    		for (Problem p : problems) {
	    			str_flat.append(p.toString()+"\n");
	    		}
	    		String testErrorMsg = filterErrorMessages(str_flat.toString());
	    		String correctErrorMsg = filterErrorMessages(getErrorMessage());
	    		if (testErrorMsg.equals(correctErrorMsg))
	    			return true;
	    	}
	    } catch (Exception e) {
	    	return false;
	    }
	    
	    
	    return false;
	    		
		
	}

	public String filterErrorMessages(String str) {
		StringBuffer filteredStr = new StringBuffer();
		BufferedReader origStr = new BufferedReader(new StringReader(str));
		String line;
		
		try {
			line = origStr.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return filteredStr.toString();
		}
		while (line!=null) {
			try {
			
				line = origStr.readLine();
				
			if (line!=null && line.contains("Semantic error at line")) {
	
					line = origStr.readLine();
				filteredStr.append(line+"\n");
			
			}
			
			} catch (IOException e) {
				e.printStackTrace();
				return filteredStr.toString();
			}	

			
		}
		
	return filteredStr.toString();
	}
	
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
