package org.jenkinsci.plugins.flow_plugin

import hudson.Extension
import jenkins.model.GlobalPluginConfiguration
import jenkins.model.Jenkins
import net.sf.json.JSONObject
import org.kohsuke.stapler.StaplerRequest
import hudson.model.Descriptor

import javax.annotation.CheckForNull

@Extension
public class FlowGlobalConfiguration extends GlobalPluginConfiguration {

    private FlowLinkAction link
    private volatile String flowUrl

    public FlowGlobalConfiguration() {
        load()
    }

    public @CheckForNull String getFlowUrl() {
        return flowUrl
    }

    public void setFlowUrl(String flowUrl){
        this.flowUrl=flowUrl
    }

    @Override
    public boolean configure(StaplerRequest req, JSONObject json) throws Descriptor.FormException {
        String flowUrl = json.getJSONObject("flow").getString("flowUrl")
        //Jenkins.getInstance().getActions().remove(link)
        //link = new FlowLinkAction()
        req.bindJSON(this, json)
        this.setFlowUrl(flowUrl)
        save()
        //Jenkins.getInstance().getActions().add(link);
        return true
    }

}
