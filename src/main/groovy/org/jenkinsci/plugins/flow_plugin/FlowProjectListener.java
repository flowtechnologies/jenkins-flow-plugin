package org.jenkinsci.plugins.flow_plugin;

import hudson.model.*;
import hudson.model.listeners.ItemListener;
import hudson.Extension;
import java.io.IOException;
import java.util.List;
import org.jenkinsci.plugins.flow_plugin.FlowProjectProperty;

@Extension
public class FlowProjectListener extends ItemListener {

    @Override
    public void onLoaded() {
        for ( AbstractProject<?, ?> project : Hudson.getInstance().getAllItems( AbstractProject.class ) )
        {
            addFlowProperty( project );
        }
    }

    @Override
    public void onCreated(Item item) {
        if (item instanceof AbstractProject) {
            AbstractProject project = (AbstractProject) item;
            addFlowProperty(project);
        }
    }

    private void addFlowProperty(AbstractProject<?, ?> project) {
        try {

            if (project.getProperty(FlowProjectProperty.class) == null) {
                project.addProperty(new FlowProjectProperty());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
