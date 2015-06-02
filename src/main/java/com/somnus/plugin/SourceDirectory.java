package com.somnus.plugin;

import java.util.List;

/**
 * 
 * @Title: SourceDirectory.java 
 * @Package com.somnus.plugin 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月2日 下午10:20:05 
 * @version V1.0
 */
public class SourceDirectory {
    private String directory;
    private List<String> includes;

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public List<String> getIncludes() {
        return includes;
    }

    public void setIncludes(List<String> includes) {
        this.includes = includes;
    }

}
