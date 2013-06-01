package org.jenkinsci.plugins.flow_plugin;

import hudson.model.AbstractProject;
import hudson.model.JobProperty;
import hudson.model.Action;
import hudson.Extension;
import hudson.model.JobPropertyDescriptor;
import hudson.model.Job;
import hudson.model.TopLevelItem;
import org.kohsuke.stapler.StaplerRequest;
import net.sf.json.JSONObject;
import hudson.model.Descriptor;

import hudson.model.Descriptor.FormException;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

class FlowProjectProperty extends JobProperty<AbstractProject<?, ?>> {


    @Override
    public Collection<? extends Action> getJobActions(AbstractProject<?, ?> job) {
        final List<Action> actions = new LinkedList<Action>();
        actions.add(new FlowLinkAction());
        return actions;
    }

    @Extension
    public static final class DescriptorImpl
    extends JobPropertyDescriptor {

        public boolean isApplicable(Class<? extends Job> jobType) {
            return TopLevelItem.class.isAssignableFrom(jobType);
        }

        public String getDisplayName() {
            return null;
        }

        public FlowProjectProperty newInstance(StaplerRequest req, JSONObject formData) throws FormException {
            return new FlowProjectProperty();
        }
    }

}