package com.somnus.plugin;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;

/**
 * 
 * @Title: AbstractExtractMojo.java 
 * @Package com.somnus.plugin 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月2日 下午10:21:07 
 * @version V1.0
 */
abstract class AbstractExtractMojo extends AbstractMojo {
    /**
     * The current Maven project.
     */
    @Component
    protected MavenProject project;

    /**
     * The current Maven Session Object.
     *
     * @since 0.2.0
     */
    @Component
    private MavenSession session;

    /**
     * A helper used to add resources to the project.
     */
    @Component
    protected MavenProjectHelper projectHelper;

}
