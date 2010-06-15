package ru.sgu.csit.selectioncommittee.gui.dialogs.panels;

import ru.sgu.csit.selectioncommittee.common.ReceiptExamine;
import ru.sgu.csit.selectioncommittee.factory.DataAccessFactory;

import java.util.*;
import java.util.List;

/**
 * Date: May 6, 2010
 * Time: 10:17:09 PM
 *
 * @author xx & hd
 */
public class MarkPanel extends SelectNumbersPanel {
    public MarkPanel() {
        super("Баллы по ЕГЭ");

        List<String> examineNames = new ArrayList<String>();

        List<ReceiptExamine> receiptExamineList = DataAccessFactory.getExamines();
        for (ReceiptExamine receiptExamine : receiptExamineList) {
            examineNames.add(receiptExamine.getName());
        }

        createLabelList(examineNames);
    }

    public void setMarks(Map<String, Integer> specialityMap) {
        setNumbers(specialityMap);
    }

    public Map<String, Integer> getMarks() {
        return getNumbers();
    }
}
