package com.adam.logic.compiler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JavaCodeCompiler implements SourceCodeCompiler {

	private static final String JAVAC_COMMAND = "cmd /c javac ";
	
	@Override
	public CompileResult compile(String srcFilename, String destFilename) {
		
		String cmd = JAVAC_COMMAND + srcFilename;
		
		try {
			return runProcess(cmd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	private static CompileResult runProcess(String cmd) throws Exception{
		
		//assume success
		CompileResult result = new CompileResult("", true);
		
		try
		{
			Process process = Runtime.getRuntime().exec(cmd);
			String output = getCompileOutput(process.getErrorStream());
			
			process.waitFor();
			
			//we have a compilation error, save it
			if ( process.exitValue() != 0 )
			{
				result.compileOutput = output;
				result.isCompileSuccess = false;
			}
			
			return result;
			
		} catch (IOException e) {
			
			result.compileOutput = "unknown error occured during compilation";
			result.isCompileSuccess = false;
			e.printStackTrace();
			return result;
		}
	}
	
	private static String getCompileOutput(InputStream ins) throws Exception
	{
	    String line = null;
	    BufferedReader in = new BufferedReader(new InputStreamReader(ins));
	    StringBuffer output = new StringBuffer();
	    
	    while ((line = in.readLine()) != null)
	    {
	        output.append(line + "\n");
	    }
	    
	    return output.toString();
	    
	}
	    
	    

}
