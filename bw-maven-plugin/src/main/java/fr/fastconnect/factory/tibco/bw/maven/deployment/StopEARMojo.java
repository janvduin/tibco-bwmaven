/**
 * (C) Copyright 2011-2015 FastConnect SAS
 * (http://www.fastconnect.fr/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.fastconnect.factory.tibco.bw.maven.deployment;

import java.util.ArrayList;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * 
 * <p>
 * This goal stops a TIBCO BusinessWorks application deployed on a TIBCO domain.
 * </p>
 * 
 * @author Mathieu Debove
 *
 */
@Mojo( name="stop-bw",
defaultPhase=LifecyclePhase.DEPLOY ) // FIXME: should be deployEAR
public class StopEARMojo extends AbstractBWDeployMojo {

	protected final static String STOP_EAR_FAILED = "Some instances failed to be stopped.";
	protected final static String STOPPING_EAR = "Stopping instances of the application...";

	@Override
	public String getInitMessage() {
		return STOPPING_EAR;
	}

	@Override
	public String getFailureMessage() {
		return STOP_EAR_FAILED;
	}

	@Override
	public ArrayList<String> arguments() {
		ArrayList<String> arguments = super.commonArguments();
		arguments.add("-stop");

		return arguments;
	}

	@Override
	public void postAction() throws MojoExecutionException {
		// nothing to do
	}

}
