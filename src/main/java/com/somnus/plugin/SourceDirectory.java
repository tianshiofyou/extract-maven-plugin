package com.somnus.plugin;

import java.util.List;

/**
 * @author levis
 * @version 1.0 13-4-16
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
