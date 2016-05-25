package apps.startup.configurexml;

import apps.Apps;
import apps.StartupActionsManager;
import apps.StartupModel;
import apps.gui3.Apps3;
import apps.startup.ScriptButtonModel;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.script.ScriptException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import jmri.InstanceManager;
import jmri.JmriException;
import jmri.configurexml.AbstractXmlAdapter;
import jmri.script.JmriScriptEngineManager;
import jmri.util.FileUtil;
import org.jdom2.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handle XML persistence for {@link apps.startup.ScriptButtonModel} objects and
 * set the defined {@link jmri.Route} during application start.
 *
 * @author Bob Jacobsen Copyright: Copyright (c) 2003
 * @author Ken Cameron Copyright: 2014(c)
 * @author Randall Wood (c) 2016
 * @see apps.startup.TriggerRouteModelFactory
 */
public class ScriptButtonModelXml extends AbstractXmlAdapter {

    private final static Logger log = LoggerFactory.getLogger(ScriptButtonModelXml.class);

    public ScriptButtonModelXml() {
    }

    /**
     * Default implementation for storing the model contents
     *
     * @param o Object to store, of type PerformActonModel
     * @return Element containing the complete info
     */
    public Element store(Object o) {
        Element element = new Element("perform"); // NOI18N
        element.setAttribute("name", ((StartupModel) o).getName()); // NOI18N
        element.setAttribute("type", "Button"); // NOI18N
        element.setAttribute("class", this.getClass().getName()); // NOI18N
        Element property = new Element("property"); // NOI18N
        property.setAttribute("name", "script"); // NOI18N
        property.setAttribute("value", FileUtil.getPortableFilename(((ScriptButtonModel) o).getScript()));
        element.addContent(property);
        return element;
    }

    /**
     * Object should be loaded after basic GUI constructed
     *
     * @return true to defer loading
     * @see jmri.configurexml.AbstractXmlAdapter#loadDeferred()
     * @see jmri.configurexml.XmlAdapter#loadDeferred()
     */
    @Override
    public boolean loadDeferred() {
        return true;
    }

    @Override
    public boolean load(Element shared, Element perNode) throws JmriException {
        // Should the script engines be pre-loaded here?
        boolean result = false;
        ScriptButtonModel model = new ScriptButtonModel();
        model.setName(shared.getAttribute("name").getValue()); // NOI18N
        for (Element child : shared.getChildren("property")) { // NOI18N
            if (child.getAttributeValue("name").equals("script") // NOI18N
                    && child.getAttributeValue("value") != null) { // NOI18N
                String script = child.getAttributeValue("value"); // NOI18N
                try {
                    model.setScript(FileUtil.getFile(script));
                    result = true;
                } catch (FileNotFoundException ex) {
                    log.error("Unable to create button for script {}", script);
                }
            }
        }
        if (Apps.buttonSpace() != null) {
            log.error("Adding button to Apps");
            JButton b = new JButton(new ScriptButtonAction(model));
            Apps.buttonSpace().add(b);
        } else if (Apps3.buttonSpace() != null) {
            log.error("Adding button to Apps3");
            JButton b = new JButton(new ScriptButtonAction(model));
            Apps3.buttonSpace().add(b);
        }

        // store the model
        InstanceManager.getDefault(StartupActionsManager.class).addAction(model);
        return result;
    }

    /**
     * Update static data from XML file
     *
     * @param element Top level Element to unpack.
     * @param o       ignored
     */
    public void load(Element element, Object o) {
        log.error("Unexpected call of load(Element, Object)");
    }

    private static class ScriptButtonAction extends AbstractAction {
        
        ScriptButtonModel model;

        public ScriptButtonAction(ScriptButtonModel model) {
            this.model = model;
            this.putValue(Action.NAME, model.getName());
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                JmriScriptEngineManager.getDefault().eval(model.getScript());
            } catch (ScriptException | IOException ex) {
                log.error("Unable to run script {}.", model.getScript(), ex);
            }
        }
    }
}
