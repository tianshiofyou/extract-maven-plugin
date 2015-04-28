package com.somnus.plugin;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.*;
import org.codehaus.plexus.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author levis
 * @version 1.0 13-4-16
 */
@Mojo(
        name = "extract",
        defaultPhase = LifecyclePhase.GENERATE_SOURCES,
        requiresDependencyResolution = ResolutionScope.COMPILE,
        threadSafe = true
)
@Execute(goal = "extract",
        phase = LifecyclePhase.GENERATE_SOURCES
)
public class ExtractMojo extends AbstractExtractMojo {

    @Parameter
    private List<SourceDirectory> sourceDirectors;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        String outputDirectory = (String) project.getCompileSourceRoots().get(0);

        if (sourceDirectors == null || sourceDirectors.size() <= 0) {
            return;
        }

        for (SourceDirectory sourceDirectory : sourceDirectors) {
            String directory = sourceDirectory.getDirectory();
            String includes = null;
            List<String> includeList = sourceDirectory.getIncludes();
            if (includeList.size() > 0) {
                includes = "";
                //拼接includes
                for (String include : includeList) {
                    if (includes.equals("")) {
                        includes = include;
                    } else {
                        includes = includes.concat(",").concat(include);
                    }
                }
            }
            try {
                List<String> srcDirectoryList = getDirectoryByPattern(directory);
                for (String srcDirectory : srcDirectoryList) {
                    List<String> fileList = FileUtils.getFileNames(new File(srcDirectory), includes, null, false);
                    for (String fileName : fileList) {
                        FileUtils.copyFile(new File(srcDirectory + "\\" + fileName), new File(outputDirectory + "\\" + fileName));
                    }
                }
            } catch (IOException ex) {
                getLog().error(ex);
            }
        }
    }

    /**
     * 根据目录模式抽取目录列表
     *
     * @param pattern
     * @return
     */
    private List<String> getDirectoryByPattern(String pattern) {
        int i = pattern.indexOf("**");
        if (i <= 0) {
            return Collections.singletonList(pattern);
        }
        String basePath = pattern.substring(0, i);
        String includes = pattern.substring(i);

        List<String> directoryList = null;
        try {
            directoryList = FileUtils.getDirectoryNames(new File(basePath), includes, null, true);
        } catch (IOException e) {
        }
        return directoryList;
    }
}
