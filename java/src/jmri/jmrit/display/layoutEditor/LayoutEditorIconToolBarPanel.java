package jmri.jmrit.display.layoutEditor;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.annotation.Nonnull;
import javax.swing.*;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import jmri.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the icon based toolbar panel
 *
 * @author George Warner Copyright: (c) 2019
 */
@SuppressWarnings("serial")
@SuppressFBWarnings(value = "SE_TRANSIENT_FIELD_NOT_RESTORED") //no Serializable support at present
public class LayoutEditorIconToolBarPanel extends LayoutEditorToolBarPanel {

    /**
     * constructor for LayoutEditorIconToolBarPanel
     *
     * @param layoutEditor the layout editor that this is for
     */
    public LayoutEditorIconToolBarPanel(@Nonnull LayoutEditor layoutEditor) {
        super(layoutEditor);

        turnoutRHButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Large/right_hand.png")));
        turnoutLHButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Large/left_hand.png")));
        turnoutWYEButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Large/wye.png")));
        doubleXoverButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Large/xover_double.png")));
        rhXoverButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Large/xover_right_hand.png")));
        lhXoverButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Large/xover_left_hand.png")));
        layoutSingleSlipButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Large/slip_single.png")));
        layoutDoubleSlipButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Large/slip_double.png")));

        endBumperButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Large/end_bumper.png")));
        anchorButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Large/anchor.png")));
        edgeButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Large/edge_connector.png")));
        trackButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Large/track_segment.png")));
        levelXingButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Large/level_crossing.png")));

        setupComponents();

        layoutComponents();
    }   //constructor

    /**
     * {@inheritDoc}
     */
    @Override
    protected void setupComponents() {
        super.setupComponents();

        turnoutRHButton.setSelected(true);

        MetalToggleButtonUI mtbui = new MetalToggleButtonUI() {
            @Override
            protected Color getSelectColor() {
                return new Color(128, 128, 255);
            }
        };

        turnoutRHButton.setUI(mtbui);
        turnoutLHButton.setUI(mtbui);
        turnoutWYEButton.setUI(mtbui);
        doubleXoverButton.setUI(mtbui);
        rhXoverButton.setUI(mtbui);
        lhXoverButton.setUI(mtbui);
        layoutSingleSlipButton.setUI(mtbui);
        layoutDoubleSlipButton.setUI(mtbui);

        endBumperButton.setUI(mtbui);
        anchorButton.setUI(mtbui);
        edgeButton.setUI(mtbui);
        trackButton.setUI(mtbui);
        levelXingButton.setUI(mtbui);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void layoutComponents() {
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 0, 0);
        setLayout(flowLayout);

        if (turnoutRHButton == null) {
            log.info("turnoutRHButton:{}", turnoutRHButton);
        }

        removeAll();

        add(turnoutRHButton);
        add(turnoutLHButton);
        add(turnoutWYEButton);
        add(doubleXoverButton);
        add(rhXoverButton);
        add(lhXoverButton);
        add(layoutSingleSlipButton);
        add(layoutDoubleSlipButton);

        add(Box.createRigidArea(new Dimension(32, 64)));

        add(endBumperButton);
        add(anchorButton);
        add(edgeButton);
        add(trackButton);
        add(levelXingButton);

        add(Box.createHorizontalStrut(30));

        revalidate();
        repaint();
    }   //layoutComponents

    //initialize logging
    //private transient final static Logger log = LoggerFactory.getLogger(LayoutEditorIconToolBarPanel.class);
    private transient final static Logger log = LoggerFactory.getLogger(new Object() {
    }.getClass().getEnclosingClass());
}
