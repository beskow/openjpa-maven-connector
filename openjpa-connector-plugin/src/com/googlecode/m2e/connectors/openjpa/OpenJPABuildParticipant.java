/*******************************************************************************
 * Copyright (c) 2012 Callista Enterprise AB - Björn Beskow
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.googlecode.m2e.connectors.openjpa;

import java.io.File;
import java.util.Set;

import org.apache.maven.plugin.MojoExecution;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.m2e.core.MavenPlugin;
import org.eclipse.m2e.core.embedder.IMaven;
import org.eclipse.m2e.core.project.configurator.MojoExecutionBuildParticipant;
import org.sonatype.plexus.build.incremental.BuildContext;

public class OpenJPABuildParticipant extends MojoExecutionBuildParticipant {

    public OpenJPABuildParticipant(MojoExecution execution) {
        super(execution, true);
    }

    @Override
    public Set<IProject> build(int kind, IProgressMonitor monitor) throws Exception {
        IMaven maven = MavenPlugin.getMaven();
        BuildContext buildContext = getBuildContext();

        // execute mojo
        final Set<IProject> result = super.build(kind, monitor);

        // tell m2e builder to refresh enhanced files
        File enhanced = maven.getMojoParameterValue(getSession(), getMojoExecution(), "classes", File.class);
        if (enhanced != null) {
            buildContext.refresh(enhanced);
        }

        return result;
    }
}
