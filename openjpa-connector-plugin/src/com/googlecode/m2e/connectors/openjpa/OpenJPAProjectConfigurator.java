/*******************************************************************************
 * Copyright (c) 2011 Callista Enterprise AB - Bj�rn Beskow
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.googlecode.m2e.connectors.openjpa;

import java.io.File;

import org.apache.maven.plugin.MojoExecution;
import org.eclipse.core.runtime.IPath;
import org.eclipse.m2e.core.lifecyclemapping.model.IPluginExecutionMetadata;
import org.eclipse.m2e.core.project.IMavenProjectFacade;
import org.eclipse.m2e.core.project.configurator.AbstractBuildParticipant;
import org.eclipse.m2e.jdt.AbstractJavaProjectConfigurator;

public class OpenJPAProjectConfigurator extends AbstractJavaProjectConfigurator {
    @Override
    public AbstractBuildParticipant getBuildParticipant(IMavenProjectFacade projectFacade, MojoExecution execution, IPluginExecutionMetadata executionMetadata) {
        return new OpenJPABuildParticipant(execution);
    }
	
    @Override
    protected IPath getFullPath( IMavenProjectFacade facade, File file ) {
        if(file != null) {
            return super.getFullPath(facade, file);
        } else {
           return null;
        }
    }

}
