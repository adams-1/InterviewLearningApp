package com.adam.logic.compiler;

/**
 * This class represent a file compilation result, which can contain compilation/linkage
 * errors or a success indicator.
 * 
 * @author rage
 *
 */
public class CompileResult {
	
	/*
	 * The compilation output.
	 */
	public String  compileOutput;
	/*
	 * was the compilation successful.
	 */
	public boolean isCompileSuccess;
	
	
	public CompileResult(String compileOutput, boolean isCompileSucess){
		
		this.compileOutput = compileOutput;
		this.isCompileSuccess = isCompileSucess;
	}

}
