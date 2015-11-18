package com.adam.logic.compiler;

/**
 * This interface represents a compiler, a compiler compiles a given src code
 * to an executable.
 * 
 * @author rage
 *
 */
public interface SourceCodeCompiler
{
	
	/**
	 * compile given source file to the given dest file.
	 * 
	 * @param srcFilename   the source file to compile
	 * @param destFilename  the destination file.
	 * 
	 * @return CompileResult, indicating the compilation result ( including compile errors, if needed)
	 */
	public CompileResult compile(String srcFilename, String destFilename);
}
