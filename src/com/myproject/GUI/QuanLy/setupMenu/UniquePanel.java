package com.myproject.GUI.QuanLy.setupMenu;

import javax.swing.JPanel;

public class UniquePanel extends JPanel{
    private String ID;
    private String Name;
    private boolean Selected;
    public UniquePanel() {

    }
    
    public void setID(String ID) {
        this.ID = ID;
    }
    
    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public boolean isSelected() {
        return Selected;
    }

    public void setSelected(boolean isSelected) {
        this.Selected = isSelected;
    }
    
    
}
