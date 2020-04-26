package jmri.jmrit.display.layoutEditor;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.annotation.Nonnull;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
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

        turnoutRHButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Small/right_hand.png")));
        turnoutLHButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Small/left_hand.png")));
        turnoutWYEButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Small/wye.png")));
        doubleXoverButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Small/xover_double.png")));
        rhXoverButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Small/xover_right_hand.png")));
        lhXoverButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Small/xover_left_hand.png")));
        layoutSingleSlipButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Small/slip_single.png")));
        layoutDoubleSlipButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Small/slip_double.png")));

        endBumperButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Small/end_bumper.png")));
        anchorButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Small/anchor.png")));
        edgeButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Small/edge_connector.png")));
        trackButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Small/track_segment.png")));
        levelXingButton = new JRadioButton(new ImageIcon(FileUtil.findURL("program:resources/icons/layouteditor/Small/level_crossing.png")));

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
                return new Color(192, 192, 255);
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

        turnoutRHButton.setMargin(new Insets(4, 4, 4, 4));
        turnoutLHButton.setMargin(new Insets(4, 4, 4, 4));
        turnoutWYEButton.setMargin(new Insets(4, 4, 4, 4));
        doubleXoverButton.setMargin(new Insets(4, 4, 4, 4));
        rhXoverButton.setMargin(new Insets(4, 4, 4, 4));
        lhXoverButton.setMargin(new Insets(4, 4, 4, 4));
        layoutSingleSlipButton.setMargin(new Insets(4, 4, 4, 4));
        layoutDoubleSlipButton.setMargin(new Insets(4, 4, 4, 4));

        endBumperButton.setMargin(new Insets(4, 4, 4, 4));
        anchorButton.setMargin(new Insets(4, 4, 4, 4));
        edgeButton.setMargin(new Insets(4, 4, 4, 4));
        trackButton.setMargin(new Insets(4, 4, 4, 4));
        levelXingButton.setMargin(new Insets(4, 4, 4, 4));

        Border border = BorderFactory.createRaisedBevelBorder();
        turnoutRHButton.setBorder(border);
        border = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
        turnoutLHButton.setBorder(border);
        border = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        turnoutWYEButton.setBorder(border);
        border = BorderFactory.createCompoundBorder(
                    BorderFactory.createBevelBorder(BevelBorder.RAISED),
                    BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        doubleXoverButton.setBorder(border);
        border = BorderFactory.createEtchedBorder();
        rhXoverButton.setBorder(border);
        border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        lhXoverButton.setBorder(border);
        border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        layoutSingleSlipButton.setBorder(border);
        border = BorderFactory.createCompoundBorder(
                    BorderFactory.createEtchedBorder(BevelBorder.RAISED),
                    BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
        layoutDoubleSlipButton.setBorder(border);

        endBumperButton.setBorder(border);
        anchorButton.setBorder(border);
        edgeButton.setBorder(border);
        trackButton.setBorder(border);
        levelXingButton.setBorder(border);
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

        JPanel topPanel = new JPanel();
        topPanel.setLayout(flowLayout);

        topPanel.add(turnoutRHButton);
        topPanel.add(turnoutLHButton);
        topPanel.add(turnoutWYEButton);
        topPanel.add(doubleXoverButton);
        topPanel.add(rhXoverButton);
        topPanel.add(lhXoverButton);
        topPanel.add(layoutSingleSlipButton);
        topPanel.add(layoutDoubleSlipButton);

        topPanel.add(Box.createHorizontalStrut(5));
        topPanel.add(new JSeparator(SwingConstants.VERTICAL));
        topPanel.add(Box.createHorizontalStrut(5));

        topPanel.add(endBumperButton);
        topPanel.add(anchorButton);
        topPanel.add(edgeButton);
        topPanel.add(trackButton);
        topPanel.add(levelXingButton);

        topPanel.add(Box.createHorizontalStrut(5));
        topPanel.add(new JSeparator(SwingConstants.VERTICAL));
        topPanel.add(Box.createHorizontalStrut(5));

        add(topPanel);

        revalidate();
        repaint();
    }   //layoutComponents

    //initialize logging
    //private transient final static Logger log = LoggerFactory.getLogger(LayoutEditorIconToolBarPanel.class);
    private transient final static Logger log = LoggerFactory.getLogger(new Object() {
    }.getClass().getEnclosingClass());
}
