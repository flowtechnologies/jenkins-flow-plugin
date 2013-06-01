package org.jenkinsci.plugins.flow_plugin;

import hudson.model.Action
import org.kohsuke.stapler.DataBoundConstructor
import javax.inject.Inject
import jenkins.model.GlobalConfiguration
import hudson.model.RootAction
import hudson.Extension
import jenkins.model.Jenkins


@Extension
public class FlowLinkAction implements RootAction {
    private String flowLink, flowLinkText, flowIcon;

    @DataBoundConstructor
    public FlowLinkAction() {
        this.flowLink = "flow"
        this.flowLinkText = "FLOW Dashboard"
        this.flowIcon = "/plugin/flow/images/logo.png"
    }

    @Inject
    private FlowGlobalConfiguration flowConfiguration

    public FlowGlobalConfiguration getGlobalConfiguration() {
        return flowConfiguration
    }

    public String getUrlName() { return flowLink }
    public String getDisplayName() { return flowLinkText }
    public String getIconFileName() { return flowIcon }

    public String getFlowUrl(){
        Jenkins.getInstance()
        return GlobalConfiguration.all().get(org.jenkinsci.plugins.flow_plugin.FlowGlobalConfiguration)?.flowUrl;
    }

}
