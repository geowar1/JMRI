package jmri.jmrit.display.layoutEditor;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import javax.annotation.Nonnull;
import javax.swing.*;
import jmri.util.FileUtil;

/**
 * This is the icon based toolbar panel
 *
 * @author George Warner Copyright: (c) 2019
 */
@SuppressWarnings("serial")
@SuppressFBWarnings(value = "SE_TRANSIENT_FIELD_NOT_RESTORED") //no Serializable support at present
public class LayoutEditorIconToolBarPanel extends LayoutEditorToolBarPanel {

    protected transient JButton turnoutRHIconButton = new JButton(new ImageIcon(FileUtil.findURL("resources/icons/panels/CSD/ESP/turnout/right/right_90.png")));
    protected transient JButton turnoutLHIconButton = new JButton(new ImageIcon(FileUtil.findURL("resources/icons/panels/CSD/ESP/turnout/left/left_90.png")));

    /**
     * constructor for LayoutEditorIconToolBarPanel
     *
     * @param layoutEditor the layout editor that this is for
     */
    public LayoutEditorIconToolBarPanel(@Nonnull LayoutEditor layoutEditor) {
        super(layoutEditor);
    }   //constructor

    /**
     * {@inheritDoc}
     */
    @Override
    protected void layoutComponents() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        ImageIcon ii = new ImageIcon(FileUtil.findURL("resources/icons/panels/CSD/ESP/turnout/right/right_90.png"));
        turnoutRHIconButton = new JButton(ii);

        if (turnoutRHIconButton != null) {
            add(turnoutRHIconButton);
        }
        if (turnoutLHIconButton != null) {
            add(turnoutLHIconButton);
        }
    }   //layoutComponents

    //initialize logging
    //private transient final static Logger log = LoggerFactory.getLogger(LayoutEditorIconToolBarPanel.class);
}
