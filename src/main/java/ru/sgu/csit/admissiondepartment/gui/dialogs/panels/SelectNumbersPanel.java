package ru.sgu.csit.admissiondepartment.gui.dialogs.panels;

import com.google.common.collect.Maps;
import ru.sgu.csit.admissiondepartment.gui.utils.GBConstraints;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Date: Jun 15, 2010
 * Time: 3:09:44 PM
 *
 * @author xx & hd
 */
public class SelectNumbersPanel extends JPanel {

    private Map<String, JSpinner> spinners = Maps.newHashMap();

    private Integer max = null;
    private Integer min = null;

    public SelectNumbersPanel(String title) {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
    }

    public SelectNumbersPanel(String title, Integer min) {
        this(title);
        this.min = min;
    }

    public SelectNumbersPanel(String title, Integer min, Integer max) {
        this(title, min);
        this.max = max;
    }

    public void createLabelList(List<String> labelNames) {
        JPanel panel = new JPanel(new GridBagLayout());

        int i = 0;
        for (String labelName : labelNames) {
            JSpinner spinner = new JSpinner(new SpinnerNumberModel((Number)0, min, max, 1));
            Dimension dimension = spinner.getPreferredSize();
            spinner.setPreferredSize(new Dimension(dimension.width + 50, dimension.height));
            spinners.put(labelName, spinner);

            panel.add(new JLabel(labelName), new GBConstraints(0, i));
            panel.add(spinner, new GBConstraints(1, i).setInsets(2, 10, 2, 10));
            i++;
        }

        add(panel, new GBConstraints(0, 0).setInsets(0).setWeight(100, 0));
    }

    public void setNumbers(Map<String, Integer> numbers) {
        for (Map.Entry<String, JSpinner> innerEntry : spinners.entrySet()) {
            Integer number = 0;
            for (Map.Entry<String, Integer> entry : numbers.entrySet()) {
                String labelName = entry.getKey();
                if (innerEntry.getKey().equals(labelName)) {
                    number = entry.getValue();
                    break;
                }
            }
            innerEntry.getValue().getModel().setValue(number);
        }
    }

    public Map<String, Integer> getNumbers() {
        Map<String, Integer> numbers = Maps.newHashMap();

        for (Map.Entry<String, JSpinner> entry : spinners.entrySet()) {
            String labelName = entry.getKey();
            Integer number = (Integer) entry.getValue().getValue();
            numbers.put(labelName, number);
        }

        return numbers;
    }
}
